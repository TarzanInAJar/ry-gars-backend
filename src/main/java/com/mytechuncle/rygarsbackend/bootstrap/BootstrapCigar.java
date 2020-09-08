package com.mytechuncle.rygarsbackend.bootstrap;

import java.util.List;
import java.util.Map;

public class BootstrapCigar {
    private String brand;
    private String subBrand;
    private String name;
    private String sizeName;
    private Integer ringGauge;
    private Float length;
    private Map<String, String> wrapper;
    private Map<String, String> binder;
    private List<Map<String, String>> filler;
    private String strength;

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

    public Map<String, String> getWrapper() {
        return wrapper;
    }

    public void setWrapper(Map<String, String> wrapper) {
        this.wrapper = wrapper;
    }

    public Map<String, String> getBinder() {
        return binder;
    }

    public void setBinder(Map<String, String> binder) {
        this.binder = binder;
    }

    public List<Map<String, String>> getFiller() {
        return filler;
    }

    public void setFiller(List<Map<String, String>> filler) {
        this.filler = filler;
    }

    public String getStrength() {
        return strength;
    }

    public void setStrength(String strength) {
        this.strength = strength;
    }
}
