package com.example.recyclerviewdemo.storage;

import com.example.recyclerviewdemo.model.Note;

import java.util.ArrayList;
import java.util.List;

public class NoteStorage {

    public static List<Note> list;

    static {
        list = new ArrayList<>();
        Note n1 = new Note("1", "Jens");
        Note n2 = new Note("2", "Er en mand...");
        list.add(n1);
        list.add(n2);
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


}

