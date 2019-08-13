package com.javarush.task.task08.task0823;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import static java.lang.Character.*;

/* 
Омовение Рамы
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<>();
        String s = reader.readLine();
        String chars="";
        for (int i=0;i<s.length();i++) {
            char ch = s.charAt(i);
            if (!isSpaceChar(ch)) {
                chars+=ch;
            }
            else {
                if (!chars.isEmpty())
                list.add(chars);
                chars="";
            }

        }
        list.add(chars);
        for (String st:list) {
        char[] h = st.toCharArray();
        if (isLowerCase(h[0]))
            h[0]=toUpperCase(h[0]);
            String str = new String(h);
            System.out.print(str+" ");

        }
        //напишите тут ваш код
    }
}
