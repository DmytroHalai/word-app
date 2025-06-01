package com.example.wordApp.service;

import com.example.wordApp.model.Word;
import com.example.wordApp.repository.WordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class WordService {
    private final WordRepository wordRepository;

    @Autowired
    public WordService(WordRepository wordRepository) {
        this.wordRepository = wordRepository;
    }

    public Word saveWord(String value) {
        return wordRepository.save(new Word(value));
    }

    public Optional<Word> findWord(String value) {
        return wordRepository.findByValue(value);
    }
}
