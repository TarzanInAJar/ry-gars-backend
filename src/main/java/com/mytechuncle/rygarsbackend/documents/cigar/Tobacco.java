package com.mytechuncle.rygarsbackend.documents.cigar;

import com.mongodb.lang.NonNull;

public class Tobacco {
    @NonNull
    private String region; // I.E. Dominican
    private String type;  // criollo
    private Integer year; // I.E. 1998

    public Tobacco() {
        // default constructor
    }

    public Tobacco(String region) {
        this.region = region;
    }

    public Tobacco(String region, String type) {
        this.region = region;
        this.type = type;
    }

    public Tobacco(String region, Integer year) {
        this.region = region;
        this.year = year;
    }

    public Tobacco(String region, String type, Integer year) {
        this.region = region;
        this.type = type;
        this.year = year;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }
}
