package stream;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalInt;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author dinghy
 * @date 2020/4/12 11:05
 */
public class StreamTest {
    @Test
    public  void test() {
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

    /**
     * @description 找到满足条件跳出循环
     * @author dinghy
     * @date 2021/4/17 15:27
     */
    @Test
    public void testForEach(){
        int[] array={1,2,3,4,5,6,7};
        OptionalInt any = Arrays.stream(array).filter(x->x>5).findFirst();
        System.out.println(any.getAsInt());
    }


}
