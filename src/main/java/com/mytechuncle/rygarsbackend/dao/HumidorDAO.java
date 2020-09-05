package com.mytechuncle.rygarsbackend.dao;

import com.mytechuncle.rygarsbackend.documents.humidor.Humidor;
import com.mytechuncle.rygarsbackend.documents.humidor.HumidorCigarAddition;
import com.mytechuncle.rygarsbackend.documents.humidor.SmokeEvent;
import com.mytechuncle.rygarsbackend.documents.user.User;
import com.mytechuncle.rygarsbackend.dto.humidor.HumidorCigarAdditionDTO;
import com.mytechuncle.rygarsbackend.dto.humidor.HumidorDTO;
import com.mytechuncle.rygarsbackend.dto.humidor.SmokeEventDTO;
import com.mytechuncle.rygarsbackend.repositories.CigarRepository;
import com.mytechuncle.rygarsbackend.repositories.HumidorRepository;
import com.mytechuncle.rygarsbackend.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;

@Service
public class HumidorDAO {
    @Autowired
    HumidorRepository repository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    CigarRepository cigarRepository;

    public List<HumidorDTO> getHumidors(String username) {
        User user = userRepository
                .findByUsername(username)
                .orElseThrow(() -> new IllegalArgumentException("No user exists with username " + username));
        List<Humidor> humidors = repository.findAllByUser(user);
        return humidors
                .stream()
                .map(this::getDTO)
                .collect(toList());
    }

    private Humidor getEntity(HumidorDTO humidor) {
        Humidor entity;
        if (humidor.getId() != null) {
            entity = repository
                    .findById(humidor.getId())
                    .orElseThrow(() -> new IllegalArgumentException("No humidor exists with id " + humidor.getId()));
        } else {
            entity = new Humidor();
        }
        entity.setName(humidor.getName());
        entity.setCigars(humidor.getCigars()
                .stream()
                .map(this::getEntity)
                .collect(toSet()));
        entity.setUser(userRepository
                .findByUsername(humidor.getUsername())
                .orElseThrow(() -> new IllegalArgumentException("User doesn't exist with username " + humidor.getUsername())));
        return entity;
    }

    private HumidorCigarAddition getEntity(HumidorCigarAdditionDTO addition) {
        HumidorCigarAddition entity = new HumidorCigarAddition();
        entity.setDateAdded(addition.getDateAdded());
        entity.setOriginalAmount(addition.getOriginalAmount());
        entity.setSmokeEvents(addition.getSmokeEvents()
                .stream()
                .map(this::getEntity)
                .collect(toList()));
        entity.setCigar(cigarRepository
                .findById(addition.getCigarId())
                .orElseThrow(() -> new IllegalArgumentException("No cigar exists with id " + addition.getCigarId())));
        return entity;
    }

    private SmokeEvent getEntity(SmokeEventDTO smokeEvent) {
        SmokeEvent entity = new SmokeEvent();
        entity.setComments(smokeEvent.getComments());
        entity.setDate(smokeEvent.getDate());
        return entity;
    }

    private HumidorDTO getDTO(Humidor humidor) {
        HumidorDTO dto = new HumidorDTO();
        dto.setId(humidor.getId());
        dto.setName(humidor.getName());
        dto.setUsername(humidor.getUser().getUsername());
        dto.setCigars(humidor.getCigars() != null ? humidor.getCigars().stream().map(this::getDTO).collect(toSet()) : null);
        return dto;
    }

    private HumidorCigarAdditionDTO getDTO(HumidorCigarAddition addition) {
        HumidorCigarAdditionDTO dto = new HumidorCigarAdditionDTO();
        dto.setCigar(addition.getCigar().getId());
        dto.setDateAdded(addition.getDateAdded());
        dto.setOriginalAmount(addition.getOriginalAmount());
        dto.setSmokeEvents(addition.getSmokeEvents() != null ? addition.getSmokeEvents().stream().map(this::getDTO).collect(toList()) : null);
        return dto;
    }

    private SmokeEventDTO getDTO(SmokeEvent smokeEvent) {
        SmokeEventDTO dto = new SmokeEventDTO();
        dto.setComments(smokeEvent.getComments());
        dto.setDate(smokeEvent.getDate());
        return dto;
    }
}
