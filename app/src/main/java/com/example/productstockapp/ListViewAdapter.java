package com.example.productstockapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ListViewAdapter extends BaseAdapter {
    List<ProductItem> AvailableitemList;
    Context activityContext;




    public ListViewAdapter(List<ProductItem> itemList, Context context) {
        this.AvailableitemList = itemList;
        activityContext = context;
    }
    @Override
    public int getCount() {
        return AvailableitemList.size();
    }

    @Override
    public Object getItem(int position) {
        return  AvailableitemList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View availableRowView = LayoutInflater.from(activityContext).inflate(R.layout.row_of_list, parent, false);

        ProductItem currentItem = AvailableitemList.get(position);

        TextView itemNameTextView = availableRowView.findViewById(R.id.textViewList);
        itemNameTextView.setText(currentItem.getProductName());

        ImageView productImage = availableRowView.findViewById(R.id.myImageViewList);
        productImage.setImageBitmap(currentItem.getImagePath());



        return availableRowView;
    }
}
