package com.example.gratitude.service;

import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;

import com.example.gratitude.model.GratitudeEntry;
import com.example.gratitude.repository.GratitudeRepository;

@Service
public class GratitudeService {

    private final GratitudeRepository repository;

    public GratitudeService(GratitudeRepository repository) {
        this.repository = repository;
    }

    // CREATE
    public GratitudeEntry addEntry(GratitudeEntry entry) {
        entry.setDate(LocalDate.now());
        return repository.save(entry);
    }

    // READ ALL
    public List<GratitudeEntry> getAllEntries() {
        return repository.findAll();
    }

    // READ ONE
    public GratitudeEntry getEntry(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Entry not found with id: " + id));
    }

    // UPDATE
    public GratitudeEntry updateEntry(Long id, GratitudeEntry updated) {
        return repository.findById(id)
                .map(existing -> {
                    existing.setTitle(updated.getTitle());
                    existing.setDescription(updated.getDescription());
                    return repository.save(existing);
                })
                .orElseThrow(() -> new RuntimeException("Entry not found with id: " + id));
    }

    // DELETE
    public void deleteEntry(Long id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Entry not found with id: " + id);
        }
        repository.deleteById(id);
    }
}