package com.mytechuncle.rygarsbackend.documents.cigar;

import com.mongodb.lang.NonNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.mapping.Document;

import java.net.URL;
import java.util.List;

@Document
@CompoundIndex(unique = true, name = "unique_name_brand", def = "{'brand': 1, 'name': 1}")
// TODO not created automatically, needs to be manually created
public class Cigar {
    @Id
    private String id;
    @NonNull
    private String brand; // I.E. Arturo Fuente
    private List<String> tags; // I.E. Fuente Fuente
    @NonNull
    private String name; // I.E. Opus X The Lost City
    @NonNull
    private Tobacco binder;
    @NonNull
    private List<Tobacco> filler;
    @NonNull
    private STRENGTH strength;
    @NonNull
    private List<CigarSize> sizes;
    private List<URL> images;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @NonNull
    public String getBrand() {
        return brand;
    }

    public void setBrand(@NonNull String brand) {
        this.brand = brand;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    @NonNull
    public String getName() {
        return name;
    }

    public void setName(@NonNull String name) {
        this.name = name;
    }

    @NonNull
    public Tobacco getBinder() {
        return binder;
    }

    public void setBinder(@NonNull Tobacco binder) {
        this.binder = binder;
    }

    @NonNull
    public List<Tobacco> getFiller() {
        return filler;
    }

    public void setFiller(@NonNull List<Tobacco> filler) {
        this.filler = filler;
    }

    @NonNull
    public STRENGTH getStrength() {
        return strength;
    }

    public void setStrength(@NonNull STRENGTH strength) {
        this.strength = strength;
    }

    public List<URL> getImages() {
        return images;
    }

    public void setImages(List<URL> images) {
        this.images = images;
    }

    @NonNull
    public List<CigarSize> getSizes() {
        return sizes;
    }

    public void setSizes(@NonNull List<CigarSize> sizes) {
        this.sizes = sizes;
    }
}
