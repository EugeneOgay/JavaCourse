package main.java.lessons.lesson5.trainingCenter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Course {
    private final String subject;
    private final Teacher lector;
    private final ArrayList<Student> students;
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

    public void getStudents() {
        System.out.println("Список студентов курса: \n");
        for (Student student : students) {
            System.out.printf("Имя: %s\n", student.getName());
        }
    }

    public void getGrades() {
        System.out.println("Журнал успеваемости: \n");
        for(Map.Entry<String, Integer> currentGrades : grades.entrySet()){
            System.out.printf("Студент: %s, оценка: %d\n", currentGrades.getKey(), currentGrades.getValue());
        }
    }

    public void getPresence() {
        System.out.println("Журнал плсещаемости: \n");
        for(Map.Entry<String, Boolean> currentPresence : presence.entrySet()){
            System.out.printf("Студент: %s, присутствует: %s\n", currentPresence.getKey(), currentPresence.getValue() == true ? "да" : "нет");
        }
    }

    public void getCourseInfo() {
        System.out.printf("Курс: %s\n", getSubject());
        System.out.printf("Учитель: %s\n", getLectorName());
        getStudents();
        getGrades();
        getPresence();
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

//    public Teacher SetLector(Teacher lector) {
//        if(lector.GetSubject().equalsIgnoreCase(subject)) {
//            if(lector.GetStatus()){
//                System.out.printf("Лектор %s назначен на курс", lector.GetName());
//                lector.MakeBusy();
//                return lector;
//            } else {
//                System.out.printf("Лектор %s занят", lector.GetName());
//                return null;
//            }
//        } else {
//            System.out.println("Данный лектор не может вести курс");
//            return null;
//        }
//    }
//
//    public void SetLector2(Teacher lector) {
//        if(lector.GetSubject().equalsIgnoreCase(subject)) {
//            if(lector.GetStatus()){
//                this.lector = lector;
//                System.out.printf("Лектор %s назначен на курс", lector.GetName());
//            } else System.out.printf("Лектор %s занят", lector.GetName());
//        } else System.out.println("Данный лектор не может вести курс");
//    }
}
