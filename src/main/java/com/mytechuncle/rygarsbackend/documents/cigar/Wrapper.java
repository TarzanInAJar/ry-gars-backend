package com.mytechuncle.rygarsbackend.documents.cigar;

import com.mongodb.lang.NonNull;

public class Wrapper {
    @NonNull
    private String shade;
    private String region;
    private String name;

    public Wrapper() {
        // default constructor
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getShade() {
        return shade;
    }

    public void setShade(String shade) {
        this.shade = shade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
