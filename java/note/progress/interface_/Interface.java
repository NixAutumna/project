package progress.interface_;
/**
 * 关于接口
 * @auther NixAutumna
 */
public class Interface {
    public static void main(String[] args) {
        /*
        接口就是给出一些没有实现的方法,封装到一起,到某个类要使用的时候,在根据具体情况把这些方法写出来。语法:
        interface 接口名{
            //属性
            //方法
        }
        class 类名 implements 接口名{
        自己属性;
        自己方法;
        必须实现的接口的抽象方法
        }
        1.在Jdk7.0前接口里的所有方法都没有方法体。
        2. Jdk8.0后接口类可以有静态方法，默认方法，也就是说接口中可以有方法的具体实现
        
        1)接口不能被实例化
        2)接口中所有方法都是public方法,接口中的抽象方法可以省略abstract,默认方法需要加default
        3)当一个普通类实现接口,必须实现所有抽象方法
        4)抽象类实现接口可以不用实现其抽象方法
        5)一个类可以实现多个接口
        6)接口中的属性省略public static final,且必须初始化好,访问方法:接口名.属性名
        7)接口不可以继承类,但是可以继承一个接口(使用extends)
        8)接口的修饰符和类一样可以是默认或public
        9)接口可以实现多态
         */
        System.out.println(A.b);
        A c = new C();
        A c2 = new C2();
        G.toString(c);
        G.toString(c2);
    }
}

interface A {
    void a ();// abstract public void a();
    int b = 1;// public static final int b = 1;
    default void c() {// default public void c()
        System.out.println("c");
    }
}

interface B {
    void a ();
}

class C implements A, B {// 实现多个接口
    
    @Override
    public void a() {
        System.out.println("C");
    }
}

class C2 implements A, B {
    
    @Override
    public void a() {
        System.out.println("C2");
        
    }
}

abstract class D implements A {}// 可以不用实现抽象方法

interface F extends A {}// 继承接口

class G {
    public static void toString (A a) {// 多态参数
        if (a != null)
            a.a();
    }
}