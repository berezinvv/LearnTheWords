package com.learnthewords.repository;

import com.learnthewords.entity.Word;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface WordRepository extends JpaRepository<Word, Integer> {
    Word findByName(String name);
    Word findWordById(Integer id);
}
