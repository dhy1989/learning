package stream;

import java.util.Arrays;
import java.util.List;
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

        String[] string ={"Hello","World"};
        List<String> strings = Arrays.asList(string);
        //map之后的["H","e","l","l","o"] ["W","o","r","l","d"]
        List<String> collect = strings.stream().map(str -> str.split("")).flatMap(str -> Arrays.stream(str)).collect(Collectors.toList());
        System.out.println(collect);
         strings.stream().map(str -> str.split("")).forEach(x-> System.out.println(Arrays.asList(x)));
    }
}
