package com.mytechuncle.rygarsbackend.services;

import com.mytechuncle.rygarsbackend.dao.HumidorDAO;
import com.mytechuncle.rygarsbackend.dto.humidor.HumidorDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HumidorServiceImpl implements HumidorService {

    @Autowired
    HumidorDAO humidorDAO;

    @Override
    public List<HumidorDTO> getHumidors(String username) {
        return humidorDAO.getHumidors(username);
    }
}
