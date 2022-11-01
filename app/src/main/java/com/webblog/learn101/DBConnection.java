package com.webblog.learn101;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DBConnection extends SQLiteOpenHelper {

    public DBConnection(@Nullable Context context) {
        super(context, "details", null, 1, null);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        final String SQL="CREATE TABLE customers(id INTEGER PRIMARY KEY AUTOINCREMENT,name VARCHAR(255),age VARCHAR(2)," +
                "details VARCHAR(255),spfor VARCHAR(255),type VARCHAR(20))";
        final String SQL2="CREATE TABLE salary(id INTEGER PRIMARY KEY AUTOINCREMENT,salary VARCHAR(255),date VARCHAR(255))";
        sqLiteDatabase.execSQL(SQL2);
        sqLiteDatabase.execSQL(SQL);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
    public boolean addRow(Person p){
        SQLiteDatabase db=this.getWritableDatabase();

        String sql="INSERT INTO customers(name,age,details,spfor,type) VALUES('"+p.getName()+"','"+p.getAge()+
                "','"+p.getDetails()+"','"+p.getSpfor()+"','"+p.getType()+"')";

        try{
            db.execSQL(sql);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public boolean addSalary(String s,String d){
        SQLiteDatabase db=this.getWritableDatabase();

        String sql="INSERT INTO salary(salary,date) VALUES('"+s+"','"+d+"')";

        try{
            db.execSQL(sql);
            return true;
        }catch (Exception e){
            return false;
        }
    }
    public boolean deleteOne(int id){
        SQLiteDatabase db=this.getWritableDatabase();

        String sql="DELETE FROM customers WHERE id="+id;
        try{
            db.execSQL(sql);
            return true;
        }catch(Exception e){
            return false;
        }
    }

    public List<Person> getPersons(){
        List<Person> p=new ArrayList<>();

        SQLiteDatabase db=this.getWritableDatabase();
        final String SQl="SELECT * FROM customers";

        try{
            Cursor c=db.rawQuery(SQl,null);

            if (c.moveToFirst()) {
                do {
                    Person ps=new Person(
                            c.getString(1),
                            c.getString(3),
                            c.getInt(2),
                            c.getString(4)
                    );
                    ps.setType(c.getString(5));
                    ps.setId(c.getInt(0));
                    // on below line we are adding the data from cursor to our array list.
                    p.add(ps);
//                    Log.d("NAME", String.valueOf(ps.getID()));
                } while (c.moveToNext());
                // moving our cursor to next.
            }
            c.close();
        }catch(Exception e){
            return p;
        }

        return p;

    }
}
