package main.java.lessons.lesson5.trainingCenter;

public class Student extends Person{

    private String chosenSubject;
    private boolean isEnrolled;

    public Student(String name, String chosenSubject, boolean isEnrolled) {
        super(name);
        this.chosenSubject = chosenSubject;
        this.isEnrolled = isEnrolled;
    }

    @Override
    public void showInfo() {
        System.out.printf("Имя: %s, предмет: %s, уже занят: %s\n", getName(), getChosenSubject(), getStatus() ? "да" : "нет");
    }

    public String getChosenSubject() {
        return chosenSubject;
    }

    public boolean getStatus() {
        return isEnrolled;
    }

    public void enroll() {
        if(!isEnrolled) { isEnrolled = true; }
        else System.out.printf("Студент %s уже записан на другой курс\n", getName());
    }
}
