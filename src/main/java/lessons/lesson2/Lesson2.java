package main.java.lessons.lesson2;

import java.util.Scanner;
import java.util.random.RandomGenerator;

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

        while (number <= 1) {
            System.out.print("Введенное число должно быть больше 1 \n");
            System.out.print("Введите число: ");
            number = scanner.nextInt();
        }

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

        while (number <= 1) {
            System.out.print("Введенное число должно быть больше 1 \n");
            System.out.print("Введите число: ");
            number = scanner.nextInt();
        }

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

        while (number <= 1) {
            System.out.print("Введенное число должно быть больше 1 \n");
            System.out.print("Введите число: ");
            number = scanner.nextInt();
        }

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

        while (number < 0) {
            System.out.print("Введенное число не должно быть отрицательным \n");
            System.out.print("Введите число: ");
            number = scanner.nextInt();
        }

        switch (number) {
            case 0 -> System.out.println("Факториал числа " + number + " равен 1");
            default -> {
                int result = 1;
                for (int i = 2; i <= number; i++) {
                    result = result * i;
                }
                System.out.println("Факториал числа " + number + " равен " + result);
            }
        }
    }

    public static void FirstOfNumbers() {
        int number = 1000;
        do {
            number++;
        } while( number % 7 != 0);


        System.out.print("Первое число что делится на 7 и больше 1000 это' " + number);
    }

    public static void CommonNumbers() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите число: ");
        int number = scanner.nextInt();

        while (number <= 1) {
            System.out.print("Введенное число должно быть больше 1 \n");
            System.out.print("Введите число: ");
            number = scanner.nextInt();
        }

        System.out.print("Простые числа от 2 до " + number + ": ");

        for (int i = 2; i <= number; i++) {
            boolean commonState = true;
            for(int k = 2; k < i; k++) {
                if( i % k == 0) {
                    commonState = false;
                    break;
                }
            }
            if(commonState) {
                System.out.print(i + " ");
            }
        }
    }

    public static void Stars() {
       for (int i = 1;  i <=4; i++) {
           switch (i) {
               case 1 -> System.out.println("*\t****");
               case 2 -> System.out.println("**\t ***");
               case 3 -> System.out.println("***\t  **");
               case 4 -> System.out.println("****   *");
           }
       }
        System.out.println("\t");

        for (int j = 1;  j <=4; j++) {
            switch (j) {
                case 1 -> System.out.println("****   *");
                case 2 -> System.out.println("***\t  **");
                case 3 -> System.out.println("**\t ***");
                case 4 -> System.out.println("*\t****");
            }
        }
    }

    public static void NumbersChanging() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите первое число: ");
        int number1 = scanner.nextInt();
        System.out.print("Введите второе число: ");
        int number2 = scanner.nextInt();

        int number3;
        number3 = number1;
        number1 = number2;
        number2 =  number3;

        System.out.print("После смены мест введенные числа это " + number1 + " и " + number2);
    }

    public static void Multiplication() {
        boolean repeat;
        do {
            Scanner scanner = new Scanner(System.in);

            System.out.print("Введите первый множитель: ");
            int number1 = scanner.nextInt();
            System.out.print("Введите второй множитель: ");
            int number2 = scanner.nextInt();

            System.out.println("Произведение чисел " + number1 + " и " + number2 + " равно " + (number1 * number2));

            System.out.print("Желаете повторить операцию(да/нет): ");
            scanner = new Scanner(System.in);
            String userChoice = scanner.nextLine();
            repeat = userChoice.equalsIgnoreCase("да");
        } while (repeat);
    }

    public static void CurrencyExchange() {
       final int exchange = 12500;
       Scanner scanner = new Scanner(System.in);

       System.out.print("Введите количество: ");
       int amount = scanner.nextInt();

        while (amount <= 0) {
            System.out.print("Введенное количество не должно быть меньше 0 \n");
            System.out.print("Введите количество: ");
            amount = scanner.nextInt();
        }

       System.out.println("Перевод " + amount +" долларов в сумы по курсу " + exchange + " равен: "
           + (amount * exchange));
    }

    public static void EvenOrOdd() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите число: ");
        int number = scanner.nextInt();

        while (number == 0) {
            System.out.print("Введенное число не должно быть равно 0 \n");
            System.out.print("Введите число: ");
            number = scanner.nextInt();
        }

        System.out.println("Введенное число " + number +
            (number % 2 == 0 ? " четное" : " нечетное"));
    }

    public static void MaxOfThree() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите первое число: ");
        int number1 = scanner.nextInt();
        System.out.print("Введите второе число: ");
        int number2 = scanner.nextInt();
        System.out.print("Введите третье число: ");
        int number3 = scanner.nextInt();

        int maxNumber;
        maxNumber = Math.max(number1, number2);
        maxNumber = Math.max(maxNumber, number3);

        System.out.println("Наибольшее число из введенных трех равно: " + maxNumber);
    }

    public static void Calculator() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите первое число: ");
        double number1 = scanner.nextInt();
        System.out.print("Введите второе число: ");
        double number2 = scanner.nextInt();

        System.out.print("Введите операцию которую хотите совершить  (+, -, *, /): ");
        scanner = new Scanner(System.in);
        String operation = scanner.nextLine();

        switch (operation) {
            case "+" ->  System.out.println("Cумма введенных чисел равна: " + (number1 + number2));
            case "-" ->  System.out.println("Разность введенных чисел равна: " + (number1 - number2));
            case "*" ->  System.out.println("Произведение введенных чисел равно: " + (number1 * number2));
            case "/" ->  System.out.println("Частное введенных чисел равно: " + ((number1 / number2)));
        }
    }


    public static void ArithmeticMean() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите количество чисел которые желаете ввести: ");
        int length = scanner.nextInt();

        while (length <= 0) {
            System.out.print("Введенное количество чисел не должно быть меньше 0 \n");
            System.out.print("Введите количество чисел которые желаете ввести: ");
            length = scanner.nextInt();
        }

        int[] arrayOfNumbers = new int[length];
        int sum = 0;
        for (int i  = 0; i < arrayOfNumbers.length; i++) {
            System.out.print("Введите "+ (i + 1) + " число: ");
            arrayOfNumbers[i] = scanner.nextInt();
            sum = sum + arrayOfNumbers[i];
        }
        double arithmeticMean = (double) sum /length;

        System.out.print("Среднее арифметическое введенных чисел равно:  " + arithmeticMean);
    }

    public static void ElementSearch() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите количество чисел которые желаете ввести: ");
        int length = scanner.nextInt();

        while (length <= 0) {
            System.out.print("Введенное количество чисел не должно быть меньше 0 \n");
            System.out.print("Введите количество чисел которые желаете ввести: ");
            length = scanner.nextInt();
        }

        int[] arrayOfNumbers = new int[length];
        for (int i  = 0; i < arrayOfNumbers.length; i++) {
            System.out.print("Введите "+ (i + 1) + " число: ");
            arrayOfNumbers[i] = scanner.nextInt();
        }

        System.out.print("Введите число которое хотите поискать в ряде ранее введенных чисел: ");
        scanner = new Scanner(System.in);
        int number = scanner.nextInt();

        boolean present = false;
        for (int i  = 0; i < arrayOfNumbers.length; i++) {
            if(arrayOfNumbers[i] == number) {
                present = true;
                System.out.println("Число " + number + " есть среди ранее введенных и было введено "
                    + (i + 1) + "м по счету");
            } 
        }
        if (!present) {
            System.out.print("Число " + number + " отсутсвует среди ранее введенных");
        }
    }

    public static void GuessTheNumber() {
        int randomNumber = RandomGenerator.getDefault().nextInt(100);

        boolean repeat = false;
        boolean found = false;
        do {
            Scanner scanner = new Scanner(System.in);
            for (int i = 0; i < 4; i++){
                System.out.print("Попробуйте угадать число от 0 до 100: ");
                int number = scanner.nextInt();
                if (number == randomNumber) {
                    found = true;
                    System.out.println("Вы угадали число - " + randomNumber);
                    break;
                }
            }

            if(!found){
                System.out.print("Желаете повторить операцию(да/нет): ");
                scanner = new Scanner(System.in);
                String userChoice = scanner.nextLine();
                repeat = userChoice.equalsIgnoreCase("да");
            }

        } while (repeat);

    }

}