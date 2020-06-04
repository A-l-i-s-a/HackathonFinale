package com.example.hackathonfinale.problemsIndividual;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.hackathonfinale.Generator;
import com.example.hackathonfinale.entities.Problem;
import com.example.hackathonfinale.entities.Question;
import com.example.hackathonfinale.network.DataRepository;

import java.util.List;

public class ProblemsIndividualVM extends ViewModel {
    private MutableLiveData<List<Problem>> mutableLiveData;
    private DataRepository dataRepository;
    public void init() {
        if (mutableLiveData != null) {
            return;
        }
        dataRepository = DataRepository.getInstance();
        mutableLiveData = dataRepository.getListProblem();

    }

    public LiveData<List<Problem>> getMutableLiveData() {
        return mutableLiveData;
    }
    public void post(Problem problem) {
        dataRepository.postProblem(problem);
    }
}
