package com.mytechuncle.rygarsbackend.dao;

import com.mytechuncle.rygarsbackend.documents.cigar.*;
import com.mytechuncle.rygarsbackend.dto.cigar.CigarDTO;
import com.mytechuncle.rygarsbackend.dto.cigar.CigarSizeDTO;
import com.mytechuncle.rygarsbackend.dto.cigar.TobaccoDTO;
import com.mytechuncle.rygarsbackend.dto.cigar.WrapperDTO;
import com.mytechuncle.rygarsbackend.repositories.CigarRepository;
import org.apache.commons.text.WordUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

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

    public Page<CigarDTO> getCigarsByBrand(Pageable pageable, String brand) {
        return cigarRepository
                .findAllByBrand(pageable, brand)
                .map(this::getDTO);
    }

    public CigarDTO getCigar(String brand, String subBrand, String name) {
        Optional<Cigar> cigar = cigarRepository.findOne(brand, subBrand, name);
        if (cigar.isPresent()) {
            return getDTO(cigar.get());
        }
        return null;
    }

    public boolean exists(String id) {
        return cigarRepository.existsById(id);
    }

    public boolean exists(String brand, String subBrand, String name) {
        return cigarRepository.exists(brand, subBrand, name);
    }

    private CigarDTO getDTO(Cigar cigar) {
        CigarDTO dto = new CigarDTO();
        dto.setBrand(cigar.getBrand());
        dto.setSubBrand(cigar.getSubBrand());
        dto.setName(cigar.getName());
        dto.setBinder(getDTO(cigar.getBinder()));
        dto.setFiller(cigar.getFiller().stream().map(this::getDTO).collect(toList()));
        dto.setId(cigar.getId());
        dto.setStrength(cigar.getStrength() != null ? WordUtils.capitalizeFully(cigar.getStrength().name()) : null);
        dto.setSizes(cigar.getSizes().stream().map(this::getDTO).collect(toList()));
        dto.setImages(cigar.getImages());
        return dto;
    }

    private CigarSizeDTO getDTO(CigarSize cigarSize) {
        CigarSizeDTO dto = new CigarSizeDTO();
        dto.setSizeName(cigarSize.getSizeName());
        dto.setLength(cigarSize.getLength());
        dto.setRingGauge(cigarSize.getRingGauge());
        dto.setRingGauge2(cigarSize.getRingGauge2());
        dto.setAlternativeSizeName(cigarSize.getAlternativeSizeName());
        dto.setWrappers(cigarSize.getWrappers().stream().map(this::getDTO).collect(toList()));
        return dto;
    }

    private WrapperDTO getDTO(Wrapper wrapper) {
        WrapperDTO dto = new WrapperDTO();
        dto.setRegion(wrapper.getRegion());
        dto.setShade(wrapper.getShade());
        dto.setName(wrapper.getName());
        return dto;
    }

    private TobaccoDTO getDTO(Tobacco tobacco) {
        TobaccoDTO tobaccoDTO = new TobaccoDTO();
        tobaccoDTO.setRegion(tobacco.getRegion());
        tobaccoDTO.setType(tobacco.getType());
        tobaccoDTO.setYear(tobacco.getYear());
        return tobaccoDTO;
    }

    private Cigar getEntity(CigarDTO cigar) {
        Cigar entity;
        if (cigar.getId() != null) {
            entity = cigarRepository.findById(cigar.getId()).orElseThrow(() -> new IllegalArgumentException("No cigar exists for id " + cigar.getId()));
        } else {
            entity = new Cigar();
        }
        entity.setBinder(getEntity(cigar.getBinder()));
        entity.setFiller(cigar.getFiller().stream().map(this::getEntity).collect(toList()));
        entity.setName(cigar.getName());
        entity.setBrand(cigar.getBrand());
        entity.setSubBrand(cigar.getSubBrand());
        entity.setStrength(STRENGTH.valueOf(cigar.getStrength().toUpperCase()));
        entity.setSizes(cigar.getSizes().stream().map(this::getEntity).collect(toList()));
        entity.setImages(cigar.getImages());
        return entity;
    }

    private CigarSize getEntity(CigarSizeDTO size) {
        CigarSize entity = new CigarSize();
        entity.setSizeName(size.getSizeName());
        entity.setAlternativeSizeName(size.getAlternativeSizeName());
        entity.setLength(size.getLength());
        entity.setRingGauge(size.getRingGauge());
        entity.setRingGauge2(size.getRingGauge2());
        entity.setImages(size.getImages());
        entity.setWrappers(size.getWrappers().stream().map(this::getEntity).collect(toList()));
        entity.setImages(size.getImages());
        return entity;
    }

    private Wrapper getEntity(WrapperDTO wrapper) {
        Wrapper entity = new Wrapper();
        entity.setRegion(wrapper.getRegion());
        entity.setShade(wrapper.getShade());
        entity.setName(wrapper.getName());
        return entity;
    }

    private Tobacco getEntity(TobaccoDTO tobacco) {
        Tobacco entity = new Tobacco();
        entity.setRegion(tobacco.getRegion());
        entity.setType(tobacco.getType());
        entity.setYear(tobacco.getYear());
        return entity;
    }

}
