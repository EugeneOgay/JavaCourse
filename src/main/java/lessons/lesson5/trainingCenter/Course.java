package main.java.lessons.lesson5.trainingCenter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Course {
    private String subject;
    private Teacher lector;
    private ArrayList<Student> students;
    private Map<String, Integer> grades = new HashMap<>();
    private Map<String, Boolean> presence = new HashMap<>();

    public Course(String subject, Teacher lector, ArrayList<Student> students) {
        this.subject = subject;
        this.lector = lector;
        this.students = students;
        this.grades = setDefaultGrades(students);
        this.presence = setDefaultPresence(students);
    }

    public String getSubject() {
        return subject;
    }

    public String getLectorName() {
        return lector.getName();
    }

    public void printStudents() {
        System.out.println("Список студентов курса: \n");
        for (Student student : students) {
            System.out.printf("Имя: %s\n", student.getName());
        }
    }

    public void printGrades() {
        System.out.println("Журнал успеваемости: \n");
        for(Map.Entry<String, Integer> currentGrades : grades.entrySet()){
            String studentName = currentGrades.getKey();
            int studentGrade = currentGrades.getValue();
            System.out.printf("Студент: %s, оценка: %d\n", studentName, studentGrade);
        }
    }

    public void printPresence() {
        System.out.println("Журнал плсещаемости: \n");
        for(Map.Entry<String, Boolean> currentPresence : presence.entrySet()){
            String studentName = currentPresence.getKey();
            String studentPresence = currentPresence.getValue() == true ? "да" : "нет";
            System.out.printf("Студент: %s, присутствует: %s\n", studentName, studentPresence);
        }
    }

    public void getCourseInfo() {
        System.out.printf("Курс: %s\n", getSubject());
        System.out.printf("Учитель: %s\n", getLectorName());
        printStudents();
        printGrades();
        printPresence();
    }

    public Map<String, Integer> setDefaultGrades(ArrayList<Student> students) {
        Map<String, Integer> defaultGrades = new HashMap<>();
        for(Student student : students){
            defaultGrades.put(student.getName(), 0);
        }
        return defaultGrades;
    }

    public Map<String, Boolean> setDefaultPresence(ArrayList<Student> students) {
        Map<String, Boolean> defaultPresence = new HashMap<>();
        for(Student student : students){
            defaultPresence.put(student.getName(), false);
        }
        return defaultPresence;
    }

    public void changeGrade(String studentName, int newGrade) {
        if (grades.containsKey(studentName)){
            grades.replace(studentName, newGrade);
        } else System.out.println("Нет такого ученика\n");
    }

    public void markPresence(String studentName, boolean present) {
        if (presence.containsKey(studentName)){
            presence.replace(studentName, present);
        } else System.out.println("Нет такого ученика\n");
    }
}
