package main.java.lessons.lesson5.trainingCenter;

import java.util.ArrayList;

public class TrainingCenter {
    private final ArrayList<Course> courses = new ArrayList<>();
    private final ArrayList<Student> students = new ArrayList<>();
    private final ArrayList<Teacher> teachers = new ArrayList<>();

    public void setTeachers() {
        teachers.add(new Teacher("John", "Math", false));
        teachers.add(new Teacher("Eddie", "Biology", true));
        teachers.add(new Teacher("Tom", "Chemistry", true));
        teachers.add(new Teacher("Dave", "Math", true));
        teachers.add(new Teacher("James", "Biology", false));
    }

    public void setStudents() {
        students.add(new Student("Michael", "Math",  true));
        students.add(new Student("Bill", "Biology",  true));
        students.add(new Student("Robert", "Math",  false));
        students.add(new Student("William", "Biology",  true));
        students.add(new Student("David", "Math",  false));
        students.add(new Student("Joseph", "Biology",  false));
        students.add(new Student("Charles", "Math",  false));
        students.add(new Student("Daniel", "Biology",  false));
        students.add(new Student("Andrew", "Math",  true));
        students.add(new Student("Ryan", "Biology",  false));
    }

    public void getCourses() {
        if(courses.isEmpty()) {
            System.out.println("На текущий момент нет активных курсов");
            return;
        }
        System.out.println("Список активных курсов: \n");
        for(Course course : courses){
            String courseName = course.getSubject();
            String lectorName = course.getLectorName();
            System.out.printf("Предмет: %s, Учитель: %s\n", courseName, lectorName);
        }
    }

    public void getTeachers() {
        if(teachers.isEmpty()) {
            System.out.println("Нет учителей");
            return;
        }
        System.out.println("Список учителей: \n");
        for (Teacher teacher : teachers){
            teacher.showInfo();
        }
    }

    public void getStudents() {
        if(students.isEmpty()) {
            System.out.println("Нет студентов");
            return;
        }
        System.out.println("Список студентов: \n");
        for (Student student : students){
            student.showInfo();
        }
    }

    public void createCourse(String courseSubject, String courseTeacherName) {
        boolean courseExist = courseExist(courseSubject);
        Teacher courseTeacher = null;

        if (courseExist) {
            for(Teacher teacher : teachers){
                if (teacher.getName().equalsIgnoreCase(courseTeacherName) && teacher.getSubject().equalsIgnoreCase(courseSubject)) {
                    if (teacher.getStatus()) {
                        courseTeacher  = teacher;
                        break;
                    } else {
                        System.out.printf("Учитель %s занят\n", teacher.getName());
                        return;
                    }
                }
            }
            if(courseTeacher == null){
                System.out.println("Нет учителя с таким именем или учитель не преподает выбранный курс\n");
                return;
            }
        } else return;

        ArrayList<Student> readyToEnrollStudents = new ArrayList<>();
        for(Student student : students) {
            if (student.getChosenSubject().equalsIgnoreCase(courseSubject) && !student.getStatus()){
                readyToEnrollStudents.add(student);
            }
        }
        if(readyToEnrollStudents.isEmpty()){
            System.out.printf("Нет свободных студентов готовых записаться на курс %s", courseSubject);
            return;
        }

        courses.add(new Course(courseSubject, courseTeacher, readyToEnrollStudents));
        courseTeacher.makeBusy();
        for (Student student : readyToEnrollStudents) {
            student.enroll();
        }
    }

    public void changeGrade(String subject, String teacherName, String studentName, int newGrade) {
        var course  = getCourse(subject, teacherName);
        if(course != null) {
            course.changeGrade(studentName, newGrade);
        } else System.out.println("Нет подобного курса\n");
    }

    public void markPresence(String subject, String teacherName, String studentName, boolean presence) {
        var course  = getCourse(subject, teacherName);
        if(course != null) {
            course.markPresence(studentName, presence);
        } else System.out.println("Нет подобного курса\n");
    }

    public void getCourseInfo(String subject, String teacherName) {
        var course  = getCourse(subject, teacherName);
        if(course != null) {
            course.getCourseInfo();
        } else System.out.println("Нет подобного курса\n");
    }

    private boolean courseExist(String courseSubject) {
        for(Teacher teacher : teachers) {
            if(teacher.getSubject().equalsIgnoreCase(courseSubject)) return true;
            }
            System.out.printf("Нет учителя что мог бы преподавать курс %s\n", courseSubject);
            return false;
    }

    private Course getCourse(String subject, String teacherName){
        for(Course course : courses){
            if(course.getSubject().equalsIgnoreCase(subject) && course.getLectorName().equalsIgnoreCase(teacherName)) {
                return course;
            }
        }
        return null;
    }
}

