package com.learnthewords.service;

import com.learnthewords.entity.Word;
import com.learnthewords.repository.WordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WordServiceImpl  implements WordService {

    @Autowired
    private WordRepository wordRepository;

    @Override
    public Word findByName(String name) {
        return wordRepository.findByName(name);
    }

    @Override
    public List<Word> findAll() {
        return wordRepository.findAll();
    }
}
