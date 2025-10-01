package main.java.lessons.lesson3;

public class Rectangle {
    int length;
    int width;

    public Rectangle(int length, int width) {
        this.length = length;
        this.width  = width;
    }

    public int CalculateSquare() {
        return length * width;
    }
    public int CalculatePerimeter() {
        return length + width + length + width;
    }
}
