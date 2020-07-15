package com.example.sookhtjet;

public class StoryItem {

    private int image;
    private boolean storyStatus;

    public StoryItem(int image) {
        this.image = image;
//        this.storyStatus = storyStatus;
    }

    public StoryItem() {
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

}
