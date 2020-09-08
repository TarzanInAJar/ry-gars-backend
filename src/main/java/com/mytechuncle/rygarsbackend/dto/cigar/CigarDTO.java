package com.mytechuncle.rygarsbackend.dto.cigar;

import java.net.URL;
import java.util.List;
import java.util.Objects;

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
    private List<URL> messages;

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

    public List<URL> getMessages() {
        return messages;
    }

    public void setMessages(List<URL> messages) {
        this.messages = messages;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CigarDTO cigarDTO = (CigarDTO) o;
        return Objects.equals(brand, cigarDTO.brand) &&
                Objects.equals(subBrand, cigarDTO.subBrand) &&
                Objects.equals(name, cigarDTO.name) &&
                Objects.equals(sizeName, cigarDTO.sizeName) &&
                Objects.equals(ringGauge, cigarDTO.ringGauge) &&
                Objects.equals(length, cigarDTO.length) &&
                Objects.equals(wrapper, cigarDTO.wrapper) &&
                Objects.equals(binder, cigarDTO.binder) &&
                Objects.equals(filler, cigarDTO.filler) &&
                Objects.equals(strength, cigarDTO.strength) &&
                Objects.equals(messages, cigarDTO.messages);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, subBrand, name, sizeName, ringGauge, length, wrapper, binder, filler, strength, messages);
    }
}
