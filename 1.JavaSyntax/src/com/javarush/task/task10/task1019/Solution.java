package com.javarush.task.task10.task1019;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/* 
Функциональности маловато!
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, Integer> map = new HashMap<>();
        String[] splitted = new String[2];
                while(true) {
                    String name = reader.readLine();
                    if (name.isEmpty())
                        break;
                    else {
                        splitted[0]=name;
                        name = reader.readLine();

                        if (name.isEmpty()) {
                            map.put(name, Integer.parseInt(splitted[0]));
                            break;
                        }
                        else {

                            splitted[1] = name;

                            map.put(splitted[1], Integer.parseInt(splitted[0]));
                        }
                    }
                }
        for(Map.Entry pair:map.entrySet()) {
            System.out.println(pair.getValue()+" "+pair.getKey());
        }
    }
}
