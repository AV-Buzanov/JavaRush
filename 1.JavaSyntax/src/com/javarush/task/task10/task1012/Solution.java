package com.javarush.task.task10.task1012;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Количество букв
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // Алфавит
        String abc = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя";
        char[] abcArray = abc.toCharArray();

        ArrayList<Character> alphabet = new ArrayList<Character>();
        for (int i = 0; i < abcArray.length; i++) {
            alphabet.add(abcArray[i]);
        }

        // Ввод строк
        ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < 10; i++) {
            String s = reader.readLine();
            list.add(s.toLowerCase());
        }

        ArrayList<Integer> howMuch = new ArrayList<>();
        int counter=0;
        for (Character ch : alphabet) {
            for (String s : list) {
                for (int i=0;i<s.length();i++) {
                    if (s.charAt(i)==ch)
                        counter++;
                }

            }
            howMuch.add(counter);
            counter=0;
        }

        for (int i=0;i<alphabet.size();i++) {
            System.out.println(alphabet.get(i)+" "+howMuch.get(i));
        }
        // напишите тут ваш код
    }

}
