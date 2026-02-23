package com.example.gratitude.service;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Random;

@Service
public class PromptService {

    private final List<String> prompts = List.of(
            "What made you smile today?",
            "Who are you grateful for today?",
            "What small thing are you thankful for?",
            "What did you enjoy about today?",
            "What made you feel peaceful today?",
            "What is one achievement you're proud of?",
            "Who helped you recently?",
            "What is something beautiful you noticed today?"
    );

    public String getDailyPrompt() {
        Random random = new Random();
        return prompts.get(random.nextInt(prompts.size()));
    }
}