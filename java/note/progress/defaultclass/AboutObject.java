package progress.defaultclass;

/**
 * @Description : Object部分方法
 * @Author : NixAutumna
 * @CreateTime : 2024/8/21 22:45
 */

public class AboutObject {
    public static void main(String[] args) {
        /*
        “==”和equals的区别
         */
        
        /*
        ==：比较运算符，可以判断基本类型和引用类型：
        当判断基本类型时，判断值是否相等；
        当判断引用类型时，判断地址是否相等，即是否指向同一个对象
        equals：类Object的方法，只能判断引用类型，
        默认判断地址是否相等，即是否指向同一个对象，和“==”一样
        子类一般重写该方法，用于判断内容是否相等
         */
        int n1 = 0;
        int n2 = 0;
        int n3 = 1;
        System.out.println(n1 == n2);// true，值相等
        System.out.println(n1 == n3);// false，值不相等
        A a1 = new A();
        A a2 = new A();
        A a3 = a1;
        B b1 = a2;
        System.out.println(a1 == a2);// false，指向不同的对象
        System.out.println(a3 == a1);// true，指向同一个对象
        System.out.println(b1 == a2);// true，还是同一个对象
        System.out.println("a".equals("a"));// true，内容一样
        System.out.println("a".equals("b"));// false，内容不一样

        /**
         * 关于hashCode方法
         */
        /*
        提高具有哈希结构的容器的效率
        指向同一个对象的引用的哈希值一样
        反之不一样
        哈希值主要由地址值转换来，但不可以把哈希值当作地址值
         */
        System.out.println(a1.hashCode());

        /**
         * 关于toString
         */
        
        /*
        toString默认返回包名+类名+@+哈希值的16进制表示
        直接输出对象时，会自动调用toString方法
         */
        System.out.println(a1.toString());
    }
}

class A extends B{}
class B {}