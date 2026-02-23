package com.example.gratitude.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class GratitudeEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String description;

    private LocalDate date;

    public GratitudeEntry() {}

    public GratitudeEntry(String title, String description, LocalDate date) {
        this.title = title;
        this.description = description;
        this.date = date;
    }

    public Long getId() { return id; }

    public String getTitle() { return title; }

    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }

    public void setDescription(String description) { this.description = description; }

    public LocalDate getDate() { return date; }

    public void setDate(LocalDate date) { this.date = date; }
}