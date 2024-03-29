package com.javarush.task.task15.task1525;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Файл в статическом блоке
*/

public class Solution {

    public static List<String> lines = new ArrayList<String>();
    static {
        FileReader f;
        BufferedReader reader;
        try {
            f = new FileReader(Statics.FILE_NAME);
            reader = new BufferedReader(f);
            while (reader.ready())
            lines.add(reader.readLine());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public static void main(String[] args) {
        System.out.println(lines);
    }
}
