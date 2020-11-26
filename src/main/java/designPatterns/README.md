# 设计模式

## 设计模式六大原则
参考：https://blog.csdn.net/benbenxiongyuan/category_2180695.html
### 单一职责原则（SRP）
> There should never be more than one reason for a class to change
1. 实现类要职责单一
2. 理解
    - 单一职责原则有利于对象的稳定，对象的职责越少，对象之间的依赖关系就越少，耦合度减弱，受其他对象的约束与牵制就越少，从而保证了系统的可扩展性
    - 并不是极端地要求我们只能为对象定义一个职责，而是利用极端的表述方式重点强调，在定义对象职责时，必须考虑职责与对象之间的所属关系
    - 单一职责适用于接口、类、同时也适用于方法，方法的粒度不宜过粗。
### 里氏替代原则（LSP）
> Functions that use pointers or references to base classes must be able to use objects of derived classes without knowing it.
1. 不要破坏继承体系
2. 里氏替代原则(Liskov Substitution Principle, LSP)
    - 所有父类能出现的地方，子类就可以出现，并且替换为子类也不会产生任何错误或异常
    - 子列可以扩展父类的功能，但不能改变父类原有的功能
    - 子类可以实现父类的抽象方法，但不能覆盖父类的非抽象方法
    - 子类可以有自己的方法和属性
    - 覆盖或实现父类的方法时输入参数可以被放大
    - 覆盖或实现父类的方法时输出结果可以被缩小

### 依赖倒置原则
1. 面向接口编程
### 接口隔离原则
1. 设计接口时要精简单一
### 迪米特法则
1. 降低耦合
### 开闭原则（OCP）
> Software entities like classes, modules and functions should be open for extension but closed for modifications.（对扩展开放，对修改关闭）
2. 软件实体应该通过扩展来实现变化，而不是通过修改已有的代码来实现变化
    - 软件实体包括
        - 项目或软件产品中按照一定的逻辑规则划分的模块
        - 抽象和类
        - 方法 
3. 修改
    - 对抽象定义的修改，如对象公开的接口，包括方法的名称、参数与返回类型
        - 保证一个接口，尤其要保证被其他对象调用的接口的稳定 
        - 要保证接口的稳定，就应该对对象进行合理的封装
    - 对具体实现的修改
        - 避免对源代码的修改，即使仅修改具体实现
        - 修改具体实现，可能会给调用者带来意想不到的结果
4. 扩展
    - 对扩展开放的关键是“抽象”，而对象的**多态**则保证了这种扩展的开放性。 
5. 开放利用了对象的抽象，封闭则在一定程度上利用了封装。