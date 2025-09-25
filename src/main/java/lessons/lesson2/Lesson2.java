package main.java.lessons.lesson2;

import java.util.Scanner;

public class Lesson2 {
    public static void NumbersRow() {
        for (int i = 1; i <= 100; i++) {
            System.out.print(i + " ");
            if (i % 10 == 0) {
                System.out.println();
            }
        }
    }

    public static void SumOfNumbers() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите число: ");
        int number = scanner.nextInt();

        int sum = 0;
        for (int i = 1; i <= number; i++) {
            sum = sum + i;
        }

        System.out.println("Сумма чисел от 1 до " + number + " равна " + sum);
    }

    public static void MultiplicationOfNumbers() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите число: ");
        int number = scanner.nextInt();

        int result = 1;
        for (int i = 2; i <= number; i++) {
            result = result * i;
        }

        System.out.println("Произведение чисел от 1 до " + number + " равно " + result);
    }

    public static void SumOfEvenNumbers() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите число: ");
        int number = scanner.nextInt();

        int sum = 0;
        for (int i = 1; i <= number; i++) {
            if (i % 2 == 0) {
                sum = sum + i;
            }
        }

        System.out.println("Сумма четных чисел от 1 до " + number + " равна " + sum);
    }

    public static void SumOfDigits() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите число: ");
        String number = scanner.nextLine();
        char[] digitsArray = number.toCharArray();

        int sum = 0;

        for (int i = 0; i < number.length(); i++) {
            int digit = Character.getNumericValue(digitsArray[i]);
            sum = sum + digit;
        }

        System.out.println("Сумма цифр введенного числа " + number + " равна " + sum);
    }

    public static void DigitsRotate() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите число: ");
        String number = scanner.nextLine();
        char[] digitsArray = number.toCharArray();

        var revertedDigitsArray = new char[number.length()];

        for (int i = 0; i < number.length(); i++) {
            for(int k = number.length() - 1 - i; k >= 0; k--) {
                revertedDigitsArray[k] = digitsArray[i];
            }
        }

        String revertedNumber = new String(revertedDigitsArray);

        System.out.println("Развернутое число " + number + " равно " + revertedNumber);
    }

    public static void FactorialOfNumber() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите число: ");
        int number = scanner.nextInt();

        while (number <= 0) {
            System.out.print("Введенное число должно быть натуральным(больше 0) \n");
            System.out.print("Введите число: ");
            number = scanner.nextInt();
        }

        int result = 1;
        for (int i = 2; i <= number; i++) {
            result = result * i;
        }

        System.out.println("Факториал числа " + number + " равен " + result);
    }
}