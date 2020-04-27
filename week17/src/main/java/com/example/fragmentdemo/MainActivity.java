package com.example.fragmentdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.View;

import com.example.fragmentdemo.storage.Storage;

public class MainActivity extends AppCompatActivity {

    private static final String messageKey = "MESSAGE_KEY";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void page1Pressed(View view) {
        presentFragment(R.id.frameLayoutId, new Page1Fragment());
    }

    public void page2Pressed(View view) {
        Bundle bundle = new Bundle();
        bundle.putString(messageKey, Storage.getValue());
        Page2Fragment fragobj = new Page2Fragment();
        fragobj.setArguments(bundle);
        presentFragment(R.id.frameLayoutId, fragobj);
    }

    private void presentFragment(int resourceID, Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(resourceID, fragment)
                .commit();
    }

}




