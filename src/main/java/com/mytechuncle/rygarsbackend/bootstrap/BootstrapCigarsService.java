package com.mytechuncle.rygarsbackend.bootstrap;

import com.mytechuncle.rygarsbackend.dto.cigar.CigarDTO;
import com.mytechuncle.rygarsbackend.dto.cigar.CigarSizeDTO;
import com.mytechuncle.rygarsbackend.dto.cigar.TobaccoDTO;
import com.mytechuncle.rygarsbackend.dto.cigar.WrapperDTO;
import com.mytechuncle.rygarsbackend.services.CigarService;
import org.apache.commons.text.WordUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.yaml.snakeyaml.Yaml;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
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

        List<File> bootstrappableCigarFiles = Files.walk(bootstrappableCigarsDirectory.toPath())
                .filter(x -> x.toString().toLowerCase().endsWith(".yml"))
                .map(Path::toFile)
                .collect(toList());

        for (File cigarFile : bootstrappableCigarFiles) {
            Yaml yaml = new Yaml();
            InputStream inputStream = new FileInputStream(cigarFile);
            BootstrapCigar cigar = yaml.loadAs(inputStream, BootstrapCigar.class);
            BootstrapResult result = bootstrapCigar(cigar);
            logger.info(cigar.getBrand() + " " + cigar.getName() + ": " + result.name());
        }
   }

    /**
     * Attempts to bootstrap cigar.
     * @param cigar - cigar details from yml config
     * @throws IllegalArgumentException - invalid cigar passed as argument
     */
    private BootstrapResult bootstrapCigar(BootstrapCigar cigar) throws IllegalArgumentException {
        CigarDTO bootstrapDTO = getDTO(cigar);
        CigarDTO dto = cigarService.getCigar(cigar.getBrand(), cigar.getName());
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
        dto.setStrength(cigar.getStrength() != null ?
                WordUtils.capitalizeFully(cigar.getStrength(), '_') : null);
        dto.setBrand(cigar.getBrand());
        dto.setName(cigar.getName());
        dto.setTags(cigar.getTags());
        dto.setImages(cigar.getImages());
        dto.setWrappers(cigar.getWrappers() != null ? cigar.getWrappers().stream()
                .map(wrapper -> {
                    WrapperDTO wrapperDTO = new WrapperDTO();
                    wrapperDTO.setShade(wrapper.getShade());
                    wrapperDTO.setRegion(wrapper.getRegion());
                    wrapperDTO.setName(wrapper.getName());
                    return wrapperDTO;
                })
                .collect(toList()) : null);

        dto.setBinder(cigar.getBinder() != null ? new TobaccoDTO(
                cigar.getBinder().getRegion(),
                cigar.getBinder().getType(),
                cigar.getBinder().getYear()) : null);

        dto.setFiller(cigar.getFiller() != null ? cigar.getFiller().stream()
                .map(filler -> new TobaccoDTO(
                        filler.getRegion(),
                        filler.getType(),
                        filler.getYear()
                ))
                .collect(toList()) : null);

        dto.setSizes(cigar.getSizes().stream()
                .map(size -> {
                    CigarSizeDTO sizeDTO = new CigarSizeDTO();
                    sizeDTO.setSizeName(size.getSizeName());
                    sizeDTO.setAlternativeSizeName(size.getAlternativeSizeName());
                    sizeDTO.setLength(size.getLength());
                    sizeDTO.setRingGauge(size.getRingGauge());
                    sizeDTO.setRingGauge2(size.getRingGauge2());
                    sizeDTO.setImages(size.getImages());
                    sizeDTO.setWrappers(size.getWrappers() != null ? size.getWrappers().stream()
                            .map(wrapper -> {
                                WrapperDTO wrapperDTO = new WrapperDTO();
                                wrapperDTO.setShade(wrapper.getShade());
                                wrapperDTO.setRegion(wrapper.getRegion());
                                wrapperDTO.setName(wrapper.getName());
                                return wrapperDTO;
                            })
                            .collect(toList()) : null);
                    sizeDTO.setBinder(size.getBinder() != null ? new TobaccoDTO(
                            size.getBinder().getRegion(),
                            size.getBinder().getType(),
                            size.getBinder().getYear()
                    ) : null);
                    sizeDTO.setFiller(size.getFiller() != null ? size.getFiller().stream()
                            .map(tobacco -> new TobaccoDTO(
                                    tobacco.getRegion(),
                                    tobacco.getType(),
                                    tobacco.getYear()
                            )).collect(toList()) : null);
                    sizeDTO.setStrength(size.getStrength() != null ?
                            WordUtils.capitalizeFully(size.getStrength(), '_') : null);
                    return sizeDTO;
                })
                .collect(toList()));
        return dto;
    }


}
