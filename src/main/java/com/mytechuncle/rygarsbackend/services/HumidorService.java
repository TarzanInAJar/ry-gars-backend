package com.mytechuncle.rygarsbackend.services;

import com.mytechuncle.rygarsbackend.dto.humidor.HumidorDTO;

import java.util.List;

public interface HumidorService {
    List<HumidorDTO> getHumidors(String username);
}
