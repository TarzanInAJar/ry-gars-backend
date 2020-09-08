package com.mytechuncle.rygarsbackend.services;

import com.mytechuncle.rygarsbackend.dto.cigar.CigarDTO;

import java.util.List;

public interface CigarService {
    String addCigar(CigarDTO cigar);
    void updateCigar(CigarDTO cigar);
    List<CigarDTO> getCigarsByBrand(String brand);
    boolean exists(String brand, String subBrand, String name, String sizeName);
    CigarDTO getCigar(String brand, String subBrand, String name, String sizeName);
}
