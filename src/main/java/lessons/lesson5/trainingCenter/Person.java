package main.java.lessons.lesson5.trainingCenter;

abstract class Person {

    private String name;

    public Person (String name) {
        SetName(name);
    }

    private void SetName(String name) {
        this.name = name;
    }

    public String GetName() {
        return name;
    }

    public abstract void ShowInfo();
}
