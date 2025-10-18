package main.java.lessons.lesson5.trainingCenter;

abstract class Person {

    private String name;

    public Person (String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract void showInfo();
}
