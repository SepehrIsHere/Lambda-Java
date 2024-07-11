package question02;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class GroupWordsByLettersB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter words separated by spaces:");
        String input = scanner.nextLine();
        String[] words = input.split("\\s+");

        Map<String, Map<String, Long>> groupedWordsWithCount = Arrays.stream(words)
                .collect(Collectors.groupingBy(word -> {
                    char[] chars = word.toCharArray();
                    Arrays.sort(chars);
                    return new String(chars);
                }, Collectors.groupingBy(word -> word, Collectors.counting())));

        groupedWordsWithCount.forEach((key, value) -> {
            System.out.print(key + " : ");
            value.forEach((word, count) -> System.out.print(word + "(" + word.length() + ") "));
            System.out.println();
        });
    }
}
