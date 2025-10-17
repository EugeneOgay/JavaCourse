package main.java.lessons.lesson3;

public class Car {
    private String county;
    private String model;
    private int yearOfManufacture;

    public Car(String county, String model, int yearOfManufacture){
        this.county = county;
        this.model = model;
        this.yearOfManufacture = yearOfManufacture;
    }

    public void printCarInfo() {
        System.out.println("\nИнформация о машине:");
        System.out.printf("Страна: %s\n", county);
        System.out.printf("Модель: %s\n", model);
        System.out.printf("Год: %d", yearOfManufacture);
    }
}
