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

// Adapter class for the image slider in the Exercise Screen
public class ImageSliderAdapter extends RecyclerView.Adapter<ImageSliderAdapter.SliderViewHolder> {
    private List<String> imageNames; // List of image names to be displayed in the slider
    private LayoutInflater inflater; // LayoutInflater to inflate the view for each slider item

    // Constructor: Initializes the adapter with context and a list of exercises
    public ImageSliderAdapter(Context context, List<Exercise> exercises) {
        this.inflater = LayoutInflater.from(context);
        this.imageNames = new ArrayList<>();
        for (Exercise exercise : exercises) {
            this.imageNames.addAll(exercise.getImageNames()); // Extracting image names from each exercise
        }
    }

    // Inflates the slider item layout and returns a new ViewHolder
    @NonNull
    @Override
    public SliderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.slider_item, parent, false);
        return new SliderViewHolder(view);
    }

    // Binds data to each slider item
    @Override
    public void onBindViewHolder(@NonNull SliderViewHolder holder, int position) {
        String imageName = imageNames.get(position);
        int imageResId = getImageResIdByName(imageName, inflater.getContext());
        holder.imageView.setImageResource(imageResId); // Setting the image resource for the ImageView
    }

    // Returns the total number of items in the slider
    @Override
    public int getItemCount() {
        return imageNames.size();
    }

    // Helper method to get the resource ID of an image by its name
    private int getImageResIdByName(String imageName, Context context) {
        return context.getResources().getIdentifier(imageName, "drawable", context.getPackageName());
    }

    // ViewHolder class for the image slider
    public static class SliderViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView; // ImageView to display the image

        public SliderViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageViewSliderItem); // Binding the ImageView from the layout
        }
    }
}



