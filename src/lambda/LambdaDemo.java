package lambda;

/**
 * <p>
 *     lambda表达式用法
 * 1.括号:() 箭头:-> 实现:{}(如果没有返回值可以省略)
 * 2.@FunctionalInterface 函数是接口,如果不加也可以,编译器会自动给加上,建议手动加上,方便识别
 *   注意;接口里边只能有一个未实现的接口
 * 3.default
 * 4.static
 *  1.8以后default和default修饰的接口里边的方法可以直接实现,可以添加多个这样的方法
 * </p>
 *
 * @author dinghy
 * @date 2019/10/2 14:08
 */
public class LambdaDemo {
    public static void main(String[] args) {
        // 匿名内部类方式
        Foo foo = new Foo() {
            @Override
            public void sayHello() {
                System.out.println("hello");
            }
        };
        foo.sayHello();

//        Foo fo = () -> System.out.println("world");
//        fo.sayHello();
    }
}

@FunctionalInterface
interface Foo {
    void sayHello();
    default int mul(int x,int y){
        return x*y;
    }
    static int minus(int x,int y){
        return x-y;
    }
}