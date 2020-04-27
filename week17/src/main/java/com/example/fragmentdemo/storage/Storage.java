package com.example.fragmentdemo.storage;

import com.example.fragmentdemo.model.Note;

import java.util.ArrayList;
import java.util.List;

public class Storage {

    public static List<Note> list;
    public static String value;

    static {
        list = new ArrayList();
        Note n1 = new Note("1");
        Note n2 = new Note("2");
        Note n3 = new Note("3");
        Note n4 = new Note("4");
        list.add(n1);
        list.add(n2);
        list.add(n3);
        list.add(n4);
    }

    public static List getList() {
        return list;
    }

    public static int getLength() {
        return list.size();
    }

    public static Note getData(int position) {
        return list.get(position);
    }

    public static String getValue() {
        return value;
    }

    public static void setValue(String value) {
        Storage.value = value;
    }
}
