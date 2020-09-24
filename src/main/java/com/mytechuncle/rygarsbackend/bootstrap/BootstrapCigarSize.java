package com.mytechuncle.rygarsbackend.bootstrap;

import java.net.URL;
import java.util.List;

public class BootstrapCigarSize {
    private String sizeName;
    private String alternativeSizeName;
    private Integer ringGauge;
    private Integer ringGauge2;
    private Float length;
    private List<BootstrapWrapper> wrappers;
    private List<URL> images;
    private BootstrapTobacco binder;
    private List<BootstrapTobacco> filler;
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

    public List<BootstrapWrapper> getWrappers() {
        return wrappers;
    }

    public void setWrappers(List<BootstrapWrapper> wrappers) {
        this.wrappers = wrappers;
    }

    public List<URL> getImages() {
        return images;
    }

    public void setImages(List<URL> images) {
        this.images = images;
    }

    public BootstrapTobacco getBinder() {
        return binder;
    }

    public void setBinder(BootstrapTobacco binder) {
        this.binder = binder;
    }

    public List<BootstrapTobacco> getFiller() {
        return filler;
    }

    public void setFiller(List<BootstrapTobacco> filler) {
        this.filler = filler;
    }

    public String getStrength() {
        return strength;
    }

    public void setStrength(String strength) {
        this.strength = strength;
    }
}
