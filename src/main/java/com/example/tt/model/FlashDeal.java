package com.example.tt.model;

public class FlashDeal {
    int image;
    String title;

    public void setImage(int image) {
        this.image = image;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public FlashDeal(int image, String title, String description) {
        this.image = image;
        this.title = title;

    }

    public int getImage() {
        return image;
    }

    public String getTitle() {
        return title;
    }

}
