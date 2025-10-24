package main.java.lessons.lesson8;

import java.util.LinkedList;

public class DigitalQueue {
    private LinkedList<User> queue = new LinkedList<>();
    
    public void addUserInQueue(String name) {
        int number = queue.size();
        queue.addLast(new User(number + 1, name));
    }

    public void processQueue() {
        if (!queue.isEmpty()) {
            queue.removeFirst();
        } else System.out.println("Обрабатывать нечего, очередь пуста");
    }

    public void getCurrentQueue() {
        System.out.println("Текущая очередь\n");
        if(queue.isEmpty())  {
            System.out.println("Нет очереди");
            return;
        }
        for(User user : queue) {
            user.getUserInfo();
        }
    }
}

class User {
    private int number;
    private  String name;

    public User(int number, String name) {
        this.number = number;
        this.name = name;
    }

    public void getUserInfo() {
        System.out.printf("Номер: %d, Имя: %s\n", number, name);
    }
}
