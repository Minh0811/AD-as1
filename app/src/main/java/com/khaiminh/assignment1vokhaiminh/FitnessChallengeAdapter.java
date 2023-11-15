package com.khaiminh.assignment1vokhaiminh;
import com.khaiminh.assignment1vokhaiminh.Models.FitnessChallenge;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.List; // Import for List

public class FitnessChallengeAdapter extends RecyclerView.Adapter<FitnessChallengeAdapter.ViewHolder> {

    private List<FitnessChallenge> fitnessChallenges;

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
    }

    @Override
    public int getItemCount() {
        return fitnessChallenges.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textViewChallengeName;
        public TextView textViewChallengeDescription;

        public ViewHolder(View itemView) {
            super(itemView);
            textViewChallengeName = itemView.findViewById(R.id.textViewChallengeName);
            textViewChallengeDescription = itemView.findViewById(R.id.textViewChallengeDescription);
        }
    }
}
