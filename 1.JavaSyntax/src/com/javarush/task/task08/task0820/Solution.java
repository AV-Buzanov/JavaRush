package com.javarush.task.task08.task0820;

import java.util.HashSet;
import java.util.*;

/* 
Множество всех животных
*/

public class Solution {
    public static void main(String[] args) {
        Set<Cat> cats = createCats();
        Set<Dog> dogs = createDogs();

        Set<Object> pets = join(cats, dogs);
        printPets(pets);

        removeCats(pets, cats);
        printPets(pets);
    }

    public static Set<Cat> createCats() {
        HashSet<Cat> result = new HashSet<>();
        for(int i=0; i<4; i++)
        result.add(new Cat());

        //напишите тут ваш код

        return result;
    }

    public static Set<Dog> createDogs() {
        //напишите тут ваш код
        HashSet<Dog> result = new HashSet<>();
        for(int i=0; i<3; i++)
            result.add(new Dog());

        return result;
    }

    public static Set<Object> join(Set<Cat> cats, Set<Dog> dogs) {
        HashSet<Object> result = new HashSet<>();

        //напишите тут ваш код
        for(Cat cat:cats)
            result.add(cat);
        for(Dog dog:dogs)
            result.add(dog);

        return result;
    }

    public static void removeCats(Set<Object> pets, Set<Cat> cats) {
        Iterator<Object> iterator = pets.iterator();
        while (iterator.hasNext())
        {
            Object pet = iterator.next();

            for(Cat cat:cats){
                if (pet.equals(cat))
                        iterator.remove();

            }

        }
        //напишите тут ваш код
    }

    public static void printPets(Set<Object> pets) {
        for (Object pet:pets)
            System.out.println(pet);
        //напишите тут ваш код
    }

    public static class Cat {

    }
    public static class Dog {

    }
    //напишите тут ваш код
}
