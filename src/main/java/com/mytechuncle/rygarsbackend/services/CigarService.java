package com.mytechuncle.rygarsbackend.services;

import com.mytechuncle.rygarsbackend.dto.cigar.CigarDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CigarService {
    String addCigar(CigarDTO cigar);
    void updateCigar(CigarDTO cigar);
    Page<CigarDTO> getCigarsByBrand(Pageable pageable, String brand);
    boolean exists(String brand, String subBrand, String name);
    CigarDTO getCigar(String brand, String subBrand, String name);
}
