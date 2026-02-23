package com.example.gratitude.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.gratitude.model.GratitudeEntry;

public interface GratitudeRepository extends JpaRepository<GratitudeEntry, Long> {
}