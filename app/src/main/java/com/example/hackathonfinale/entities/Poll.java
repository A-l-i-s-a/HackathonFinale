package com.example.hackathonfinale.entities;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Poll {

    @SerializedName("id")
    @Expose
    private long id;
    private Problem promblem;
    @SerializedName("phoneNumber")
    @Expose
    private String phoneNumber;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Problem getPromblem() {
        return promblem;
    }

    public void setPromblem(Problem promblem) {
        this.promblem = promblem;
    }
}
