package com.example.sookhtjet;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class TrainingCourseAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    List<TrainingCourseItem> CourseItemList;
    Context context;

    public TrainingCourseAdapter(List<TrainingCourseItem> courseItemList, Context context) {
        CourseItemList = courseItemList;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.trainingcourserecyclerview_item, parent, false);
        return new ViewHolderTrainingCourseItem(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        TrainingCourseItem trainingCourseItem = CourseItemList.get(position);
        final TrainingCourseAdapter.ViewHolderTrainingCourseItem vh =(TrainingCourseAdapter.ViewHolderTrainingCourseItem)holder;
        vh.imageView.setImageResource(trainingCourseItem.getImage());
        vh.txtName.setText(trainingCourseItem.getName());
        vh.txtPrice.setText(trainingCourseItem.getPrice());
    }

    @Override
    public int getItemCount() {
        return CourseItemList.size();
    }


    static class ViewHolderTrainingCourseItem extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView txtName;
        TextView txtPrice;

        public ViewHolderTrainingCourseItem(@NonNull View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.profile_image);
            txtName = (TextView) itemView.findViewById(R.id.txtName);
            txtPrice = (TextView) itemView.findViewById(R.id.txtPrice);
        }

    }

}
