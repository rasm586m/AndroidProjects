package com.example.recyclerviewdemo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.recyclerviewdemo.model.Note;
import com.example.recyclerviewdemo.storage.FileStorage;
import com.example.recyclerviewdemo.storage.FireBaseDB;
import com.example.recyclerviewdemo.storage.NoteStorage;

public class SecondActivity extends AppCompatActivity {

    private String text = "";
    private String headline = "";
    private EditText get_notemsg;
    private EditText get_headline;
    int note_position;
    FireBaseDB fireBaseDB = new FireBaseDB();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);
        get_notemsg = findViewById(R.id.editText);
        get_headline = findViewById(R.id.textView);


        Intent intent = getIntent();
        note_position = intent.getIntExtra("list_position", 0);
        String headline = NoteStorage.list.get(note_position).getHeadline();
        String note = NoteStorage.list.get(note_position).getText();
        get_headline.setText(headline);
        get_notemsg.setText((note));
    }

    public void Save(View view) {
        headline = get_headline.getText().toString();
        text = get_notemsg.getText().toString();
        NoteStorage.list.get(note_position).setId(note_position);
        NoteStorage.list.get(note_position).setHeadline(headline);
        NoteStorage.list.get(note_position).setText(text);
        NoteStorage.saveNoteToFile();
        fireBaseDB.addEditNewNote(note_position);
        finish();
    }

}
