package com.javarush.task.task08.task0819;

import java.util.HashSet;
import java.util.*;

/* 
Set из котов
*/

public class Solution {
    public static Cat cat1;
    public static Cat cat2;
    public static Cat cat3;


    public static void main(String[] args) {
        Set<Cat> cats = createCats();

        //напишите тут ваш код. step 3 - пункт 3
        Iterator<Cat> iterator = cats.iterator();

        cats.remove(cats.iterator().next());

        printCats(cats);
    }

    public static Set<Cat> createCats() {
        //напишите тут ваш код. step 2 - пункт 2
        Set<Cat> set = new HashSet<>();
        cat1 = new Cat();
        cat2 = new Cat();
        cat3 = new Cat();
        set.add(cat1);
        set.add(cat2);
        set.add(cat3);

        return set;
    }

    public static void printCats(Set<Cat> cats) {

        for (Cat cat:cats) {
            System.out.println(cat);
        }
        // step 4 - пункт 4
    }

public static class Cat {

}
    // step 1 - пункт 1
}
