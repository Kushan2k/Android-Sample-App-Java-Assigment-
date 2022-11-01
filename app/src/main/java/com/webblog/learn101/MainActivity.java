package com.webblog.learn101;

import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.media.FaceDetector;
import android.media.Image;
import android.media.ImageReader;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void addDoctor(View v){
        Intent w=new Intent(this,AddCustomer.class);
        w.putExtra("name","Add Doctor");
        startActivity(w);
    }

    public void AddAttendent(View v){
        Intent w=new Intent(this,AddCustomer.class);
        w.putExtra("name","Add Attendent");
        startActivity(w);
    }

    public void AddEmployee(View v){
        Intent w=new Intent(this,AddCustomer.class);
        w.putExtra("name","Add Employee");
        startActivity(w);
    }

    public void viewAll(View v){
        Intent i=new Intent(this,Catagory.class);
        startActivity(i);
    }
}