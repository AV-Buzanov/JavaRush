package com.javarush.task.task10.task1013;

/* 
Конструкторы класса Human
*/

public class Solution {
    public static void main(String[] args) {
    }

    public static class Human {
        private String name;
        private int age;
        private boolean sex;
        private int height;
        private int weight;
        private byte footSize;

        public Human(String name, int age, boolean sex, int height, int weight, byte footSize) {
            this.name=name;
            this.age=age;
            this.sex=sex;
            this.height=height;
            this.weight=weight;
            this.footSize=footSize;
        }

        public Human(String name, int age, boolean sex, int height, int weight) {
            this.name=name;
            this.age=age;
            this.sex=sex;
            this.height=height;
            this.weight=weight;
        }

        public Human(String name, int age, byte footSize) {
            this.name=name;
            this.age=age;
            this.footSize=footSize;
        }

        public Human(String name,  int height, int weight, byte footSize) {
            this.name=name;
            this.height=height;
            this.weight=weight;
            this.footSize=footSize;
        }

        public Human(String name, int age, int height, int weight, byte footSize) {
            this.name=name;
            this.age=age;
            this.height=height;
            this.weight=weight;
            this.footSize=footSize;
        }

        public Human(String name, int age, boolean sex, int height, byte footSize) {
            this.name=name;
            this.age=age;
            this.sex=sex;
            this.height=height;
            this.footSize=footSize;
        }

        public Human(String name, int age) {
            this.name=name;
            this.age=age;
        }

        public Human(String name, int age, int height, int weight) {
            this.name=name;
            this.age=age;

            this.height=height;
            this.weight=weight;

        }

        public Human(String name, boolean sex, int height, int weight) {
            this.name=name;
            this.sex=sex;
            this.height=height;
            this.weight=weight;
        }

        public Human(String name, boolean sex, int height, byte footSize) {
            this.name=name;

            this.sex=sex;
            this.height=height;

            this.footSize=footSize;
        }

        // Напишите тут ваши переменные и конструкторы
    }
}
