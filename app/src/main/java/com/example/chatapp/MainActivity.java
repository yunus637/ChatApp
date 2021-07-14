package com.example.chatapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView, recyclerView2;
    private final String[] names = {"Frank Martin", "Instamobile Team", "Frank", "Marta Popaes", "Frank", "Francis Soprano", "Jose Gonzales","The Group Chat","Samie","Anthon","James"};
    private final int[] images = {R.drawable.p1, R.drawable.p2, R.drawable.p1, R.drawable.p3, R.drawable.p4, R.drawable.p5, R.drawable.p6, R.drawable.p7,R.drawable.p9,R.drawable.p10,R.drawable.p11};
    private final String[] lastmessages = {"This is so good", "Thanks for everything", "Ohh my God", "Wow that is beautiful", "See you soon!", "I miss you", "I want to see you", "Thanks All","Hey how are you?","What are you doing?","I will work get new job inshAllah"};
    private ViewAdapter viewAdapter;
    private SecondAdapter secondAdapter;
    private final String[] names1 = {"Frank", "Marta", "Theresa", "Francis", "Narmin"};
    private Toolbar toolbar;
    private ImageView imageView;
    private  EditText searchtext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        connectInstance();
        setDatatoAdapter();
        setDatatoAdapterForSecond();
        clickForCancel();
        setSupportActionBar(toolbar);
    }
    private void clickForCancel() {
       imageView.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               searchtext.setText("");
           }
       });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }
    private void setDatatoAdapter() {
        SpaceGenerator spaceGenerator1 = new SpaceGenerator(25);
        viewAdapter = new ViewAdapter(names, lastmessages, images, getApplicationContext());
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        recyclerView.addItemDecoration(spaceGenerator1);
        recyclerView.setAdapter(viewAdapter);
        viewAdapter.notifyDataSetChanged();
    }
    private void setDatatoAdapterForSecond() {
        SpaceGenerator spaceGenerator = new SpaceGenerator(35);
        secondAdapter = new SecondAdapter(images, names1, getApplicationContext());
        LinearLayoutManager linearLayoutManager2 = new LinearLayoutManager(this);
        linearLayoutManager2.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView2.setLayoutManager(linearLayoutManager2);
        recyclerView2.addItemDecoration(spaceGenerator);
        recyclerView2.setAdapter(secondAdapter);
        secondAdapter.notifyDataSetChanged();
    }
    @SuppressLint("ResourceType")
    private void connectInstance() {
        recyclerView = findViewById(R.id.recyclerview);
        recyclerView2 = findViewById(R.id.recycleview2);
        toolbar = findViewById(R.id.customtoolbar);
        imageView=findViewById(R.id.cancelimage);
        searchtext=findViewById(R.id.searchbox);
    }
}