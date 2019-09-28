package com.example.hackathonfinale;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hackathonfinale.entities.Answers;
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

//            List<Question> listQuestions = poll.getQuestions();



        }



        questions = Generator.generatorQuestion(20);

        RecyclerView recyclerView = findViewById(R.id.recyclerViewQuestion);
        PollAdapter adapter = new PollAdapter(questions, new PollAdapter.ViewHolder.Listener() {
            @Override
            public void onCheckedChanged(Question question, int i) {
                switch (i) {
                    case -1:
                        Toast.makeText(getApplicationContext(),  "Ничего не выбрано",
                                Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.radioButton:
                        question.setAnswer(Answers.YES);
                        Toast.makeText(getApplicationContext(), question.getName() + " : Первый переключатель",
                                Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.radioButton2:
                        question.setAnswer(Answers.NO);
                        Toast.makeText(getApplicationContext(), question.getName() + " : Второй переключатель",
                                Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.radioButton3:
                        question.setAnswer(Answers.MAYBEYES);
                        Toast.makeText(getApplicationContext(), question.getName() + " : Третий переключатель",
                                Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.radioButton4:
                        question.setAnswer(Answers.MAYBENO);
                        Toast.makeText(getApplicationContext(), question.getName() + " : 4 переключатель",
                                Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.radioButton5:
                        question.setAnswer(Answers.NEUTRAKL);
                        Toast.makeText(getApplicationContext(), question.getName() + " : 5 переключатель",
                                Toast.LENGTH_SHORT).show();
                        break;

                    default:
                        break;
                }
            }
        });

        recyclerView.setAdapter(adapter);

        LinearLayoutManager gridLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(gridLayoutManager);

//        if (extras != null) {
//            textViewProblemName.setText(extras.getString("textViewProblemName"));
//            textViewProblemDiscription.setText(extras.getString("textViewProblemDiscription"));
//        }

        Button button = findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ProblemDetailsActivity.this, ChartActivity.class);
                startActivity(intent);
            }
        });

    }
}
