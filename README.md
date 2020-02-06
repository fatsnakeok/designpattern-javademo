# 设计模式

## /designPattern/Singleton： 单例模式
1. 单例的定义单例设计模式（Singleton Design Pattern）理解起来非常简单。一个类只允许创建一个对象（或者叫实例），那这个类就是一个单例类，
这种设计模式就叫作单例设计模式，简称单例模式。
2. 单例的用处从业务概念上，有些数据在系统中只应该保存一份，就比较适合设计为单例类。比如，系统的配置信息类。除此之外，
我们还可以使用单例解决资源访问冲突的问题。
3. 单例的实现单例有下面几种经典的实现方式。
- IdGenerator1.java   饿汉式
- IdGenerator2.java   懒汉式
- IdGenerator3.java   双重检测
- IdGenerator4.java   静态内部类
- IdGenerator5.java   枚举