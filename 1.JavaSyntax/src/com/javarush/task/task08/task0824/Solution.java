package com.javarush.task.task08.task0824;

/* 
Собираем семейство
*/

import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        ArrayList<Human> firstGenerationFem = new ArrayList<>();
        ArrayList<Human> firstGenerationMale = new ArrayList<>();
        ArrayList<Human> secondGeneration = new ArrayList<>();
        ArrayList<Human> thirdGenerationdF = new ArrayList<>();
        ArrayList<Human> thirdGenerationdS = new ArrayList<>();
        ArrayList<Human> thirdGenerationS = new ArrayList<>();


        Human grandPaFem = new Human( "Дед мамы",true,74, firstGenerationFem);
        Human grandMaFem = new Human( "Бабка мамы",false,82, firstGenerationFem);

        Human grandPaMale = new Human( "Дед бати",true,80, firstGenerationMale);
        Human grandMaMale = new Human( "Бабка бати",false,78, firstGenerationMale);

        Human father = new Human( "Батя",true,34, secondGeneration);
        Human mother = new Human( "Мама",false,27, secondGeneration);

        Human daughterFirst = new Human( "Дочь первая",false,9,thirdGenerationdF);
        Human Son = new Human( "Сын",true,7,thirdGenerationS);
        Human daughterSecond = new Human( "Дочь вторая",false,5,thirdGenerationdS);

        firstGenerationFem.add(mother);
        firstGenerationMale.add(father);

        secondGeneration.add(daughterFirst);
        secondGeneration.add(Son);
        secondGeneration.add(daughterSecond);


        System.out.println(grandMaFem.toString());
        System.out.println(grandPaFem.toString());
        System.out.println(grandMaMale.toString());
        System.out.println(grandPaMale.toString());
        System.out.println(mother.toString());
        System.out.println(father.toString());
        System.out.println(daughterFirst.toString());
        System.out.println(Son.toString());
        System.out.println(daughterSecond.toString());


    }

    public static class Human {
        //напишите тут ваш код
        String name;
        boolean sex;
        int age;
        ArrayList<Human> children;
        public  Human(String name, boolean sex, int age, ArrayList<Human> children) {
            this.name=name;
            this.sex=sex;
            this.age=age;
            this.children=children;
        }
        public  Human(String name, boolean sex, int age) {
            this.name=name;
            this.sex=sex;
            this.age=age;
        }

        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            int childCount = this.children.size();
            if (childCount > 0) {
                text += ", дети: " + this.children.get(0).name;

                for (int i = 1; i < childCount; i++) {
                    Human child = this.children.get(i);
                    text += ", " + child.name;
                }
            }
            return text;
        }
    }

}
