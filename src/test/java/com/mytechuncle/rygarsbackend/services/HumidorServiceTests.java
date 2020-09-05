package com.mytechuncle.rygarsbackend.services;

import com.mytechuncle.rygarsbackend.documents.humidor.Humidor;
import com.mytechuncle.rygarsbackend.documents.humidor.HumidorCigarAddition;
import com.mytechuncle.rygarsbackend.documents.user.User;
import com.mytechuncle.rygarsbackend.dto.humidor.HumidorDTO;
import com.mytechuncle.rygarsbackend.repositories.CigarRepository;
import com.mytechuncle.rygarsbackend.repositories.HumidorRepository;
import com.mytechuncle.rygarsbackend.repositories.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.List;

import static com.mytechuncle.rygarsbackend.services.CigarTestUtils.getHemingwayShortStory;
import static com.mytechuncle.rygarsbackend.services.CigarTestUtils.getHemingwaySignature;
import static java.util.Arrays.asList;
import static org.springframework.test.util.AssertionErrors.assertEquals;

@SpringBootTest
public class HumidorServiceTests {
    @Autowired
    HumidorService humidorService;

    @Autowired
    HumidorRepository humidorRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    CigarRepository cigarRepository;

    @Autowired
    CigarService cigarService;

    @BeforeEach
    public void init() {
        humidorRepository.deleteAll();
        cigarRepository.deleteAll();
        userRepository.deleteAll();
    }

    @Test
    public void getHumidorsSimpleTest() {
        String hemingwayId = cigarService.addCigar(getHemingwaySignature());
        String shortStoryId = cigarService.addCigar(getHemingwayShortStory());

        User user = new User();
        user.setUsername("Bugaloo@gmail.com");
        userRepository.save(user);

        Humidor humidor = new Humidor();

        HumidorCigarAddition addition = new HumidorCigarAddition();
        addition.setCigar(cigarRepository.findById(hemingwayId).get());
        addition.setDateAdded(new GregorianCalendar());
        addition.setOriginalAmount(1);

        HumidorCigarAddition addition2 = new HumidorCigarAddition();
        addition2.setCigar(cigarRepository.findById(shortStoryId).get());
        addition2.setDateAdded(new GregorianCalendar());
        addition2.setOriginalAmount(10);

        humidor.setName("My Humidor");
        humidor.setUser(user);
        humidor.setCigars(new HashSet<>(asList(addition, addition2)));

        humidorRepository.save(humidor);
        List<HumidorDTO> dtos = humidorService.getHumidors(user.getUsername());
        assertEquals("One humidor is returned", 1, dtos.size());
    }


}
