package com.webblog.learn101;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class AddCustomer extends AppCompatActivity {
    private TextView txt;
    private EditText name,age,details,sp;
    private DBConnection db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_customer);
        txt=findViewById(R.id.title);
        Intent i=getIntent();
        txt.setText(i.getStringExtra("name"));
        name=findViewById(R.id.n);
        age=findViewById(R.id.ageinp);
        sp=findViewById(R.id.spinp);
        details=findViewById(R.id.detailinp);
        db=new DBConnection(getApplicationContext());

    }

    public void addToDatabase(View v){
        String n=name.getText().toString();
        String a=age.getText().toString();
        String d=details.getText().toString();
        String s=sp.getText().toString();
        String t=txt.getText().toString();

        try{
            if(db.addRow(new Person(n,d,Integer.parseInt(a),s,t))){
                Toast.makeText(this,"Record Added",Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(this,"error happed!",Toast.LENGTH_SHORT).show();
            }
        }catch(Exception e){
            Toast.makeText(this,"please check your inputs!",Toast.LENGTH_SHORT).show();
        }



    }

}