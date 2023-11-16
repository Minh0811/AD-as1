package com.khaiminh.assignment1vokhaiminh.Controllers;
import com.khaiminh.assignment1vokhaiminh.Models.FitnessChallenge;
import com.khaiminh.assignment1vokhaiminh.R;

import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.List; // Import for List
import android.widget.ImageView;


public class FitnessChallengeAdapter extends RecyclerView.Adapter<FitnessChallengeAdapter.ViewHolder> {

    private List<FitnessChallenge> fitnessChallenges;
    private Context context;

    // Constructor accepting a list of FitnessChallenge
    public FitnessChallengeAdapter(List<FitnessChallenge> fitnessChallenges) {
        this.fitnessChallenges = fitnessChallenges;
    }

    // Constructor and other necessary methods

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_fitness_challenge, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        FitnessChallenge challenge = fitnessChallenges.get(position);
        holder.textViewChallengeName.setText(challenge.getName());
        holder.textViewChallengeDescription.setText(challenge.getDescription());

        // Convert the image name to a resource ID
        int imageResId = holder.itemView.getContext().getResources().getIdentifier(
                challenge.getImageName(), "drawable", holder.itemView.getContext().getPackageName());

        // Set the image resource
        holder.imageViewChallenge.setImageResource(imageResId);
    }





    @Override
    public int getItemCount() {
        return fitnessChallenges != null ? fitnessChallenges.size() : 0;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textViewChallengeName;
        public TextView textViewChallengeDescription;
        public ImageView imageViewChallenge;

        public ViewHolder(View itemView) {
            super(itemView);
            textViewChallengeName = itemView.findViewById(R.id.textViewChallengeName);
            textViewChallengeDescription = itemView.findViewById(R.id.textViewChallengeDescription);
            imageViewChallenge = itemView.findViewById(R.id.imageViewChallenge);
        }
    }


    public void updateFitnessChallenges(List<FitnessChallenge> newChallenges) {
        fitnessChallenges = newChallenges;
        notifyDataSetChanged();
    }
}
