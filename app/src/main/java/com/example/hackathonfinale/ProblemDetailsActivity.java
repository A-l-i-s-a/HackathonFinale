package com.example.hackathonfinale;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class ProblemDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_problem_details);

        TextView textViewProblemName = findViewById(R.id.textViewNameDetailsProblem);
        TextView textViewProblemDiscription = findViewById(R.id.textViewDiscriptionDetailsProblem);

        Bundle extras = getIntent().getExtras();

        if (extras != null) {
            textViewProblemName.setText(extras.getString("textViewProblemName"));
            textViewProblemDiscription.setText(extras.getString("textViewProblemDiscription"));
        }
    }
}
