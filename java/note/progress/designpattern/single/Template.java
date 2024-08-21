package progress.designpattern.single;

/**
 * @Description : 抽象模版设计模式
 * @Author : NixAutumna
 * @CreateTime : 2024/8/21 22:45
 */

public class Template {
    public static void main(String[] args) {
        Y y = new Y();
        y.time();
    
        Z z = new Z();
        z.time();
    }
}

abstract class X {
    abstract void job();
     public void time() {
         long start = System.currentTimeMillis();
         job();// 由子类自行实现
         System.out.println(System.currentTimeMillis() - start);// 打印耗费时间
     }
}

class Y extends X {
    void job() {// 对于子类只需要编写不同的job提高复用性
        int num = 0;
        for (int i = 0; i < 1000000; i++) {
            num += i;
        }
    }
}

class Z extends X {
    void job() {
        int num = 5;
        for (int i = 0; i < 100000; i++) {
            num *= i;
        }
    }
}