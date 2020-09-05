package com.mytechuncle.rygarsbackend.controllers;

import com.mytechuncle.rygarsbackend.dto.humidor.HumidorDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/humidors")
public class HumidorController {

    @GetMapping(path = "", produces = "application/json")
    public ResponseEntity<List<HumidorDTO>> getHumidors() {
        return null;
    }

}
