package progress.abstract_;

/**
 * @Description : 关于abstract
 * @Author : NixAutumna
 * @CreateTime : 2024/8/21 22:45
 */

public class Abstract {
    public static void main(String[] args) {
        /*
        1)用abstract关键字来修饰一个类时,这个类就叫抽象类,用于解决父类方法不确定性
        访问修饰符 abstract 类名{
        }
        2)用abstract关键字来修饰一个方法时,这个方法就是抽象方法
        访问修饰符 abstract 返回类型方法名 (参数列表);//没有方法体
        3)抽象类的价值更多作用是在于设计，是设计者设计好后，让子类继承并实现抽象类()
        4)抽象类，是考官比较爱问的知识点,在框架和设计模式使用较多
        5)抽象类不能被实例化
        6)抽象类不一定要包含abstract方法。也就是说,抽象类可以没有abstract方法,并且可以有实现的方法
        7)一旦类包含了abstract方法,则这个类必须声明为abstract
        8)abstract只能修饰类和方法，不能修饰属性和其它的
        9)抽象类也是类，可以有任意成员
        10)抽象方法不能有主体(不出现"{}")
        11)如果一个类继承了抽象类则需将所有抽象方法实现或将自己声明为抽象类
        12)抽象方法不可以被private/final/static任意一个修饰,只因他们和重写违背
         */
    }
}

abstract class AbstractDetail {
    public static final int WW = 0;// 可以有任意成员
    
    abstract void print(int i);// 抽象方法
    
    void print1() {// 可以有实现的方法
        System.out.println(WW);
    }
}

class AbstractDetail1 extends AbstractDetail {
    @java.lang.Override
    void print(int i) {
    
    }// 有"{}"为实现了方法
}

abstract class AbstractDetail2 extends AbstractDetail {
    // 可以不用实现抽象方法
}