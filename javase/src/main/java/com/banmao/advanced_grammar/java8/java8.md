### java8基础应用
> 5大部分
+ Lambda表达式
+ 函数式接口（Functional）
+ 方法引用与构造器引用
+ 强大大Stream API
+ Optional类

#### Lambda表达式
核心原理：类型推断

举例：
```
List<String> strList = new ArrayList<>();
int[] intArr = new int[]{1,2,3}; => int[] intArr = {1,2,3};
```
本质：作为函数式接口的实例（也就是说，lambda表达式的使用依赖于函数式接口）
细节：如果右边只有一条语句，且是return语句，则可以省略{}与return关键字


#### 函数式接口
要求：必须只有一个方法
会有注解声明：@FunctionalInterface
@FunctionalInterface（此注解只是一个标记注解，可以用作校验）
java.util.function包下定义了java8丰富的函数式接口
java8提供的四大函数式接口：
（1）Consumer<T> 消费型接口 参数类型：T，返回类型：void 包含方法：void accept(T t)
（1）Supplier<T> 供给型接口 参数类型 无，返回类型：T 包含方法：T get()
（1）Function<T,R> 函数型接口 参数类型 T，返回类型：R 包含方法：R apply(T t)
（1）Predicate<T> 断定型接口 参数类型 T，返回类型：boolean 包含方法：boolean test(T t)


### 方法引用和构造器引用


### 强大的Stream API
操作三个步骤：
（1）创建Stream：一个数据源（集合、数组），获取一个流
（2）中间操作：操作链，可以对数据进行处理
（3）终止操作：不执行终止操作，则中间操作不会被执行

#### Stream的中间操作：
过滤(filter)、映射(map)、排序(sorted)、归并(reduce)、查找与匹配(findAny)、collect

### 静态、动态代理
静态代理举例：
```
class MyThread implements Runnable{} // 相当于被代理类
class Thread implements Runnable{} // 相当于代理类

main() {
    MyThread t = new MyThread();
    Thread thread = new Thread(t);
    thread.start(); // 启动线程，调用线程的run()
}
```

静态代理缺点：
（1）代理类与被代理类都是在编译阶段就确定下来，不利于程序的扩展
（2）每一个代理类只能为一个接口服务，这样一来程序开发中必然产生过多的代理

动态代理的理解：
动态代理是指客户通过代理类来调用其它对象的方法，并且是在程序运行时根据需要动态创建目标类的代理对象

使用场景：
（1）调试
（2）远程方法调用

动态代理相比与静态代理的优点：
抽象角色中（接口）声明的所有方法都被转移到调用处理器一个集中的方法中处理，这样，我们可以
更加灵活和统一的处理更多的方法

动态代理的缺点：
