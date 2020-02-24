package com.example.recyclerviewdemo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.recyclerviewdemo.model.Note;
import com.example.recyclerviewdemo.storage.NoteStorage;

public class SecondActivity extends AppCompatActivity {

    private String save_msg = "";
    private String headline = "";
    private EditText notemsg;
    private TextView get_headline;
    private Note note;
    int number;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);
        notemsg = findViewById(R.id.editText);
        get_headline = findViewById(R.id.textView);


        Intent intent = getIntent();
        number = intent.getIntExtra("list_position", 0);
        String headline = NoteStorage.list.get(number).getHeadline();
        String note = NoteStorage.list.get(number).getText();
        get_headline.setText(headline);
        notemsg.setText((note));

    }

    public void Save(View view) {
        Note note = new Note();
        headline = get_headline.getText().toString();
        save_msg = notemsg.getText().toString();
        Note asd = new Note(headline, save_msg);
        NoteStorage.list.set(number, asd);
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

    }
}
