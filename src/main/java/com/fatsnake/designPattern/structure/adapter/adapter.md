# 适配器类型
### 类适配器
- 类适配器使用继承关系来实现
```java
// 类适配器: 基于继承
public interface ITarget { 
    void f1(); 
    void f2(); 
    void fc();
}

public class Adaptee { 
    public void fa() { 
    //... 
    } 
    public void fb() { 
    //... 
    } 
    public void fc() { 
    //... 
    }
}
public class Adaptor extends Adaptee implements ITarget {
    public void f1() { 
        super.fa();
    } 
    public void f2() { 
        //...重新实现f2()... 
    } 
    // 这里fc()不需要实现，直接继承自Adaptee，这是跟对象适配器最大的不同点
}
```
### 对象适配器
- 对象适配器使用组合关系来实现
```java
// 对象适配器：基于组合
public interface ITarget { 
    void f1(); 
    void f2(); 
    void fc();
}
public class Adaptee { 
    public void fa() { 
        //... 
    } 
    public void fb() { 
        //... 
    } public void fc() { 
        //... 
    }
}
public class Adaptor implements ITarget {
    private Adaptee adaptee;
    public Adaptor(Adaptee adaptee) { 
        this.adaptee = adaptee; 
    } 
    public void f1() { 
        adaptee.fa(); //委托给Adaptee 
    } 
    public void f2() { 
        //...重新实现f2()...
    } 
    public void fc() { 
        adaptee.fc(); 
    }
}
```
### 说明
- 如果 Adaptee 接口并不多，那两种实现方式都可以。
- 如果 Adaptee 接口很多，而且 Adaptee 和 ITarget 接口定义大部分都相同，那我们推荐使用
类适配器，因为 Adaptor 复用父类 Adaptee 的接口，比起对象适配器的实现方式，Adaptor 的代码量要少一些。
- 如果 Adaptee 接口很多，而且 Adaptee 和 ITarget 接口定义大部分都不相同，那我们推荐使用对象适配器，因为组合结构相对于继承更加灵活。


