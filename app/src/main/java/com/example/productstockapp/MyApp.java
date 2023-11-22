package com.example.productstockapp;

import android.app.Application;
import android.util.Log;

import java.util.ArrayList;

public class MyApp extends Application {
   // ArrayList<ProductItem> productItemList;
    //public ArrayList<ProductItem> getProductItemList() {

    public ArrayList<ProductItem> getProductItemList() {
        if(productItemList == null) {
            Log.d("testing", "productItemList is null ");
        }

        return productItemList;
    }

    //  if (productItemList == null) {
      ArrayList<ProductItem>  productItemList = new ArrayList<>();


        //}
       // return productItemList;




    }

