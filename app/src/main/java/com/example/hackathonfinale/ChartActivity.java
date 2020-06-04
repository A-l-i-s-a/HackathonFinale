package com.example.hackathonfinale;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Color;
import android.os.Bundle;

import com.example.hackathonfinale.entities.Question;

import java.util.ArrayList;
import java.util.List;

public class ChartActivity extends AppCompatActivity {

    private List<Question> questions = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chart);

        questions = Generator.generatorQuestion(20);

        RecyclerView recyclerView = findViewById(R.id.recyclerViewChart);

        ChartAdapter adapter = new ChartAdapter(questions);
        recyclerView.setAdapter(adapter);

        LinearLayoutManager gridLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(gridLayoutManager);
    }
}
