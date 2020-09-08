package com.mytechuncle.rygarsbackend.documents.cigar;

import com.mongodb.lang.NonNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.mapping.Document;

import java.net.URL;
import java.util.List;

@Document
@CompoundIndex(unique = true, name = "unique_name_brand_size", def = "{'brand': 1, 'subBrand': 1, 'name': 1, 'sizeName': 1}")
// TODO not created automatically, needs to be manually created
public class Cigar {
    @Id
    private String id;
    @NonNull
    private String brand; // I.E. Arturo Fuente
    private String subBrand; // I.E. Fuente Fuente
    @NonNull
    private String name; // I.E. Opus X The Lost City
    @NonNull
    private String sizeName; // I.E. Robustu
    @NonNull
    private Integer ringGauge; // I.E. 50
    @NonNull
    private Float length; // I.E. 5.25
    @NonNull
    private Wrapper wrapper;
    @NonNull
    private Tobacco binder;
    @NonNull
    private List<Tobacco> filler;
    @NonNull
    private STRENGTH strength;
    private List<URL> images;

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

    public String getSubBrand() {
        return subBrand;
    }

    public void setSubBrand(String subBrand) {
        this.subBrand = subBrand;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSizeName() {
        return sizeName;
    }

    public void setSizeName(String sizeName) {
        this.sizeName = sizeName;
    }

    public Integer getRingGauge() {
        return ringGauge;
    }

    public void setRingGauge(Integer ringGauge) {
        this.ringGauge = ringGauge;
    }

    public Float getLength() {
        return length;
    }

    public void setLength(Float length) {
        this.length = length;
    }

    public Wrapper getWrapper() {
        return wrapper;
    }

    public void setWrapper(Wrapper wrapper) {
        this.wrapper = wrapper;
    }

    public Tobacco getBinder() {
        return binder;
    }

    public void setBinder(Tobacco binder) {
        this.binder = binder;
    }

    public List<Tobacco> getFiller() {
        return filler;
    }

    public void setFiller(List<Tobacco> filler) {
        this.filler = filler;
    }

    public STRENGTH getStrength() {
        return strength;
    }

    public void setStrength(STRENGTH strength) {
        this.strength = strength;
    }

    public List<URL> getImages() {
        return images;
    }

    public void setImages(List<URL> images) {
        this.images = images;
    }
}
