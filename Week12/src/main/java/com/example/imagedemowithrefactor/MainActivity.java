package com.example.imagedemowithrefactor;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.imagedemowithrefactor.controller.ImageController;

import java.io.FileNotFoundException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {

    public ImageView imageView;
    private ImageController ic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = findViewById(R.id.imageView);
        ic = new ImageController(this);
        ActivityCompat.requestPermissions(MainActivity.this,
                new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},1);
    }

    public void photoRollBtnPressed(View view) {
        // 1. Make an intent
        // Start activity (Which will make Android System launch one activity which CAN
        // handle this "request").
        Intent intent = new Intent(Intent.ACTION_PICK); // Android chooses an activity, we have no controle.
        intent.setType("image/*");
        startActivityForResult(intent, 0); // 0 means photoroll, 1 means camera
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);
        // What should we do when we get back?
        // 1. Check if resultCode is OK. If not, then return
        if (resultCode != -1)  return; // -1 indicates OK!
        ic.handleImageReturn(requestCode, intent);
    }


    public void cameraBtnPressed(View view) {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE); // We ask Android for something different.
        startActivityForResult(intent,1);
    }

    public void resizeImage (View view) {
        BitmapDrawable drawable = (BitmapDrawable) imageView.getDrawable();
        Bitmap bitmap = drawable.getBitmap();
        Bitmap resized = Bitmap.createScaledBitmap(bitmap, 100, 200, true);
        imageView.setImageBitmap(resized);
    }

    public void saveReziedImage(View view) {
        BitmapDrawable drawable = (BitmapDrawable) imageView.getDrawable();
        Bitmap bitmap = drawable.getBitmap();
        MediaStore.Images.Media.insertImage(getContentResolver(), bitmap, "Picture", "Test...!");
    }

}
