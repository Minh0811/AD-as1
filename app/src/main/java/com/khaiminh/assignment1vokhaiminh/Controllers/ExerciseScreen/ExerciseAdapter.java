package com.khaiminh.assignment1vokhaiminh.Controllers.ExerciseScreen;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.DrawableRes;
import androidx.recyclerview.widget.RecyclerView;

import com.khaiminh.assignment1vokhaiminh.Models.Exercise;
import com.khaiminh.assignment1vokhaiminh.R;
import java.util.List;

// Adapter class for Exercise RecyclerView
public class ExerciseAdapter extends RecyclerView.Adapter<ExerciseAdapter.ViewHolder> {
    private List<Exercise> exercises; // List of Exercise objects
    private Context context; // Context for inflating the layout

    // Constructor
    public ExerciseAdapter(List<Exercise> exercises, Context context) {
        this.exercises = exercises;
        this.context = context;
    }

    // Inflates the item layout and creates ViewHolder
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_exercise, parent, false);
        return new ViewHolder(view);
    }

    // Binds data to each item in RecyclerView
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Exercise exercise = exercises.get(position);
        // Set exercise details to TextViews
        holder.textViewExerciseName.setText(exercise.getName());
        holder.textViewDescription.setText(exercise.getDescription());
        holder.textViewDescription1.setText(exercise.getDescription1());
        holder.textViewDescription2.setText(exercise.getDescription2());
        holder.texViewTips.setText(exercise.getTips());
        // Load and display video if URL is available
        String videoUrl = exercise.getVideoUrl();
        if (videoUrl != null && !videoUrl.isEmpty()) {
            holder.webViewExercise.getSettings().setJavaScriptEnabled(true);
            holder.webViewExercise.loadData(getEmbeddedVideoHTML(videoUrl), "text/html", "utf-8");
        }
    }
    // Helper method to embed YouTube video in WebView
    private String getEmbeddedVideoHTML(String videoUrl) {
        // Assuming the video URL is a YouTube link
        String videoId = extractYoutubeVideoId(videoUrl);
        return "<html><body><iframe width=\"match_parent\" height=\"wrap_content\" src=\"https://www.youtube.com/embed/" + videoId + "\" frameborder=\"0\" allowfullscreen></iframe></body></html>";
    }

    // Helper method to extract YouTube video ID from URL
    private String extractYoutubeVideoId(String videoUrl) {
        // Extract the YouTube video ID from the URL
        Uri videoUri = Uri.parse(videoUrl);
        return videoUri.getQueryParameter("v");
    }

    // Returns the size of the exercises list
    @Override
    public int getItemCount() {
        return exercises != null ? exercises.size() : 0;
    }

    // ViewHolder class for RecyclerView items
    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textViewExerciseName;
        public TextView textViewDescription;
        public TextView textViewDescription1;
        public TextView textViewDescription2;
        public TextView texViewTips;
        public WebView webViewExercise;

        // Constructor to initialize views
        public ViewHolder(View itemView) {
            super(itemView);
            textViewExerciseName = itemView.findViewById(R.id.textViewExerciseName);
            textViewDescription = itemView.findViewById(R.id.textViewDescription);
            textViewDescription1 = itemView.findViewById(R.id.textViewDescription1);
            textViewDescription2 = itemView.findViewById(R.id.textViewDescription2);
            texViewTips = itemView.findViewById(R.id.textViewTips);
            webViewExercise = itemView.findViewById(R.id.webview);
        }
    }
}