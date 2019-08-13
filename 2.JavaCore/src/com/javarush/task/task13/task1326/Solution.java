package com.javarush.task.task13.task1326;

/* 
Сортировка четных чисел из файла
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Solution {
    public static void main(String[] args) throws IOException {
        // напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fileInputStream = new FileInputStream(reader.readLine());
        BufferedInputStream inputStream = new BufferedInputStream(fileInputStream);

        ArrayList<Character> list = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();

        while (inputStream.available()>0){
            list.add((char)inputStream.read());
        }

        String text = "";

        for (char h:list) {
            text+=h;
        }
        String[] numbers = text.split("\n");

        for (String s: numbers ) {
            int num = Integer.parseInt(s);
            if (num%2==0)
            list2.add(num);
        }

        Collections.sort(list2);

        for (int j:list2
             ) {
            System.out.println(j);
        }

        fileInputStream.close();
        inputStream.close();
        reader.close();


    }
}
