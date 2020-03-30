package com.example.week13;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


import com.example.week13.adapter.MyRecyclerViewAdapter;
import com.example.week13.model.Gallery;
import com.example.week13.storage.Storage;

public class MainActivity extends AppCompatActivity {

    private AlertDialog.Builder builder;
    private Button button;


    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView.Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new MyRecyclerViewAdapter();
        recyclerView.setAdapter(adapter);
        builder = new AlertDialog.Builder(this);
        button = findViewById(R.id.button1);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final EditText editText = new EditText(MainActivity.this);
                editText.setInputType(InputType.TYPE_CLASS_TEXT);
                builder.setTitle("Enter headline");
                builder.setView(editText).setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Gallery g1 = new Gallery(editText.getText().toString(), R.drawable.image5);
                        Storage.galleryList.add(g1);
                        adapter.notifyDataSetChanged();
                    }
                }).setNegativeButton("Cancel", null).show();
            }
        });

    }

}
