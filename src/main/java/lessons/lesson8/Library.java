package main.java.lessons.lesson8;

import java.util.HashMap;
import java.util.Map;

public class Library {
    private Map<String, Book> books = new HashMap<>();

    public void addBooks() {
        books.put("123sss", new Book("123sss" , "book 1", "author 1"));
        books.put("456dddd", new Book("456dddd" , "book 1", "author 1"));
        books.put("789aaaa", new Book("789aaaa" , "book 1", "author 1"));
        books.put("532fff", new Book("532fff" , "book 1", "author 1"));
    }

    public void displayAllBooks() {
        System.out.print("Книги:\n");
        for(Map.Entry<String, Book> book : books.entrySet()) {
            String isbn = book.getKey();
            Book currentBook = book.getValue();
            System.out.printf("isbn: %s, book: %s, author: %s\n", isbn, currentBook.getBookName(), currentBook.getAuthor());
        }
    }
}

class Book {
    private String isbn;
    private String bookName;
    private String author;

    Book(String isbn, String bookName, String author){
        this.isbn = isbn;
        this.bookName = bookName;
        this.author = author;
    }

    public String getBookName() {
        return bookName;
    }

    public String getAuthor() {
        return author;
    }
}
