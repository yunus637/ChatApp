package com.example.chatapp;

import android.graphics.Rect;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class SpaceGenerator extends RecyclerView.ItemDecoration {
    private final int horizontalspace;

    public SpaceGenerator(int horizontalspace) {
        this.horizontalspace = horizontalspace;
    }

    @Override
    public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
                   if(this.horizontalspace==25){
                       outRect.top=horizontalspace;
                   }
                   else if(this.horizontalspace==35){
                       outRect.left=horizontalspace;
                   }
                   else{
                       outRect.top=horizontalspace;
                   }
    }
}
