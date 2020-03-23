package com.example.imagedemowithrefactor.controller;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;

import androidx.annotation.Nullable;

import com.example.imagedemowithrefactor.MainActivity;

import java.io.FileNotFoundException;
import java.io.InputStream;

public class ImageController {

    private MainActivity mainActivity;

    public ImageController(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }

    public void handleImageReturn(int requestCode, @Nullable Intent intent) {
        if (requestCode == 0) { // 0 is the photoroll.
            // Get the url for the image
            Uri uri = intent.getData();
            try {
                // Create inputstream to read the file
                InputStream is = mainActivity.getContentResolver().openInputStream(uri); // The other is ContentProvider
                // Make a Bitmap from stream
                Bitmap bitmap = BitmapFactory.decodeStream(is);
                // Set Bitmap to ImageView
                mainActivity.imageView.setImageBitmap(bitmap);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        if (requestCode == 1) { // Its the camera
            Bitmap bitmap = (Bitmap) intent.getExtras().get("data"); // Here, the data itself was provided
            // with the intent.
            // Assign Bitmap to ImageView
            mainActivity.imageView.setImageBitmap(bitmap);
        }
    }

}
