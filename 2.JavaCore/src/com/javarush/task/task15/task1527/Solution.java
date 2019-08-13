package com.javarush.task.task15.task1527;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Парсер реквестов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String url = reader.readLine();
        url=separate(url);

        String[] urlarr = url.split("&");
        String[] buf;
        String val="";

        for(String st:urlarr) {
            if (st.contains("=")){
                buf=st.split("=");
                System.out.print(buf[0]+" ");
                if (buf[0].equals("obj"))
                    val=buf[1];
            }
            else
                System.out.print(st+" ");

        }
        System.out.println();
        if (!val.isEmpty()&&isdouble(val))
            alert(Double.parseDouble(val));
        else if(!val.isEmpty())
            alert((String)val);


        //add your code here
    }

    public static void alert(double value) {
        System.out.println("double: " + value);
    }

    public static void alert(String value) {
        System.out.println("String: " + value);
    }

    public static String separate(String value) {
        String sepUrl ="";
        char[] urlch = value.toCharArray();
        int ind = 0;
        for (int i=0;i<urlch.length;i++) {
            if (urlch[i]=='?')
                ind=i;
            if (i>ind&&ind!=0) {
                sepUrl += urlch[i];
            }
        }
        return sepUrl;
    }

    public static boolean isdouble(String value) {
        try {
            Double.parseDouble(value);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

}
