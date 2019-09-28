package com.example.hackathonfinale;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hackathonfinale.entities.Question;

import java.util.List;

public class PollAdapter extends RecyclerView.Adapter<PollAdapter.ViewHolder> {
    private final List<Question> questions;

    public PollAdapter(List<Question> questions) {
        this.questions = questions;
    }

    @NonNull
    @Override
    public PollAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.poll_item, parent, false);
        return new PollAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PollAdapter.ViewHolder holder, int position) {
        Question question = questions.get(position);
        holder.bind(question);
        holder.itemView.setTag(question);
    }

    @Override
    public int getItemCount() {
        return questions.size();
    }

    final static class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView textViewProblemName;
        private final RadioButton radioButton_YES;
        private final RadioButton radioButton_NO;
        private final RadioButton radioButton_MAYBEYES;
        private final RadioButton radioButton_MAYBENO;
        private final RadioButton radioButton_NEUTRAKL;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewProblemName = itemView.findViewById(R.id.textViewQuestion);
            radioButton_YES = itemView.findViewById(R.id.radioButton);
            radioButton_NO = itemView.findViewById(R.id.radioButton2);
            radioButton_MAYBEYES = itemView.findViewById(R.id.radioButton3);
            radioButton_MAYBENO = itemView.findViewById(R.id.radioButton4);
            radioButton_NEUTRAKL = itemView.findViewById(R.id.radioButton5);
        }

        private void bind(@NonNull Question question) {
            System.out.println(question.getName());
            textViewProblemName.setText(question.getName());
            radioButton_YES.setText("YES");
            radioButton_NO.setText("NO");
            radioButton_MAYBEYES.setText("MAYBEYES");
            radioButton_MAYBENO.setText("MAYBENO");
            radioButton_NEUTRAKL.setText("NEUTRAKL");
        }

    }
}
