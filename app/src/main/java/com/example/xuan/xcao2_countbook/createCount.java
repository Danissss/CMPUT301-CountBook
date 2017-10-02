package com.example.xuan.xcao2_countbook;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.content.Context;
import java.io.FileNotFoundException;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Date;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class createCount extends AppCompatActivity {

    public static final String FILENAME  = "countFile.sav";
    public ArrayList<Count> ListOfCount = new ArrayList<Count>();

    public EditText countName;
    public EditText countComments;
    public EditText createdDate;
    public TextView initialNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_count);

        countName = (EditText) findViewById(R.id.count_name);
        countComments = (EditText) findViewById(R.id.count_commets);
        createdDate = (EditText) findViewById(R.id.count_date);
        initialNumber = (EditText) findViewById(R.id.count_value);

        Button saveButton = (Button) findViewById(R.id.button_save);
        Button resetButton = (Button) findViewById(R.id.button_reset);


        //reset the user input after clicking the reset button
        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                countName.setText(null);
                countComments.setText(null);
                createdDate.setText(null);
                initialNumber.setText(null);
            }
        });
        /*
        after click the save button, this function will save the user input into the arraylist "ListOfCount",
        then call another activity through function "saveCount.
         */
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String count_name = countName.getText().toString();
                String count_comment = countComments.getText().toString();
                String count_date = createdDate.getText().toString();
                int initial_value = Integer.parseInt(initialNumber.getText().toString());



                Count newcount = new Count(count_name,count_date,count_comment,initial_value);

                //successfully added into ListOfCount
                ListOfCount.add(newcount);
                //successfully saved into gson file
                saveInFile();




            }
        });






    }





    /*
    This function will save the new counter into the gson file
    reference: lonely twitter, lab 3 (https://github.com/ta301fall2017/lonelyTwitter/blob/f17TueLab3)
     */
    private void saveInFile() {
        try {
            FileOutputStream fos = openFileOutput(FILENAME,
                    Context.MODE_PRIVATE);

            BufferedWriter Counter = new BufferedWriter(new OutputStreamWriter(fos));

            Gson gson = new Gson();
            gson.toJson(ListOfCount,Counter);
            Counter.flush();

            fos.close();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            throw new RuntimeException();

        } catch (IOException e) {
            // TODO Auto-generated catch block
            throw new RuntimeException();

        }
    }



}
