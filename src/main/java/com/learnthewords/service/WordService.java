package com.learnthewords.service;

import com.learnthewords.entity.Word;

import java.util.List;

public interface WordService {

    Word findByName(String name);
    Word findWordById(Integer id);

    List<Word> findAll();
}
