package com.example.novaapplication.adapter;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.novaapplication.ElementActivity;
import com.example.novaapplication.ListDetailActivity;
import com.example.novaapplication.MainActivity;
import com.example.novaapplication.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {


    // Store Data
    public String[] listData ;
    ArrayList<String> mContent = new ArrayList<String>();
    ArrayList<String> mName = new ArrayList<String>();



    class ViewHolder extends RecyclerView.ViewHolder{


        TextView name, content;
        ImageView msgSelfie;
        LinearLayout msg_item;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            // Declare itemView
            name = itemView.findViewById(R.id.message_name);
            content = itemView.findViewById(R.id.message_content);
            msgSelfie = itemView.findViewById(R.id.message_selfie);

            msgSelfie.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Intent intent = new Intent();
                    Bundle bundle = new Bundle();
//                    intent.setClass(MainActivity.this, ListDetailActivity.class);
//                    // title , content
//                    bundle.putString("text", "Detail Page");
//                    intent.putExtras(bundle);
//
//                    startActivity(intent);


                }
            });

            msg_item = itemView.findViewById(R.id.message_item);
            msg_item.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    content.setText("XXXXX");
                }
            });

        }
    }

    public ListAdapter(String[] listData){
        this.listData = listData;

        // Get the data from activity and put them into the list by position.
        processData();
    }



    @NonNull
    @Override
    public ListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        // Tell which list item view will be connected.
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListAdapter.ViewHolder holder, int position) {


        // Set value to textView by position.
        holder.name.setText(mName.get(position));
        holder.content.setText(mContent.get(position));

    }


    private void processData(){
        if(listData != null && listData.length > 0){
            for(int i = 0; i<listData.length; i++){

                try{
                    JSONObject jsonObject = new JSONObject(listData[i]);

                    String sub_name = jsonObject.getString("name");
                    String sub_content = jsonObject.getString("content");


                    mName.add(sub_name);
                    mContent.add(sub_content);


                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    @Override
    public int getItemCount() {
        return listData.length;
    }
}
