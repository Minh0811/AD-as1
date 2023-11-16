package com.khaiminh.assignment1vokhaiminh.Controllers.ExerciseScreen;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.viewpager2.widget.ViewPager2;
import androidx.recyclerview.widget.RecyclerView;

import com.khaiminh.assignment1vokhaiminh.Models.Exercise;
import com.khaiminh.assignment1vokhaiminh.R;

import java.util.ArrayList;
import java.util.List;

public class ImageSliderAdapter extends RecyclerView.Adapter<ImageSliderAdapter.SliderViewHolder> {
    private List<String> imageNames;
    private LayoutInflater inflater;

    public ImageSliderAdapter(Context context, List<Exercise> exercises) {
        this.inflater = LayoutInflater.from(context);
        this.imageNames = new ArrayList<>();
        for (Exercise exercise : exercises) {
            this.imageNames.addAll(exercise.getImageNames());
        }
    }

    @NonNull
    @Override
    public SliderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.slider_item, parent, false);
        return new SliderViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SliderViewHolder holder, int position) {
        String imageName = imageNames.get(position);
        int imageResId = getImageResIdByName(imageName, inflater.getContext());
        holder.imageView.setImageResource(imageResId);
    }

    @Override
    public int getItemCount() {
        return imageNames.size();
    }

    private int getImageResIdByName(String imageName, Context context) {
        return context.getResources().getIdentifier(imageName, "drawable", context.getPackageName());
    }

    public static class SliderViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;

        public SliderViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageViewSliderItem);
        }
    }
}


