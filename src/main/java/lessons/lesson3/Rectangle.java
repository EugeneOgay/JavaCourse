package main.java.lessons.lesson3;

public class Rectangle {
    private int length;
    private int width;

    public Rectangle(int length, int width) {
        assert length > 0 : "Длина не может быть меньше 0";
        assert width > 0 : "Ширина не может быть меньше 0";

        this.length = length;
        this.width  = width;
    }

    public int сalculateSquare() {
        return length * width;
    }
    public int сalculatePerimeter() {
        return length + width + length + width;
    }
}
