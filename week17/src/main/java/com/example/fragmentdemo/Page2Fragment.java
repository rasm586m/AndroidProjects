package com.example.fragmentdemo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


public class Page2Fragment extends Fragment {

    private TextView textView;
    private static final String messageKey = "MESSAGE_KEY";


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.detail_activity, container, false);
        textView = view.findViewById(R.id.textView3);

        String value = getArguments().getString(messageKey);
        textView.setText(value);

        return view;
    }

}
