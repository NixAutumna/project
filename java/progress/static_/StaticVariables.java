package progress.static_;

/**
 * 关于类变量
 * @auther Bai_YiA2
 */
public class StaticVariables {
    public static void main(String[] args) {
        /*
        1.类变量的作用: 当我们需要让某个类的所有对象都共享一个变量时,就可以考虑使用类变量(静态变量)
        2.类变量与实例变量(普通属性)区别: 类变量是该类的所有对象共享的，而实例变量是每个对象独享的.
        3.加上static称为类变量或静态变量,否则称为实例变量/普通变量/非静态变量
         */
        
        /*
        访问方法：
        类名.类变量名;   [常用]
        对象名.类变量名;
         */
        A.a = 1;// 类变量随着类的加载而创建，所以没有创建对象实例也可以访问
        A a = new A();
        System.out.println(a.a);
        A a1 = new A();
        System.out.println(a1.a);
    }
}

class A {
    /*
    定义方法：
    访问修饰符 static 数据类型 变量名;   [常用]
    static 访问修饰符 数据类型 变量名;
     */
    public static int a;// 定义类变量a
}