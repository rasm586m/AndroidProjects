package com.example.recyclerviewdemo.view;

import android.content.Intent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.recyclerviewdemo.R;
import com.example.recyclerviewdemo.SecondActivity;
import com.example.recyclerviewdemo.storage.NoteStorage;


public class ViewHolder extends RecyclerView.ViewHolder {

    public TextView headlineTextView;
    public TextView textView;
    public int rowNumber = -1;


    public ViewHolder(@NonNull View itemView) {
        super(itemView);
        LinearLayout linearLayout = (LinearLayout) itemView;
        headlineTextView = linearLayout.findViewById(R.id.textView1);
        //textView = linearLayout.findViewById(R.id.textView);
        headlineTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView textView = (TextView) v.findViewById(R.id.textView1);
                int pos = getAdapterPosition();
                Intent intent = new Intent(v.getContext(), SecondActivity.class);
                intent.putExtra("list_position", pos);
                v.getContext().startActivity(intent);
            }
        });
    }


    public void setData ( int row){
        rowNumber = row;
        headlineTextView.setText(NoteStorage.getNote(rowNumber).headline);
        //textView.setText(NoteStorage.getNote(rowNumber).text);

    }


}