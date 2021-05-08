import org.json.JSONObject;

import java.math.BigDecimal;
import java.util.Optional;

/**
 * @author dinghy
 * @date 2021/5/7 09:34
 */
public class Test {
    public static void main(String[] args) {
        BigDecimal bigDecimal = new BigDecimal("0.00");
        BigDecimal bigDecimal1 =null;
        BigDecimal bigDecimal2 =null;
        bigDecimal1=Optional.ofNullable(bigDecimal1).orElse(bigDecimal);
        bigDecimal2=Optional.ofNullable(bigDecimal2).orElse(bigDecimal);
        System.out.println(bigDecimal1);
        System.out.println(bigDecimal2);
        System.out.println(bigDecimal1==bigDecimal2);
    }
}
