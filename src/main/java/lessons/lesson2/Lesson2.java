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
            case "+" ->  System.out.println("Сумма введенных чисел равна: " + (number1 + number2));
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

    public static void Quest() {
        System.out.println("Ты приходишь в себя на холодном песке у берега озера. Вокруг — туман, ночь, ни души. " +
            "Телефон в кармане почти разряжен (1%). \nВ другом кармане — спичка и клочок бумаги с надписью: " +
            "\"Не доверяй голосам. Иди к северу.\"\n");
        System.out.println("Выбор: \n1. \uD83D\uDD26 Пойти на восток, туда, где в тумане мерцает свет. → [Сцена 2A]\n" +
            "2. \uD83E\uDDED Пойти на север, как советует записка. → [Сцена 2B]\n" +
            "3. \uD83E\uDEB5 Остаться у озера, может, кто-то придёт. → [Сцена 2C]\t");

        Scanner scanner = new Scanner(System.in);
        System.out.print("Ваш выбор: ");
        int choice = scanner.nextInt();

        while (choice < 1 || choice > 3) {
            System.out.print("Выберите из доступных опций \n");
            System.out.print("Ваш выбор: ");
            choice = scanner.nextInt();
        }

        switch (choice) {
            case 1 -> {
                System.out.println("Ты идёшь на свет и находишь старую электростанцию. Внезапно загорается прожектор. " +
                    "Голос в громкоговорителе: «Стоять. Идентификация...» \nТы ничего не понимаешь. \n");
                System.out.println("Выбор: \n1. \uD83E\uDD16 Ответить: «Я человек, я потерялся!» → [Сцена 3A]\n" +
                    "2. \uD83C\uDFC3 Убежать назад в лес. → [Сцена 3B]\n\t");
                System.out.print("Ваш выбор: ");
                choice = scanner.nextInt();

                while (choice < 1 || choice > 2) {
                    System.out.print("Выберите из доступных опций \n");
                    System.out.print("Ваш выбор: ");
                    choice = scanner.nextInt();
                }

                if (choice == 1) {
                    System.out.println("Ты кричишь, но свет слепит тебя. Из темноты появляется фигура в противогазе. " +
                        "Вас усыпляют. Очнулся ты уже в лаборатории. Ты стал частью эксперимента. \n");
                    System.out.println("Концовка : Неудача \nРезультат: Смерть");
                } else {
                    System.out.println("Ты бежишь, но спотыкаешься. Прожектор гаснет. Что-то двигается в кустах. " +
                        "Ты исчез без следа. \n");
                    System.out.println("Концовка : Неудача \nРезультат: Исчезновение");
                }
            }
            case 2 -> {
                System.out.println("Ты следуешь на север и находишь заброшенную деревню. Дома пусты, но в одном — следы костра и дневник. " +
                    "\"Озеро просыпается в полнолуние. Не верь голосам. Прячься до рассвета.\"\n");
                System.out.println("Выбор: \n1. \uD83D\uDD25 Остаться в доме до рассвета. → [Сцена 3C]\n" +
                    "2. \uD83D\uDEAA Выйти и идти дальше в туман. → [Сцена 3D]\n\t");
                System.out.print("Ваш выбор: ");
                choice = scanner.nextInt();

                while (choice < 1 || choice > 2) {
                    System.out.print("Выберите из доступных опций \n");
                    System.out.print("Ваш выбор: ");
                    choice = scanner.nextInt();
                }

                if (choice == 1) {
                    System.out.println("Ты сидишь у костра. Проходят часы. На рассвете из тумана выходит " +
                        "группа людей — выжившие. Они помогают тебе выбраться. \n");
                    System.out.println("Концовка : Победа \nРезультат: Спасение");
                } else {
                    System.out.println("Ты блуждаешь в тумане и выходишь к маяку. Там — старая рация. Связь " +
                        "удаётся установить. На следующий день — эвакуация. \n");
                    System.out.println("Концовка : Победа \nРезультат: Эвакуация");
                }
            }
            case 3 -> {
                System.out.println("Ты остаёшься на месте. Из тумана слышишь детский голос: " +
                    "«Помоги мне… пожалуйста…»\n Тебя охватывает страх.\n");
                System.out.println("Выбор: \n1. \uD83D\uDC67 Пойти на голос. → [Сцена 3E]\n" +
                    "2. \uD83D\uDE28 Убежать прочь в лес. → [Сцена 3F]\n\t");
                System.out.print("Ваш выбор: ");
                choice = scanner.nextInt();

                while (choice < 1 || choice > 2) {
                    System.out.print("Выберите из доступных опций \n");
                    System.out.print("Ваш выбор: ");
                    choice = scanner.nextInt();
                }
                if (choice == 1) {
                    System.out.println("Ты идёшь на голос и видишь девочку в белом. Она улыбается и исчезает в воде. " +
                        "Вокруг тебя — тени. Ты не можешь двигаться. \n");
                    System.out.println("Концовка : Проклятие озера \nРезультат: Попал под влияние озера");
                } else {
                    System.out.println("Ты бежишь прочь. Натыкаешься на подземный люк. Внутри — бункер. " +
                        "Там — доказательства эксперимента: мониторы, карты, журналы. \n");
                    System.out.println("Выбор: \n1. \uD83D\uDCA3 Разрушить центр управления. → [Сцена 4A]\n" +
                        "2. \uD83E\uDDE0 Присоединиться к проекту. → [Сцена 4B]\n\t");
                    System.out.print("Ваш выбор: ");
                    choice = scanner.nextInt();

                    while (choice < 1 || choice > 2) {
                        System.out.print("Выберите из доступных опций \n");
                        System.out.print("Ваш выбор: ");
                        choice = scanner.nextInt();
                    }
                    if (choice == 1) {
                        System.out.println("Ты активируешь самоуничтожение. Озеро начинает светиться. Тьма уходит. " +
                            "Ты спас мир… но погиб.\n");
                        System.out.println("Концовка : Герой \nРезультат: Спас мир, но погиб");
                    } else {
                        System.out.println("Ты входишь в проект. Тебе дают новое имя. Ты становишься частью того, " +
                            "что раньше преследовало тебя.\n");
                        System.out.println("Концовка : Тайный участник \nРезультат: Стал частью эксперимента");
                    }
                }
            }
        }
    }
}