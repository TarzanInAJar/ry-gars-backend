package com.mytechuncle.rygarsbackend.services;

import com.mytechuncle.rygarsbackend.dao.CigarDAO;
import com.mytechuncle.rygarsbackend.dto.cigar.CigarDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public List<CigarDTO> getCigarsByBrand(String brand) {
        return dao.getCigarsByBrand(brand);
    }

    @Override
    public boolean exists(String brand, String subBrand, String name, String sizeName) {
        return dao.exists(brand, subBrand, name, sizeName);
    }

    @Override
    public CigarDTO getCigar(String brand, String subBrand, String name, String sizeName) {
        return dao.getCigar(brand, subBrand, name, sizeName);
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
