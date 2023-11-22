package com.example.productstockapp;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    EditText prouctNameTV;
Button takePhotoBtn, saveProductBtn;
ImageView productImage;
    String productNameByUSer;
    Bitmap bitmap;
    boolean prouctNameisEmpty=true;
    boolean prouctImageisEmpty=true;
    ArrayList<ProductItem> productListLocal = new ArrayList<ProductItem>();
    ActivityResultLauncher<Intent> cameraActivityLauncher;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        takePhotoBtn =findViewById(R.id.takeAPhoto);
        saveProductBtn =findViewById(R.id.saveButton);
        prouctNameTV = findViewById(R.id.productNameTextView);
        productImage= findViewById(R.id.myImageView);
       // takePhotoBtn.setOnClickListener(this);
        saveProductBtn.setOnClickListener(this);
        prouctNameTV.setOnClickListener(this);
        productImage.setOnClickListener(this);
        takePhotoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (checkSelfPermission(Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED){
                    Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    Log.d("permission","after give the permission");
                    // if (cameraIntent.resolveActivity(getPackageManager()) != null) {
                    // if there are more than 1 app to handle the intent,
                    // the os will ask the user.
                    //  startActivityForResult(cameraInent, REQUEST_IMAGE_CAPTURE);
                    cameraActivityLauncher.launch(cameraIntent);
                    // }
                }else {
                    requestPermissions(new String []{Manifest.permission.CAMERA},100);
                    Log.d("permission","after request the permission");

                }

            }
        });
        cameraActivityLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>(){
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if (result.getResultCode() == RESULT_OK){

                             bitmap= result.getData().getParcelableExtra("data");
                            productImage.setImageBitmap(bitmap);
                            Log.d("testing", "bitmap"+bitmap);
                            prouctImageisEmpty=false;

                        }
                    }
                });

    }

    @Override
    public void onClick(View view) {
        //Log.d("testing", "in onclick");

        Button clickedButton = (Button) view;
    productNameByUSer=prouctNameTV.getText().toString();
    if(!productNameByUSer.isEmpty()) {
        Log.d("testing", "productNameByUSer "+productNameByUSer);
        prouctNameisEmpty=false;
    }



       // if (clickedButton == takePhotoBtn) {

       // }


        if (clickedButton == saveProductBtn && prouctNameisEmpty || prouctImageisEmpty) {
            Log.d("testing", "in clickedButton == saveProductBtn && prouctNameisEmpty && prouctImageisEmpt");
            Toast.makeText(this ,"Enter a Product Name/ Take the Photo" , Toast.LENGTH_LONG).show();
        }
        if (clickedButton == saveProductBtn && !prouctNameisEmpty && !prouctImageisEmpty) {

            Log.d("testing", "in clickedButton == saveProductBtn && !prouctNameisEmpty && !prouctImageisEmpt");
           // productListLocal.add(new ProductItem(productNameByUSer,bitmap));

            // Log.d("testing", "in productListLocal"+((MyApp)getApplication()).getProductItemList().size());
            ProductItem p= new ProductItem(productNameByUSer,bitmap);
            ((MyApp)getApplication()).productItemList.add(p);
           // ((MyApp)getApplication()).productItemList.add);

           Log.d("testing", "in ((MyApp)getApplication()).productItemList"+((MyApp)getApplication()).productItemList.size());
           // ((MyApp)getApplication()).
                //    productItemList
            Toast.makeText(this, "Entered Product: " + productNameByUSer, Toast.LENGTH_SHORT).show();
            prouctNameisEmpty=true;
            prouctImageisEmpty=true;
            Intent intentToViewList = new Intent(MainActivity.this, ProductListActivity.class);
//            productListLocal=((MyApp)getApplication()).getProductItemList();
//            ProductItem currentItem = productListLocal.get(0);
//            String name= currentItem.getProductName();
//            Bitmap local=currentItem.getImagePath();
//            Log.d("testing", "name "+name+" local bitamp "+local);
            startActivity(intentToViewList);
        }
        }






}