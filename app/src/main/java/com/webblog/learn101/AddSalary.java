package com.webblog.learn101;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AddSalary extends AppCompatActivity {
    private EditText salary,d;
    private DBConnection db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_salary);
        salary=findViewById(R.id.editTextTextPersonName6);
        d=findViewById(R.id.editTextTextPersonName7);
        db=new DBConnection(getApplicationContext());
    }
    public void add_data(View v){

        if(db.addSalary(salary.getText().toString(),d.getText().toString())){
            startActivity(new Intent(this,MainActivity.class));

        }else{
            Toast.makeText(this,"error Happend!",Toast.LENGTH_LONG).show();
        }
    }
}