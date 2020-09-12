package com.mytechuncle.rygarsbackend.dto.cigar;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class TobaccoDTO {
    private String region; // I.E. Dominican
    private String type;  // criollo
    private Integer year; // I.E. 1998

    public TobaccoDTO() {
        // default constructor
    }

    public TobaccoDTO(String region) {
        this.region = region;
    }

    public TobaccoDTO(String region, String type) {
        this.region = region;
    }

    public TobaccoDTO(String region, Integer year) {
        this.region = region;
    }

    public TobaccoDTO(String region, String type, Integer year) {
        this.region = region;
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
