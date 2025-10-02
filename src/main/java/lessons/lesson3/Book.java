package main.java.lessons.lesson3;

import java.util.ArrayList;

public class Book {
    String name;
    String author;
    int year;
    boolean status;

    public static ArrayList<Book> books = new ArrayList<>();

    public Book(String name, String author, int year, boolean status) {
        this.name = name;
        this.author = author;
        this.year = year;
        this.status = status;
    }

    public static void AddNewBook(Book book) {
        books.add(book);
    }

    public void GetBookInfo() {
        String reserved;
        System.out.printf("Информация о книге: \nНазвание: %s\n, Автор: %s\n, Год: %d\n, Cтатус: %s\n",
            name, author, year, reserved = status ? "Свободна\n" : "Зарезервирована\n");
    }

    public static void GetBooks() {
        if (books.isEmpty()) {
            System.out.println("Библиотека пуста");
        } else {
            System.out.println("Библиотека:\n");
            for (Book book : books) {
                book.GetBookInfo();
            }
        }
    }

    public void ReserveBook() {
        if (status) {
            status = false;
            System.out.println("Книга " + name + " зарезервирована\n");
        } else {
            System.out.println("Книга " + name + " уже зарезервирована\n");
        }
    }
}
