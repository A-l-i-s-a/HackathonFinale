package com.example.hackathonfinale;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hackathonfinale.entities.Question;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.List;

public class ChartAdapter  extends RecyclerView.Adapter<ChartAdapter.ViewHolder> {
    private final List<Question> questions;

    public ChartAdapter(List<Question> questions) {
        this.questions = questions;
    }

    @NonNull
    @Override
    public ChartAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.chart_item, parent, false);
        RadioGroup radioGroup = view.findViewById(R.id.radioGroup);
        return new ChartAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ChartAdapter.ViewHolder holder, int position) {
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
        private final BarChart barChart;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewProblemName = itemView.findViewById(R.id.textViewTitle);
            barChart = itemView.findViewById(R.id.chart);
        }

        private void bind(@NonNull Question question) {
            textViewProblemName.setText(question.getName());

            ArrayList<BarEntry> entries = new ArrayList<>();

            entries.add(new BarEntry((int) (5 + (Math.random() * 20)), 0));
            entries.add(new BarEntry((int) (5 + (Math.random() * 20)), 1));
            entries.add(new BarEntry((int) (5 + (Math.random() * 20)), 2));
            entries.add(new BarEntry((int) (5 + (Math.random() * 20)), 3));
            entries.add(new BarEntry((int) (5 + (Math.random() * 20)), 4));


            BarDataSet dataset = new BarDataSet(entries, "# of Calls");

            ArrayList<String> labels = new ArrayList<>();
            labels.add("YES");
            labels.add("NO");
            labels.add("MAYBEYES");
            labels.add("MAYBENO");
            labels.add("NEUTRAKL");

            BarData data = new BarData(labels ,dataset);
            barChart.setData(data);

            dataset.setColors(ColorTemplate.COLORFUL_COLORS);


            barChart.invalidate();

        }

    }
}
