package com.example.hackathonfinale.entities;

public class Comment {
    private User author;
    private String text;
    private int id;

    public Comment(User author, String text) {
        this.author = author;
        this.text = text;
    }

    public int getId() {
        return id;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setId(int id) {
        this.id = id;
    }


}
