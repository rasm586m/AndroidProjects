package com.example.recyclerviewdemo.storage;

import android.util.Log;

import com.example.recyclerviewdemo.model.Note;

import java.util.ArrayList;
import java.util.List;

public class NoteStorage {

    public static List<Note> list;
    private static FileStorage fileStorage;
    private static final String fileName = "data.dat";


    public static void setFileStorage(FileStorage fs) {
        fileStorage = fs;
    }

    public static void saveNoteToFile() {
        fileStorage.saveToFile(list, fileName);
    }

    public static void readNotesFromFile() {
        Object object = fileStorage.readObject(fileName);
        if (object != null) {
            list = (List<Note>) object;
            Log.i("all", "read list from file, size: " + list.size());
        } else {
            Log.i("all", "NULL object from file");
        }
    }

    static {
        list = new ArrayList<>();
        //Note n1 = new Note("1", "Knud");
        //Note n2 = new Note("2", "Er en mand...");
        //list.add(n1);
        //list.add(n2);
    }

    public static Note getNote(int index) {
        return list.get(index);
    }

    public static int getLength() {
        return list.size();
    }

    public static List<Note> getList() {
        return list;
    }

    public static void deleteNote(int position) {
        list.remove(position);
    }


}

