package com.mytechuncle.rygarsbackend.services;

import com.mytechuncle.rygarsbackend.documents.cigar.STRENGTH;
import com.mytechuncle.rygarsbackend.dto.cigar.CigarDTO;
import com.mytechuncle.rygarsbackend.dto.cigar.TobaccoDTO;
import com.mytechuncle.rygarsbackend.dto.cigar.WrapperDTO;
import org.apache.commons.text.WordUtils;

import static java.util.Arrays.asList;

public class CigarTestUtils {

    public static CigarDTO getHemingwaySignature() {
        CigarDTO cigar = new CigarDTO();
        cigar.setBrand("Arturo Fuente");
        cigar.setTags(asList("Gran Reserva"));
        cigar.setName("Hemingway Signature");
        cigar.setSizeName("Figurado");
        cigar.setRingGauge(47);
        cigar.setLength(6f);
        cigar.setWrapper(new WrapperDTO("African", "Cameroon"));
        cigar.setBinder(new TobaccoDTO("Dominican"));
        cigar.setFiller(asList(new TobaccoDTO("Dominican")));
        cigar.setStrength(WordUtils.capitalizeFully(STRENGTH.MEDIUM.toString()));
        return cigar;
    }

    public static CigarDTO getHemingwayShortStory() {
        CigarDTO cigar = new CigarDTO();
        cigar.setBrand("Arturo Fuente");
        cigar.setSubBrand("Gran Reserva");
        cigar.setName("Hemingway Short Story");
        cigar.setSizeName("Perfecto");
        cigar.setRingGauge(48);
        cigar.setLength(4f);
        cigar.setWrapper(new WrapperDTO("African", "Cameroon"));
        cigar.setBinder(new TobaccoDTO("Dominican"));
        cigar.setFiller(asList(new TobaccoDTO("Dominican")));
        cigar.setStrength(WordUtils.capitalizeFully(STRENGTH.MEDIUM.toString()));
        return cigar;
    }
}
