package com.example.hackathonfinale.entities;

import java.util.List;

public class Poll {

    private int id;
    private int promblemId;
    private List<Question> questions;

    public Poll(List<Question> questions) {
        this.questions = questions;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }
}
