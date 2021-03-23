package guava;

import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import org.junit.Test;

/**
 * @author dinghy
 * @date 2021/3/22 17:59
 */
public class GuavaTest {
    @Test
    public void testOptional(){
        Integer value1 =  null;
        Integer value2 =  new Integer(10);
        //Optional.fromNullable - allows passed parameter to be null.
        Optional<Integer> a = Optional.fromNullable(value1).or(Optional.of(0));
        boolean present = a.isPresent();
        System.out.println(present);
        Optional<Integer> b = Optional.of(value2);

        System.out.println(a.get()+b.get());;
    }
}
