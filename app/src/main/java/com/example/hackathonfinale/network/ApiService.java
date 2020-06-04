package com.example.hackathonfinale.network;

import com.example.hackathonfinale.entities.Comment;
import com.example.hackathonfinale.entities.Poll;
import com.example.hackathonfinale.entities.Problem;
import com.example.hackathonfinale.entities.Question;
import com.example.hackathonfinale.entities.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiService {

    @POST("user")
    Call<User> addUser(@Body User user);
    @POST("question")
    Call<Question> addQuestion(@Body Question question);
    @POST("problem")
    Call<Problem> addProblem(@Body Problem problem);
    @POST("poll")
    Call<Poll> addPoll(@Body Poll poll);
    @POST("bars")
    Call<Comment> addComment(@Body Comment comment);

    @GET("user/all")
    Call<List<User>> getListUser();
    @GET("question/all")
    Call<List<Question>> getListQuestion();
    @GET("problem/all/")
    Call<List<Problem>> getListProblem();
    @GET("poll/all")
    Call<List<Poll>> getListPoll();
    @GET("bars/all")
    Call<List<Comment>> getListComment();
}


