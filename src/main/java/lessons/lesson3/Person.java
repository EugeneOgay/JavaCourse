package main.java.lessons.lesson3;

import java.util.Scanner;

public class Person {
    String name;
    int age;

    public Person() {}

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void Introduce() {
        System.out.printf("Привет, меня зовут %s, мне %d лет", name, age);
    }

    public void Introduce2() {
        System.out.print("Введите имя : ");
        Scanner stringScanner = new Scanner(System.in);
        String name = stringScanner.nextLine();
        System.out.print("Введите возраст: ");
        Scanner scanner = new Scanner(System.in);
        int age = scanner.nextInt();
        this.name = name;
        this.age = age;
        System.out.printf("Привет, меня зовут %s, мне %d лет", name, age);
    }
}
