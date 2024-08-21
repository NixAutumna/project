package progress.final_;

/**
 * @Description : 关于final
 * @Author : NixAutumna
 * @CreateTime : 2024/8/21 22:45
 */

public class Final {
    public static void main(String[] args) {
        /*
        final可以修饰类、属性、方法和局部变量,
        final使用场景:
        1)当不希望类被继承时,可以用final修饰
        2)当不希望父类的某个方法被子类覆盖/重写(override)时,可以用final关键字修饰
        3)当不希望类的的某个属性的值被修改,可以用final修饰
        4)当不希望某个局部变量被修改，可以使用final修饰
         */
        FinalDetail finalDetail = new FinalDetail();// 实例化
        A a = new A();
        a.a();
        System.out.println(FinalDetail2.a);
    }
}

/**
 * 关于常量
 */
class FinalDetail {
    /*
    1) final修饰的属性又叫常量,命名时全部大写,单词间用下划线隔开
    2) final修饰的属性在定义时,必须赋初值,并且以后不能再修改,赋值的位置有:
    1.定义时
    2.在构造器中
    3.在代码块中
    3)如果final修饰的属性是静态的，则初始化的位置只能是
    1.定义时
    2.在静态代码块
    3.不能在构造器中赋值
    4) final类不能继承,但是可以实例化对象
    5)如果类不是final类,但是含有final方法,则该方法虽然不能重写，但是可以被继承
     */
    public final int NUM1 = 1;// 定义时
    public final int NUM2;
    public final int NUM3;
    
    public FinalDetail() {
        NUM2 = 2;// 构造器中
    }
    
    {
        NUM3 = 3;// 代码块中
    }
    public final static int NUM4 = 4;// 定义时
    public final static int NUM5;
    
    static{
        NUM5 = 5;// 静态代码块
    }
    public final void a() {
        System.out.println("a");
    }
    
}

class A extends FinalDetail{

}

final class FinalDetail2 {
    /*
    5)一般来说，如果一个类已经是final类了，就没有必要再将方法修饰成final方法
    6) final不能修饰构造器，代码块(没有意义，不会被重写)
    7) 使用static final 修饰并直接赋值(不是动态赋值)变量，使用时不会导致类加载，底层编译器做了优化处理。
    8)包装类(Integer,Double,Float，Boolean等都是final),String也是final类。
     */
    public void b() {// <=> public final void b() {  因为本身类不会被继承，故一定不会被重写
    
    }
    public final static int a = 1;// 不会导致(1)的输出
    
    static{
        System.out.println("2类加载");// (1)
    }
}