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
            "'name' : ?1" +
            "}")
    boolean exists(String brand, String name);


    @Query("{ " +
            "'brand' : ?0" +
            "'name' : ?1" +
            "}")
    Optional<Cigar> findOne(String brand, String name);

    @Query("{ " +
            "$or: [" +
            "{'brand' : { $regex: /.*?0.*/, $options: 'i' } }" +
            //"{'subBrand' : { $regex: /.*?0.*/, $options: 'i' } }" + TODO search on tags
            "{'name' : { $regex: /.*?0.*/, $options: 'i' } }" +
            "]}")
    Page<IdName> findAllByBrandOrSubBrandOrName(String search, Pageable pageable);

    public class IdName {
        private String id;
        private String brand;
        private List<String> tags;
        private String name;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getBrand() {
            return brand;
        }

        public void setBrand(String brand) {
            this.brand = brand;
        }

        public List<String> getTags() {
            return tags;
        }

        public void setTags(List<String> tags) {
            this.tags = tags;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
