package com.mytechuncle.rygarsbackend.dto.cigar;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WrapperDTO that = (WrapperDTO) o;
        return Objects.equals(region, that.region) &&
                Objects.equals(shade, that.shade);
    }

    @Override
    public int hashCode() {
        return Objects.hash(region, shade);
    }
}
