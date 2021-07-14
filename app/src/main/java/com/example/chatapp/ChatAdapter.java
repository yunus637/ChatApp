package com.example.chatapp;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
public class ChatAdapter extends RecyclerView.Adapter<ChatAdapter.ViewHolder> {
    private String[] messages;
    private Context context;
    private int personphoto;

    public ChatAdapter(String[] messages,int personphoto,Context context) {
        this.messages = messages;
        this.context=context;
        this.personphoto=personphoto;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=LayoutInflater.from(context);
        View view;
        if(viewType%2==0){
       view=layoutInflater.inflate(R.layout.sender_message,null);
        }
        else{
            view=layoutInflater.inflate(R.layout.receiver_message,null);
        }
        return new ViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
       if(position%2==0){
           holder.sender.setText(messages[position]);
         if(holder.receiverimage!=null){
             holder.receiverimage.setBackgroundResource(R.drawable.p8me);
         }
       }
       else {
           holder.receiver.setText(messages[position]);
           if(holder.senderimage!=null){
               holder.senderimage.setBackgroundResource(personphoto);
           }
       }
    }

    @Override
    public int getItemCount() {
        return messages.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView sender,receiver;
        private ImageView senderimage,receiverimage;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            sender=itemView.findViewById(R.id.sender_text);
            receiver= itemView.findViewById(R.id.receiver_text);
            senderimage= (ImageView) itemView.findViewById(R.id.sender_image1);
            receiverimage= itemView.findViewById(R.id.receiver_image);
        }

    }
    @Override
    public int getItemViewType(int position) {
        return  position;
    }
}
