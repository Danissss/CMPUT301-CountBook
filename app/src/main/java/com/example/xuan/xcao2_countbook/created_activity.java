package com.example.xuan.xcao2_countbook;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.io.IOException;

import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import android.widget.ArrayAdapter;

public class created_activity extends AppCompatActivity implements View.OnClickListener {

    public static final String FILENAME = "file.sav";
    public ArrayList<Count> ListOfCount = new ArrayList<>();
    public ArrayAdapter<Count> adapter;


    public TextView countName;
    public TextView countComments;
    public TextView createdDate;
    public TextView countValue;

    Button incrementing;
    Button decrementing;
    Button reset;

    int counter = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_created_activity);


        countName = (TextView) findViewById(R.id.count_name);
        countComments = (TextView) findViewById(R.id.count_comments);
        createdDate = (TextView) findViewById(R.id.count_date);
        countValue = (TextView) findViewById(R.id.count_value);
        //set the countValue to initial value;
        countValue.setText(Integer.toString(counter));

        incrementing = (Button) findViewById(R.id.plus);
        decrementing = (Button) findViewById(R.id.minus);
        reset  = (Button) findViewById(R.id.reset);


        //set on click listeners on the buttons
        incrementing.setOnClickListener(this);
        decrementing.setOnClickListener(this);
        reset.setOnClickListener(this);

        // change font size of the text
        countValue.setTextSize(TypedValue.COMPLEX_UNIT_SP, 24);

        loadFromFile();



        //extracting information from json(gson) file;

        //adapter = new ArrayAdapter<Count>(this, R.layout., ListOfCount);
        //countName.setText( );




    }
    /*
    decrementing or incrementing the count value;
    set the value is not less than 0;
    if reset the count value will return to the initial value;
     */

    public void onClick(View v) {
        if (v == incrementing){
            counter++;
            countValue.setText(Integer.toString(counter));

        }
        if (v == decrementing){
            counter--;
            countValue.setText(Integer.toString(counter));

        }

        if (v == reset){
            counter = 0;
            countValue.setText(Integer.toString(counter));
        }

        //set the minimal value to 0;
        if (counter < 0){
            counter = 0;
            countValue.setText(Integer.toString(counter));
        }
    }

    public void loadFromFile(){
        try {
            FileInputStream fis = openFileInput(FILENAME);
            BufferedReader in = new BufferedReader(new InputStreamReader(fis));
            Gson gson = new Gson();
            Type listType = new TypeToken<ArrayList<Count>>(){}.getType();

            ListOfCount= gson.fromJson(in, listType);
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block

            ListOfCount = new ArrayList<Count>();
        } catch (IOException e) {
            // TODO Auto-generated catch block

            throw new RuntimeException();
        }

    }

}
