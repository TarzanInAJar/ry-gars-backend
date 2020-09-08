package com.mytechuncle.rygarsbackend.dto.cigar;

import java.util.Objects;
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
        this.type = Optional.ofNullable(type);
    }

    public TobaccoDTO(String region, Integer year) {
        this.region = region;
        this.type = Optional.empty();
        this.year = Optional.ofNullable(year);
    }

    public TobaccoDTO(String region, String type, Integer year) {
        this.region = region;
        this.type = Optional.ofNullable(type);
        this.year = Optional.ofNullable(year);
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TobaccoDTO that = (TobaccoDTO) o;
        return Objects.equals(region, that.region) &&
                Objects.equals(type, that.type) &&
                Objects.equals(year, that.year);
    }

    @Override
    public int hashCode() {
        return Objects.hash(region, type, year);
    }
}
