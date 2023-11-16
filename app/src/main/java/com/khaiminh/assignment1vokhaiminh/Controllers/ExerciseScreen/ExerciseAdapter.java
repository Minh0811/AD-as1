package com.khaiminh.assignment1vokhaiminh.Controllers.ExerciseScreen;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.DrawableRes;
import androidx.recyclerview.widget.RecyclerView;

import com.khaiminh.assignment1vokhaiminh.Models.Exercise;
import com.khaiminh.assignment1vokhaiminh.R;
import java.util.List;

public class ExerciseAdapter extends RecyclerView.Adapter<ExerciseAdapter.ViewHolder> {

    private List<Exercise> exercises;
    private Context context;

    public ExerciseAdapter(List<Exercise> exercises, Context context) {
        this.exercises = exercises;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_exercise, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Exercise exercise = exercises.get(position);
        holder.textViewExerciseName.setText(exercise.getName());

        // Set the image
        if (!exercise.getImageNames().isEmpty()) {
            String imageName = exercise.getImageNames().get(0); // Assuming you want the first image
            @DrawableRes int imageResId = context.getResources().getIdentifier(imageName, "drawable", context.getPackageName());
            holder.imageViewExercise.setImageResource(imageResId);
        }
    }

    @Override
    public int getItemCount() {
        return exercises != null ? exercises.size() : 0;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textViewExerciseName;
        public ImageView imageViewExercise;

        public ViewHolder(View itemView) {
            super(itemView);
            textViewExerciseName = itemView.findViewById(R.id.textViewExerciseName);
            imageViewExercise = itemView.findViewById(R.id.imageViewExercise); // Make sure you have this ImageView in your item layout
        }
    }
}