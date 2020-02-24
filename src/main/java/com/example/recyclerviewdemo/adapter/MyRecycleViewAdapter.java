package com.example.recyclerviewdemo.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.recyclerviewdemo.MainActivity;
import com.example.recyclerviewdemo.R;
import com.example.recyclerviewdemo.model.Note;
import com.example.recyclerviewdemo.storage.NoteStorage;
import com.example.recyclerviewdemo.view.ViewHolder;
import java.util.List;

public class MyRecycleViewAdapter extends RecyclerView.Adapter<ViewHolder> {

    private List<Note> list;

    public MyRecycleViewAdapter(MainActivity mainActivity, List<Note> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // False --> Cause attaching layout to the root
        LinearLayout ll = (LinearLayout) LayoutInflater.from(parent.getContext()).inflate(R.layout.customrow, parent, false);
        return new ViewHolder(ll);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.setData(position);
        //holder.textView.setText(list.get(position));
    }

    @Override
    public int getItemCount() {
        return NoteStorage.getLength();
    }

}
