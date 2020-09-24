package com.mytechuncle.rygarsbackend.documents.cigar;

import com.mongodb.lang.NonNull;

import java.net.URL;
import java.util.List;

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

    private Tobacco binder;  // overrides the default
    private List<Tobacco> filler;
    private STRENGTH strength;

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
}
