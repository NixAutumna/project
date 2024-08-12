package progress.designpattern.single;
/**
 * 关于单例设计模式
 * @auther Bai_YiA2
 */
public class SingleTon {
    public static void main(String[] args) {
        // 当创建一个类时需要很多资源,就希望只有一个被创建的类,使用单例设计模式
        A a = A.getA();
        System.out.println(a.toString());
    }
}

class A {
    private String name;
    
    private A(String name) { // 构造器私有化,防止一直new出对象
        this.name = name;
    }
    
//    private static A a = new A("K");// 创建唯一一个实例,static为了在getA中使用
//
//    public static A getA() {
//        return a;// 提供给外部调这个实例
//    }
//    此方法在类加载时就创建对象,而类加载不一定因为需要创建对象而加载,浪费资源
    
    private static A a = null;
    
    public static A getA() {
        return a == null ? a = new A("K") : a;// 没被创建就创建,创建了就返回创建的,不会因为类加载而创建,节约资源,线程不安全
    }
    
    @Override
    public String toString() {
        return name;
    }
}

