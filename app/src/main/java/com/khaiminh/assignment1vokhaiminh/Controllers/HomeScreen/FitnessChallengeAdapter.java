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


public class FitnessChallengeAdapter extends RecyclerView.Adapter<FitnessChallengeAdapter.ViewHolder> {

    public interface OnItemClickListener {
        void onItemClick(int fitnessChallengeId);
    }

    private List<FitnessChallenge> fitnessChallenges;
    private Context context;
    private OnItemClickListener listener;

    // Constructor accepting a list of FitnessChallenge
    public FitnessChallengeAdapter(List<FitnessChallenge> fitnessChallenges, OnItemClickListener listener) {
        this.fitnessChallenges = fitnessChallenges;
        this.listener = listener;
    }

    // Constructor and other necessary methods


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_fitness_challenge, parent, false);
        return new ViewHolder(view, fitnessChallenges.get(viewType), listener);
    }


    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        FitnessChallenge challenge = fitnessChallenges.get(position);
        holder.textViewChallengeName.setText(challenge.getName());
        holder.textViewChallengeDescription.setText(challenge.getDescription());

        int imageResId = holder.itemView.getContext().getResources().getIdentifier(
                challenge.getImageName(), "drawable", holder.itemView.getContext().getPackageName());
        holder.imageViewChallenge.setImageResource(imageResId);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onItemClick(challenge.getId());
            }
        });
    }




    @Override
    public int getItemCount() {
        return fitnessChallenges != null ? fitnessChallenges.size() : 0;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textViewChallengeName;
        public TextView textViewChallengeDescription;
        public ImageView imageViewChallenge;

        public ViewHolder(View itemView, final FitnessChallenge challenge, final OnItemClickListener listener) {
            super(itemView);
            textViewChallengeName = itemView.findViewById(R.id.textViewChallengeName);
            textViewChallengeDescription = itemView.findViewById(R.id.textViewChallengeDescription);
            imageViewChallenge = itemView.findViewById(R.id.imageViewChallenge);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (getBindingAdapterPosition() != RecyclerView.NO_POSITION) {
                        listener.onItemClick(challenge.getId());
                    }
                }
            });
        }
    }







    public void updateFitnessChallenges(List<FitnessChallenge> newChallenges) {
        fitnessChallenges = newChallenges;
        notifyDataSetChanged();
    }
}
