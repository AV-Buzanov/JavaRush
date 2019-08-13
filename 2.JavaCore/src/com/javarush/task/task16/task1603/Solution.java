package com.javarush.task.task16.task1603;

import java.util.ArrayList;
import java.util.List;

/* 
Список и нити
*/

public class Solution {
    public static volatile List<Thread> list = new ArrayList<Thread>(5);

    public static void main(String[] args) {
        SpecialThread spt1 = new SpecialThread();
        SpecialThread spt2 = new SpecialThread();
        SpecialThread spt3 = new SpecialThread();
        SpecialThread spt4 = new SpecialThread();
        SpecialThread spt5 = new SpecialThread();

        Thread th1 = new Thread(spt1);
        Thread th2 = new Thread(spt2);
        Thread th3 = new Thread(spt3);
        Thread th4 = new Thread(spt4);
        Thread th5 = new Thread(spt5);

        list.add(th1);
        list.add(th2);
        list.add(th3);
        list.add(th4);
        list.add(th5);



        //Add your code here - добавьте свой код тут
    }

    public static class SpecialThread implements Runnable {
        public void run() {
            System.out.println("it's a run method inside SpecialThread");
        }
    }
}
