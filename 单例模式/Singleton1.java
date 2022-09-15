public class Singleton1 {
    //1. 在内部构建对象
    private static Singleton1 instance = new Singleton1();

    //2. 定义其他属性
    private int id;
    private String num;
    
    //3. 私有化构造器
    private Singleton1() {
        id = 1001;
        num = "此处应为一串数字";
    }

    //4. 通过公共方法返回实例
    public static Singleton1 getInstance() {
        return instance;
    }
}