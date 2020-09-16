package com.mytechuncle.rygarsbackend.dto.cigar;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.net.URL;
import java.util.List;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class CigarDTO {
    private String id;
    private String brand;
    private List<String> tags;
    private String name;
    private TobaccoDTO binder;
    private List<TobaccoDTO> filler;
    private List<WrapperDTO> wrappers;
    private String strength;
    private List<CigarSizeDTO> sizes;
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

    public TobaccoDTO getBinder() {
        return binder;
    }

    public void setBinder(TobaccoDTO binder) {
        this.binder = binder;
    }

    public List<TobaccoDTO> getFiller() {
        return filler;
    }

    public void setFiller(List<TobaccoDTO> filler) {
        this.filler = filler;
    }

    public List<WrapperDTO> getWrappers() {
        return wrappers;
    }

    public void setWrappers(List<WrapperDTO> wrappers) {
        this.wrappers = wrappers;
    }

    public String getStrength() {
        return strength;
    }

    public void setStrength(String strength) {
        this.strength = strength;
    }

    public List<CigarSizeDTO> getSizes() {
        return sizes;
    }

    public void setSizes(List<CigarSizeDTO> sizes) {
        this.sizes = sizes;
    }

    public List<URL> getImages() {
        return images;
    }

    public void setImages(List<URL> images) {
        this.images = images;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CigarDTO cigarDTO = (CigarDTO) o;
        return  Objects.equals(brand, cigarDTO.brand) &&
                Objects.equals(tags, cigarDTO.tags) &&
                Objects.equals(name, cigarDTO.name) &&
                Objects.equals(binder, cigarDTO.binder) &&
                Objects.equals(filler, cigarDTO.filler) &&
                Objects.equals(wrappers, cigarDTO.wrappers) &&
                Objects.equals(strength, cigarDTO.strength) &&
                Objects.equals(sizes, cigarDTO.sizes) &&
                Objects.equals(images, cigarDTO.images);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, tags, name, binder, filler, wrappers, strength, sizes, images);
    }

    public String getBrandAndName() {
        return brand + " " + name;
    }
}
