package main.java.lessons.lesson5.trainingCenter;

public class Teacher extends Person {

    private String subject;
    private boolean free = true;

    public Teacher(String name, String subject, boolean free) {
        super(name);
        this.subject = subject;
        this.free = free;
    }

    @Override
    public String GetName() {
        return super.GetName();
    }

    @Override
    public void ShowInfo() {
        String ready;
        System.out.printf("Имя: %s, предмет: %s, свободен: %s\n", GetName(), GetSubject(), ready = GetStatus() ? "да" : "нет");
    }

    public String GetSubject() {
        return subject;
    }

    public void MakeBusy() {
        if(free){ free = false; }
        else System.out.printf("Преподаватель %s уже занят\n", GetName());
    }

    public boolean GetStatus() {
        return free;
    }
}
