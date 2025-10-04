package main.java.lessons.lesson5.trainingCenter;

import java.util.ArrayList;

public class TrainingCenter {
    static ArrayList<Course> courses = new ArrayList<>();
    static ArrayList<Student> students = new ArrayList<>();
    static ArrayList<Teacher> teachers = new ArrayList<>();

    public static void SetTeachers() {
        teachers.add(new Teacher("John", "Math", true));
    }

    public static void addTeacher(Teacher teacher) {
        teachers.add(teacher);
    }

    public static void SetStudents() {
        students.add(new Student("Bill", "Biology",  false));
    }

    public static void CreateCourse(String courseSubject, String courseTeacherName) {
        boolean courseExist;
        Teacher courseTeacher = null;

        for(Teacher teacher : teachers) {
            if(teacher.GetSubject().equalsIgnoreCase(courseSubject)) {
                courseExist = true;
                if(teacher.GetName().equalsIgnoreCase(courseTeacherName) && teacher.GetStatus()) {
                    courseTeacher  = teacher;
                    teacher.MakeBusy();
                }
            } else System.out.printf("Нет учителя что мог бы преподавать курс %s", courseSubject);
        }

        ArrayList<Student> readyToEnrollStudents = new ArrayList<>();
        for(Student student : students) {
            if (student.GetChosenSubject().equalsIgnoreCase(courseSubject) && !student.GetStatus()){
                readyToEnrollStudents.add(student);
                student.GetEnrolled();
            } else {
                System.out.printf("Нет свободных студентов готовых записаться на курс %s", courseSubject);
                return;
            }
        }

        courses.add(new Course(courseSubject, courseTeacher, readyToEnrollStudents));


    }
}
