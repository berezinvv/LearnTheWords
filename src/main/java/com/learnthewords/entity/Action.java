package com.learnthewords.entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "actions")
public class Action {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private int id;

    @ManyToOne
    @JoinColumn(name = "word", nullable = false)
    private Word word;

    @Column(name = "dateOfLastEntry")
    private Timestamp periodFrom;

    @Column(name = "outcome", nullable=false)
    private boolean outcome;

    public boolean isOutcome() {
        return outcome;
    }

    public void setOutcome(boolean outcome) {
        this.outcome = outcome;
    }

    public Action(Word word, Timestamp periodFrom, boolean outcome) {
        this.word = word;
        this.periodFrom = periodFrom;
        this.outcome = outcome;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Word getWord() {
        return word;
    }

    public void setWord(Word name) {
        this.word = word;
    }

    public Timestamp getPeriodFrom() {
        return periodFrom;
    }

    public void setPeriodFrom(Timestamp periodFrom) {
        this.periodFrom = periodFrom;
    }
}
