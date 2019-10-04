package jvm;

/**
 * @author dinghy
 * @date 2019/10/4 15:25
 * <p>
 *    双亲委派机制
 *当一个类收到了类加载请求，他首先不会尝试自己去加载这个类，而是把这个请求委派给父类去完成，每一个层次类加载器都是如*此，因此所有的加载请求都应该传送到启动类加载其中，只有当父类加载器反馈自己无法完成这个请求的时候（在它的加载路径下*没有找到所需加载的Class），子类加载器才会尝试自己去加载。
 *
 *采用双亲委派的一个好处是比如加载位于 rt.jar 包中的类 java.lang.Object，不管是哪个加载器加载这个类，最终都是委托给*顶层的启动类加载器进行加载，这样就保证了使用不同的类加载器最终得到的都是同样一个 Object对象。
 * </p>
 */
//public class String {
//    public static void main(String[] args) {
//        // 程序会先从BootstrapClassLoader里边查找,再从ExtensionClassLoader查找,再从AppClassLoader
//        System.out.println("aaaaaa");
//    }
//}
