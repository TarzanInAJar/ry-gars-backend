package com.mytechuncle.rygarsbackend.bootstrap;

import java.net.URL;
import java.util.List;

public class BootstrapCigar {
    private String brand;
    private List<String> tags;
    private String name;
    private BootstrapTobacco binder;
    private List<BootstrapTobacco> filler;
    private List<BootstrapWrapper> wrappers;
    private String strength;
    private List<BootstrapCigarSize> sizes;
    private List<URL> images;

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

    public List<BootstrapWrapper> getWrappers() {
        return wrappers;
    }

    public void setWrappers(List<BootstrapWrapper> wrappers) {
        this.wrappers = wrappers;
    }

    public String getStrength() {
        return strength;
    }

    public void setStrength(String strength) {
        this.strength = strength;
    }

    public List<BootstrapCigarSize> getSizes() {
        return sizes;
    }

    public void setSizes(List<BootstrapCigarSize> sizes) {
        this.sizes = sizes;
    }

    public List<URL> getImages() {
        return images;
    }

    public void setImages(List<URL> images) {
        this.images = images;
    }
}
