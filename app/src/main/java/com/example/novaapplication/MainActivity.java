package com.example.novaapplication;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView left_text, right_text;
    Button left_btn, right_btn, next, element_page, list_page;


    // Declare PopupWindow (container)
    private PopupWindow popupWindow;
    // Declare PopupView (content, context)
    private View popupView;


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

        next = findViewById(R.id.next);
        next.setOnClickListener(actionBtnOnClick);


        go_to_next_page();

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


                case R.id.next:


                    popWindow(popupView);

                    break;
                case R.id.element_page:

                    Intent intent = new Intent();
                    intent.setClass(MainActivity.this, ElementActivity.class);
                    startActivity(intent);

                    WindowManager.LayoutParams lp = getWindow().getAttributes();
                    lp.alpha =  1f;
                    getWindow().setAttributes(lp);
                    popupWindow.dismiss();
                    break;
                case R.id.list_page:

                    intent = new Intent();
                    intent.setClass(MainActivity.this, ListActivity.class);
                    startActivity(intent);

                    lp = getWindow().getAttributes();
                    lp.alpha =  1f;
                    getWindow().setAttributes(lp);
                    popupWindow.dismiss();
                    break;


                default:
                    break;
            }
        }
    };


    public void popWindow(final View popupView) {
        popupWindow = new PopupWindow(
                popupView,
                LinearLayout.LayoutParams.MATCH_PARENT,                 // width
                LinearLayout.LayoutParams.MATCH_PARENT);                // height

        // Determine the location of the popupview.
        popupWindow.showAtLocation(this.findViewById(R.id.main), Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0, 0);

        popupWindow.setOutsideTouchable(true);

        WindowManager.LayoutParams lp = getWindow().getAttributes();
        // 100% => 1f, 0% => 0.0f
        lp.alpha =  0.6f;
        getWindow().setAttributes(lp);

        popupView.setOnTouchListener(new View.OnTouchListener() {// 如果触摸位置在窗口外面则销毁

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                // TODO Auto-generated method stub

                int height = popupView.findViewById(R.id.id_pop_layout).getTop();

                int y = (int) event.getY();
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    if (y < height) {

                        lp.alpha = 1f;
                        getWindow().setAttributes(lp);

                        popupWindow.dismiss();
                    }
                }
                return true;
            }
        });

    }

    public void go_to_next_page(){

        LayoutInflater layoutInflater = (LayoutInflater) getBaseContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        popupView = layoutInflater.inflate(R.layout.popupview_message, null);

        element_page = popupView.findViewById(R.id.element_page);
        element_page.setOnClickListener(actionBtnOnClick);

        list_page = popupView.findViewById(R.id.list_page);
        list_page.setOnClickListener(actionBtnOnClick);

    }
}