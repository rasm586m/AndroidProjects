package com.example.week13.storage;

import com.example.week13.R;
import com.example.week13.model.Gallery;

import java.util.ArrayList;

public class Storage {

    public static ArrayList<Gallery> galleryList;


    static {
        galleryList = new ArrayList<>();
        Gallery gallery1 = new Gallery("Naturbillede 1", R.drawable.image1);
        Gallery gallery2 = new Gallery("Naturbillede 2", R.drawable.image2);
        Gallery gallery3 = new Gallery("Naturbillede 3", R.drawable.image3);
        Gallery gallery4 = new Gallery("Naturbillede 4", R.drawable.image4);
        Gallery gallery5 = new Gallery("Naturbillede 5", R.drawable.image5);
        galleryList.add(gallery1);
        galleryList.add(gallery2);
        galleryList.add(gallery3);
        galleryList.add(gallery4);
        galleryList.add(gallery5);
    }

    public static int getLength() {
        return galleryList.size();
    }

    public static Gallery getData(int index) {
        return galleryList.get(index);
    }

}
