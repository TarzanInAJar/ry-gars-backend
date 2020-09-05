package com.mytechuncle.rygarsbackend.repositories;

import com.mytechuncle.rygarsbackend.documents.humidor.Humidor;
import com.mytechuncle.rygarsbackend.documents.user.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HumidorRepository extends MongoRepository<Humidor, String> {

    List<Humidor> findAllByUser(User user);
}
