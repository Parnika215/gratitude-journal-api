package com.example.gratitude.controller;

import org.springframework.web.bind.annotation.*;
import java.util.List;

import com.example.gratitude.model.GratitudeEntry;
import com.example.gratitude.service.GratitudeService;
import com.example.gratitude.service.PromptService;

@RestController
@RequestMapping("/api/gratitude")
public class GratitudeController {

    private final GratitudeService service;
    private final PromptService promptService;

    public GratitudeController(GratitudeService service, PromptService promptService) {
        this.service = service;
        this.promptService = promptService;
    }

    // CREATE
    @PostMapping
    public GratitudeEntry addEntry(@RequestBody GratitudeEntry entry) {
        return service.addEntry(entry);
    }

    // READ ALL
    @GetMapping
    public List<GratitudeEntry> getAllEntries() {
        return service.getAllEntries();
    }

    // READ ONE
    @GetMapping("/{id}")
    public GratitudeEntry getEntry(@PathVariable Long id) {
        return service.getEntry(id);
    }

    // UPDATE
    @PutMapping("/{id}")
    public GratitudeEntry updateEntry(@PathVariable Long id, @RequestBody GratitudeEntry entry) {
        return service.updateEntry(id, entry);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public void deleteEntry(@PathVariable Long id) {
        service.deleteEntry(id);
    }

    // DAILY PROMPT
    @GetMapping("/prompt")
    public String getDailyPrompt() {
        return promptService.getDailyPrompt();
    }
}