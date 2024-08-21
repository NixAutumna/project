package progress.static_;

/**
 * @Description : 关于类方法
 * @Author : NixAutumna
 * @CreateTime : 2024/8/21 22:45
 */

public class StaticMethod {
    public static void main(String[] args) {
        /*
        类方法也叫静态方法。
        当方法中不涉及到任何和对象相关的成员，则可以将方法设计成静态方法,提高开发效率。
        因为可以不实例化就使用。
        1)类方法和普通方法都是随着类的加载而加载，
        将结构信息存储在方法区；
        2)类方法可以通过类名调用，
        也可以通过对象名调用。
        3)普通方法和对象有关，
        需要通过对象名调用，
        不能通过类名调用
        4)类方法中不允许使用和对象有关的关键字，比如this和super。普通方法(成员方法)可以。
        5)静态方法，只能访问静态的成员，非静态的方法，可以访问静态成员和非静态成员
         */
        
        /*
        调用方法:
        类名.类方法名;   [常用]
        对象名.类方法名;
         */
        Student a = new Student("a", 222);
        Student b = new Student("b", 111);
        System.out.println(Student.getPublicfee());
    }
}

class Student {
    public String name;
    public int fee = 0;
    public static int publicfee = 0;
    
    public Student(String name, int fee) {
        this.name = name;
        this.fee = fee;
    }
    
    public  void addfee() {
        publicfee += fee;
    }
    
    /*
    定义方法：
    访问修饰符 static 数据返回类型 方法名(){}   [常用]
    static 访问修饰符 数据返回类型 方法名(){}
     */
    public static int getPublicfee() {
        return publicfee;
    }
}