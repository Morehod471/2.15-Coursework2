import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static java.util.Map.Entry.comparingByValue;

public class Main {
    public static void main(String[] args) {

        System.out.println("Input: your app the quick brown fox jumps over the lazy dog");
        String input = "your app the quick brown fox jumps over the lazy dog";
        System.out.println(" Слова отсортированы по алфавиту и по количеству упоминаний.");
        String[] words = input.split("\\W+");
        long count = Arrays.stream(words).map(String::toLowerCase)
                .filter(Predicate.not(String::isBlank))
                .count();
        System.out.println("В тексте " + count + " слов");
        System.out.println("TOP 10");
        Arrays.stream(words)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream().sorted(comparingByValue(Comparator.reverseOrder()))
                .limit(10)
                .forEach(System.out::println);
    }
}

