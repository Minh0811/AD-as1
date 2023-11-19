package com.khaiminh.assignment1vokhaiminh.Controllers.HomeScreen;
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


// Adapter class for displaying fitness challenges in a RecyclerView
public class FitnessChallengeAdapter extends RecyclerView.Adapter<FitnessChallengeAdapter.ViewHolder> {

    // Interface for handling item clicks
    public interface OnItemClickListener {
        void onItemClick(int fitnessChallengeId);
    }

    private List<FitnessChallenge> fitnessChallenges; // List of FitnessChallenge objects
    private Context context;
    private OnItemClickListener listener; // Listener for item clicks

    // Constructor: Initializes the adapter with a list of fitness challenges and a click listener
    public FitnessChallengeAdapter(List<FitnessChallenge> fitnessChallenges, OnItemClickListener listener) {
        this.fitnessChallenges = fitnessChallenges;
        this.listener = listener;
    }

    // Inflates the layout for each fitness challenge item
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_fitness_challenge, parent, false);
        return new ViewHolder(view, fitnessChallenges.get(viewType), listener);
    }

    // Binds data to each fitness challenge item
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        FitnessChallenge challenge = fitnessChallenges.get(position);
        holder.textViewChallengeName.setText(challenge.getName());
        holder.textViewChallengeDescription.setText(challenge.getDescription());

        // Setting the image for the challenge
        int imageResId = holder.itemView.getContext().getResources().getIdentifier(
                challenge.getImageName(), "drawable", holder.itemView.getContext().getPackageName());
        holder.imageViewChallenge.setImageResource(imageResId);

        // Setting up click listener for each item
        holder.itemView.setOnClickListener(v -> listener.onItemClick(challenge.getId()));

        // Displaying difficulty as stars
        String difficultyStars = generateStars(challenge.getDifficulty());
        holder.textViewChallengeDifficulty.setText("Difficulty: " + difficultyStars);
    }

    // Generates a string of star characters based on difficulty level
    private String generateStars(int difficulty) {
        StringBuilder stars = new StringBuilder();
        for (int i = 0; i < difficulty; i++) {
            stars.append("⭐ "); // Star character
        }
        return stars.toString();
    }

    // Returns the total number of items in the list
    @Override
    public int getItemCount() {
        return fitnessChallenges != null ? fitnessChallenges.size() : 0;
    }

    // ViewHolder class for fitness challenge items
    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textViewChallengeName;
        public TextView textViewChallengeDescription;
        public ImageView imageViewChallenge;
        public TextView textViewChallengeDifficulty;

        public ViewHolder(View itemView, final FitnessChallenge challenge, final OnItemClickListener listener) {
            super(itemView);
            // Binding views from the layout
            textViewChallengeName = itemView.findViewById(R.id.textViewChallengeName);
            textViewChallengeDescription = itemView.findViewById(R.id.textViewChallengeDescription);
            imageViewChallenge = itemView.findViewById(R.id.imageViewChallenge);
            textViewChallengeDifficulty = itemView.findViewById(R.id.textViewChallengeDifficulty);

            // Setting up click listener for the item
            itemView.setOnClickListener(v -> {
                if (getBindingAdapterPosition() != RecyclerView.NO_POSITION) {
                    listener.onItemClick(challenge.getId());
                }
            });
        }
    }

    // Method to update the list of fitness challenges
    public void updateFitnessChallenges(List<FitnessChallenge> newChallenges) {
        fitnessChallenges = newChallenges;
        notifyDataSetChanged(); // Notifying the adapter of the data change
    }
}

