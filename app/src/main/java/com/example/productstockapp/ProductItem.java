package com.example.productstockapp;

import android.graphics.Bitmap;

import java.io.Serializable;

public class ProductItem {

    String productName;
    Bitmap imagePath;

    ProductItem(String productName, Bitmap imagePath) {
        this.productName = productName;
        this.imagePath = imagePath;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Bitmap getImagePath() {
        return imagePath;
    }

    public void setImagePath(Bitmap imagePath) {
        this.imagePath = imagePath;
    }

}
