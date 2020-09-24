package com.mytechuncle.rygarsbackend.controllers;

import com.mytechuncle.rygarsbackend.dto.cigar.CigarDTO;
import com.mytechuncle.rygarsbackend.repositories.CigarRepository;
import com.mytechuncle.rygarsbackend.repositories.CigarRepository.IdName;
import com.mytechuncle.rygarsbackend.services.CigarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "/api/cigars")
public class CigarController {

    @Autowired
    CigarService service;

    @Autowired
    CigarRepository repository;

    @GetMapping(path = "", produces = "application/json")
    public ResponseEntity<Page<CigarDTO>> getCigars(Pageable pageable, @RequestParam(name = "brand") Optional<String> brand) {
        Page<CigarDTO> cigars = service.getCigarsByBrand(pageable, brand.get());
        return new ResponseEntity<>(cigars, HttpStatus.OK);
    }

    @GetMapping(path = "/{id}", produces = "application/json")
    public ResponseEntity<CigarDTO> getCigar(Pageable pageable, @PathVariable(name = "id") String id) {
        CigarDTO cigar = service.getCigarById(id);
        return new ResponseEntity<>(cigar, HttpStatus.OK);
    }

    @GetMapping(path="/search")
    public ResponseEntity<Page<IdName>> searchCigars(Pageable pageable, @RequestParam(name = "query") String query) {
        Page<IdName> result = repository.findAllByBrandOrTagsOrName(query, PageRequest.of(0, 10));
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

}
