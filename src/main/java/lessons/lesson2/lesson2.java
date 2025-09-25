package main.java.lessons.lesson2;

public class lesson2 {
    public void Numbers() {
        for(int i = 1; i <= 100; i++){
            System.out.print(i + " ");
            if(i % 10 == 0) {
                System.out.println();
            }
        }
    }
}