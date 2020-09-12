package com.mytechuncle.rygarsbackend.bootstrap;

import com.mytechuncle.rygarsbackend.dto.cigar.CigarDTO;
import com.mytechuncle.rygarsbackend.dto.cigar.CigarSizeDTO;
import com.mytechuncle.rygarsbackend.dto.cigar.TobaccoDTO;
import com.mytechuncle.rygarsbackend.dto.cigar.WrapperDTO;
import com.mytechuncle.rygarsbackend.services.CigarService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.yaml.snakeyaml.Yaml;

import javax.annotation.PostConstruct;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class BootstrapCigarsService {
    @Autowired
    private CigarService cigarService;

    private enum BootstrapResult {
        created,
        updated,
        ignored
    }

    Logger logger = LoggerFactory.getLogger(BootstrapCigarsService.class);

    @PostConstruct
    public void bootstrap() throws IOException {
        // get all bootstrappable cigars
        File bootstrappableCigarsDirectory = new File(this.getClass()
                .getClassLoader()
                .getResource("bootstrap/cigars")
                .getFile());

        FilenameFilter yamlFilter = (dir, name) -> {
            String lower = name.toLowerCase();
            if (lower.endsWith(".yml") || lower.endsWith(".yaml")) {
                return true;
            }
            return false;
        };

        //List<File> bootstrappableCigarFiles = asList(bootstrappableCigarsDirectory.listFiles(yamlFilter));
        List<File> bootstrappableCigarFiles = Files.walk(bootstrappableCigarsDirectory.toPath())
                .filter(x -> x.toString().toLowerCase().endsWith(".yml"))
                .map(Path::toFile)
                .collect(toList());

        for (File cigarFile : bootstrappableCigarFiles) {
            Yaml yaml = new Yaml();
            InputStream inputStream = new FileInputStream(cigarFile);
            BootstrapCigar[] cigars = yaml.loadAs(inputStream, BootstrapCigar[].class);
            Map<BootstrapResult, Long> resultsMap = asList(cigars).stream()
                    .map(this::bootstrapCigar)
                    .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

            logger.info("ignored " + (resultsMap.get(BootstrapResult.ignored) != null ? resultsMap.get(BootstrapResult.ignored) : 0));
            logger.info("created " + (resultsMap.get(BootstrapResult.created) != null ? resultsMap.get(BootstrapResult.created) : 0));
            logger.info("updated " + (resultsMap.get(BootstrapResult.updated) != null ? resultsMap.get(BootstrapResult.updated) : 0));
        }
   }

    /**
     * Attempts to bootstrap cigar.
     * @param cigar
     * @throws IllegalArgumentException - invalid cigar passed as argument
     */
    private BootstrapResult bootstrapCigar(BootstrapCigar cigar) throws IllegalArgumentException {
        CigarDTO bootstrapDTO = getDTO(cigar);
        CigarDTO dto = cigarService.getCigar(cigar.getBrand(), cigar.getSubBrand(), cigar.getName());
        if (dto == null) {
            cigarService.addCigar(bootstrapDTO);
            return BootstrapResult.created;
        } else {
            if (bootstrapDTO.equals(dto)) {
                return BootstrapResult.ignored;
            } else {
                bootstrapDTO.setId(dto.getId());
                cigarService.updateCigar(bootstrapDTO);
                return BootstrapResult.updated;
            }
        }

    }

    private CigarDTO getDTO(BootstrapCigar cigar) {
        CigarDTO dto = new CigarDTO();
        dto.setStrength(cigar.getStrength());
        dto.setBrand(cigar.getBrand());
        dto.setName(cigar.getName());
        dto.setSubBrand(cigar.getSubBrand());
        dto.setImages(cigar.getImages());

        dto.setBinder(new TobaccoDTO(
                cigar.getBinder().getRegion(),
                cigar.getBinder().getType(),
                cigar.getBinder().getYear()));

        dto.setFiller(cigar.getFiller().stream()
                .map(filler -> new TobaccoDTO(
                        filler.getRegion(),
                        filler.getType(),
                        filler.getYear()
                ))
                .collect(toList()));

        dto.setSizes(cigar.getSizes().stream()
                .map(size -> {
                    CigarSizeDTO sizeDTO = new CigarSizeDTO();
                    sizeDTO.setSizeName(size.getSizeName());
                    sizeDTO.setAlternativeSizeName(size.getAlternativeSizeName());
                    sizeDTO.setLength(size.getLength());
                    sizeDTO.setRingGauge(size.getRingGauge());
                    sizeDTO.setRingGauge2(size.getRingGauge2());
                    sizeDTO.setImages(size.getImages());
                    sizeDTO.setWrappers(size.getWrappers().stream()
                            .map(wrapper -> {
                                WrapperDTO wrapperDTO = new WrapperDTO();
                                wrapperDTO.setShade(wrapper.getShade());
                                wrapperDTO.setRegion(wrapper.getRegion());
                                wrapperDTO.setName(wrapper.getName());
                                return wrapperDTO;
                            })
                            .collect(toList()));
                    return sizeDTO;
                })
                .collect(toList()));
        return dto;
    }


}
