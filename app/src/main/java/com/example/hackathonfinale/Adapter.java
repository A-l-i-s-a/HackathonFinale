package com.example.hackathonfinale;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hackathonfinale.entities.Problem;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    private final List<Problem> problems;
    private final ViewHolder.Listener onClickListener;

    public Adapter(List<Problem> problems, ViewHolder.Listener onClickListener) {
        this.problems = problems;
        this.onClickListener = onClickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_problems, parent, false);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickListener.onProblemClick((Problem) view.getTag());
            }
        });
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Problem problem = problems.get(position);
        holder.bind(problem);
        holder.itemView.setTag(problem);
    }

    @Override
    public int getItemCount() {
        return problems.size();
    }

    final static class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView textViewProblemName;
        private final TextView textViewProblemDiscription;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewProblemName = itemView.findViewById(R.id.textViewProblemName);
            textViewProblemDiscription = itemView.findViewById(R.id.textViewProblemDiscription);
        }

        private void bind(@NonNull Problem problem) {
            textViewProblemName.setText(problem.getName());
            textViewProblemDiscription.setText(problem.getDescription());
        }

        interface Listener {
            void onProblemClick(Problem problem);
        }

    }
}
