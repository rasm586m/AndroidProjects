package com.example.firebaselogindemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.example.firebaselogindemo.auth.FirebaseManager;


public class MainActivity extends AppCompatActivity {

    // Keep this activity as slim as possible. Put code in seperate classes.

    private EditText emailText;
    private EditText passwordText;
    private TextView userName;
    private FirebaseManager firebaseManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firebaseManager = new FirebaseManager(this);
        emailText = findViewById(R.id.emailText);
        passwordText = findViewById(R.id.passwordText);
        userName = findViewById(R.id.userText);

    }

    public void showSecret(String userEmail) {
        userName.setText(userEmail);
    }

    public void hideSecret() {
        //userName.setVisibility(View.INVISIBLE);
        userName.setText(null);
    }

    public void signIn(View view) {
        String email = emailText.getText().toString();
        String password = passwordText.getText().toString();
        if (email.length() > 0 && password.length() > 0) {
            firebaseManager.signIn(email, password, this);
            //Intent intent = new Intent(this, SecretActivity.class);
            //startActivity(intent);
        } else {

        }
    }

    public void signUp(View view) {
        String email = emailText.getText().toString();
        String password = passwordText.getText().toString();
        if (email.length() > 0 && password.length() > 0) {
            firebaseManager.signUp(email, password, this);
        } else {

        }
    }

    public void signOut(View view) {
        firebaseManager.signOut();
    }

}
