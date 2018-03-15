package com.learnthewords.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.learnthewords.entity.Word;
import com.learnthewords.repository.WordRepository;
import com.learnthewords.service.WordService;
import json.Leo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.List;
import java.util.Random;

@Controller
@RequestMapping(path = "/demo")
public class MainController {

    @Autowired
    private WordRepository wordRepository;
    ;

    @GetMapping(path = "/getRandomWord")
    public @ResponseBody
    Word getRandomWord() {

        Random random = new Random();
        List<Word> wordList = wordRepository.findAll();
        int numberOfWords = wordList.size();

        return wordRepository.findWordById(random.nextInt(numberOfWords));
    }

    @GetMapping(path = "/getJsonWord")
    public @ResponseBody
    Leo getJsonWord() {

        Random random = new Random();
        List<Word> wordList = wordRepository.findAll();
        int numberOfWords = wordList.size();

        Leo leo = readValuejsonData(wordRepository.findWordById(random.nextInt(numberOfWords)));

        return leo;
    }

    @GetMapping(path = "/all")
    public @ResponseBody
    Iterable<Word> getAllUsers() {
        // This returns a JSON or XML with the users
        return wordRepository.findAll();
    }

    public Leo readValuejsonData(Word word) {

        ObjectMapper objectMapper = new ObjectMapper();
        String jsonText = "";
        Leo leo = new Leo();
        try {
            InputStream is = new URL("http://api.lingualeo.com/gettranslates?word=" + word.getName()).openStream();
            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(is, "utf-8"), 8);
                StringBuilder sb = new StringBuilder();
                String line = null;
                while ((line = reader.readLine()) != null) {
                    sb.append(line);
                }
                jsonText = sb.toString();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                is.close();
            }
            leo = objectMapper.readValue(jsonText, Leo.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return leo;
    }


}
