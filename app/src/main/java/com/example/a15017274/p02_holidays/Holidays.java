package com.example.a15017274.p02_holidays;

/**
 * Created by 15017274 on 27/4/2017.
 */

public class Holidays {
    private String name;
    private String date;

    public Holidays(String name, String date){
        this.name = name;
        this.date = date;
    }
    public String getName(){
        return name;
    }
    public String getDate(){
        return date;
    }
}
