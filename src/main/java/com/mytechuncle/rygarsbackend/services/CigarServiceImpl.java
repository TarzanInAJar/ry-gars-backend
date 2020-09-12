package com.mytechuncle.rygarsbackend.services;

import com.mytechuncle.rygarsbackend.dao.CigarDAO;
import com.mytechuncle.rygarsbackend.dto.cigar.CigarDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CigarServiceImpl implements CigarService {

    @Autowired
    CigarDAO dao;

    @Override
    public String addCigar(CigarDTO cigar) {
        if (cigar.getId() != null) {
            throw new IllegalArgumentException("New cigar cannot have a specified id!");
        }
        return dao.save(cigar);
    }

    @Override
    public Page<CigarDTO> getCigarsByBrand(Pageable pageable, String brand) {
        return dao.getCigarsByBrand(pageable, brand);
    }

    @Override
    public boolean exists(String brand, String subBrand, String name) {
        return dao.exists(brand, subBrand, name);
    }

    @Override
    public CigarDTO getCigar(String brand, String subBrand, String name) {
        return dao.getCigar(brand, subBrand, name);
    }

    @Override
    public void updateCigar(CigarDTO cigar) {
        if (cigar.getId() == null) {
            throw new IllegalArgumentException("Update cigar request must have an id!");
        } else if (!dao.exists(cigar.getId())) {
            throw new IllegalArgumentException("Can't update - no cigar exists for id " + cigar.getId());
        }
        dao.save(cigar);
    }
}
