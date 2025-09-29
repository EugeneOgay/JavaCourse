package main.java.lessons.lesson1;

import main.java.lessons.lesson2.Lesson2;

import java.util.Scanner;

public class MainClass {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите номер урока: ");
        int lesson = scanner.nextInt();

        switch (lesson) {
            case 1 -> {
                System.out.print("Первый урок был ознакомительным и практических заданий не было)");
            }
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

                System.out.print("Введите номер урока: ");
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
            default -> System.out.print("Нет урока под этим номером");
        }
    }
}