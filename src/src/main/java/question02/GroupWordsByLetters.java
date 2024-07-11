package question02;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class GroupWordsByLetters {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter words separated by spaces:");
        String input = scanner.nextLine();
        String[] words = input.split("\\s+");

        Map<String, List<String>> groupedWords = Arrays.stream(words)
                .collect(Collectors.groupingBy(word -> {
                    char[] chars = word.toCharArray();
                    Arrays.sort(chars);
                    return new String(chars);
                }));

        groupedWords.forEach((key, value) -> System.out.println(key + " : " + value));
    }
}
