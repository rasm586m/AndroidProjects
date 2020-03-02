package com.example.recyclerviewdemo;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.recyclerviewdemo.adapter.MyRecycleViewAdapter;
import com.example.recyclerviewdemo.model.Note;
import com.example.recyclerviewdemo.storage.FileStorage;
import com.example.recyclerviewdemo.storage.FireBaseDB;
import com.example.recyclerviewdemo.storage.MemoryStorage;
import com.example.recyclerviewdemo.storage.NoteStorage;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.HashMap;
import java.util.Map;


public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    MyRecycleViewAdapter adapter;
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    private final static String notes = "notes";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        NoteStorage.setFileStorage(new FileStorage(this));
        recyclerView = findViewById(R.id.recyclerView1);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new MyRecycleViewAdapter(this, NoteStorage.getList());
        recyclerView.setAdapter(adapter);
        startNoteListener();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("all", "onResume()...");
        NoteStorage.readNotesFromFile();
        adapter.notifyDataSetChanged();
    }

    public void addHeadline(View view) {
        Note note = new Note();
        note.setHeadline("New note");
        note.setText("");
        NoteStorage.list.add(note);
        NoteStorage.saveNoteToFile();
        adapter.notifyDataSetChanged();
    }

    private void startNoteListener() {
        db.collection(notes).addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(@Nullable QuerySnapshot values, @Nullable FirebaseFirestoreException e) {
                MemoryStorage.notes.clear();
                for (DocumentSnapshot snap : values.getDocuments()) {
                    Log.i("all", "read from FB " + snap.getId() + " " + snap.get("text"));
                    //MemoryStorage.notes.add(new Note(snap.getId(), snap.get("headline").toString(), snap.get("text").toString()));
                }
                adapter.notifyDataSetChanged();
            }
        });
    }

}


