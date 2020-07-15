package com.example.sookhtjet;

public class TrainingCourseItem {
    private int image;
    private String name;
    private float price;

    public TrainingCourseItem(int image, String name, float price) {
        this.image = image;
        this.name = name;
        this.price = price;
    }



    public int getImage() {
        return image;
    }

    public String getName() {
        return name;
    }

    public float getPrice() {
        return price;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
