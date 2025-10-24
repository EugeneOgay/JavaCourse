package main.java.lessons.lesson8;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class UniqueDigits {
    private String userInput;
    private HashSet<Integer> numbers = new HashSet<>();

    public void inputDigits() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите число: ");
        this.userInput = scanner.nextLine();
    }

    private List<Integer> parse() {
        List<Integer> parsedNumbers = new ArrayList<>();
        String[] parts = userInput.split(" ");
        for(String part : parts) {
            parsedNumbers.add(Integer.parseInt(part));
        }
        return parsedNumbers;
    }

    private List<Integer> sortNumbers(List<Integer> parsedNumbers) {
        List<Integer> sortedNumbers = new ArrayList<>();
        for(int number : parsedNumbers) {
            if(!sortedNumbers.contains(number)) sortedNumbers.add(number);
        }
        return sortedNumbers;
    }

    public void displayUniqueNumbers() {
        List<Integer> parsedNumbers =  parse();
        List<Integer> sortedNumbers = sortNumbers(parsedNumbers);
        numbers.addAll(sortedNumbers);

        System.out.print("Уникальные числа: ");
        for (int number : numbers) {
            System.out.printf(number + " ");
        }
    }
}
