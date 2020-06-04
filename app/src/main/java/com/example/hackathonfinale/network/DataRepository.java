package com.example.hackathonfinale.network;

import androidx.lifecycle.MutableLiveData;

import com.example.hackathonfinale.entities.Comment;
import com.example.hackathonfinale.entities.Poll;
import com.example.hackathonfinale.entities.Problem;
import com.example.hackathonfinale.entities.Question;
import com.example.hackathonfinale.entities.User;

import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import timber.log.Timber;

public class DataRepository implements Repository {
    private static DataRepository dataRepository;
    private ApiService apiService;

    public DataRepository() {
        apiService = App.getApi();
    }

    public static DataRepository getInstance() {
        if (dataRepository == null) {
            dataRepository = new DataRepository();
        }
        return dataRepository;
    }

    @Override
    public MutableLiveData<List<User>> getListUser() {
        MutableLiveData<List<User>> listUser = new MutableLiveData<>();
        apiService.getListUser().enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(@NotNull Call<List<User>> call, @NotNull Response<List<User>> response) {
                if (response.isSuccessful()) {
                    listUser.setValue(response.body());
                    Timber.i(" onResponse = %s", response.body());
                }
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
                listUser.setValue(null);
                Timber.i(t);
            }
        });

        return listUser;
    }


     @Override
    public MutableLiveData<List<Comment>> getListComment() {
        MutableLiveData<List<Comment>> listComment = new MutableLiveData<>();
        apiService.getListComment().enqueue(new Callback<List<Comment>>() {
            @Override
            public void onResponse(@NotNull Call<List<Comment>> call, @NotNull Response<List<Comment>> response) {
                if (response.isSuccessful()) {
                    listComment.setValue(response.body());
                    Timber.i(" onResponse = %s", response.body());
                }
            }

            @Override
            public void onFailure(Call<List<Comment>> call, Throwable t) {
                listComment.setValue(null);
                Timber.i(t);
            }
        });

        return listComment;
    }

     @Override
    public MutableLiveData<List<Poll>> getListPoll() {
        MutableLiveData<List<Poll>> listPoll = new MutableLiveData<>();
        apiService.getListPoll().enqueue(new Callback<List<Poll>>() {
            @Override
            public void onResponse(@NotNull Call<List<Poll>> call, @NotNull Response<List<Poll>> response) {
                if (response.isSuccessful()) {
                    listPoll.setValue(response.body());
                    Timber.i(" onResponse = %s", response.body());
                }
            }

            @Override
            public void onFailure(Call<List<Poll>> call, Throwable t) {
                listPoll.setValue(null);
                Timber.i(t);
            }
        });

        return listPoll;
    }

     @Override
    public MutableLiveData<List<Problem>> getListProblem() {
        MutableLiveData<List<Problem>> listProblem = new MutableLiveData<>();
        apiService.getListProblem().enqueue(new Callback<List<Problem>>() {
            @Override
            public void onResponse(@NotNull Call<List<Problem>> call, @NotNull Response<List<Problem>> response) {
                if (response.isSuccessful()) {
                    System.out.println("response.body() = " + response.body());
                    listProblem.setValue(response.body());
                    Timber.i(" onResponse = %s", response.body());
                }
            }

            @Override
            public void onFailure(Call<List<Problem>> call, Throwable t) {
                listProblem.setValue(null);
                System.out.println(t);
                Timber.i(t);
            }
        });
         System.out.println("listProblem.getValue() = " + listProblem.getValue());
        return listProblem;
    }

     @Override
    public MutableLiveData<List<Question>> getListQuestion() {
        MutableLiveData<List<Question>> listQuestion = new MutableLiveData<>();
        apiService.getListQuestion().enqueue(new Callback<List<Question>>() {
            @Override
            public void onResponse(@NotNull Call<List<Question>> call, @NotNull Response<List<Question>> response) {
                if (response.isSuccessful()) {
                    listQuestion.setValue(response.body());
                    Timber.i(" onResponse = %s", response.body());
                }
            }

            @Override
            public void onFailure(Call<List<Question>> call, Throwable t) {
                listQuestion.setValue(null);
                Timber.i(t);
            }
        });

        return listQuestion;
    }


    @Override
    public void postUser(User User) {
        apiService.addUser(User).enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if (response.isSuccessful()) {
                    Timber.i("response %s", response.body().getFullname());
                } else {
                    Timber.i("response code %s", response.code());
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Timber.i(t);
            }
        });
    }


    @Override
    public void postComment(Comment Comment) {
        apiService.addComment(Comment).enqueue(new Callback<Comment>() {
            @Override
            public void onResponse(Call<Comment> call, Response<Comment> response) {
                if (response.isSuccessful()) {
                    Timber.i("response %s", response.body().getAuthor());
                } else {
                    Timber.i("response code %s", response.code());
                }
            }

            @Override
            public void onFailure(Call<Comment> call, Throwable t) {
                Timber.i(t);
            }
        });
    }

    @Override
    public void postPoll(Poll Poll) {
        apiService.addPoll(Poll).enqueue(new Callback<Poll>() {
            @Override
            public void onResponse(Call<Poll> call, Response<Poll> response) {
                if (response.isSuccessful()) {
                    Timber.i("response %s", response.body().getQuestions());
                } else {
                    Timber.i("response code %s", response.code());
                }
            }

            @Override
            public void onFailure(Call<Poll> call, Throwable t) {
                Timber.i(t);
            }
        });
    }

    @Override
    public void postProblem(Problem problem) {
        Timber.i("\n\n\nstart postProblem\n\n\n");
        apiService.addProblem(problem).enqueue(new Callback<Problem>() {
            @Override
            public void onResponse(Call<Problem> call, Response<Problem> response) {
                if (response.isSuccessful()) {
                    System.out.println("response = " + response);
                    Timber.i("response %s", response.body().getName());
                } else {
                    Timber.i("response code %s", response.code());
                }
            }

            @Override
            public void onFailure(Call<Problem> call, Throwable t) {
                System.out.println(t);
                Timber.i(t);
            }
        });
    }

    @Override
    public void postQuestion(Question Question) {
        apiService.addQuestion(Question).enqueue(new Callback<Question>() {
            @Override
            public void onResponse(Call<Question> call, Response<Question> response) {
                if (response.isSuccessful()) {
                    Timber.i("response %s", response.body().getName());
                } else {
                    Timber.i("response code %s", response.code());
                }
            }

            @Override
            public void onFailure(Call<Question> call, Throwable t) {
                Timber.i(t);
            }
        });
    }

}
