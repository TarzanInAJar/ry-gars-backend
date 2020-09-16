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
        validCigar(cigar); // throws exception if not valid
        return dao.save(cigar);
    }

    @Override
    public Page<CigarDTO> getCigarsByBrand(Pageable pageable, String brand) {
        return dao.getCigarsByBrand(pageable, brand);
    }

    @Override
    public boolean exists(String brand, String name) {
        return dao.exists(brand, name);
    }

    @Override
    public CigarDTO getCigar(String brand, String name) {
        return dao.getCigar(brand, name);
    }

    @Override
    public CigarDTO getCigarById(String id) {
        return dao.getCigarById(id);
    }

    @Override
    public void updateCigar(CigarDTO cigar) {
        if (cigar.getId() == null) {
            throw new IllegalArgumentException("Update cigar request must have an id!");
        } else if (!dao.exists(cigar.getId())) {
            throw new IllegalArgumentException("Can't update - no cigar exists for id " + cigar.getId());
        }
        validCigar(cigar); // throws exception if not valid
        dao.save(cigar);
    }

    private void validCigar(CigarDTO cigar) {
        if (cigar.getStrength() == null && cigar.getSizes().stream().anyMatch(size -> size.getStrength() == null)) {
            throw new IllegalArgumentException("Can't update - size exists with no strength!");
        } else if (cigar.getFiller() == null && cigar.getSizes().stream().anyMatch(size -> size.getFiller() == null)) {
            throw new IllegalArgumentException("Can't update - size exists with no filler!");
        } else if (cigar.getBinder() == null && cigar.getSizes().stream().anyMatch(size -> size.getBinder() == null)) {
            throw new IllegalArgumentException("Can't update - size exists with no binder!");
        } else if (cigar.getWrappers() == null && cigar.getSizes().stream().anyMatch(size -> size.getWrappers() == null)) {
            throw new IllegalArgumentException("Can't update - size exists with no wrappers!");
        }
    }
}
