package com.khaiminh.assignment1vokhaiminh.Controllers.MealPlanScreen;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.khaiminh.assignment1vokhaiminh.Models.MealPlan;
import com.khaiminh.assignment1vokhaiminh.R;
import java.util.List;

public class MealPlanAdapter extends RecyclerView.Adapter<MealPlanAdapter.MealPlanViewHolder> {

    private List<MealPlan> mealPlanList;

    public MealPlanAdapter(List<MealPlan> mealPlanList) {
        this.mealPlanList = mealPlanList;
    }

    @NonNull
    @Override
    public MealPlanViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.meal_plan_item, parent, false);
        return new MealPlanViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MealPlanViewHolder holder, int position) {
        MealPlan mealPlan = mealPlanList.get(position);
        holder.textViewMealPlanName.setText(mealPlan.getName());
        holder.textViewMealPlanDescription.setText(mealPlan.getDescription());
        int imageResId = holder.itemView.getContext().getResources().getIdentifier(
                mealPlan.getImageName(), "drawable", holder.itemView.getContext().getPackageName());
        holder.imageViewMealPlan.setImageResource(imageResId);
        // Set other fields as needed
    }

    @Override
    public int getItemCount() {
        return mealPlanList.size();
    }

    static class MealPlanViewHolder extends RecyclerView.ViewHolder {
        TextView textViewMealPlanName;
        TextView textViewMealPlanDescription;
        ImageView imageViewMealPlan;
        // Other views

        public MealPlanViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewMealPlanName = itemView.findViewById(R.id.textViewMealPlanName);
            textViewMealPlanDescription = itemView.findViewById(R.id.textViewMealPlanDescription);
            imageViewMealPlan = itemView.findViewById(R.id.imageViewMealPlan);
            // Initialize other views
        }
    }
}
