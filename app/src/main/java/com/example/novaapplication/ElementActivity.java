package com.example.novaapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;

public class ElementActivity extends AppCompatActivity {

    EditText height_edit, weight_edit;
    TextView result_text, comment;
    Button calculate;
    ImageView imageView, imageView2;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_element);


        init_View();
    }

    private void init_View(){

        imageView2 = findViewById(R.id.back);
        imageView2.setOnClickListener(actionBtnOnClick);

        height_edit = findViewById(R.id.height_edit);
        weight_edit = findViewById(R.id.weight_edit);
        result_text = findViewById(R.id.result);
        calculate = findViewById(R.id.calculate);
        calculate.setOnClickListener(actionBtnOnClick);

        comment = findViewById(R.id.comment);
        imageView = findViewById(R.id.image);

    }


    private View.OnClickListener actionBtnOnClick = new View.OnClickListener(){

        @Override
        public void onClick(View view) {

            switch (view.getId()){

                case R.id.back:

                    Intent intent = new Intent();
                    intent.setClass(ElementActivity.this, MainActivity.class);
                    startActivity(intent);
                    break;

                case R.id.calculate:

                    String h = height_edit.getText().toString();
                    String w = weight_edit.getText().toString();

                    if (h.equals("") || w.equals("")){

                        Toast.makeText(getApplicationContext(), "Please enter valid data!!!", Toast.LENGTH_SHORT).show();

                    }else{

                        double h_d = Double.parseDouble(h);
                        double w_d = Double.parseDouble(w);

                        double result_d = w_d / (h_d * h_d);

                        DecimalFormat df = new DecimalFormat("0.000");
                        String result = df.format(result_d);

                        result_text.setText(result);

                        if (result_d > 20){

                            comment.setVisibility(View.VISIBLE);
                            imageView.setImageResource(R.drawable.fatdog);
                        }
                        else{
                            comment.setVisibility(View.GONE);
                            imageView.setImageResource(R.drawable.dog);
                        }
                    }
                    break;

                default:
                    break;
            }
        }
    };



}
