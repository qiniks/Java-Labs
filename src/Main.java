import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

interface MathOperation {
    int operate(int a, int b);
}
public class Main {
    public static void main(String[] args) {
        MathOperation addition = (a, b) -> a + b;
        MathOperation subtraction = (a, b) -> a - b;
        MathOperation multiplication = (a, b) -> a * b;
        MathOperation division = (a, b) -> a / b;

        System.out.println("Addition: " + addition.operate(5, 5));
        System.out.println("Subtraction: " + subtraction.operate(7, 3));
        System.out.println("Multiplication: " + multiplication.operate(7, 3));
        System.out.println("Division: " + division.operate(6, 2));

        List<Integer> numbers = Arrays.asList(2,3,4,5,1,-110, -11, 15, 22, 33, 40, 55);

        Predicate<Integer> isOdd = number -> number % 2 != 0;

        TreeSet<Integer> oddNumbers = new TreeSet<>();

        for (int number : numbers) {
            if (isOdd.test(number)) {
                oddNumbers.add(number);
            }
        }

        System.out.println("Odd Numbers: " + oddNumbers);

        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David", "Eve", "Frank", "George", "Hannah", "Ivan", "John", "Kevin", "Linda");
        names.sort((name1, name2) -> name2.compareTo(name1));

        System.out.println("Names in reverse order: " + names);


        List<String> words = Arrays.asList("hello", "java", "lambda");
        Function<String, String> transformString = str -> new StringBuilder(str.toUpperCase()).reverse().toString();

        System.out.print("Transformed words: ");
        words.forEach(word -> System.out.print(transformString.apply(word) + " "));

        System.out.println();


        List<String> cities = Arrays.asList("New York", "London", "Tokyo", "Berlin");
        Consumer<String> printCity = city -> System.out.println(city);
        Consumer<String> printCityRef = System.out::println;


        cities.forEach(printCity);
        cities.forEach(printCityRef);

        BiFunction<Integer, Integer, Integer> max = (a, b) -> {
            if (a > b) return a; else return b;};
        System.out.println("Max: " + max.apply(40,2));
        BiFunction<Integer, Integer, Integer> min = (a, b) -> {
            if (a < b) return a; else return b;};
        System.out.println("Min: " + min.apply(40,2));

    }
}




