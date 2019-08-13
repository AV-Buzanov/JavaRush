package com.javarush.task.task13.task1319;

import java.io.*;
import java.util.ArrayList;

/* 
Писатель в файл с консоли
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new FileWriter(new File(reader.readLine())));
        ArrayList<String> list = new ArrayList<>();
        String s ;
        while (true) {
            s = reader.readLine();
            if (s.equals("exit")) {
                list.add(s);
                break;
            }
            list.add(s);
        }

        for (String a:list) {
            writer.write(a);
            writer.newLine();
        }
        writer.close();
        reader.close();
        // напишите тут ваш код
    }
}
