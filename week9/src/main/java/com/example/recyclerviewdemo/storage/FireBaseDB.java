package com.example.recyclerviewdemo.storage;

import android.util.Log;

import androidx.annotation.NonNull;
import com.example.recyclerviewdemo.model.Note;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;


public class FireBaseDB {

    FirebaseFirestore db = FirebaseFirestore.getInstance();
    private final static String notes = "notes";

    public void addEditNewNote (int position) {

        Note note = NoteStorage.list.get(position);
        CollectionReference docRef = db.collection(notes);
        String id = Integer.toString(position);
        docRef.document(id).set(note);

        docRef.document(id).set(note).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                Log.i("all", "added successfully");
            }
        });
    }

    public void deleteNote(int position) {

        String id = Integer.toString(position);
        DocumentReference docRef = db.collection(notes).document(id);
        docRef.delete();
        Query myTopPostsQuery = db.collection(notes).orderBy(id);
        Log.i("all", myTopPostsQuery.toString());

    }

}
