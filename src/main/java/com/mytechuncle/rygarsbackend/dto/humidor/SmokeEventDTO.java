package com.mytechuncle.rygarsbackend.dto.humidor;

import java.util.Calendar;

public class SmokeEventDTO {
    private Calendar date;
    private String comments;

    public Calendar getDate() {
        return date;
    }

    public void setDate(Calendar date) {
        this.date = date;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
}
