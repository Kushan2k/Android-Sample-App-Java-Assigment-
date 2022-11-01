package com.webblog.learn101;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecycleViewAdapter extends RecyclerView.Adapter<RecycleViewAdapter.Adapter> {
    private List<Person> list;
    private Context context;
    private DBConnection db;

    public RecycleViewAdapter(Context ctx,DBConnection d) {

        context=ctx;
        db=d;
        list=db.getPersons();
    }

    @NonNull
    @Override
    public Adapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.oneitem, parent, false);

        return new Adapter(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter holder, @SuppressLint("RecyclerView") int position) {

        holder.txt.setText(list.get(position).getName());
        holder.txt2.setText(list.get(position).getType());
        holder.textView5.setText(String.valueOf(list.get(position).getID()));
        holder.btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(context,Details.class);
                i.putExtra("name",list.get(position).getName());
                i.putExtra("age",String.valueOf(list.get(position).getAge()));
                i.putExtra("sp",list.get(position).getSpfor());
                i.putExtra("d",list.get(position).getDetails());
//                Log.d("M",String.valueOf(list.get(position).getAge()));
                holder.btn2.getContext().startActivity(i);
            }
        });
//        holder.txt.setText(String.valueOf(list.size()));
//        Toast.makeText(holder.btn.getContext(),list.get(position).getDetails(),Toast.LENGTH_SHORT).show();
        holder.btn.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("NotifyDataSetChanged")
            @Override
            public void onClick(View view) {
                db.deleteOne(list.get(position).getID());
                Intent i=new Intent(context,MainActivity.class);
                holder.btn.getContext().startActivity(i);



            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    public class Adapter extends RecyclerView.ViewHolder {

        private TextView txt,txt2,textView5;
        private ImageButton btn,btn2;

        public Adapter(@NonNull View itemView) {
            super(itemView);
            txt=itemView.findViewById(R.id.textView2);
            btn=itemView.findViewById(R.id.button5);
            txt2=itemView.findViewById(R.id.textView4);
            btn2=itemView.findViewById(R.id.edit);
            textView5=itemView.findViewById(R.id.textView5);

        }
    }
}
