package main.java.lessons.lesson11.lesson11task1;

import java.util.Scanner;

public class Publisher implements Runnable{
    private MessageQueue queue;

    public Publisher(MessageQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try (Scanner scanner = new Scanner(System.in)) {
            boolean active = true;
            System.out.println("Введите слово ('exit' слово для выхода)");
            while (active) {
                String input = scanner.nextLine();
                queue.put(input);
                if(input.equalsIgnoreCase("exit")) {
                    active = false;
                }
            }
            System.out.println("Publisher завершил работу.");
        }
    }
}
