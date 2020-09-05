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


}
