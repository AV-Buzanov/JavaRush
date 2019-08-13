package com.javarush.task.task10.task1011;

/* 
Большая зарплата
*/

import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {
        String s = "Я не хочу изучать Java, я хочу большую зарплату";
        ArrayList<Character> ch = new ArrayList<>();
        for (int i=0;i<s.length();i++) {
            ch.add(s.charAt(i));
        }

            for(int i=0;i<40;i++) {
                for (Character h : ch)
                    System.out.print(h);
                ch.remove(0);
                System.out.println();
            }
        //напишите тут ваш код
    }

}

