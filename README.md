# 设计模式

## /designPattern/Singleton： 单例模式
1. 单例的定义单例设计模式（Singleton Design Pattern）理解起来非常简单。一个类只允许创建一个对象（或者叫实例），那这个类就是一个单例类，
这种设计模式就叫作单例设计模式，简称单例模式。
2. 单例的用处从业务概念上，有些数据在系统中只应该保存一份，就比较适合设计为单例类。比如，系统的配置信息类。除此之外，
我们还可以使用单例解决资源访问冲突的问题。
3. 单例的实现单例有下面几种经典的实现方式。
- IdGenerator1.java   饿汉式
- IdGenerator2.java   懒汉式
- IdGenerator3.java   双重检测  参考：https://www.cnblogs.com/tangZH/p/10031337.html
- IdGenerator4.java   静态内部类
- IdGenerator5.java   枚举   参考：https://www.cnblogs.com/kaleidoscope/p/9636779.html

4.单例模式三个主要特点：
（1）构造方法私有化；
（2）实例化的变量引用私有化；
（3）获取实例的方法共有。

## designPattern/factory: 工厂模式
当创建逻辑比较复杂，是一个“大工程”的时候，我们就考虑使用工厂模式，封装对象的创建过程，将对象的创建和使用相分离。何为创建逻辑比较复杂呢？
我总结了下面两种情况。
- 第一种情况：类似规则配置解析的例子，代码中存在 if-else 分支判断，动态地根据不同的类型创建不同的对象。针对这种情况，
我们就考虑使用工厂模式，将这一大坨 if-else 创建对象的代码抽离出来，放到工厂类中。

- 第二种情况：尽管我们不需要根据不同的类型创建不同的对象，但是，单个对象本身的创建过程比较复杂，比如前面提到的要组合其他类对象，做各种初
始化操作。在这种情况下，我们也可以考虑使用工厂模式，将对象的创建过程封装到工厂类中

对于第一种情况，当每个对象的创建逻辑都比较简单的时候，我推荐使用简单工厂模式，将多个对象的创建逻辑放到一个工厂类中。当每个对象的创建逻辑
都比较复杂的时候，为了避免设计一个过于庞大的简单工厂类，我推荐使用工厂方法模式，将创建逻辑拆分得更细，每个对象的创建逻辑独立到各自的工厂
类中。同理，对于第二种情况，因为单个对象本身的创建逻辑就比较复杂，所以，我建议使用工厂方法模式。

除了刚刚提到的这几种情况之外，如果创建对象的逻辑并不复杂，那我们就直接通过 new 来创建对象就可以了，不需要使用工厂模式。
上升一个思维层面来看工厂模式，它的作用无外乎下面这四个。这也是判断要不要使用工厂模式的最本质的参考标准。封装变化：创建逻辑有可能变化，封
装成工厂类之后，创建逻辑的变更对调用者透明。代码复用：创建代码抽离到独立的工厂类之后可以复用。隔离复杂性：封装复杂的创建逻辑，调用者无需
了解如何创建对象。控制复杂度：将创建代码抽离出来，让原本的函数或类职责更单一，代码更简洁。

## designPattern/builder: 建造者模式
### 使用场景：
* 1）类的构造函数必填属性很多，通过set设置，没有办法校验必填属性
* 2）如果类的属性之间有一定的依赖关系，构造函数配合set方式，无法进行依赖关系和约束条件校验
* 3）需要创建不可变对象，不能暴露set方法。
（前提是需要传递很多的属性，如果属性很少，可以不需要建造者模式）
### 实现方式：
把构造函数定义为private，定义public static class Builder 内部类，通过Builder 类的set方法设置属性，调用build方法创建对象。

### 和工厂模式的区别：
* 1）工厂模式：创建不同的同一类型对象（集成同一个父类或是接口的一组子类），由给定的参数来创建哪种类型的对象；
* 2）建造者模式：创建一种类型的复杂对象，通过很多可设置参数，“定制化”的创建对象
