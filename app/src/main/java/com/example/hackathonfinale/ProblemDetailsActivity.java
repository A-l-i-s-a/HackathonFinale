package com.example.hackathonfinale;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.hackathonfinale.entities.Poll;
import com.example.hackathonfinale.entities.Problem;
import com.example.hackathonfinale.entities.Question;

import java.util.ArrayList;
import java.util.List;

public class ProblemDetailsActivity extends AppCompatActivity {

    private List<Question> questions = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_problem_details);

        TextView textViewProblemName = findViewById(R.id.textViewNameDetailsProblem);
        TextView textViewProblemDiscription = findViewById(R.id.textViewDiscriptionDetailsProblem);

        Bundle extras = getIntent().getExtras();

        final Problem problem;
        if(extras!=null) {
            problem = (Problem) extras.getSerializable(Problem.class.getSimpleName());
            textViewProblemName.setText(problem.getName());
            textViewProblemDiscription.setText(problem.getDescription());
            Poll poll = problem.getPoll();


        }

        questions = Generator.generatorQuestion(20);

        RecyclerView recyclerView = findViewById(R.id.recyclerViewQuestion);
        PollAdapter adapter = new PollAdapter(questions);

        recyclerView.setAdapter(adapter);

        LinearLayoutManager gridLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(gridLayoutManager);

//        if (extras != null) {
//            textViewProblemName.setText(extras.getString("textViewProblemName"));
//            textViewProblemDiscription.setText(extras.getString("textViewProblemDiscription"));
//        }
    }
}
