package com.example.faraday.sqlitepage.recyclerview;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.faraday.sqlitepage.R;

import java.util.ArrayList;

public class MainPage extends AppCompatActivity {


    RecyclerView recyclerView;

    ArrayList<String> stringArrayList = new ArrayList<>();
    CustomeAdapter customeAdapter;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainpage);

        recyclerView = findViewById(R.id.recyclerview);

        stringArrayList.add("1");
        stringArrayList.add("2");
        stringArrayList.add("3");
        stringArrayList.add("4");
        stringArrayList.add("5");
        stringArrayList.add("6");
        stringArrayList.add("7");

        customeAdapter = new CustomeAdapter(this,stringArrayList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(customeAdapter);


    }


    public class CustomeAdapter extends RecyclerView.Adapter<MyViewHolder>{

        Context context;
        ArrayList<String> strings;

        public CustomeAdapter(Context context,ArrayList<String> strings){

            this.context = context;
            this.strings = strings;

        }
        @NonNull
        @Override
        public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.child,viewGroup,false);

            MyViewHolder myViewHolder = new MyViewHolder(view);
            return myViewHolder;
        }

        @Override
        public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {

            myViewHolder.txt_email.setText(strings.get(i));
        }

        @Override
        public int getItemCount() {
            return strings.size();
        }
    }


    private class MyViewHolder extends RecyclerView.ViewHolder {

        TextView txt_email;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            txt_email = itemView.findViewById(R.id.txt_email);
        }
    }
}
