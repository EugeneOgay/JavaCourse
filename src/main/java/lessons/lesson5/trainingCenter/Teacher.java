package main.java.lessons.lesson5.trainingCenter;

public class Teacher extends Person {

    private String subject;
    private boolean isAvailable;

    public Teacher(String name, String subject, boolean available) {
        super(name);
        this.subject = subject;
        this.isAvailable = available;
    }

    @Override
    public void showInfo() {
        System.out.printf("Имя: %s, предмет: %s, свободен: %s\n", getName(), getSubject(), getStatus() ? "да" : "нет");
    }

    public String getSubject() {
        return subject;
    }

    public void makeBusy() {
        if(isAvailable){ isAvailable = false; }
        else System.out.printf("Преподаватель %s уже занят\n", getName());
    }

    public boolean getStatus() {
        return isAvailable;
    }
}
