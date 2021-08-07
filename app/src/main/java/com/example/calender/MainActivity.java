package com.example.calender;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity  implements  DateAdapter.ClickListener{

    DateAdapter dateAdapter;
    ArrayList<DateObject> list = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        list.add(new DateObject("","",false,false));
        list.add(new DateObject("","",false,false));
        for(int i = 1; i <= 31 ; i++){
            if(i == 6 || i == 13 || i == 20 || i == 27) {
                list.add(new DateObject(String.valueOf(i), "",false,true));
                }else if (i == 25) {
                list.add(new DateObject(String.valueOf(i), "Birth Date ", true, false));
                }else if(i == 2){
                list.add(new DateObject(String.valueOf(i), "Rath Yatra ", true, false));

            }
            else {
                list.add(new DateObject(String.valueOf(i), "",false,false));

            }
            }

        RecyclerView recyclerView =  (RecyclerView) findViewById(R.id.recylerView);
        dateAdapter = new DateAdapter(list,this);
        recyclerView.setAdapter(dateAdapter);
        int numberOfColumns = 7;
        recyclerView.setLayoutManager(new GridLayoutManager(this, numberOfColumns));
        dateAdapter.notifyDataSetChanged();
    }

    @Override
    public void dateClicked(int position) {
        DateObject date = list.get(position);
        if(date.isEvent()){
            Toast.makeText(MainActivity.this,date.getEvent(),Toast.LENGTH_SHORT).show();
        }
    }
}