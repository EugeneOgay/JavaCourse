package main.java.lessons.lesson3;

public class Rectangle {
    int length;
    int width;

    public Rectangle(int length, int width) {
        this.length = length;
        this.width  = width;
    }

    public void CalculateSquare() {
        System.out.printf("Площадь прямоугольника равна %d\n", (length * width));
    }
    public void CalculatePerimeter() {
        System.out.printf("Периметр прямоугольника равен %d", (length + width + length + width));
    }
}
