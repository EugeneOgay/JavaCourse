package main.java.lessons.lesson5.trainingCenter;

import java.util.ArrayList;

public class Course {
    private String subject;
    private Teacher lector;
    private ArrayList<Student> students = new ArrayList<>();

    public Course(String subject, Teacher lector, ArrayList<Student> students) {
        this.subject = subject;
        this.lector = lector;
        this.students = students;
    }

    public void setLector(Teacher lector) {
        if(lector.GetSubject().equalsIgnoreCase(subject)) {
            if(lector.GetStatus()){
                this.lector = lector;
                System.out.printf("Лектор %s назначен на курс", lector.GetName());
            } else System.out.printf("Лектор %s занят", lector.GetName());
        } else System.out.println("Данный лектор не может вести курс");
    }

    public void setStudent() {}
}
