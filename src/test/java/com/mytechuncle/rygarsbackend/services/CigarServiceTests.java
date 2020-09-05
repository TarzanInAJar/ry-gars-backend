package com.mytechuncle.rygarsbackend.services;

import com.mytechuncle.rygarsbackend.dto.cigar.CigarDTO;
import com.mytechuncle.rygarsbackend.repositories.CigarRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DuplicateKeyException;

import java.util.List;

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

        List<CigarDTO> result = cigarService.getCigarsByBrand("Arturo Fuente");
        assertEquals("Correct amount of cigars are returned", 1, result.size());
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

        List<CigarDTO> result = cigarService.getCigarsByBrand("Arturo Fuente");
        assertEquals("Correct amount of cigars are returned", 2, result.size());
    }


}
