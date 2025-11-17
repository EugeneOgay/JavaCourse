package main.java.lessons.lesson11.lesson11task2;

import java.util.LinkedList;
import java.util.List;

public class SimpleThreadPool {

    private final List<Worker> workers = new LinkedList<>();
    private final LinkedList<Runnable> taskQueue = new LinkedList<>();
    private volatile boolean isShutdown = false;

    public SimpleThreadPool(int threadCount) {
        for (int i = 0; i < threadCount; i++) {
            Worker worker = new Worker("Worker-" + i);
            workers.add(worker);
            worker.start();
        }
    }

    public void submit(Runnable task) {
        synchronized (taskQueue) {
            if (isShutdown) {
                throw new IllegalStateException("ThreadPool is shut down");
            }
            taskQueue.add(task);
            taskQueue.notify(); // пробуждаем один поток
        }
    }

    public void shutdown() {
        isShutdown = true;

        // Разбудить всех воркеров — иначе они могут висеть в wait()
        synchronized (taskQueue) {
            taskQueue.notifyAll();
        }

        // Дождаться завершения всех потоков
        for (Worker worker : workers) {
            try {
                worker.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        System.out.println("Пул потоков корректно завершён.");
    }

    private class Worker extends Thread {
        public Worker(String name) {
            super(name);
        }

        @Override
        public void run() {
            while (true) {
                Runnable task;

                synchronized (taskQueue) {
                    while (taskQueue.isEmpty() && !isShutdown) {
                        try {
                            taskQueue.wait();
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                    }

                    // Если shutdown + нет задач → поток завершает работу
                    if (isShutdown && taskQueue.isEmpty()) {
                        break;
                    }

                    task = taskQueue.removeFirst();
                }

                try {
                    task.run();
                } catch (RuntimeException e) {
                    System.out.println("Ошибка выполнения задачи: " + e.getMessage());
                }
            }

            System.out.println(Thread.currentThread().getName() + " завершил работу.");
        }
    }
}

