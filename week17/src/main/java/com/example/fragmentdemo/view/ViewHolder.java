package com.example.fragmentdemo.view;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fragmentdemo.MainActivity;
import com.example.fragmentdemo.R;
import com.example.fragmentdemo.storage.Storage;


public class ViewHolder extends RecyclerView.ViewHolder {

    private TextView text;
    public static final String messageKey = "MESSAGE_KEY";



    public ViewHolder(@NonNull View itemView) {
        super(itemView);
        LinearLayout linearLayout = (LinearLayout) itemView;
        text = linearLayout.findViewById(R.id.textView1);
        setTextViewListener();
    }

    private void setTextViewListener() {
        text.setOnClickListener(v -> {
            Storage.setValue(text.getText().toString());
        });
    }

    public void setData(int position) {
        text.setText(Storage.getData(position).text);
    }

}

