package com.mytechuncle.rygarsbackend.dto.cigar;

public class WrapperDTO {
    private String region;
    private String shade;

    public WrapperDTO() {
        // default constructor
    }

    public WrapperDTO(String region, String shade) {
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
