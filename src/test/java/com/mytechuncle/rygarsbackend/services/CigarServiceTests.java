package com.mytechuncle.rygarsbackend.services;

import com.mytechuncle.rygarsbackend.dto.cigar.CigarDTO;
import com.mytechuncle.rygarsbackend.repositories.CigarRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import static com.mytechuncle.rygarsbackend.services.CigarTestUtils.getHemingwayShortStory;
import static com.mytechuncle.rygarsbackend.services.CigarTestUtils.getHemingwaySignature;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.springframework.test.util.AssertionErrors.assertEquals;

@SpringBootTest
public class CigarServiceTests {
    @Autowired
    CigarRepository cigarRepository;

    @Autowired
    CigarService cigarService;

    @BeforeEach
    public void init() {
        cigarRepository.deleteAll();
    }

    @Test
    public void getCigarsByBrandSimpleTest() {
        CigarDTO cigar = getHemingwaySignature();
        cigarService.addCigar(cigar);

        Pageable pageable = PageRequest.of(0,10);

        Page<CigarDTO> result = cigarService.getCigarsByBrand(pageable, "Arturo Fuente");
        assertEquals("Correct amount of cigars are returned", 1, result.getTotalPages());
    }

    @Test
    public void addSameCigarThrowsError() {
        CigarDTO cigar = getHemingwayShortStory();
        cigarService.addCigar(cigar);
        DuplicateKeyException exception = assertThrows(DuplicateKeyException.class, () -> {
            cigarService.addCigar(cigar);
        });
    }

    @Test
    public void getCigarsByBrandTwoSimilarCigars() {
        CigarDTO signature = getHemingwaySignature();
        CigarDTO shortStory = getHemingwayShortStory();

        cigarService.addCigar(signature);
        cigarService.addCigar(shortStory);

        Pageable pageable = PageRequest.of(0,10);

        Page<CigarDTO> result = cigarService.getCigarsByBrand(pageable, "Arturo Fuente");
        assertEquals("Correct amount of cigars are returned", 2, result.getTotalPages());
    }


}
