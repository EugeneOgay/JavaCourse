package main.java.lessons.lesson5.trainingCenter;

import java.util.ArrayList;

public class TrainingCenter {
    static ArrayList<Course> courses = new ArrayList<>();
    static ArrayList<Student> students = new ArrayList<>();
    static ArrayList<Teacher> teachers = new ArrayList<>();

    public static void SetTeachers() {
        teachers.add(new Teacher("John", "Math", false));
        teachers.add(new Teacher("Eddie", "Biology", true));
        teachers.add(new Teacher("Tom", "Chemistry", true));
        teachers.add(new Teacher("Dave", "Math", true));
        teachers.add(new Teacher("James", "Biology", false));
    }

    public static void addTeacher(Teacher teacher) {
        teachers.add(teacher);
    }

    public static void SetStudents() {
        students.add(new Student("Michael", "Math",  true));
        students.add(new Student("Bill", "Biology",  true));
        students.add(new Student("Robert", "Math",  false));
        students.add(new Student("William", "Biology",  true));
        students.add(new Student("David", "Math",  false));
        students.add(new Student("Joseph", "Biology",  false));
        students.add(new Student("Charles", "Math",  false));
        students.add(new Student("Daniel", "Biology",  false));
        students.add(new Student("Andrew", "Math",  false));
        students.add(new Student("Ryan", "Biology",  false));
    }

    public static void addStudent(Student student) {
        students.add(student);
    }

    public static void GetCourses() {
        if(courses.isEmpty()) {
            System.out.println("На текущий момент нет активных курсов");
            return;
        }
        System.out.println("Список активных курсов: \n");
        for(Course course : courses){
            System.out.printf("%s\n", course.GetSubject());
        }
    }

    public static void GetTeachers() {
        if(teachers.isEmpty()) {
            System.out.println("Нет учителей");
            return;
        }
        System.out.println("Список учителей: \n");
        for (Teacher teacher : teachers){
            teacher.ShowInfo();
        }
    }

    public void GetStudents() {
        if(students.isEmpty()) {
            System.out.println("Нет студентов");
            return;
        }
        System.out.println("Список студентов: \n");
        for (Student student : students){
            student.ShowInfo();
        }
    }

//    public static void CreateCourse(String courseSubject, String courseTeacherName) {
//        boolean courseExist = false;
//        Teacher courseTeacher = null;
//
//        for(Teacher teacher : teachers) {
//            if(teacher.GetSubject().equalsIgnoreCase(courseSubject)) {
//                courseExist = true;
//                if(teacher.GetName().equalsIgnoreCase(courseTeacherName)) {
//                    if(teacher.GetStatus()) {
//                        courseTeacher  = teacher;
//                        teacher.MakeBusy(); // инкапсулировать в классе Teacher
//                    } else System.out.printf("Учитель %s занят", teacher.GetName());
//                }
//            } else System.out.printf("Нет учителя что мог бы преподавать курс %s", courseSubject);
//        }
//
//        ArrayList<Student> readyToEnrollStudents = new ArrayList<>();
//        for(Student student : students) {
//            if (student.GetChosenSubject().equalsIgnoreCase(courseSubject) && !student.GetStatus()){
//                readyToEnrollStudents.add(student);
//                student.GetEnrolled();
//            } else {
//                System.out.printf("Нет свободных студентов готовых записаться на курс %s", courseSubject);
//                return;
//            }
//        }
//
//        courses.add(new Course(courseSubject, courseTeacher, readyToEnrollStudents));
//    }

    public static void CreateCourse(String courseSubject, String courseTeacherName) {
        boolean courseExist = CourseExist(courseSubject);
        Teacher courseTeacher = null;

        if (courseExist) {
            for(Teacher teacher : teachers){
                if (teacher.GetName().equalsIgnoreCase(courseTeacherName) && teacher.GetSubject().equalsIgnoreCase(courseSubject)) {
                    if (teacher.GetStatus()) {
                        courseTeacher  = teacher;
                        break;
                    } else System.out.printf("Учитель %s занят", teacher.GetName());
                } else {
                    System.out.println("Нет учителя с таким именем или учитель не преподает выбранный курс");
                    return;
                }
            }
        } else {
            System.out.printf("Нет подобного курса %s", courseSubject);
            return;
        }

        ArrayList<Student> readyToEnrollStudents = new ArrayList<>();
        for(Student student : students) {
            if (student.GetChosenSubject().equalsIgnoreCase(courseSubject) && !student.GetStatus()){
                readyToEnrollStudents.add(student);
                //student.GetEnrolled();
            } else {
                System.out.printf("Нет свободных студентов готовых записаться на курс %s", courseSubject);
                return;
            }
        }

        if (readyToEnrollStudents.isEmpty() || courseTeacher != null){
            courses.add(new Course(courseSubject, courseTeacher, readyToEnrollStudents));
            courseTeacher.MakeBusy();
            for (Student student : readyToEnrollStudents) {
                student.GetEnrolled();
            }
        }
    }

    private static boolean CourseExist(String courseSubject) {
        for(Teacher teacher : teachers) {
            if(teacher.GetSubject().equalsIgnoreCase(courseSubject)) return true;
            }
            System.out.printf("Нет учителя что мог бы преподавать курс %s", courseSubject);
            return false;
    }
}

