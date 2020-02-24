package com.example.recyclerviewdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import android.view.View;
import com.example.recyclerviewdemo.adapter.MyRecycleViewAdapter;
import com.example.recyclerviewdemo.model.Note;
import com.example.recyclerviewdemo.storage.NoteStorage;


public class MainActivity extends AppCompatActivity  {

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    MyRecycleViewAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView1);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new MyRecycleViewAdapter(this, NoteStorage.getList());
        recyclerView.setAdapter(adapter);

    }

    public void addHeadline (View view) {
        Note note = new Note();
        note.setHeadline("New note");
        note.setText("");
        NoteStorage.list.add(note);
        adapter.notifyDataSetChanged();
    }

}
