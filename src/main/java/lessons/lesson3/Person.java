package main.java.lessons.lesson3;

import java.util.Scanner;

public class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void introducePerson() {
        System.out.printf("Привет, меня зовут %s, мне %d лет", name, age);
    }
}
