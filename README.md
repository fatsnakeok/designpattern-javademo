# 一、创建型设计模式
主要解决“对象的创建”问题
## /created/Singleton： 单例模式
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
***

## created/factory: 工厂模式
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
***

## created/builder: 建造者模式
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

## created/prototype: 原型模式
### 1. 什么是原型模式？
如果对象的创建成本比较大，而同一个类的不同对象之间差别不大（大部分字段都相同），在这种情况下，我们可以利用对已有对象（原型）进行复制（或
者叫拷贝）的方式，来创建新对象，以达到节省创建时间的目的。这种基于原型来创建对象的方式就叫作原型设计模式，简称原型模式。

### 2. 原型模式的两种实现方法
原型模式有两种实现方法，深拷贝和浅拷贝。
- 浅拷贝：
浅拷贝只会复制对象中基本数据类型数据和引用对象的内存地址，不会递归地复制引用对象，以及引用对象的引用对象……

- 深拷贝：
深拷贝得到的是一份完完全全独立的对象。所以，深拷贝比起浅拷贝来说，更加耗时，更加耗内存空间。

* 建议
如果要拷贝的对象是不可变对象，浅拷贝共享不可变对象是没问题的，但对于可变对象来说，浅拷贝得到的对象和原始对象会共享部分数据，就有可能出现
数据被修改的风险，也就变得复杂多了。除非像我们今天实战中举的那个例子，需要从数据库中加载 10 万条数据并构建散列表索引，操作非常耗时，比较
推荐使用浅拷贝，否则，没有充分的理由，不要为了一点点的性能提升而使用浅拷贝。
***

## 创建型总结
- 单例模式用来创建全局唯一的对象。
- 工厂模式用来创建不同但是相关类型的对象（继承同一父类或者接口的一组子类），由给定的参数来决定创建哪种类型的对象。
- 建造者模式是用来创建复杂对象，可以通过设置不同的可选参数，“定制化”地创建不同的对象。
- 原型模式针对创建成本比较大的对象，利用对已有对象进行复制的方式进行创建，以达到节省创建时间的目的。
***

# 二、结构型设计模式
主要解决“类或对象的组合或组装”问题
## structure/proxy 代理模式（Proxy Design Pattern）
- 它在不改变原始类（或叫被代理类）代码的情况下，通过引入代理类来给原始类附加功能。
 ### 1.静态代理
 #### 接口实现
 一般情况下，我们让代理类和原始类实现同样的接口。
 #### 继承实现
 如果原始类并没有定义接口，并且原始类代码并不是我们开发维护的。在这种情况下，我们可以通过让代理类继承原始类的方法来实现代理模式。
 
 ### 2.动态代理
 ### 动态代理的原理与实现
- 静态代理需要针对每个类都创建一个代理类，并且每个代理类中的代码都有点像模板式的“重复”代码，增加了维护成本和开发成本。对于静态代理存在的
  问题，我们可以通过动态代理来解决。我们不事先为每个原始类编写代理类，而是在运行的时候动态地创建原始类对应的代理类，然后在系统中用代理类
  替换掉原始类。

有关动态代理，请参考：

