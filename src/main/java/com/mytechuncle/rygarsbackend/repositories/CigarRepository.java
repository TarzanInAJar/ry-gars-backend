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

    // TODO anyway to do this and use a collation?
    @ExistsQuery("{ " +
            "'brand' : { $regex: /^?0$/, $options: 'i' }" +
            "'name' : { $regex: /^?1$/, $options: 'i' }" +
            "}")
    boolean exists(String brand, String name);


    @Query(collation = "{ locale: 'en_US', strength: 1 }",
            value = "{ " +
            "'brand' : ?0" +
            "'name' : ?1" +
            "}")
    Optional<Cigar> findOne(String brand, String name);

    // TODO does specifying a collation do anything/take advantage of indexes when using regex queries?
    @Query(collation = "{ locale: 'en_US', strength: 1 }",
            value = "{ " +
            "$or: [" +
            "{'brand' : { $regex: /.*?0.*/, $options: 'i' } }" +
            "{'tags' : { $regex: /.*?0.*/, $options: 'i' } }" +
            "{'name' : { $regex: /.*?0.*/, $options: 'i' } }" +
            "]}")
    Page<IdName> findAllByBrandOrTagsOrName(String search, Pageable pageable);

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
