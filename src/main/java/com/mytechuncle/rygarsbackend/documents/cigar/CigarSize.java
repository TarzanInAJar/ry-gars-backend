package com.mytechuncle.rygarsbackend.documents.cigar;

import com.mongodb.lang.NonNull;

import java.net.URL;
import java.util.List;
import java.util.Optional;

//TODO unique constraint? for sizeName
public class CigarSize {
    @NonNull
    private String sizeName; // I.E. Robustu
    private String alternativeSizeName;
    @NonNull
    private Integer ringGauge; // I.E. 50
    private Integer ringGauge2; // I.E. 52, for cigars that vary in size
    @NonNull
    private Float length; // I.E. 5.25
    @NonNull
    private List<Wrapper> wrappers;
    private List<URL> images;

    private Optional<Tobacco> binder;  // overrides the default
    private Optional<List<Tobacco>> filler;
    private Optional<STRENGTH> strength;

    @NonNull
    public String getSizeName() {
        return sizeName;
    }

    public void setSizeName(@NonNull String sizeName) {
        this.sizeName = sizeName;
    }

    public String getAlternativeSizeName() {
        return alternativeSizeName;
    }

    public void setAlternativeSizeName(String alternativeSizeName) {
        this.alternativeSizeName = alternativeSizeName;
    }

    @NonNull
    public Integer getRingGauge() {
        return ringGauge;
    }

    public void setRingGauge(@NonNull Integer ringGauge) {
        this.ringGauge = ringGauge;
    }

    public Integer getRingGauge2() {
        return ringGauge2;
    }

    public void setRingGauge2(Integer ringGauge2) {
        this.ringGauge2 = ringGauge2;
    }

    @NonNull
    public Float getLength() {
        return length;
    }

    public void setLength(@NonNull Float length) {
        this.length = length;
    }

    @NonNull
    public List<Wrapper> getWrappers() {
        return wrappers;
    }

    public void setWrappers(@NonNull List<Wrapper> wrappers) {
        this.wrappers = wrappers;
    }

    public List<URL> getImages() {
        return images;
    }

    public void setImages(List<URL> images) {
        this.images = images;
    }

    public Optional<Tobacco> getBinder() {
        return binder;
    }

    public void setBinder(Optional<Tobacco> binder) {
        this.binder = binder;
    }

    public Optional<List<Tobacco>> getFiller() {
        return filler;
    }

    public void setFiller(Optional<List<Tobacco>> filler) {
        this.filler = filler;
    }

    public Optional<STRENGTH> getStrength() {
        return strength;
    }

    public void setStrength(Optional<STRENGTH> strength) {
        this.strength = strength;
    }
}
