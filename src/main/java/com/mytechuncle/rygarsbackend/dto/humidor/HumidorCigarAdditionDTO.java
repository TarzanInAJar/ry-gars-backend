package com.mytechuncle.rygarsbackend.dto.humidor;

import java.util.Calendar;
import java.util.List;

public class HumidorCigarAdditionDTO {
    private String cigarId;
    private Integer originalAmount;
    private Calendar dateAdded;
    private List<SmokeEventDTO> smokeEvents;

    public String getCigarId() {
        return cigarId;
    }

    public void setCigar(String id) {
        this.cigarId = cigarId;
    }

    public Integer getOriginalAmount() {
        return originalAmount;
    }

    public void setOriginalAmount(Integer originalAmount) {
        this.originalAmount = originalAmount;
    }

    public Calendar getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(Calendar dateAdded) {
        this.dateAdded = dateAdded;
    }

    public List<SmokeEventDTO> getSmokeEvents() {
        return smokeEvents;
    }

    public void setSmokeEvents(List<SmokeEventDTO> smokeEvents) {
        this.smokeEvents = smokeEvents;
    }

}
