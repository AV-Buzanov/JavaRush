package com.javarush.task.task15.task1514;

import java.util.HashMap;
import java.util.Map;

/* 
Статики-1
*/

public class Solution {
    public static Map<Double, String> labels = new HashMap<Double, String>();

    static {
        labels.put(7.8,"7,8");
        labels.put(7.7,"7,7");
        labels.put(7.6,"7,6");
        labels.put(7.5,"7,5");
        labels.put(7.4,"7,4");

    }

    public static void main(String[] args) {
        System.out.println(labels);
    }
}
