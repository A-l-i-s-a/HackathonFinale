package com.example.hackathonfinale.entities;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Question {
    @SerializedName("id")
    @Expose
    private long id;
    @SerializedName("name")
    @Expose
    private String name;
    private Answers answer;
    private ArrayList<String> arrayListAnswers;
    private static final ArrayList<String> defoltArrayListanswers = new ArrayList<>();

    {
        defoltArrayListanswers.add("YES");
        defoltArrayListanswers.add("NO");
        defoltArrayListanswers.add("MAYBEYES");
        defoltArrayListanswers.add("MAYBENO");
        defoltArrayListanswers.add("NEUTRAL");
    }

    public Question(String name) {
        this(name, Answers.NEUTRAL, defoltArrayListanswers);
    }

    public Question(String name, Answers answer) {
        this(name, answer, defoltArrayListanswers);
    }

    public Question(String name, Answers answer, ArrayList<String> arrayListAnswers) {
        this.name = name;
        this.answer = answer;
        this.arrayListAnswers = arrayListAnswers;
    }

    public Question(String name, ArrayList<String> arrayListAnswers) {
        this(name, Answers.NEUTRAL, arrayListAnswers);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
