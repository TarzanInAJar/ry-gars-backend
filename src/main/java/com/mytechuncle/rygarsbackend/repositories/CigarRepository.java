package com.mytechuncle.rygarsbackend.repositories;

import com.mytechuncle.rygarsbackend.documents.cigar.Cigar;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.ExistsQuery;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CigarRepository extends MongoRepository<Cigar, String> {

    List<Cigar> findAllByBrand(String brand);

    Page<Cigar> findAllByBrand(Pageable pageable, String brand);

    @ExistsQuery("{ " +
            "'brand' : ?0" +
            "'subBrand' : ?1" +
            "'name' : ?2" +
            "'sizeName' : ?3" +
            "}")
    boolean exists(String brand, String subBrand, String name, String sizeName);


    @Query("{ " +
            "'brand' : ?0" +
            "'subBrand' : ?1" +
            "'name' : ?2" +
            "'sizeName' : ?3" +
            "}")
    Optional<Cigar> findOne(String brand, String subBrand, String name, String sizeName);
}
