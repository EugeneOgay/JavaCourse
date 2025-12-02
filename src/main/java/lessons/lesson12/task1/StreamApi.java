package main.java.lessons.lesson12.task1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamApi {
    public void EvenAndSquaresSteamApi() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        numbers.stream().filter(s -> s % 2 == 0).forEach(s -> System.out.printf("Число: %d, его квадрат %d \n", s, s * s));
    }

    public void EvenAndSquaresFor() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        for(int number : numbers) {
            if(number % 2 ==0 ) {
                System.out.printf("Число: %d, его квадрат %d \n", number, number * number);
            }
        }
    }

    public void LengthGreaterThanFiveStreamApi() {
        List<String> words = List.of("apple", "banana", "pear", "pineapple");
        System.out.println("Слова длиннее 5 символов: ");
        words.stream().filter(s -> s.length() > 5).forEach(s -> System.out.printf("%s ", s));
    }

    public void LengthGreaterThanFiveFor() {
        List<String> words = List.of("apple", "banana", "pear", "pineapple");
        System.out.println("Слова длиннее 5 символов: ");
        for(String word : words) {
            if(word.length() > 5) {
                System.out.printf("%s ", word);
            }
        }
    }
    public void MaxAndMinSteamApi() {
        List<Integer> nums = List.of(10, 2, 33, 4, 25);
        var max = nums.stream().max(Integer::compare);
        var min = nums.stream().min(Integer::compare);
        System.out.printf("Максимальное число: %d, минимальное число: %%d", max.get(), min. get());
    }

    public void MaxAndMinFor() {
        List<Integer> nums = List.of(10, 2, 33, 4, 25);
        int min = nums.getFirst();
        int max = 0;
        for(int number : nums ){
            if(number < min) {
                min = number;
            }
            if(number > max){
                max = number;
            }
        }
        System.out.printf("Максимальное число: %d, минимальное число: %%d", max, min);
    }

    public void MidLengthSteamApi() {
        List<String> names = List.of("Alice", "Bob", "Charlie", "David");
        int length = names.stream().mapToInt(String::length).sum();
        System.out.printf("Средняя длина строк в списке: %d", length/names.size());
    }

    public void MidLengthFor() {
        List<String> names = List.of("Alice", "Bob", "Charlie", "David");
        int length = 0;
        for(String name : names){
            length = length + name.length();
        }
        System.out.printf("Средняя длина строк в списке: %d", length/names.size());
    }

    public void DeleteDuplicatesAndSortSteamApi() {
        List<String> input = List.of("apple", "pear", "apple", "banana", "pear");
        System.out.print("Отсортированный список с уникальными значениями: ");
        input.stream().distinct().sorted().forEach(s -> System.out.printf("%s ", s));
    }

    public void DeleteDuplicatesAndSortFor() {
        List<String> input = List.of("apple", "pear", "apple", "banana", "pear");
        List<String> distinctList = new ArrayList<>();
        for(String fruit : input) {
            if(!distinctList.contains(fruit)) {
                distinctList.add(fruit);
            }
        }
        List<String> sortedList = new ArrayList<>();
        for (int i = 0; i < input.size() - 1; i++) {
            for (int j = 0; j < input.size() - 1 - i; j++) {
                if (input.get(j).length() > input.get(j + 1).length()) {
                    String tmp = input.get(j);
                    input.set(j, input.get(j + 1));
                    input.set(j + 1, tmp);
                }
            }
        }
        System.out.print("Отсортированный список с уникальными значениями: ");
        input.stream().distinct().sorted().forEach(s -> System.out.printf("%s ", s));
    }

}
