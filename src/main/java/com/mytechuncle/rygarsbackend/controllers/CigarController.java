package com.mytechuncle.rygarsbackend.controllers;

import com.mytechuncle.rygarsbackend.dto.cigar.CigarDTO;
import com.mytechuncle.rygarsbackend.services.CigarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/cigars")
public class CigarController {

    @Autowired
    CigarService service;

    @GetMapping(path = "", produces = "application/json")
    public ResponseEntity<List<CigarDTO>> getCigars(@RequestParam(name = "brand") Optional<String> brand) {
        List<CigarDTO> cigars = service.getCigarsByBrand(brand.get());
        return new ResponseEntity<>(cigars, HttpStatus.OK);
    }

}
