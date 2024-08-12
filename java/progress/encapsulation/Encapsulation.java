package progress.encapsulation;

/**
 * 关于封装
 * @auther NixAutumna
 */
public class Encapsulation {
    public static void main(String[] args) {
        Enc enc = new Enc();
        // 一个一个set
        enc.setName("作者");
        enc.setAge(23);
        enc.setSalary(232344.465);
        System.out.println(enc.info());// 输出信息
        
        // 使用构造器set
        Enc nix = new Enc("NixAutumna", 13, 2342.3);
        System.out.println(nix.info());
    }
}

class Enc {
    /*
    封装就是把抽象出来的数据（属性）和对数据的操作（方法）封装在一起
    数据被保护在内部，程序的其他部分只能通过被授权的操作（方法）才能对数据进行操作
    好处：
    隐藏细节，使其使用方便
    使用步骤：
    1.将属性私有化
    2.提供一个公共的set方法，用于对属性进行判断并赋值
        public void setXxx(类型 参数名) {
            代码块，进行验证数据并给属性赋值
        }
    3.提供一个公共的get方法，用于获取属性的值
        public XX getXxx() {//权限判断
            return xx;
        }
     */
    // 看一个案例，可以储存名字（公开）年龄，工资（私有）
    // 名字在10个字符以内，年龄<120，工资不限
    public String name;// 公开名字
    private int age;// 私有年龄
    private double salary;// 私有工资
    
    // 无参构造器
    public Enc() {
    }
    
    public Enc(String name, int age, double salary) {
        // 在构造器中调用get方法，以判断是否再区间内
        setAge(age);
        setName(name);
        setSalary(salary);
    }
    // get和set方法
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        if (name.length() <= 12) {// 判断输入区间
            this.name = name;
        } else {
            System.out.println("名字不能超过12个字符，给予默认名User");
            this.name = "User";
        }
    }
    
    public int getAge() {
        return age;
    }
    
    public void setAge(int age) {
        if (age >= 0 && age <= 120) {// 判断输入区间
            this.age = age;
        } else {
            System.out.println("年龄应在0-120之间，您输入的年龄有误，给予默认值0");
            this.age = 0;
        }
    }
    
    public double getSalary() {
        return salary;
    }
    
    public void setSalary(double salary) {
        this.salary = salary;
    }
    
    // 返回属性信息
    public String info() {
        return "信息如下: \n名字：" + name + "\n年龄：" + age + "\n工资：" + salary;
    }
}
