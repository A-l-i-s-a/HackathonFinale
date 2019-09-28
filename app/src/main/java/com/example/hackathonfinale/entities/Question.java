package com.example.hackathonfinale.entities;

import java.util.ArrayList;

public class Question {
    private String name;
    private Answers answer;
    private ArrayList<String> arrayListAnswers;
    private static final ArrayList<String> defoltArrayListanswers = new ArrayList<>();

    {
        defoltArrayListanswers.add("YES");
        defoltArrayListanswers.add("NO");
        defoltArrayListanswers.add("MAYBEYES");
        defoltArrayListanswers.add("MAYBENO");
        defoltArrayListanswers.add("NEUTRAKL");
    }

    public Question(String name) {
        this(name, Answers.NEUTRAKL, defoltArrayListanswers);
    }

    public Question(String name, Answers answer) {
        this(name, answer, defoltArrayListanswers);
    }

    public Question(String name, Answers answer, ArrayList<String> arrayListAnswers) {
        this.name = name;
        this.answer = answer;
        this.arrayListAnswers = arrayListAnswers;
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
