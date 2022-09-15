public class Singleton2 {
    //1. 内部创建对象
    private static Singleton2 instance = null;

    //2. 其他属性
    private int id;
    private String str;

    //3. 私有化构造器
    private Singleton2() {
        id = 1;
        str = "number1";
    }

    //4. 公共方法返回对象实例
    public static Singleton2 getInstance() {
        if (instance == null) {
            instance = new Singleton2();
        }
        return instance;
    }
    
}