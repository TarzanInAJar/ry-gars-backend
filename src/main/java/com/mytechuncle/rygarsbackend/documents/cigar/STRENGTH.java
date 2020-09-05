package com.mytechuncle.rygarsbackend.documents.cigar;

public enum STRENGTH {
    MILD(0),
    MILD_MEDIUM(1),
    MEDIUM(2),
    MEDIUM_FULL(3),
    FULL(4);

    private int strength;

    STRENGTH(int strength) {
        this.strength = strength;
    }

    public int getValue() {
        return strength;
    }
}
