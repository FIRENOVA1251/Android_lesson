package com.example.novaapplication;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView left_text, right_text;
    Button left_btn, right_btn, btn_1, btn_list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        ActionBar actionBar = getSupportActionBar();
//        if(actionBar != null){
//            actionBar.hide();
//        }

        init_View();
    }

    private void init_View(){

        left_text = findViewById(R.id.left_text);
        right_text = findViewById(R.id.right_text);

        left_btn = findViewById(R.id.left_btn);
        left_btn.setOnClickListener(actionBtnOnClick);
        right_btn = findViewById(R.id.right_btn);
        right_btn.setOnClickListener(actionBtnOnClick);

        btn_1 = findViewById(R.id.btn_1);
        btn_1.setOnClickListener(actionBtnOnClick);

        btn_list = findViewById(R.id.btn_list);
        btn_list.setOnClickListener(actionBtnOnClick);

    }

    private View.OnClickListener actionBtnOnClick = new View.OnClickListener(){

        @Override
        public void onClick(View view) {

            switch (view.getId()){

                case R.id.left_btn:
                    String temp = left_text.getText().toString();
                    int temp_int = Integer.parseInt(temp);
                    temp_int = temp_int + 1;
                    temp = String.valueOf(temp_int);
                    left_text.setText(temp);
                    break;

                case R.id.right_btn:
                    temp = right_text.getText().toString();
                    temp_int = Integer.parseInt(temp);
                    temp_int = temp_int + 1;
                    temp = String.valueOf(temp_int);
                    right_text.setText(temp);
                    break;


                case R.id.btn_1:

                    Intent intent = new Intent();
                    intent.setClass(MainActivity.this, ElementActivity.class);
                    startActivity(intent);

                    break;
                case R.id.btn_list:

                    intent = new Intent();
                    intent.setClass(MainActivity.this, ListActivity.class);
                    startActivity(intent);

                    break;


                default:
                    break;
            }
        }
    };
}