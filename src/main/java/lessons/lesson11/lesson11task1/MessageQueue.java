package main.java.lessons.lesson11.lesson11task1;

import java.util.LinkedList;
import java.util.List;

public class MessageQueue {
    private final List<String> messages = new LinkedList<>();

    public synchronized void put(String message) {
        messages.add(message);
        notify(); // уведомляем подписчика, что появилось новое сообщение
    }

    public synchronized String take() {
        while (messages.isEmpty()) {
            try {
                wait(); // ждём, пока появится сообщение
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return null;
            }
        }
        return messages.remove(0);
    }
}
