package com.example.hackathonfinale;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hackathonfinale.entities.Problem;
import com.example.hackathonfinale.problemsIndividual.ProblemsIndividualVM;

import java.util.ArrayList;
import java.util.List;

public class ProblemsIndividualActivity extends AppCompatActivity {
    List<Problem> problems = new ArrayList<>();

    private ProblemsIndividualVM viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_problems_individual);

        viewModel = ViewModelProviders.of(this).get(ProblemsIndividualVM.class);
        viewModel.init();


        viewModel.getMutableLiveData().observe(this, list -> {
            problems.addAll(list);
            Adapter adapter = new Adapter(problems, problem -> {
                Intent intent = new Intent(ProblemsIndividualActivity.this, ProblemDetailsActivity.class);

//                intent.putExtra("textViewProblemName", problem.getName());
//                intent.putExtra("textViewProblemDiscription", problem.getDescription());
                intent.putExtra(Problem.class.getSimpleName(), problem);

                startActivity(intent);
            });
            RecyclerView recyclerView = findViewById(R.id.recyclerViewProblems);

            recyclerView.setAdapter(adapter);

            LinearLayoutManager gridLayoutManager = new LinearLayoutManager(this);
            recyclerView.setLayoutManager(gridLayoutManager);
        });
    }
}
