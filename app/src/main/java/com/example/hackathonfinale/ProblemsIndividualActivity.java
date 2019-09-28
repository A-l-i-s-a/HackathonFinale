package com.example.hackathonfinale;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.example.hackathonfinale.entities.Problem;

import java.util.ArrayList;

public class ProblemsIndividualActivity extends AppCompatActivity {
    ArrayList<Problem> problems = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_problems_individual);

        problems = Generator.generatorProduct(50);

        RecyclerView recyclerView = findViewById(R.id.recyclerViewProblems);
        Adapter adapter = new Adapter(problems, new Adapter.ViewHolder.Listener() {
            @Override
            public void onMovieClick(Problem problem) {
                Intent intent = new Intent(ProblemsIndividualActivity.this, ProblemDetailsActivity.class);

                intent.putExtra("textViewProblemName", problem.getName());
                intent.putExtra("textViewProblemDiscription", problem.getDescription());

                startActivity(intent);
            }
        });

        recyclerView.setAdapter(adapter);

        LinearLayoutManager gridLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(gridLayoutManager);
    }
}