[Java 动态代理(Dynamic proxy) 小结](https://segmentfault.com/a/1190000007089902)

[java动态代理详解](https://blog.csdn.net/qq_32532321/article/details/81874990)

[你真的完全了解Java动态代理吗？看这篇就够了](https://www.jianshu.com/p/95970b089360)

### 代理模式的应用场景
代理模式常用在业务系统中开发一些非功能性需求，比如：监控、统计、鉴权、限流、事务、幂等、日志。我们将这些附加功能与业务
功能解耦，放到代理类统一处理，让程序员只需要关注业务方面的开发。除此之外，代理模式还可以用在 RPC、缓存等应用场景中。
***

## structure/bridge 桥接模式（Bridge Design Pattern）
### 遵循的设计原则
* 组合优于继承

### 桥接模式定义
#### 将抽象和实现解耦，让它们可以独立变化。（摘自GoF 的《设计模式》）
- 对于第一种 GoF 的理解方式，弄懂定义中“抽象”和“实现”两个概念，是理解它的关键。
抽象：指的并非“抽象类”或“接口”，而是被抽象出来的一套“类库”，它只包含骨架代码，真正的业务逻辑需要委派给定义中的“实现”来完成。
实现：并非“接口的实现类”，而是的一套独立的“类库”。“抽象”和“实现”独立开发，通过对象之间的组合关系，组装在一起。

#### 另一种解释：一个类存在两个（或多个）独立变化的维度，我们通过组合的方式，让这两个（或多个）维度可以独立进行扩展。
- “组合优于继承”设计原则，通过组合关系来替代继承关系，避免继承层次的指数级爆炸。
***

## structure/decorator 装饰器模式（decorator Design Pattern） 
装饰器模式主要解决继承关系过于复杂的问题，通过组合来替代继承。
- 它主要的作用是给原始类添加增强功能。这也是判断是否该用装饰器模式的一个重要的依据。
- 除此之外，装饰器模式还有一个特点，那就是可以对原始类嵌套使用多个装饰器。
- 为了满足这个应用场景，在设计的时候，装饰器类需要跟原始类，继承相同的抽象类或者接口。
***

## structure/adapter 适配器模式（adapter Design Pattern） 
用来做适配的，它将不兼容的接口转换为可兼容的接口，让原本由于接口不兼容而不能一起工作的类可以一起工作。对于这个模式，有一个经常被拿来解释
它的例子，就是 USB 转接头充当适配器，把两种不兼容的接口，通过转接变得可以一起工作。
### 类适配器
- 类适配器使用继承关系来实现
### 对象适配器
- 对象适配器使用组合关系来实现

### 应用场景
一般来说，适配器模式可以看作一种“补偿模式”，用来补救设计上的缺陷。应用这种模式算是“无奈之举”，如果在设计初期，我们就能协调规避接口不兼容
的问题，那这种模式就没有应用的机会了。那在实际的开发中，什么情况下才会出现接口不兼容呢？我总结下了下面这样 5 种场景：
- 封装有缺陷的接口设计
- 统一多个类的接口设计
- 替换依赖的外部系统
- 兼容老版本接口
- 适配不同格式的数据

***
## 代理、桥接、装饰器、适配器 4 种设计模式的区别
代理、桥接、装饰器、适配器，这 4 种模式是比较常用的结构型设计模式。它们的代码结构非常相似。
笼统来说，它们都可以称为 Wrapper 模式，也就是通过 Wrapper 类二次封装原始类。

尽管代码结构相似，但这 4 种设计模式的用意完全不同，也就是
说要解决的问题、应用场景不同，这也是它们的主要区别。这里我就简单说一下它们之间的区别。

- 代理模式：代理模式在不改变原始类接口的条件下，为原始类定义一个代理类，主要目的是控制访问，而非加强功能，这是它跟装饰器模式最大的不同。
- 桥接模式：桥接模式的目的是将接口部分和实现部分分离，从而让它们可以较为容易、也相对独立地加以改变。
- 装饰器模式：装饰者模式在不改变原始类接口的情况下，对原始类功能进行增强，并且支持多个装饰器的嵌套使用。
- 适配器模式：适配器模式是一种事后的补救策略。适配器提供跟原始类不同的接口，而代理模式、装饰器模式提供的都是跟原始类相同的接口。

## structure/facade 门面模式（facade Design Pattern）
门面模式，也叫外观模式
### 定义
门面模式为子系统提供一组统一的接口，定义一组高层接口让子系统更易用。

接口粒度设计得太大，太小都不好。太大会导致接口不可复用，太小会导致接口不易用。在实际的开发中，接口的可复用性和易用性需要“微妙”的权衡。针
对这个问题，我的一个基本的处理原则是，尽量保持接口的可复用性，但针对特殊情况，允许提供冗余的门面接口，来提供更易用的接口

### 应用场景
#### 1. 解决易用性问题
- 门面模式可以用来封装系统的底层实现，隐藏系统的复杂性，提供一组更加简单易用、更高层的接口。比如，Linux 系统调用函数就可
以看作一种“门面”。它是 Linux 操作系统暴露给开发者的一组“特殊”的编程接口，它封装了底层更基础的 Linux 内核调用。再比如，Linux 的 Shell 
命令，实际上也可以看作一种门面模式的应用。它继续封装系统调用，提供更加友好、简单的命令，让我们可以直接通过执行命令来跟操作系统交互。
- 我们前面也多次讲过，设计原则、思想、模式很多都是相通的，是同一个道理不同角度的表述。实际上，从隐藏实现复杂性，提供更易用接口这个意图来看，门
面模式有点类似之前讲到的迪米特法则（最少知识原则）和接口隔离原则：两个有交互的系统，只暴露有限的必要的接口。除此之外，门面模式还有点类似
之前提到封装、抽象的设计思想，提供更抽象的接口，封装底层实现细节。

#### 2.解决性能问题
- 关于利用门面模式解决性能问题这一点，刚刚我们已经讲过了。我们通过将多个接口调用替换为一个门面接口调用，减少网络通信成本，提高 App 客户
端的响应速度。所以，关于这点，我就不再举例说明了。我们来讨论一下这样一个问题：从代码实现的角度来看，该如何组织门面接口和非门面接口？

- 如果门面接口不多，我们完全可以将它跟非门面接口放到一块，也不需要特殊标记，当作普通接口来用即可。如果门面接口很多，我们可以在已有的接口
之上，再重新抽象出一层，专门放置门面接口，从类、包的命名上跟原来的接口层做区分。如果门面接口特别多，并且很多都是跨多个子系统的，我们可以
将门面接口放到一个新的子系统中。


##### 3.解决分布式事务问题
栗子：
- 在一个金融系统中，有两个业务领域模型，用户和钱包。这两个业务领域模型都对外暴露了一系列接口，比如用户的增删改查接口、钱包的增删改查接口。
假设有这样一个业务场景：在用户注册的时候，我们不仅会创建用户（在数据库 User 表中），还会给用户创建一个钱包（在数据库的 Wallet 表中）。

- 对于这样一个简单的业务需求，我们可以通过依次调用用户的创建接口和钱包的创建接口来完成。但是，用户注册需要支持事务，也就是说，创建用户和
钱包的两个操作，要么都成功，要么都失败，不能一个成功、一个失败。

- 要支持两个接口调用在一个事务中执行，是比较难实现的，这涉及分布式事务问题。虽然我们可以通过引入分布式事务框架或者事后补偿的机制来解决，
但代码实现都比较复杂。而最简单的解决方案是，利用数据库事务或者 Spring 框架提供的事务（如果是 Java 语言的话），在一个事务中，执行创建用
户和创建钱包这两个 SQL 操作。这就要求两个 SQL 操作要在一个接口中完成，所以，我们可以借鉴门面模式的思想，再设计一个包裹这两个操作的新接
口，让新接口在一个事务中执行两个 SQL 操作。

***
## structure/composite 组合模式（composite Design Pattern）
与其说是一种设计模式，倒不如说是对业务场景的一种数据结构和算法的抽象。其中，数据可以表示成树这种数据结构，业务需求可以通过在树上的递归遍
历算法来实现。
### 定义
组合模式，将一组对象组织成树形结构，将单个对象和组合对象都看做树中的节点，以统一处理逻辑，并且它利用树形结构的特点，递归地处理每个子树，
依次简化代码实现。

### 应用场景
使用组合模式的前提在于，你的业务场景必须能够表示成树形结构。所以，组合模式的应用场景也比较局限，它并不是一种很常用的设计模式。

***
## structure/flyweight 享元模式（flyweight Design Pattern）
### 定义
享元： 共享的单元。享元模式的意图是复用对象，节省内存，前提是享元对象是不可变对象。
具体来讲，当一个系统中存在大量重复对象的时候，如果这些重复的对象是不可变对象，我们就可以利用享元模式将对象设计成享元，在内存中只保留一份
实例，供多处代码引用。这样可以减少内存中对象的数量，起到节省内存的目的。实际上，不仅仅相同对象可以设计成享元，对于相似对象，我们也可以将
这些对象中相同的部分（字段）提取出来，设计成享元，让这些大量相似对象引用这些享元。

### 不可变对象
一旦通过构造函数初始化完成之后，它的状态（对象的成员变量或者属性）就不会再被修改了。所以，不可变对象不能暴露任何 set() 等修改内部状态的
方法。之所以要求享元是不可变对象，那是因为它会被多处代码共享使用，避免一处代码对享元进行了修改，影响到其他使用它的代码。

#### 与单例、缓存、对象池 区别
区别两种设计模式，不能光看代码实现，而是要看设计意图，也就是要解决的问题。

### 享元模式 vs 单例
- 在单例模式中，一个类只能创建一个对象，而在享元模式中，一个类可以创建多个对象，每个对象被多处代码引用共享。实际上，享元模式有点类似于之
前讲到的单例的变体：多例。
- 尽管从代码实现上来看，享元模式和多例有很多相似之处，但从设计意图上来看，它们是完全不同的。应用享元模式是为了对象复用，节省内存，而应用多
例模式是为了限制对象的个数。

### 享元模式 vs 缓存
在享元模式的实现中，我们通过工厂类来“缓存”已经创建好的对象。这里的“缓存”实际上是“存储”的意思，跟我们平时所说的“数据库缓存”“CPU 缓存”
“MemCache 缓存”是两回事。我们平时所讲的缓存，主要是为了提高访问效率，而非复用。

### 享元模式 vs 对象池
#### 1.对象池
像 C++ 这样的编程语言，内存的管理是由程序员负责的。为了避免频繁地进行对象创建和释放导致内存碎片，我们可以预先申请一片连续的内存空间，也
就是这里说的对象池。每次创建对象时，我们从对象池中直接取出一个空闲对象来使用，对象使用完成之后，再放回到对象池中以供后续复用，而非直接释
放掉。

#### 2.对'复用'的理解
虽然对象池、连接池、线程池、享元模式都是为了复用，但是，“复用”这个字眼的话，对象池、连接池、线程池等池化技术中的“复用”和享元模式中的
“复用”实际上是不同的概念。

#### 3.池化技术中的“复用”
可以理解为“重复使用”，主要目的是节省时间（比如从数据库池中取一个连接，不需要重新创建）。在任意时刻，每一个对象、连接、线程，并不会被多处
使用，而是被一个使用者独占，当使用完成之后，放回到池中，再由其他使用者重复利用。

#### 4.享元模式中的“复用”
可以理解为“共享使用”，在整个生命周期中，都是被所有使用者共享的，主要目的是节省空间。

### 享元模式注意事项--勿过度使用
实际上，享元模式对 JVM 的垃圾回收并不友好。因为享元工厂类一直保存了对享元对象的引用，这就导致享元对象在没有任何代码使用的情况下，也并不
会被 JVM 垃圾回收机制自动回收掉。因此，在某些情况下，如果对象的生命周期很短，也不会被密集使用，利用享元模式反倒可能会浪费更多的内存。所
以，除非经过线上验证，利用享元模式真的可以大大节省内存，否则，就不要过度使用这个模式，为了一点点内存的节省而引入一个复杂的设计模式，得不
偿失啊。

***
# 三、行为型设计模式
主要解决的就是“类或对象之间的交互”问题。
## behavior/observer 观察者模式（observer Design Pattern）
### 基本概念
- 观察者模式（Observer Design Pattern）也被称为发布订阅模式（Publish-Subscribe Design Pattern）。
- 在对象之间定义一个一对多的依赖，当一个对象状态改变的时候，所有依赖的对象都会自动收到通知。
- 被依赖的对象叫作被观察者（Observable），依赖的对象叫作观察者
Subject-Observer、Publisher-Subscriber、Producer-Consumer、EventEmitter-EventListener、Dispatcher-Listener。不管怎么称呼，
只要应用场景符合刚刚给出的定义，都可以看作观察者模式。

### 各类设计模式用途
设计模式要干的事情就是解耦。
- 创建型模式是将创建和使用代码解耦
- 结构型模式是将不同功能代码解耦
- 行为型模式是将不同的行为代码解耦，具体到观察者模式，它是将观察者和被观察者代码解耦。
- 借助设计模式，我们利用更好的代码结构，将一大坨代码拆分成职责更单一的小类，让其满足开闭原则、
高内聚松耦合等特性，以此来控制和应对代码的复杂性，提高代码的可扩展性。

### 实现一个 google guava EventBus
自造轮子：/designPattern/behavior/observer/eventBus

[google guava EventBus源码](https://github.com/google/guava)


## behavior/templateMethod 模板模式 (Template Method Design Pattern)
### 基本概念
模板方法模式在一个方法中定义一个算法/业务逻辑骨架，并将某些步骤推迟到子类中实现。模板方法模式可以让子类在不改变算法/业务逻辑整体结构的
情况下，重新定义算法中的某些步骤。

在模板模式经典的实现中，模板方法定义为 final，可以避免被子类重写。需要子类重写的方法定义为 abstract，可以强迫子类去实现。不过，在实际项
目开发中，模板模式的实现比较灵活，以上两点都不是必须的。

### 作用一： 复用
模板模式把一个算法中不变的流程抽象到父类的模板方法 templateMethod() 中，将可变的部分 method1()、method2() 留给子类 ContreteClass1
 和 ContreteClass2 来实现。所有的子类都可以复用父类中模板方法定义的流程代码。我们通过两个小例子来更直观地体会一下。


### 作用二：扩展
这里所说的扩展，并不是指代码的扩展性，而是指框架的扩展性，有点类似我们之前讲到的控制反转。基于这个作用，模
板模式常用在框架的开发中，让框架用户可以在不修改框架源码的情况下，定制化框架的功能。通过 Junit TestCase、Java Servlet 两个例子来解释一下。

### 回调
回调可以细分为同步回调和异步回调。
- 从应用场景上来看，同步回调看起来更像模板模式，异步回调看起来更像观察者模式。
- 回调跟模板模式的区别，更多的是在代码实现上，而非应用场景上。
- 回调基于组合关系来实现，模板模式基于继承关系来实现，回调比模板模式更加灵活。

### 模板 vs 回调
#### 从应用场景上来看，同步回调跟模板模式几乎一致。
它们都是在一个大的算法骨架中，自由替换其中的某个步骤，起到代码复用和扩展的目的。
而异步回调跟模板模式有较大差别，更像是观察者模式。

#### 从代码实现上来看，回调和模板模式完全不同。
回调基于组合关系来实现，把一个对象传递给另一个对象，是一种对象之间的关系；
模板模式基于继承关系来实现，子类重写父类的抽象方法，是一种类之间的关系。

组合优于继承，在代码实现上，回调相对于模板模式会更加灵活，主要体现在下面几点。
- 像 Java 这种只支持单继承的语言，基于模板模式编写的子类，已经继承了一个父类，不再具有继承的能力。
- 回调可以使用匿名类来创建回调对象，可以不用事先定义类；而模板模式针对不同的实现都要定义不同的子类
- 如果某个类中定义了多个模板方法，每个方法都有对应的抽象方法，那即便我们只用到其中的一个模板方法，子类也必须实现所有的抽象方法。而回调就
更加灵活，我们只需要往用到的模板方法中注入回调对象即可。

## behavior/strategy 策略模式 （Strategy Design Pattern）
### 定义
定义一族算法类，将每个算法分别封装起来，让它们可以互相替换。策略模式可以使算法的变化独立于使用它们的客户端（这里的客户端代指使用算法的代码）。

工厂模式是解耦对象的创建和使用，观察者模式是解耦观察者和被观察者。策略模式跟两者类似，也能起到解耦的作用，
不过，它解耦的是策略的定义、创建、使用这三部。

- 策略类的定义比较简单，包含一个策略接口和一组实现这个接口的策略类。
- 策略的创建由工厂类来完成，封装策略创建的细节。
- 策略模式包含一组策略可选，客户端代码如何选择使用哪个策略，有两种确定方法：编译时静态确定和运行时动态确定。其中，“运行时动态确定”才是
策略模式最典型的应用场景。

除此之外，我们还可以通过策略模式来移除 if-else 分支判断。实际上，这得益于策略工厂类，更本质上点讲，是借助“查表法”，根据 type 查表替代
根据 type 分支判断。

## behavior/chainOfResponsibility 模板模式 (Chain Of Responsibility Design Pattern)
### 定义
将请求的发送和接收解耦，让多个接收对象都有机会处理这个请求。将这些接收对象串成一条链，并沿着这条链传递这个请求，直到链上的某个接收对象能
够处理它为止。

在职责链模式中，多个处理器（也就是刚刚定义中说的“接收对象”）依次处理同一个请求。一个请求先经过 A 处理器处理，然后再把请求传递给 B 处理器
，B 处理器处理完后再传递给 C 处理器，以此类推，形成一个链条。链条上的每个处理器各自承担各自的处理职责，所以叫作职责链模式。


在 GoF 的定义中，一旦某个处理器能处理这个请求，就不会继续将请求传递给后续的处理器了。当然，在实际的开发中，也存在对这个模式的变体，那就
是请求不会中途终止传递，而是会被所有的处理器都处理一遍。

职责链模式有两种常用的实现。一种是使用链表来存储处理器，另一种是使用数组来存储处理器，后面一种实现方式更加简单。
