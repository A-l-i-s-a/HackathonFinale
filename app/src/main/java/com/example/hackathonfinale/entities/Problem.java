package com.example.hackathonfinale.entities;

import java.util.List;

public class Problem {
    private String name;
    private String description;
    private Poll poll;
    private List<Comment> comments;

    public Problem() {
        this("name", "description", null, null);
    }

    public Problem(String name, String description, Poll poll, List<Comment> comments) {
        this.name = name;
        this.description = description;
        this.poll = poll;
        this.comments = comments;
    }

    public Problem(String name, String description) {
        this(name, description, null, null);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Poll getPoll() {
        return poll;
    }

    public void setPoll(Poll poll) {
        this.poll = poll;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
}
