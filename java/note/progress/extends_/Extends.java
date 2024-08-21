package progress.extends_;

/**
 * @Description : 关于继承
 * @Author : NixAutumna
 * @CreateTime : 2024/8/21 22:45
 */

public class Extends {
    public static void main(String[] args) {
        /*
        继承可以解决代码复用，当多个类存在相同的属性和方法时
        可以从当中抽取出父类，在父类中定义相同的属性和方法，子类中无需重新定义
        用extends声明继承父类
        class 子类 extends 父类 {
        }
        子类中会拥有父类定义的属性和方法
        父类又名超类、基类
        子类又名派生类
        子类也可以有子类，叫孙类（bushi）
        继承的好处
        代码复用性、扩展性和维护性提高了
         */
        Pupil pupil = new Pupil();
        pupil.name = "银角大王~";
        pupil.age = 11;
        pupil.testing();
        pupil.setScore(50);
        pupil.info();
        
        System.out.println("=======");
        Graduate graduate = new Graduate();
        graduate.name = "金角大王~";
        graduate.age = 23;
        graduate.testing();
        graduate.setScore(80);
        graduate.info();
        
        // 细节：子类继承了所有的属性和方法，但是私有的属性和方法不能在子类直接访问，但是可以间接访问
        // 例如：
        // pupil.id;是不可以的
        pupil.setId(1212353124L);// 通过公共的方法间接调用
        pupil.info();
        
        // 细节：子类必须调用父类的构造器，完成父类的初始化
        // 调用子类构造器
        Pupil pupil1 = new Pupil();// 可以发现父类的无参构造器也被调用且在子类之前
        // 不管调用子类那个构造器，都会默认调用父类无参构造器，就像上面那个例子
        // 如果父类没有无参构造器，就会在子类构造器中用super去指向父类的那个构造器对父类进行初始化，否则编译将不会通过
        Son son = new Son(123);
        
        // 调用“孙类”构造器
        Grandson grandson = new Grandson(123, "sd");
    }
}

class BaseStudent {// 父类
    public BaseStudent() {
        System.out.println("父类Student被使用");
    }
    // 公有属性
    public String name;
    protected int age;
    double score;
    private long id;
    
    // 公有方法
    public void setScore(double score) {
        this.score = score;
    }
    
    public void info() {
        System.out.println("学生名 " + name + " 年龄 " + age + " 成绩 " + score + "学号 " + id);
    }
    
    public void setId(long id) {// 通过公共方法调用私有属性
        this.id = id;
    }
}

class Pupil extends BaseStudent {// Pupil作为Student的子类
    public Pupil() {
        System.out.println("子类Student被调用");
    }
    public void testing() {// 特有方法
        System.out.println("小学生 " + name + "  正在考小学数学..");
    }
}

class Graduate extends BaseStudent {// Graduate作为Student的子类
    
    public void testing() {// 特有方法
        System.out.println("大学生 " + name + " 正在考大学数学..");
    }
}

class Father {
    public Father(int age) {
        System.out.println("Father的有参构造器被调用");
    }
    
    public Father(int age, String name) {
        System.out.println("Father的两个参数构造器被调用");
    }
}

class Son extends Father {
    public Son(int age) {
        super(age);// 当没有这句话的时候就会报错
        System.out.println("Son的构造器被调用");
    }
    
    public Son(int age, String name) {
        // 在希望指定调用那个父类的构造器的时候，需要显示调用一下， 格式super(参数列表)
        // super使用的时候要放在第一行
        // ∵super()和this()都只能在第一行
        // ∴不可以在同一个构造器出现this和super
        super(age, name);
        System.out.println("Son两参数构造器被调用");
    }
}

class Grandson extends Son {
    // 所有类都直接或间接的继承了Object类
    // 调用父类构造器的时候将一直往上调用到Object类（顶级父类）
    public Grandson(int age, String name) {
        super(age, name);
        System.out.println("Grandson构造器被调用");
    }
}