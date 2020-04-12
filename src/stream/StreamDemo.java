package stream;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author dinghy
 * @date 2020/4/12 11:05
 */
public class StreamDemo {
    public static void main(String[] args) {
        long count = Arrays.stream(new int[]{1, 2, 3}).count();
        System.out.println(count);

        Stream.of("one", "two", "three", "four")
                .filter(e -> e.length() > 3)
                .peek(e -> System.out.println("Filtered value: " + e))
                .map(String::toUpperCase)
                .peek(e -> System.out.println("Mapped value: " + e))
                .collect(Collectors.toList());
    }
}
