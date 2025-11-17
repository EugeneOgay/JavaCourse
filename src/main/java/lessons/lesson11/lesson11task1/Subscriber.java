package main.java.lessons.lesson11.lesson11task1;

public class Subscriber implements Runnable{
    private MessageQueue queue;

    public Subscriber(MessageQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        boolean active = true;
        while (active) {
            String message = queue.take();
            if (message == null || message.equalsIgnoreCase("exit")) {
                active = false;
            } else {
                System.out.println("Subscriber получил сообщение: " + message);
            }
        }
        System.out.println("Subscriber завершил работу");
    }
}
