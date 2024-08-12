package progress.super_;
/**
 * 关于super
 * @auther Bai_YiA2
 */
public class Super {
    public static void main(String[] args) {
        /*
        super代表父类的引用，用于访问父类的属性、方法、构造器
        访问父类的属性（除了private）：super.属性名
        访问父类的方法（除了private）：super.方法名(参数列表)
        访问父类的构造器：super(参数列表)参考extend.Extends
        super的好处：
        调用了父类构造器，分工明确
        当子类有属性或方法和父类重名的时候，为了访问父类的属性或方法，必须用super
        没有重名，super、this、直接访问的效果一样
        在用super调用方法的时候，会跳过本类，在父类（父类的父类、父类的父类的……）中查找该方法，直到Object类
        在查找的时候，如果多重继承关系，从辈分小到辈分大，一旦找到就直接使用并停止查找。也就是先来后到原则
         */
        B b = new B();
        b.df();
    }
}

class BaseA {
    public BaseA(int a) {
        System.out.println("A类构造器");
    }
    public void er() {
        System.out.println("A类er方法");
    }
    public int anInt = 1;
    public void sd() {
        System.out.println("A类sd方法");
    }
}

class B extends BaseA {
    public B() {
        super(1);// 调用A类构造器
    }
    public void er() {
        System.out.println("B类er方法");
    }
    public void df() {
        super.er();// 调用A类er方法
        int a = super.anInt;// 调用A类anInt变量
        System.out.println(a == anInt);
        this.er();// 调用B类er方法 == er();
        er();
        
        // 下面三个完全一样
        this.sd();// == sd()
        sd();
        super.sd();
    }
}

class BaseGrandpa {
    void sd() {
        System.out.println("Grandpa");
    }
}

class Dad extends BaseGrandpa{
    void sd() {
        System.out.println("Dad");
    }
}

class Son extends Dad{}

class GrandSon extends Son{
    void sd() {
        super.sd();// 访问Dad的sd
        /*
        查找顺序：
        Son——没有
        Dad——有，使用
        那么BaseGrandpa怎么办呢？
        他虽然有，但是比他辈分小的已经有了，所以就不用他的了
         */
    }
}

/*
super和this有一些相像：
访问属性和方法时：
    this先找本类有没有，在往父类上面找
    super从父类开始找
访问构造器：
    this调用本类构造器
    super调用父类构造器
    都要放在第一行
this表示当前对象
super表示子类访问父类对象
 */
