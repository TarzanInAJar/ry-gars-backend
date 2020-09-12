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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CigarSizeDTO that = (CigarSizeDTO) o;
        return Objects.equals(sizeName, that.sizeName) &&
                Objects.equals(alternativeSizeName, that.alternativeSizeName) &&
                Objects.equals(ringGauge, that.ringGauge) &&
                Objects.equals(ringGauge2, that.ringGauge2) &&
                Objects.equals(length, that.length) &&
                Objects.equals(wrappers, that.wrappers) &&
                Objects.equals(images, that.images);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sizeName, alternativeSizeName, ringGauge, ringGauge2, length, wrappers, images);
    }
}
