package com.mytechuncle.rygarsbackend.dto.cigar;

import java.util.List;

public class CigarDTO {
    private String id;
    private String brand;
    private String subBrand;
    private String name;
    private String sizeName;
    private Integer ringGauge; // I.E. 50
    private Float length; // I.E. 5.25
    private WrapperDTO wrapper;
    private TobaccoDTO binder;
    private List<TobaccoDTO> filler;
    private String strength;

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

    public WrapperDTO getWrapper() {
        return wrapper;
    }

    public void setWrapper(WrapperDTO wrapper) {
        this.wrapper = wrapper;
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

    public String getStrength() {
        return strength;
    }

    public void setStrength(String strength) {
        this.strength = strength;
    }
}
