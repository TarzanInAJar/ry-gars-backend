package com.mytechuncle.rygarsbackend.dto.cigar;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.net.URL;
import java.util.List;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class CigarSizeDTO {
    private String sizeName;
    private String alternativeSizeName;
    private Integer ringGauge;
    private Integer ringGauge2;
    private Float length;
    private List<WrapperDTO> wrappers;
    private List<URL> images;
    private TobaccoDTO binder;
    private List<TobaccoDTO> filler;
    private String strength;

    public String getSizeName() {
        return sizeName;
    }

    public void setSizeName(String sizeName) {
        this.sizeName = sizeName;
    }

    public String getAlternativeSizeName() {
        return alternativeSizeName;
    }

    public void setAlternativeSizeName(String alternativeSizeName) {
        this.alternativeSizeName = alternativeSizeName;
    }

    public Integer getRingGauge() {
        return ringGauge;
    }

    public void setRingGauge(Integer ringGauge) {
        this.ringGauge = ringGauge;
    }

    public Integer getRingGauge2() {
        return ringGauge2;
    }

    public void setRingGauge2(Integer ringGauge2) {
        this.ringGauge2 = ringGauge2;
    }

    public Float getLength() {
        return length;
    }

    public void setLength(Float length) {
        this.length = length;
    }

    public List<WrapperDTO> getWrappers() {
        return wrappers;
    }

    public void setWrappers(List<WrapperDTO> wrappers) {
        this.wrappers = wrappers;
    }

    public List<URL> getImages() {
        return images;
    }

    public void setImages(List<URL> images) {
        this.images = images;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CigarSizeDTO sizeDTO = (CigarSizeDTO) o;
        return Objects.equals(sizeName, sizeDTO.sizeName) &&
                Objects.equals(alternativeSizeName, sizeDTO.alternativeSizeName) &&
                Objects.equals(ringGauge, sizeDTO.ringGauge) &&
                Objects.equals(ringGauge2, sizeDTO.ringGauge2) &&
                Objects.equals(length, sizeDTO.length) &&
                Objects.equals(wrappers, sizeDTO.wrappers) &&
                Objects.equals(images, sizeDTO.images) &&
                Objects.equals(binder, sizeDTO.binder) &&
                Objects.equals(filler, sizeDTO.filler) &&
                Objects.equals(strength, sizeDTO.strength);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sizeName, alternativeSizeName, ringGauge, ringGauge2, length, wrappers, images, binder, filler, strength);
    }
}
