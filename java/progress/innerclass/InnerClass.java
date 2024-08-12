package progress.innerclass;

/**
 * 关于内部类
 * @auther NixAutumna
 */
public class InnerClass {
    public static void main(String[] args) {
        /*
        一个类的内部又完整的嵌套了另一个类结构。被嵌套的类称为内部类(inner class)
        嵌套其他类的类称为外部类(outer class)。是我们类的第五大成员(属性、方法、
        构造器、代码块、内部类）内部类最大的特点就是可以直接访问私有属性，并且可以体
        现类与类之间的包含关系
        
        分类：
                                                  /匿名内部类(没有类名)
                 /定义在外部类的局部位置上(如方法内)<-|
                |                                 \局部内部类(有类名)
        内部类 <-|
                |                                 /成员内部类(不用static)
                 \定义在外部类的成员位置上         <-|
                                                  \静态内部类(用static)
         */
        new LocalInnerClass().m();
        new AnonymousInnerClass().m();
    }
}

/**
 * 关于局部内部类
 * @auther NixAutumna
 */
class LocalInnerClass {// 外部类
    private int num = 100;
    private int n = 222;
    public void m2() {
        System.out.println("m2");
    }
    public void m() {// 方法
        /*
        局部内部类是定义在外部类的局部位置，通常在方法
        不能添加访问修饰符，因为本身为局部变量，局部变量不能使用访问修饰符，
        但是可以用final，让其他局部内部类不能继承他
        作用域在定义他的方法或代码块中
         */
        class LocalInner {// 局部内部类(本质还是类)
            // 可以访问外部类的所有成员包括但不限于私有的
            private int n = 111;
            public void f() {
                // 可以直接访问外部类成员
                System.out.println(num);
                m2();
                // 当局部内部类成员和外部类成员重名的时候访问采用就近原则
                // 当访问外部类的成员时使用 外部类名+this+成员名
                System.out.println("inner的n" + n + "\router的n" + LocalInner.this.n);
            }
        }
        
        // 外部类调用时先创建对象在调用方法(需要在作用域内)
        // 外部其他类不能访问局部内部类因为局部内部类是一个成员变量
        LocalInner localInner = new LocalInner();
        localInner.f();
    }
}

/**关于匿名内部类
 * @auther NixAutumna
 */
class AnonymousInnerClass {// 外部类
    /*
   (1)本质是类
   (2)内部类
   (3)该类没有名字
   (4)是一个对象
   匿名内部类是定义在外部类的局部位置比如方法中，并且没有类名
   匿名内部类的基本语法
   
   new 类或接口(参数列表) {
       类体
   };
    */
    private int n1 = 10;// 属性
    public void m() {// 方法
        /*
        基于接口的匿名内部类
        一般地，想要实现animal接口要写一个类，实现接口，再创建对象
        而如果写的类只要用1次，略微复杂
        可以使用匿名内部类
        dog的编译类型Animal
        dog的运行类型是匿名内部类(类名为外部类名$数字)
        在创建匿名内部类时创建了匿名内部类的实例并返回给了dog
        匿名内部类使用一次就不能再使用，但是对象可以多次调用
         */
        Animal dog = new Animal() {
            @Override
            public void say() {
                System.out.println("say");
            }
        };
        System.out.println("dog运行类型" + dog.getClass());
        dog.say();
        
        /*
        基于类的匿名内部类
        father编译类型Father
        运行类型AnonymousInnerClass$2
        底层创建匿名内部类并返回匿名内部类的对象
        参数列表会传递给构造器
        可以重写father类的方法但不可以重写构造器
         */
        Father father = new Father("jk") {
            @Override
            public void test() {
                System.out.println("内部类重写");
            }
        };
        System.out.println(father.getClass());
        father.test();
        
        /*
        基于抽象类的匿名内部类
        必须实现抽象方法
         */
        An an = new An() {
            @Override
            void eat() {
                System.out.println("eat");
            }
        };
        an.eat();
    }
}

interface Animal {
    void say();
}

class Father {
    public Father(String name) {
        System.out.println(name);
    }
    public void test() {
    
    }
}

abstract class  An {
    abstract void eat();
}
