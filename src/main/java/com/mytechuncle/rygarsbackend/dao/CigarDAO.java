package com.mytechuncle.rygarsbackend.dao;

import com.mytechuncle.rygarsbackend.documents.cigar.Cigar;
import com.mytechuncle.rygarsbackend.documents.cigar.STRENGTH;
import com.mytechuncle.rygarsbackend.documents.cigar.Tobacco;
import com.mytechuncle.rygarsbackend.documents.cigar.Wrapper;
import com.mytechuncle.rygarsbackend.dto.cigar.CigarDTO;
import com.mytechuncle.rygarsbackend.dto.cigar.TobaccoDTO;
import com.mytechuncle.rygarsbackend.dto.cigar.WrapperDTO;
import com.mytechuncle.rygarsbackend.repositories.CigarRepository;
import org.apache.commons.text.WordUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static java.util.Optional.empty;
import static java.util.stream.Collectors.toList;

@Service
public class CigarDAO {

    @Autowired
    CigarRepository cigarRepository;

    public String save(CigarDTO cigar) {
        Cigar entity = this.getEntity(cigar);
        cigarRepository.save(entity);
        return entity.getId();
    }

    public List<CigarDTO> getCigarsByBrand(String brand) {
        return cigarRepository
                .findAllByBrand(brand)
                .stream()
                .map(this::getDTO)
                .collect(toList());
    }

    private CigarDTO getDTO(Cigar cigar) {
        CigarDTO dto = new CigarDTO();
        dto.setBrand(cigar.getBrand());
        dto.setSubBrand(cigar.getSubBrand());
        dto.setSizeName(cigar.getSizeName());
        dto.setBinder(getDTO(cigar.getBinder()));
        dto.setWrapper(getDTO(cigar.getWrapper()));
        dto.setFiller(cigar.getFiller().stream().map(this::getDTO).collect(toList()));
        dto.setLength(cigar.getLength());
        dto.setRingGauge(cigar.getRingGauge());
        dto.setId(cigar.getId());
        dto.setStrength(cigar.getStrength() != null ? WordUtils.capitalizeFully(cigar.getStrength().name()) : null);
        return dto;
    }

    private WrapperDTO getDTO(Wrapper wrapper) {
        WrapperDTO dto = new WrapperDTO();
        dto.setRegion(wrapper.getRegion());
        dto.setShade(wrapper.getShade());
        return dto;
    }

    private TobaccoDTO getDTO(Tobacco tobacco) {
        TobaccoDTO tobaccoDTO = new TobaccoDTO();
        tobaccoDTO.setRegion(tobacco.getRegion());
        tobaccoDTO.setType(tobacco.getType() != null ? Optional.of(tobacco.getType()) : empty());
        tobaccoDTO.setYear(tobacco.getYear() != null ? Optional.of(tobacco.getYear()) : empty());
        return tobaccoDTO;
    }

    private Cigar getEntity(CigarDTO cigar) {
        Cigar entity;
        if (cigar.getId() != null) {
            entity = cigarRepository.findById(cigar.getId()).orElseThrow(() -> new IllegalArgumentException("No cigar exists for id " + cigar.getId()));
        } else {
            entity = new Cigar();
        }
        entity.setWrapper(getEntity(cigar.getWrapper()));
        entity.setBinder(getEntity(cigar.getBinder()));
        entity.setFiller(cigar.getFiller().stream().map(this::getEntity).collect(toList()));
        entity.setLength(cigar.getLength());
        entity.setRingGauge(cigar.getRingGauge());
        entity.setSizeName(cigar.getSizeName());
        entity.setName(cigar.getName());
        entity.setBrand(cigar.getBrand());
        entity.setSubBrand(cigar.getSubBrand());
        entity.setStrength(STRENGTH.valueOf(cigar.getStrength().toUpperCase()));
        return entity;
    }

    private Wrapper getEntity(WrapperDTO wrapper) {
        Wrapper entity = new Wrapper();
        entity.setRegion(wrapper.getRegion());
        entity.setShade(wrapper.getShade());
        return entity;
    }

    private Tobacco getEntity(TobaccoDTO tobacco) {
        Tobacco entity = new Tobacco();
        entity.setRegion(tobacco.getRegion());
        entity.setType(tobacco.getType().orElse(null));
        entity.setYear(tobacco.getYear().orElse(null));
        return entity;
    }

}
