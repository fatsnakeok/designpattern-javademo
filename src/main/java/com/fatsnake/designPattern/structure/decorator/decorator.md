# 装饰器设计模式
## 与简单组合关系的不同之处
- 装饰器类和原始类继承同样的父类，这样我们可以对原始类“嵌套”多个装饰器类。
- 装饰器类是对功能的增强，这也是装饰器模式应用场景的一个重要特点。

实际上，符合“组合关系”这种代码结构的设计模式有很多，比如之前讲过的代理模式、桥接模式，还有现在的装饰器模式。尽管它们的代码结构很相似，
但是每种设计模式的意图是不同的。就拿比较相似的代理模式和装饰器模式来说吧，代理模式中，代理类附加的是跟原始类无关的功能，而在装饰器模式中，
装饰器类附加的是跟原始类相关的增强功能。
```java

// 代理模式的代码结构(下面的接口也可以替换成抽象类)
public interface IA {
  void f();
}
public class A impelements IA {
  public void f() { //... }
}
public class AProxy impements IA {
  private IA a;
  public AProxy(IA a) {
    this.a = a;
  }
  
  public void f() {
    // 新添加的代理逻辑
    a.f();
    // 新添加的代理逻辑
  }
}

// 装饰器模式的代码结构(下面的接口也可以替换成抽象类)
public interface IA {
  void f();
}
public class A impelements IA {
  public void f() { //... }
}
public class ADecorator impements IA {
  private IA a;
  public ADecorator(IA a) {
    this.a = a;
  }
  
  public void f() {
    // 功能增强代码
    a.f();
    // 功能增强代码
  }
}
```


## 栗子 JDK 中的  
InputStream: 抽象类，定义基础方法
  FileInputStream: 装饰器父类 (重点，精髓所在)
    BufferedInputStream:  装饰器类只需要实现它需要增强的方法就可以了，其他方法继承装饰器父类的默认实现。
    DataInputStream: 装饰器类只需要实现它需要增强的方法就可以了，其他方法继承装饰器父类的默认实现。

## 应用场景
对原有类的功能进行增强