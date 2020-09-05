package com.mytechuncle.rygarsbackend.services;

import com.mytechuncle.rygarsbackend.dto.cigar.CigarDTO;

import java.util.List;

public interface CigarService {
    String addCigar(CigarDTO cigar);

    List<CigarDTO> getCigarsByBrand(String brand);
}
