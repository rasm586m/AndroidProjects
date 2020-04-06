package com.example.firebaselogindemo.auth;

import android.widget.Toast;
import androidx.annotation.NonNull;
import com.example.firebaselogindemo.MainActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class FirebaseManager {

    FirebaseAuth auth;
    private MainActivity mainActivity;


    public FirebaseManager(MainActivity activity) {
        auth = FirebaseAuth.getInstance();
        mainActivity = activity;
        setupAuthStateListener();
    }


    private void setupAuthStateListener() {
        auth.addIdTokenListener(new FirebaseAuth.IdTokenListener() {
            @Override
            public void onIdTokenChanged(@NonNull FirebaseAuth firebaseAuth) {
                if (firebaseAuth.getCurrentUser() == null) {
                    System.out.println("Signed out from Firebase");
                    mainActivity.hideSecret();
                } else {
                    System.out.println("Signed in to Firebase");
                }
            }
        });
    }

    public void signIn(String email, String password, final MainActivity activity) {
        auth.signInWithEmailAndPassword(email, password).addOnCompleteListener(activity, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    System.out.println("Login successfull: " + task.getResult().getUser().getEmail());
                    FirebaseUser user = auth.getCurrentUser();
                    String userEmail = user.getEmail();
                    activity.showSecret(userEmail); // Call the calling activity
                } else {
                    System.out.println("Login failed: " + task.getException());
                    Toast.makeText(activity, "Login Failed: " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void signUp(String email, String password, final MainActivity activity) {
        auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(activity, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    System.out.println("User created: " + task.getResult().getUser().getEmail());
                } else {
                    System.out.println("User creation failed: " + task.getException());
                    Toast.makeText(activity, "User creation failed: " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void signOut() {
        auth.signOut();
    }

}
