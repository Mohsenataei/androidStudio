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

public class StoryItemAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    List<StoryItem> storyItemList;
    Context context;

    public StoryItemAdapter(List<StoryItem> storyItemList, Context context) {
        this.storyItemList = storyItemList;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.storymodel_item, parent, false);
        return new ViewHolderStoryItem(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        StoryItem storyItem = storyItemList.get(position);
        final ViewHolderStoryItem vh =(ViewHolderStoryItem)holder;
        vh.profileImage.setImageResource(storyItem.getImage());
    }

    @Override
    public int getItemCount() {
        return storyItemList.size();
    }


    class ViewHolderStoryItem extends RecyclerView.ViewHolder {

        ImageView profileImage;

        public ViewHolderStoryItem(@NonNull View itemView) {
            super(itemView);
            profileImage = (ImageView) itemView.findViewById(R.id.profile_image);
        }

    }
}