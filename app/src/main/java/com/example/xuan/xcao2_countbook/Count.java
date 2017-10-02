package com.example.xuan.xcao2_countbook;

import java.util.Date;


/**
 * Created by xuan on 2017-09-30.
 * this is the structure of the count for arraylist "ListofCount"
 * the class contains count name, count comment, date that count created (user input) and initial value
 */

public class Count {
    private String NameOfCount;
    private String CountComments;
    private String createdDate;
    private static int initialValue;

    public Count (String NameOfCount, String createdDate, String CountComments, int initialValue){
        this.CountComments = CountComments;
        this.NameOfCount = NameOfCount;
        this.createdDate = createdDate;
        this.initialValue = initialValue;
    }

    //get all the value;
    public String getNameOfCount(){
        return this.NameOfCount;
    }

    public String getCountComments(){
        return  this.CountComments;
    }

    public String getCreatedDate(){
        return this.createdDate;
    }

    public int getInitialValue(){
        return this.initialValue;
    }

    //set up the function of increment and decrement;


}
