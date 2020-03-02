package com.example.recyclerviewdemo.view;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.recyclerviewdemo.R;
import com.example.recyclerviewdemo.SecondActivity;
import com.example.recyclerviewdemo.model.Note;
import com.example.recyclerviewdemo.storage.FileStorage;
import com.example.recyclerviewdemo.storage.FireBaseDB;
import com.example.recyclerviewdemo.storage.NoteStorage;
import com.google.firebase.firestore.DocumentSnapshot;


public class ViewHolder extends RecyclerView.ViewHolder {

    public TextView headlineTextView;
    public TextView textView;
    public int rowNumber = -1;
    public Button deleteButton;
    FireBaseDB fireBaseDB = new FireBaseDB();


    public ViewHolder(@NonNull View itemView) {
        super(itemView);
        LinearLayout linearLayout = (LinearLayout) itemView;
        headlineTextView = linearLayout.findViewById(R.id.textView1);
        textView = linearLayout.findViewById(R.id.textView);
        deleteButton = linearLayout.findViewById(R.id.deleteButton);
        headlineTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TextView textView = (TextView) v.findViewById(R.id.textView1);
                int pos = getAdapterPosition();
                Intent intent = new Intent(v.getContext(), SecondActivity.class);
                intent.putExtra("list_position", pos);
                v.getContext().startActivity(intent);
            }
        });

        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int pos = getAdapterPosition();
                Log.i("button", "postition " + pos);
                NoteStorage.deleteNote(pos);
                NoteStorage.saveNoteToFile();
                fireBaseDB.deleteNote(pos);
            }
        });


    }

    public void setData ( int row){
        rowNumber = row;
        headlineTextView.setText(NoteStorage.getNote(rowNumber).headline);
        //textView.setText(NoteStorage.getNote(rowNumber).text);

    }




}