package com.example.novaapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.novaapplication.adapter.ListAdapter;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {


    public RecyclerView recyclerView;
    public ListAdapter listAdapter;
    public ArrayList<String> mData = new ArrayList<>();
    public ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        String json1 = "{\n" +
                " \"name\":\"呱呱呱\",\n"+
                " \"content\":\"123\"\n" +
                "}";

        String json2 = "{\n" +
                " \"name\":\"Nova\",\n"+
                " \"content\":\"kkkkk\"\n" +
                "}";

        for (int i = 1; i < 5; i++){
            mData.add(json1);
            mData.add(json2);
        }


        init_View();
    }

    private void init_View(){



        recyclerView = findViewById(R.id.list);
        //LinearLayoutManager
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        String[] listArray = mData.toArray(new String[0]);
        listAdapter = new ListAdapter(listArray);

        recyclerView.setAdapter(listAdapter);
    }

    private View.OnClickListener actionBtnOnClick = new View.OnClickListener(){

        @Override
        public void onClick(View view) {

            switch (view.getId()){

                case R.id.back:

                    Intent intent = new Intent();
                    intent.setClass(ListActivity.this, MainActivity.class);
                    startActivity(intent);
                    break;


                default:
                    break;
            }
        }
    };



}
