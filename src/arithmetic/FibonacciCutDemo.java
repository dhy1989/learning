package arithmetic;

/**
 * @author dinghy
 * @description 斐波切纳数列:0,1,1,2,3,5,8....
 * @date 2021/3/26 9:27
 */
public class FibonacciCutDemo {
    /**
     * @description 时间复杂度为2^n
     * @author dinghy
     * @date 2021/3/26 14:44 
     */ 
    public static int fib(int n) {
        if (n <= 1) {
            return n;
        }
        return fib(n - 1) + fib(n - 2);
    }
    /**
     * @description 复杂度n
     * @author dinghy
     * @date 2021/3/26 14:45
     */
    public static int fib2(int n) {
        if(n<=1){
            return n;
        }
        int first = 0;
        int second = 1;
        for (int i = 0; i < n - 1; i++) {
            int sum=first+second;
            first=second;
            second=sum;
        }
        return second;
    }

    public static void main(String[] args) {
        final int num=3;
        new Thread(()->{
            System.out.println(Thread.currentThread().getName()+"开始");
            long start= System.currentTimeMillis();
            System.out.println(fib(num));
            long end = System.currentTimeMillis();
            System.out.println(Thread.currentThread().getName()+"结束--------"+(end-start));
        },"fib").start();
        new Thread(()->{
            System.out.println(Thread.currentThread().getName()+"开始");
            long start= System.currentTimeMillis();
            System.out.println(fib2(num));
            long end = System.currentTimeMillis();
            System.out.println(Thread.currentThread().getName()+"结束--------"+(end-start));

        },"fib2").start();
    }
}
