package com.javarush.task.task08.task0827;

import java.text.*;
import java.util.*;


/* 
Работа с датой
*/

public class Solution {
    public static void main(String[] args) throws ParseException {
        System.out.println(isDateOdd("MAY 1 2013"));
    }

    public static boolean isDateOdd(String date) throws ParseException {


        SimpleDateFormat dF = new SimpleDateFormat("MMM d yyyy", Locale.ENGLISH);
        Date data = dF.parse(date);
        SimpleDateFormat dD = new SimpleDateFormat("D", Locale.ENGLISH);
        int number = Integer.parseInt(dD.format(data));
        return (number%2==0)? false:true;


    }
}
