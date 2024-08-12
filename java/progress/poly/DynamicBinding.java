package progress.poly;
/**
 * 关于动态绑定机制
 * @auther NixAutumna
 */
public class DynamicBinding {
    public static void main(String[] args) {
        /*
        动态绑定机制：
        当调用对象方法的时候，方法会和对象的内存地址（运行类型）绑定
        当调用对象属性的时候，没有动态绑定机制，则那里声明那里使用
         */
        Base little = new Little();
        System.out.println(little.sum());
        System.out.println(little.sum2());
    }
}

class Base {
    private int i = 10;
    
    public int sum() {
        return getI() + 10;// 此时运行类型是Little所以从Little开始找方法找到20所以是30
    }
    
    public int sum2() {
        return i + 10;// i是属性，没有动态绑定机制，所以就是20
    }
    
    public int getI() {
        return i;
    }
}

class Little extends Base {
    private int i = 20;
    
    public int getI() {
        return i;
    }
}