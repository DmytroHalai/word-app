package com.example.wordApp.controller;

import com.example.wordApp.model.Word;
import com.example.wordApp.service.WordService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/words")
public class WordController {
    private final WordService wordService;

    public WordController(WordService wordService) {
        this.wordService = wordService;
    }

    @PostMapping
    public ResponseEntity<String> saveWord(@RequestBody String value) {
        Word saved = wordService.saveWord(value);
        return ResponseEntity.ok("Word saved with ID: " + saved.getId());
    }

    @GetMapping("/{value}")
    public ResponseEntity<String> getWord(@PathVariable String value) {
        return wordService.findWord(value)
                .map(word -> ResponseEntity.ok("Found word " + word.getValue() + " with ID: " + word.getId()))
                .orElseGet(() -> ResponseEntity.status(404).body("Word not found. Please add it first."));
    }
}
