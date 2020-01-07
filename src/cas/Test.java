package cas;

import java.util.HashMap;
import java.util.Map;

/**
 * @author dinghy
 * @date 2019/9/27 15:52
 */
public class Test {
    public static void main(String[] args) {
        Boolean a = true;
        Boolean b = true;
        if (a.equals(b)) {
            System.out.println("相等");
        }
        Map<String, String> map = new HashMap<>(16);
        map.put("a", "张三");
        map.put("b", "李四");
        map.forEach((key, value) ->
                System.out.println(key + "------" + value)
        );
        System.out.println("test revert");
    }
}
