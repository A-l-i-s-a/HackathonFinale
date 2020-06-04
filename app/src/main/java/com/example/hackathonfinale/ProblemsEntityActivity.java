package com.example.hackathonfinale;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.example.hackathonfinale.entities.Problem;
import com.example.hackathonfinale.network.DataRepository;

import java.util.ArrayList;

public class ProblemsEntityActivity extends AppCompatActivity {
    ArrayList<Problem> problems = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_problems_entity);



        RecyclerView recyclerView = findViewById(R.id.recyclerViewProblemsEntity);
        Adapter adapter = new Adapter(problems, new Adapter.ViewHolder.Listener() {
            @Override
            public void onProblemClick(Problem problem) {
                Intent intent = new Intent(ProblemsEntityActivity.this, ProblemDetailsActivity.class);

//                intent.putExtra("textViewProblemName", problem.getName());
//                intent.putExtra("textViewProblemDiscription", problem.getDescription());
                intent.putExtra(Problem.class.getSimpleName(), problem);

                startActivity(intent);
            }
        });

        recyclerView.setAdapter(adapter);

        LinearLayoutManager gridLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(gridLayoutManager);
    }
}
