package jvm;

/**
 * @author dinghy
 * @date 2019/10/4 15:15
 * <p>
 *     类加载器
 *     BootstrapClassLoader C++写的
 *     ExtensionClassLoader 扩展包加载
 *     ApplicationClassLoader 应用程序类加载
 *     用户自定义ClassLoader
 *    加载顺序,自上而下
 *
 *
 * </p>
 */
public class ClassLoadDemo {
    public static void main(String[] args) {
        Object object = new Object();
        // jdk里边的类都是使用的BootstrapClassLoader加载的,获取为null
        System.out.println(object.getClass().getClassLoader());

       // 获取到的是AppClassLoader
        System.out.println(ClassLoadDemo.class.getClassLoader());
        // 获取到的是ExtClassLoader
        System.out.println(ClassLoadDemo.class.getClassLoader().getParent());
        // 获取到的是BootstrapClassLoader,为null
        System.out.println(ClassLoadDemo.class.getClassLoader().getParent().getParent());
    }
}
