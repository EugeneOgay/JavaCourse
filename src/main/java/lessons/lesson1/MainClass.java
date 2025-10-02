package main.java.lessons.lesson1;

import main.java.lessons.lesson2.Lesson2;
import main.java.lessons.lesson3.BankAccount;
import main.java.lessons.lesson3.Car;
import main.java.lessons.lesson3.Person;
import main.java.lessons.lesson3.Rectangle;

import java.util.Scanner;

public class MainClass {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите номер урока: ");
        int lesson = scanner.nextInt();

        switch (lesson) {
            case 1 -> System.out.print("Первый урок был ознакомительным и практических заданий не было)");
            case 2 -> {
                System.out.println("\nЗадания:\n" +
                    "1.Квест игра «Тень над Озером» \n" +
                    "2.Вывести числа от 1 до 100 (каждые 10 цифр в одну строку и каждую группу с новой строки).\n" +
                    "3.Сумма чисел от 1 до N (ввод N с клавиатуры).\n" +
                    "4.Произведение чисел от 1 до N.\n" +
                    "5.Сумма четных чисел от 1 до N.\n" +
                    "6.Сумма цифр числа (например, 1234 → 10).\n" +
                    "7.Разворот числа (например, 1234 → 4321).\n" +
                    "8.Найти факториал N (через цикл, не рекурсией).\n" +
                    "9.Найти первое число, которое делится на 7 и больше 1000.\n" +
                    "10.Вывести все простые числа до N.\n" +
                    "11.Нарисовать треугольники из звездочек:\n" +
                    "12.Обмен значений\n" +
                    "13.Таблица умножения\n" +
                    "14.Конвертер валют\n" +
                    "15.Чётное или нечётное\n" +
                    "16.Максимум из трёх\n" +
                    "17.Калькулятор\n" +
                    "18.Среднее арифметическое\n" +
                    "19.Поиск элемента\n" +
                    "20.Мини-игра \"Угадай число\"\n");

                System.out.print("Введите номер задания: ");
                int task = scanner.nextInt();
                switch (task){
                    case 1 -> Lesson2.Quest();
                    case 2 -> Lesson2.NumbersRow();
                    case 3 -> Lesson2.SumOfNumbers();
                    case 4 -> Lesson2.MultiplicationOfNumbers();
                    case 5 -> Lesson2.SumOfEvenNumbers();
                    case 6 -> Lesson2.SumOfDigits();
                    case 7 -> Lesson2.DigitsRotate();
                    case 8 -> Lesson2.FactorialOfNumber();
                    case 9 -> Lesson2.FirstOfNumbers();
                    case 10 -> Lesson2.CommonNumbers();
                    case 11 -> Lesson2.Stars();
                    case 12 -> Lesson2.NumbersChanging();
                    case 13 -> Lesson2.Multiplication();
                    case 14 -> Lesson2.CurrencyExchange();
                    case 15 -> Lesson2.EvenOrOdd();
                    case 16 -> Lesson2.MaxOfThree();
                    case 17 -> Lesson2.Calculator();
                    case 18 -> Lesson2.ArithmeticMean();
                    case 19 -> Lesson2.ElementSearch();
                    case 20 -> Lesson2.GuessTheNumber();
                    default -> System.out.print("Нет задания под этим номером");
                }
            }
            case 3 -> {
                System.out.println("\nЗадания:\n" +
                    "1.dasdasdasd» \n");
//                    "2.Вывести числа от 1 до 100 (каждые 10 цифр в одну строку и каждую группу с новой строки).\n" +
//                    "3.Сумма чисел от 1 до N (ввод N с клавиатуры).\n" +
//                    "4.Произведение чисел от 1 до N.\n" +
//                    "5.Сумма четных чисел от 1 до N.\n" +
//                    "6.Сумма цифр числа (например, 1234 → 10).\n" +
//                    "7.Разворот числа (например, 1234 → 4321).\n" +
//                    "8.Найти факториал N (через цикл, не рекурсией).\n" +
//                    "9.Найти первое число, которое делится на 7 и больше 1000.\n" +
//                    "10.Вывести все простые числа до N.\n" +
//                    "11.Нарисовать треугольники из звездочек:\n" +
//                    "12.Обмен значений\n" +
//                    "13.Таблица умножения\n" +
//                    "14.Конвертер валют\n" +
//                    "15.Чётное или нечётное\n" +
//                    "16.Максимум из трёх\n" +
//                    "17.Калькулятор\n" +
//                    "18.Среднее арифметическое\n" +
//                    "19.Поиск элемента\n" +
//                    "20.Мини-игра \"Угадай число\"\n");

                System.out.print("Введите номер задания: ");
                int task = scanner.nextInt();
                switch (task){
                    case 1 -> {
                        System.out.print("Введите имя: ");
                        Scanner stringScanner = new Scanner(System.in);
                        String name = stringScanner.nextLine();
                        System.out.print("Введите возраст: ");
                        int age = scanner.nextInt();
                        Person person = new Person(name, age);
                        person.Introduce();
//                        Person person2 = new Person();
//                        person2.Introduce2();
                    }
                    case 2 -> {
                        System.out.print("Введите длину прямоугольника: ");
                        int length = scanner.nextInt();
                        System.out.print("Введите ширину прямоугольника: ");
                        int width = scanner.nextInt();
                        Rectangle rectangle = new Rectangle(length, width);
                        System.out.printf("Площадь прямоугольника равна %d\n", rectangle.CalculateSquare());
                        System.out.printf("Периметр прямоугольника равен %d", rectangle.CalculatePerimeter());
                    }
                    case 3 -> {
                        System.out.print("Введите данные о машине!\n");
                        Scanner stringScanner = new Scanner(System.in);
                        System.out.print("Страна: ");
                        String county = stringScanner.nextLine();
                        System.out.print("Модель: ");
                        String model = stringScanner.nextLine();
                        System.out.print("Год: ");
                        int yearOfManufacture = scanner.nextInt();
                        Car car = new Car(county, model, yearOfManufacture);
                        Car.PrintCarInfo(car);
                    }
                    case 4 -> {
                        System.out.print("Введите данные об аккаунте!\n");
                        Scanner stringScanner = new Scanner(System.in);
                        System.out.print("ФИО: ");
                        String fio = stringScanner.nextLine();
                        System.out.print("Номер аккаунта: ");
                        long accountNumber = scanner.nextLong();
                        System.out.print("Баланс: ");
                        int balance = scanner.nextInt();
                        BankAccount bankAccount = new BankAccount(fio, accountNumber, balance);
                        bankAccount.GetBalance();
                        bankAccount.Deposit(5000);
                        bankAccount.GetBalance();
                        bankAccount.Withdraw(10000);
                        bankAccount.GetBalance();
                    }
//                    case 5 -> Lesson2.SumOfEvenNumbers();
//                    case 6 -> Lesson2.SumOfDigits();
//                    case 7 -> Lesson2.DigitsRotate();
//                    case 8 -> Lesson2.FactorialOfNumber();
//                    case 9 -> Lesson2.FirstOfNumbers();
//                    case 10 -> Lesson2.CommonNumbers();
//                    case 11 -> Lesson2.Stars();
//                    case 12 -> Lesson2.NumbersChanging();
//                    case 13 -> Lesson2.Multiplication();
//                    case 14 -> Lesson2.CurrencyExchange();
//                    case 15 -> Lesson2.EvenOrOdd();
//                    case 16 -> Lesson2.MaxOfThree();
//                    case 17 -> Lesson2.Calculator();
//                    case 18 -> Lesson2.ArithmeticMean();
//                    case 19 -> Lesson2.ElementSearch();
//                    case 20 -> Lesson2.GuessTheNumber();
                    default -> System.out.print("Нет задания под этим номером");
                }
            }
            default -> System.out.print("Нет урока под этим номером");
        }
    }
}