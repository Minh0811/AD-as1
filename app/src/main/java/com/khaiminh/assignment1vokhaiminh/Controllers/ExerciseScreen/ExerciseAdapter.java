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
        holder.textViewDescription.setText(exercise.getDescription());

        String videoUrl = exercise.getVideoUrl();
        if (videoUrl != null && !videoUrl.isEmpty()) {
            holder.webViewExercise.getSettings().setJavaScriptEnabled(true);
            holder.webViewExercise.loadData(getEmbeddedVideoHTML(videoUrl), "text/html", "utf-8");
        }
    }
    private String getEmbeddedVideoHTML(String videoUrl) {
        // Assuming the video URL is a YouTube link
        String videoId = extractYoutubeVideoId(videoUrl);
        return "<html><body><iframe width=\"match_parent\" height=\"wrap_content\" src=\"https://www.youtube.com/embed/" + videoId + "\" frameborder=\"0\" allowfullscreen></iframe></body></html>";
    }
    private String extractYoutubeVideoId(String videoUrl) {
        // Extract the YouTube video ID from the URL
        Uri videoUri = Uri.parse(videoUrl);
        return videoUri.getQueryParameter("v");
    }
    @Override
    public int getItemCount() {
        return exercises != null ? exercises.size() : 0;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textViewExerciseName;
        public TextView textViewDescription;
        public WebView webViewExercise;

        public ViewHolder(View itemView) {
            super(itemView);
            textViewExerciseName = itemView.findViewById(R.id.textViewExerciseName);
            textViewDescription = itemView.findViewById(R.id.textViewDescription);
            webViewExercise = itemView.findViewById(R.id.webview);
        }
    }
}