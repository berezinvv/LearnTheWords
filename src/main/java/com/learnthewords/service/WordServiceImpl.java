package com.learnthewords.service;

import com.learnthewords.entity.Word;
import com.learnthewords.repository.WordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class WordServiceImpl implements WordService {

    @Autowired
    private WordRepository wordRepository;

    @Override
    public Word findByName(String name) {
        return wordRepository.findByName(name);
    }

    @Override
    @Transactional
    public Word findWordById(Integer id) {
        return wordRepository.getOne(id);
    }

    @Override
    public List<Word> findAll() {
        return wordRepository.findAll();
    }
}
