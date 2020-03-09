package com.example.uploaddownloadtocloudstorage;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;

import com.example.uploaddownloadtocloudstorage.repo.Repo;

import java.io.InputStream;

public class MainActivity extends AppCompatActivity {

    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = findViewById(R.id.imageView);
        Repo.downloadImage("Car1.jpg", imageView);
    }

    public void galleryBtnPressed(View view) {
        Intent intent = new Intent(Intent.ACTION_PICK); // Make an implicit intent,
        // Which willallow the user to choose among different services to accomplish this task.
        intent.setType("image/*"); // We needtoset the type of content to pick.
        startActivityForResult(intent, 1); // Start the activity, and in this case
        // expect an answer.
    }

    public void cameraBtnPressed(View view) {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent, 2); // Provide a different number to identify the
        // camera action on onActivityResult(...)
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        backFromGallery(requestCode, resultCode, data);
        if (requestCode == 2) { // From camera
            if (resultCode == -1) { // -1 is code for OK.
                System.out.println("Success !!");
                Bitmap bitmap = (Bitmap) data.getExtras().get("data"); // Ask for data from the incoming intent
                // pick the image data, and cast to Bitmap.
                imageView.setImageBitmap(bitmap); // Assign the data to our imageView.
            } else {
                System.out.println("Failed to get image...");
            }
        }
        if (requestCode == 1) {
            if (resultCode == -1) {
                Bitmap bitmap = (Bitmap) data.getExtras().get("data");
                imageView.setImageBitmap(bitmap);
            }
        }
    }

    private void backFromGallery(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == 1) { // from Gallery
            if (resultCode == -1) { // -1 means OK.
                Uri uri = data.getData();
                try {
                    InputStream is = getContentResolver().openInputStream(uri);
                    Bitmap bitmap = BitmapFactory.decodeStream(is);
                    imageView.setImageBitmap(bitmap);
                } catch (Exception e) {
                }
            }
        }
    }

    public void uploadButton(View view) {
        Repo.uploadFile(imageView);
    }
}
