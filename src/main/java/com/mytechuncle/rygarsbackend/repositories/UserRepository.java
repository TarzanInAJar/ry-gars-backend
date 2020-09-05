package com.mytechuncle.rygarsbackend.repositories;

import com.mytechuncle.rygarsbackend.documents.user.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepository extends MongoRepository<User, String> {
    Optional<User> findByUsername(String username);
}
