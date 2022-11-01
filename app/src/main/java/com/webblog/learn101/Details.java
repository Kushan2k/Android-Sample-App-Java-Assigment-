package com.webblog.learn101;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Details extends AppCompatActivity {

    private EditText e1,e2,e3,e4;
    private Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        e1=findViewById(R.id.name);
        e2=findViewById(R.id.age);
        e3=findViewById(R.id.spf);
        e4=findViewById(R.id.d);
        Intent i=getIntent();
        e1.setText(i.getStringExtra("name"));
        e2.setText(i.getStringExtra("age"));
        e3.setText(i.getStringExtra("sp"));
        e4.setText(i.getStringExtra("d"));
        btn=findViewById(R.id.button6);


    }

    public void AddS(View v){
        startActivity(new Intent(this,AddSalary.class));
    }
}