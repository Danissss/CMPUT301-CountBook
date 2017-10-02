package com.example.xuan.xcao2_countbook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class CountBook_mainPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_count_book_main_page);
    }

    public void createCount (View view){
        Intent createCountIntent = new Intent(this, createCount.class);
        startActivity(createCountIntent);
    }

    public void created_activity (View view){
        Intent createCountIntent = new Intent(this, created_activity.class);
        startActivity(createCountIntent);
    }
}
