package com.example.hackathonfinale.entities;

import java.util.List;

public class Question {
    private String name;
    private Answers answer;

    public Question(String name, Answers answer) {
        this.name = name;
        this.answer = answer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Answers getAnswer() {
        return answer;
    }

    public void setAnswer(Answers answer) {
        this.answer = answer;
    }
}
