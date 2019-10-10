package collection;

/**
 * @author dinghy
 * @date 2019/10/10 11:25
 * System.arraycopy属于浅度复制
 */
public class SystemCoppyArray {
    public static void main(String[] args) {
        User[] from = new User[]{new User("张三"), new User("李四"), new User("王五"), new User("赵六")};
        int length = from.length;
        User[] target = new User[length];
        System.arraycopy(from, 0, target, 0, length);
        System.out.println(from[0] == target[0]);
    }
}

class User {

    private String name;

    public User(String name) {
        this.name = name;
    }
}