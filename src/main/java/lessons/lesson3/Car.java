package main.java.lessons.lesson3;

public class Car {
    String county;
    String model;
    int yearOfManufacture;

    public Car(String county, String model, int yearOfManufacture){
        this.county = county;
        this.model = model;
        this.yearOfManufacture = yearOfManufacture;
    }

    public static void PrintCarInfo(Car car) {
        System.out.println("\nИнформация о машине:");
        System.out.printf("Страна: %s\n", car.county);
        System.out.printf("Модель: %s\n", car.model);
        System.out.printf("Год: %d", car.yearOfManufacture);
    }
}
