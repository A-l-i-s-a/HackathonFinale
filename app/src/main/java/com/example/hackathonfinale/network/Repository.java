package com.example.hackathonfinale.network;

import androidx.lifecycle.MutableLiveData;

import com.example.hackathonfinale.entities.Comment;
import com.example.hackathonfinale.entities.Poll;
import com.example.hackathonfinale.entities.Problem;
import com.example.hackathonfinale.entities.Question;
import com.example.hackathonfinale.entities.User;

import java.util.List;

public interface Repository {
    MutableLiveData<List<User>> getListUser();
    MutableLiveData<List<Problem>> getListProblem();
    MutableLiveData<List<Poll>> getListPoll();
    MutableLiveData<List<Comment>> getListComment();
    MutableLiveData<List<Question>> getListQuestion();

    void postUser(User event);
    void postProblem(Problem event);
    void postPoll(Poll event);
    void postComment(Comment event);
    void postQuestion(Question event);
}
