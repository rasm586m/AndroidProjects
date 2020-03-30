package com.example.week13.view;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.week13.R;
import com.example.week13.storage.Storage;


public class ViewHolder extends RecyclerView.ViewHolder {

    private TextView headline;
    private ImageView image;


    public ViewHolder(@NonNull View itemView) {
        super(itemView);
        LinearLayout linearLayout = (LinearLayout) itemView;
        headline = linearLayout.findViewById(R.id.textView1);
        image = linearLayout.findViewById(R.id.imageView1);
    }

    public void setData(int position) {
        headline.setText(Storage.getData(position).headline);
        image.setImageResource(Storage.getData(position).image);
    }

}
