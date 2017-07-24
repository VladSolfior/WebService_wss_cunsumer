package com.vladapps.fmanager.model;

import java.time.LocalDateTime;

public class BuysExceed {
    private final LocalDateTime dateTime;

    private final String description;

    private final int total;

    private final boolean exceed;

    public BuysExceed(LocalDateTime dateTime, String description, int total, boolean exceed) {
        this.dateTime = dateTime;
        this.description = description;
        this.total = total;
        this.exceed = exceed;
    }

    @Override
    public String toString() {
        return "BuysExceed{" +
                "dateTime=" + dateTime +
                ", description='" + description + '\'' +
                ", total=" + total +
                ", exceed=" + exceed +
                '}';
    }
}