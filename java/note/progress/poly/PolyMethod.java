package progress.poly;

/**
 * @Description : 关于方法多态
 * @Author : NixAutumna
 * @CreateTime : 2024/8/21 22:45
 */

public class PolyMethod {
    /*
    方法或者对象具有多种状态，成为多态
    多态建立在封装和继承之上
     */
    public static void main(String[] args) {
        BaseFather basePolyMethod = new BaseFather();
        System.out.println(basePolyMethod.sum(1, 2));
        System.out.println(basePolyMethod.sum(12, 43, 55));
        // 对于传入参数个数的不同，同一个方法名会进行不同的操作，体现多态
        Daughter polyMethod2 = new Daughter();
        System.out.println(polyMethod2.sum(1, 2));
        // 对于对象的不同，同一个方法名和形参列表，返回值不同，体现多态
    }
}

class BaseFather {
    // 方法的多态，可以体现在重载上
    public int sum(int n1, int n2, int n3) {
        return n1 + n2 + n3;
    }
    
    public int sum(int n1, int n2) {
        return n1 - n2;
    }
}

class Daughter extends BaseFather {
    // 方法的多态，可以体现在重写上
    public int sum(int n1, int n2) {
        return n1 + n2;
    }
}

class Son extends BaseFather{
    public int sum(int n1, int n2) {
        return n1 * n2;
    }
}

