package com.mytechuncle.rygarsbackend.documents.humidor;


import com.mytechuncle.rygarsbackend.documents.cigar.Cigar;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.util.Calendar;
import java.util.List;

public class HumidorCigarAddition {
    @DBRef
    private Cigar cigar;
    private Integer originalAmount;
    private Calendar dateAdded;
    private List<SmokeEvent> smokeEvents;

    public Cigar getCigar() {
        return cigar;
    }

    public void setCigar(Cigar cigar) {
        this.cigar = cigar;
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

    public List<SmokeEvent> getSmokeEvents() {
        return smokeEvents;
    }

    public void setSmokeEvents(List<SmokeEvent> smokeEvents) {
        this.smokeEvents = smokeEvents;
    }
}
