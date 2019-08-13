package com.javarush.task.task07.task0724;

/* 
Семейная перепись
*/

import java.sql.SQLOutput;

public class Solution {
    public static void main(String[] args) {
        // напишите тут ваш код
        Human h1 = new Human("Andrew",true, 35);
        Human h2 = new Human("Irina",false, 28);
        Human h3 = new Human("Vova",true, 31);
        Human h4 = new Human("Lena",false, 46);
        Human h5 = new Human("Daria",false, 10, h1, h2);
        Human h6 = new Human("Stepan",true, 8, h1, h2);
        Human h7 = new Human("Sasha",true, 15, h3, h4);
        Human h8 = new Human("Natasha",false, 13, h3, h4);
        Human h9 = new Human("Lesha",true, 7, h3, h4);

        System.out.println(h1);
        System.out.println(h2);
        System.out.println(h3);
        System.out.println(h4);
        System.out.println(h5);
        System.out.println(h6);
        System.out.println(h7);
        System.out.println(h8);
        System.out.println(h9);


    }

    public static class Human {
        // напишите тут ваш код
        String name;
        boolean sex;
        int age;
        Human father;
        Human mother;

        public Human(String name, boolean sex, int age) {
            this.name = name;
            this.sex = sex;
            this.age = age;
        }
        public Human(String name, boolean sex, int age, Human father, Human mother) {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.father = father;
            this.mother = mother;
        }


        public String toString() {



            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            if (this.father != null)
                text += ", отец: " + this.father.name;

            if (this.mother != null)
                text += ", мать: " + this.mother.name;

            return text;
        }
    }
}