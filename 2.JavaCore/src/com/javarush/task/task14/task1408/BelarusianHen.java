package com.javarush.task.task14.task1408;

public class BelarusianHen extends Hen {
    @Override
    int getCountOfEggsPerMonth() {
        return 2;
    }

    @Override
    String getDescription() {
        return super.getDescription()+" Моя страна - "+Country.BELARUS+". Я несу 2 яиц в месяц.";
    }
}
