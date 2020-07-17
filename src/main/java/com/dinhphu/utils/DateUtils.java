package com.dinhphu.utils;

import org.springframework.context.annotation.Bean;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

    private static SimpleDateFormat dateFormat;


    public static Date strToDate(String str){
        Date dateFmt=new Date();
        dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            dateFmt= dateFormat.parse(str);

        } catch (ParseException e) {
            e.printStackTrace();
        }

        return dateFmt;
    }

    public static String dateToString (Date date){
        dateFormat=new SimpleDateFormat("dd-MM-yyyy");

        String str=dateFormat.format(date);

        return str;
    }

}


