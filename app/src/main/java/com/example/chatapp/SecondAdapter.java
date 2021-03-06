package com.example.chatapp;
import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
public class SecondAdapter extends RecyclerView.Adapter<SecondAdapter.RowHolder> {
    private final Context context;
    private final int [] images;
    private  final String [] names;
    public SecondAdapter(int [] images,String [] names,Context context){
        this.images=images;
        this.names=names;
        this.context=context;
    }
    @NonNull
    @Override
    public RowHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=LayoutInflater.from(context);
        @SuppressLint("InflateParams") View view =layoutInflater.inflate(R.layout.second_layout_images,null);
        return new RowHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull RowHolder holder, int position) {
    holder.imageView.setBackgroundResource(images[position]);
    holder.textView.setText(names[position]);
    }
    @Override
    public int getItemCount() {
        return names.length;
    }
    public static class RowHolder extends RecyclerView.ViewHolder {
        private final ImageView imageView;
        private final TextView textView;
        public RowHolder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.imagesecond);
            textView=itemView.findViewById(R.id.nameofperson);
        }
    }
}