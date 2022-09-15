## 单例模式

- 饿汉模式
- 懒汉模式

### 声明对象为静态变量
使用 static 将内部对象声明为**静态变量**，以保证单例模式生效。
### 饿汉模式

在声明对象时直接创建对象。
```java
private static Singleton1 instance = new Singleton1();
/*
...
...
*/
public static Singleton1 getInstance() {
    return instance;
}
```

### 懒汉模式

在外部调用时才判断是是否需要创建对象。
```java
private static Singleton2 instance = null;
/*
...
...
*/
public static Singleton2 getInstance() {
    if (instance == null) {
      instance = new Singleton2();
    }
    return instance;
}
```
