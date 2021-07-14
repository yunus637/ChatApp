package com.example.chatapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
public class ViewAdapter extends RecyclerView.Adapter<ViewAdapter.RowHolder> {
    private  String [] names,messages;
    private  int [] images;
    private Context context;

    public ViewAdapter(String [] names,String [] messages,int [] images,Context context){
        this.images=images;
        this.messages=messages;
        this.names=names;
        this.context=context;

    }
    @NonNull
    @Override
    public RowHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=LayoutInflater.from(context);
        View view=layoutInflater.inflate(R.layout.names_layout,null);
        return new RowHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull RowHolder holder, int position) {
     holder.nameofpeople.setText(names[position]);
     holder.lastmessage.setText(messages[position]);
     holder.imageofperson.setBackgroundResource(images[position]);
     holder.itemView.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
              Intent intent =new Intent(context,ChatModel.class);
              intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
              intent.putExtra("personname",names[position]);
              intent.putExtra("personphoto",images[position]);
              context.startActivity(intent);
         }
     });
    }
    @Override
    public int getItemCount() {
        return images.length;
    }
    public class RowHolder extends RecyclerView.ViewHolder {
        private TextView nameofpeople,lastmessage;
        private ImageView imageofperson;
        public RowHolder(@NonNull View itemView) {
            super(itemView);
            nameofpeople=itemView.findViewById(R.id.nameofpeople);
            lastmessage=itemView.findViewById(R.id.lastmessage);
            imageofperson=itemView.findViewById(R.id.imageofpeople);
        }
    }
}
