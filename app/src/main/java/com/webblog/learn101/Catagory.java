package com.webblog.learn101;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class Catagory extends AppCompatActivity {

    private RecyclerView rc;
    private DBConnection db;
    private RecycleViewAdapter ad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catagory);
        rc=findViewById(R.id.rcview);
        rc.setLayoutManager(new LinearLayoutManager(this));
        db=new DBConnection(getApplicationContext());
        ad=new RecycleViewAdapter(this,db);
        rc.setAdapter(ad);


    }
}