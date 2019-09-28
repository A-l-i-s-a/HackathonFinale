package com.example.hackathonfinale.entities;

public class User {
    private int id;
    private String phoneNumber;
    private String nickname;
    private String password;
    private String type;

    public User() {
    }

    public User(String phoneNumber, String nickname, String password, String type) {
        this.phoneNumber = phoneNumber;
        this.nickname = nickname;
        this.password = password;
        this.type = type;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
