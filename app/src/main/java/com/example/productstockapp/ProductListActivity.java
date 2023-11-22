package com.example.productstockapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class ProductListActivity extends AppCompatActivity implements View.OnClickListener{
    ListViewAdapter adapter;
    ListView ItemList;

    ArrayList<ProductItem> productListLocal ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_list);
        Log.d("testing", "in on create 2nd activity ");
        ItemList = findViewById(R.id.listView);

        productListLocal=((MyApp)getApplication()).getProductItemList();
        Log.d("testing", "productListLocal before "+productListLocal.size());
        adapter = new ListViewAdapter(productListLocal,ProductListActivity.this);
        Log.d("testing", "productListLocal after "+productListLocal.size());
        ItemList.setAdapter(adapter);
//        ItemList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//
//            }
//        });

    }

    @Override
    public void onClick(View v) {

    }
}