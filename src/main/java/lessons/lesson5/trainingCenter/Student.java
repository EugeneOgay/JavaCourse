package main.java.lessons.lesson5.trainingCenter;

public class Student extends Person{

    private String chosenSubject;
    private boolean alreadyEnrolled = false;

    public Student(String name, String chosenSubject, boolean alreadyEnrolled) {
        super(name);
        this.chosenSubject = chosenSubject;
        this.alreadyEnrolled = alreadyEnrolled;
    }

    @Override
    public String GetName() {
        return super.GetName();
    }

    public String GetChosenSubject() {
        return chosenSubject;
    }

    public boolean GetStatus() {
        return alreadyEnrolled;
    }

    public void GetEnrolled() {
        if(!alreadyEnrolled) { alreadyEnrolled = true; }
        else System.out.printf("Студент %s уже записан на другой курс", GetName());
    }
}
