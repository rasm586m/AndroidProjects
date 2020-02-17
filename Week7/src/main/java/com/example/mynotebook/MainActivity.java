package com.example.mynotebook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText note;
    private String msg = "";
    public static final String messageKey = "MESSAGE_KEY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        note = findViewById(R.id.editText);
    }

    public void Save(View view) {

        msg = note.getText().toString();
    }

    public void ShowText(View view) {

        //Kan også bruge getApplicationContext() istedet for this
        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra("message_key", msg);
        startActivity(intent);

    }



}