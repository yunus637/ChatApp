package com.example.chatapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
public class ChatModel extends AppCompatActivity {
    private Toolbar toolbar;
    private TextView toolbartext;
    private final String[] messages = {"This is so good,Thanks for everything.Everything is okey", "Thanks for everything.Have you seen Flutter APP.That is very beautiful app that i Seen", "Ohh my God.That is very cute.I will download it and I will use it.Thanks for inform me", "Wow that is beautiful.I think you will enjoy it when you use it.You will always say me thanks for this.", "See you soon.MY Dear I will call you", "I miss you", "See yoou soon my dear.Thanks for everythinng so you are the best person that I have seen on my life.", "Thanks All because you are my friend.Don't mention it!"};
    private RecyclerView showmessages;
    private int imageofperson;
    private ImageView returnbackimage;
    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_model);
        initialize();
        setSupportActionBar(toolbar);
        getValue();
        returnbackbutton();
        sendDatatoAdapter();
    }
    private void sendDatatoAdapter() {
        ChatAdapter chatAdapter;
        SpaceGenerator spaceGenerator1 = new SpaceGenerator(14);

        chatAdapter = new ChatAdapter(messages, imageofperson, getApplicationContext());
        showmessages.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        showmessages.addItemDecoration(spaceGenerator1);
        showmessages.setAdapter(chatAdapter);
        chatAdapter.notifyDataSetChanged();
    }
    private void returnbackbutton() {
        returnbackimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
    private void getValue() {
        String nameofperson;
        Intent intent = getIntent();
        nameofperson = intent.getStringExtra("personname");
        imageofperson = intent.getIntExtra("personphoto", 1);
        if (!nameofperson.isEmpty()) {
            toolbartext.setText(nameofperson);
        }
    }
    private void initialize() {
        toolbar = findViewById(R.id.chattoolbar);
        toolbartext = findViewById(R.id.toolbartext);
        showmessages = findViewById(R.id.showmessages);
        returnbackimage = findViewById(R.id.returnback);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.chat_menu, menu);
        return true;
    }
}