package com.mytechuncle.rygarsbackend.documents.cigar;

import com.mongodb.lang.NonNull;

public class Wrapper {
    @NonNull
    private String region;
    @NonNull
    private String shade;

    public Wrapper() {
        // default constructor
    }

    public Wrapper(String region, String shade) {
        this.region = region;
        this.shade = shade;
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
}
