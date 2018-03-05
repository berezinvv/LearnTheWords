package com.learnthewords.service;

import com.learnthewords.entity.Word;

import java.util.List;
import java.util.Optional;

public interface WordService {

    Word findByName(String name);

    List<Word> findAll();
}
