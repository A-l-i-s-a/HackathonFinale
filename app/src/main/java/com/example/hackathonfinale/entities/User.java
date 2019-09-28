package com.example.hackathonfinale.entities;

public class User {
    private String phoneNumber;
    private String nickname;
    private String password;
    private UserType type;

    public User(String phoneNumber, String nickname, String password, UserType type) {
        this.phoneNumber = phoneNumber;
        this.nickname = nickname;
        this.password = password;
        this.type = type;
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

    public UserType getType() {
        return type;
    }

    public void setType(UserType type) {
        this.type = type;
    }
}