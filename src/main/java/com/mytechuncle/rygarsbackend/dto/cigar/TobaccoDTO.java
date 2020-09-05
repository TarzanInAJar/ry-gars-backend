package com.mytechuncle.rygarsbackend.dto.cigar;

import java.util.Optional;

public class TobaccoDTO {
    private String region; // I.E. Dominican
    private Optional<String> type;  // criollo
    private Optional<Integer> year; // I.E. 1998

    public TobaccoDTO() {
        // default constructor
    }

    public TobaccoDTO(String region) {
        this.region = region;
        this.type = Optional.empty();
        this.year = Optional.empty();
    }

    public TobaccoDTO(String region, String type) {
        this.region = region;
        this.type = Optional.of(type);
    }

    public TobaccoDTO(String region, Integer year) {
        this.region = region;
        this.type = Optional.empty();
        this.year = Optional.of(year);
    }

    public TobaccoDTO(String region, String type, Integer year) {
        this.region = region;
        this.type = Optional.of(type);
        this.year = Optional.of(year);
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public Optional<String> getType() {
        return type;
    }

    public void setType(Optional<String> type) {
        this.type = type;
    }

    public Optional<Integer> getYear() {
        return year;
    }

    public void setYear(Optional<Integer> year) {
        this.year = year;
    }
}
