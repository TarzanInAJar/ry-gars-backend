package com.mytechuncle.rygarsbackend.repositories;

import com.mytechuncle.rygarsbackend.documents.cigar.Cigar;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CigarRepository extends MongoRepository<Cigar, String> {

    List<Cigar> findAllByBrand(String brand);

    Page<Cigar> findAllByBrand(Pageable pageable, String brand);
}
