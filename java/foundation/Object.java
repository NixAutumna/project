package foundation;

import java.util.Scanner;

/**
 * 关于面向对象
 * @author Bai_YiA2
 * @version 1.0
 */
public class Object {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        /*
        创建一个对象的方法：
        1.先声明在创建
        2.直接创建
        只有创建了才有存储空间
        new的空间才是对象，名字只是对象名
        对象的传递机制是引用传递
        可以参考数组的传递机制
         */
        Method method1 = new Method();// 创建一个Cat对象，给cat1
        // method是对象名，new Method()的空间才是对象
        /*
        访问一个属性的方法：
        对象名.属性名
         */
        method1.name = "小白";
        method1.age = 3;
        method1.color = "white";
        Method method2;// 声明一个对象
        method2 = new Method();// 创建对象
        method2.name = "小黄";
        method2.age = 5;
        method2.color = "yellow";
        System.out.println("第一只猫的信息" + " " + method1.name + " " + method1.age
                + " " + method1.color);
        System.out.println("第二只猫的信息" + " " + method2.name + " " + method2.age
                + " " + method2.color);

        /*
        调用方法的方法：
        先创建对象再调用方法
         */
        Method method3 = new Method();
        // 使用方法
        method3.cal(1, 100, 1);
        System.out.println("请输入首项");
        int firstNum = scanner.nextInt();
        System.out.println("请输入末项");
        int lastNum = scanner.nextInt();
        System.out.println("请输入公差");
        int tolerance = scanner.nextInt();
        method3.cal(firstNum, lastNum, tolerance);

        // 方法赋值机制之基本数据类型
        int a = 10;
        int b = 20;
        method3.swap(a, b);
        System.out.println("a == " + a + "b == " + b);// a=10,b=20
        // 引用数据类型
        int[] c = {10, 1};
        method3.swap2(c);
        System.out.println(c[0]);// 143
        // 引用数据类型转移地址
        Method m = new Method();
        m.age = 123;
        method3.swap3(m);
        System.out.println(m.age);
        /*
        不会空指针
        先前swap3的m指向main方法的m
        现在指向null
        而main方法的m还是原来那样
        swap3的m没有改变原来地址里的元素，直接改变地址
         */
        Recursion r = new Recursion();
        System.out.println("请输入阶乘到哪里");
        int keyInt = scanner.nextInt();
        System.out.println("从1乘到" + keyInt + "的值是" + r.factorial(keyInt));
        System.out.println("求第几位的斐波那契数");
        keyInt = scanner.nextInt();
        System.out.println("斐波那契数列的第" + keyInt + "位是" + r.fibonacci(keyInt));

        // 关于迷宫问题的递归解决方法
        // 先制作一个8行7列的地图，1表示墙，0表示路
        int[][] map ={{1,1,1,1,1,1,1}, {1,0,0,0,0,0,1},{1,0,0,0,0,0,1},
                {1,0,0,0,0,0,1}, {1,0,0,0,0,0,1}, {1,0,0,0,0,0,1},
                {1,0,0,0,0,0,1}, {1,1,1,1,1,1,1}};
        // 打印空地图
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                System.out.print(map[i][j] + "\t");
            }
            System.out.println();
        }
        boolean b1 = true;
        while (b1) {
            // 设置障碍
            System.out.println("在哪行哪列设置障碍");
            int line = scanner.nextInt();
            int column = scanner.nextInt();
            if (line > 0 && column > 0) {
                map[line - 1][column - 1] = 1;
            }
            // 打印地图
            for (int i = 0; i < map.length; i++) {
                for (int j = 0; j < map[i].length; j++) {
                    System.out.print(map[i][j] + "\t");
                }
                System.out.println();
            }
            System.out.println("是否继续改变，是请输入true");
            b1 = scanner.nextBoolean();
        }
        System.out.println("请输入出口位置");
        int line = scanner.nextInt();
        int column = scanner.nextInt();
        System.out.println("请输入现在位置");
        a = scanner.nextInt();
        b = scanner.nextInt();
        if (! r.findWay(map, a - 1, b - 1, line - 1, column - 1)) {
            System.out.println("没路了");
        }
        
        // 关于汉罗塔的代码实现
        System.out.println("请输入层数");
        int tier = scanner.nextInt();
        r.tower(tier, 'A', 'B', 'C');
        
        // 关于八皇后的代码实现
        System.out.println("请输入几个皇后");
        int length = scanner.nextInt();
        int[] nums = new int[length + 1];
        r.rightQueens(nums, 0);
        VariableScope v = new VariableScope();
        v.say();
    }
}
/**
 * 方法
 */
class Method {
    /*
     属性（成员变量）（field（字段））：
     是类的一部分，一般储存基本数据类型和引用数据类型

     属性创建格式：
     访问修饰符 属性类性型 属名;
     访问修饰符用于控制属性访问范围，包括：
     public（公共的）, protected（受保护的）, 默认(就是不写)（缺省）, private（私有的）
     定义后若不赋值，则按照数组一样的默认值
     公共的表示什么都可以用
     受保护的表示同一个包内或不同包里的子类才访问访问
     缺省表示在同一个包内才能访问
     私有的表示在同一个类才能访问
     */
    String name;// 名字
    int age;// 姓名
    String color;// 颜色
    /*
    关于方法（成员方法） ：
    方法可以把代码封装起来，在需要使用的时候再调用即可
    达到方便简洁的效果，也方便多人合作开发

    方法的定义：
    访问修饰符 返回数据类型 方法名 (形参列表) {
        方法体：
        语句;
        return 返回值
    }

    关于形参列表：
    成员方法输入
    形参列表可以有0个参数也可以有多个参数，有多个参数时用逗号隔开
    参数类型为任意数据类型
    调用含参数的方法是要对照参数列表传入相同数据类型或兼容数据类型（可以自动转化，是传入数据转形参列表数据）
    方法定义时的参数称为形式参数，简称形参；方法调用是的参数称为实际参数，简称实参
    实参好形参的类型要一致或兼容，个数、顺序要一致

    关于返回数据类型：
    表示成员变量输出，void表示没有返回值
    方法最多一个返回值，若要返回多个，则使用数组
    返回类型可以为任意数据类型
    方法如果有返回数据类型，则方法最后一个执行语句为return
    并且返回类型要和return一直或兼容（可以自动类型转化，是return转返回类型）
    在返回数据类型为void时，return可以没有，或只写return

    关于方法体：
    方法体里面写的语句可以为输入、输出、方法调用、运算、分支、循环、变量等
    !!!但是不能在里边定义方法!!!

    成员方法的传参机制：
    在使用基本数据类型时，形参变化不会影响实参(是值拷贝)
    在使用引用数据类型时，形参变化会影响实参(是地址拷贝)
    在传参时相当于将实参赋给形参，赋值机制不变
     */
    public void cal(int num1, int num2, int num3) {
        int res = 0;
        for (int i = num1; i <= num2; i += num3) {
            res += i;
        }
        System.out.println("在公差为" + num3 + "的情况下" + "从" + num1 + "加到" + num2 +"的和是" + res);
    }

    /**
     * 返回值
     */
    // 示范在方法中return的使用
    int res(int num1, int num2, int num3) {
        int res = 0;
        for (int i = num1; i <= num2; i += num3) {
            res += i;
        }
        return res;
    }

    /**
     * 返回多个值
     */
    // 当有多个返回值时，将多个数据合并成一个数组
    int[] aRes(int num1, int num2, int num3) {
        int num4 = 0;
        for (int i = num1; i <= num2; i += num3) {
            num4 += i;
        }
        int[] res = new int[2];
        res[0] = num4;
        res [1] = num1;
        return res;
    }

    /**
     * 调用方法
     */
    public void call() {
        // 同一个类里的方法，直接调用即可
        res(1, 1, 100);
        // 不同一个类的方法，用对象名调用
        Method method = new Method();
        method.cal(1, 1, 100);
        /*
        说明：
        跨类调用和方法的访问修饰符相关
         */
    }

    /**
     * 方法的传参机制
     */
    public void swap(int a, int b){

        System.out.println(a + "" + b);// 10 20
        int temp = a;
        a = b;
        b = temp;
        System.out.println(a + "" + b);// 20 10
    }
    public void swap2(int[] c) {
        System.out.println(c[0]);// 10
        c[0] = 143;
        System.out.println(c[0]);// 143
    }
    public void swap3(Method m) {
        m = null;
//        System.out.println(m.age);// 这样才会空指针异常
    }

    // 克隆对象
    public Method copy(Method m) {
        Method m2 = new Method();
        m2.age = m.age;
        m2.color = m.color;
        m2.name = m.name;
        return  m2;
    }
}

/**
 * 递归
 */
class Recursion {
    // 递归用于完成计算阶乘
    // 返回int，接收int
    public int factorial(int n) {
        if (n == 1) {
            return 1;
        } else {
            return factorial(n - 1) * n;// 循环乘到n==1
        }
    }
    
    /*
    使用递归的重要规则：
    执行一个方法的时候会创建一个新地独立栈空间
    方法中的局部变量是独立的，不会互相影响，就像上面的n
    如果方法使用引用数据类型，则会共享引用类型的数据
    递归必须可以退出，即不可以无限递归
    一个方法执行完毕或return了，就会返回。谁调用就将结果给谁，此时方法也就执行完毕了
     */
    // 递归解决斐波那契数列
    public int fibonacci(int n) {
        if (n >= 1) {
            if (n == 1 || n == 2) {
                return 1;
            } else {
                return fibonacci(n - 1) + fibonacci(n - 2);// 返回前两个数的和
            }
        } else {
            System.out.println("请输入大于等于1的数字");
            return - 1;
        }
    }
    
    /*
    i是行j是列
    0表示可以走
    1表示不能走
    2表示可以走
    3表示走过
     */
    /*
    方法返回布尔值，true表示找到false表示没找到
    map接收地图（二维数组）
    i表示老鼠所在行数，j表示老鼠所在列数
    line表示目标行数
    column表示目标列数
    0表示可以走，1表示障碍物，2表示走过，3表示死路
    使用下上左右的顺序找路
     */
    public boolean findWay(int[][] map, int i, int j, int line, int column) {
        // 通过递归解决出迷宫问题
        if (map[line][column] == 2) {
            // 当终点变成2是说明已经走到了
            for (i = 0; i < map.length; i++) {
                for (j = 0; j < map[i].length; j++) {
                    System.out.print(map[i][j] + "\t");
                }
                System.out.println();
            }
            return true;
        } else {// 还没到终点
            if (map[i][j] == 0) {// 如果可以走且没走过
                map[i][j] = 2;// 假定可以走，把这里变成2
                if (findWay(map, i - 1, j, line, column)) {
                    return true;// 往下走
                } else if (findWay(map, i + 1, j, line, column)) {
                    return true;// 往上走
                } else if (findWay(map, i, j - 1, line, column)) {
                    return true;// 往左走
                } else if (findWay(map, i, j + 1, line, column)) {
                    return true;// 往右走
                } else {// 四条路都走不通，假定错误，改成3
                    map[i][j] = 3;
                    return false;
                }
            } else {// 意味着这是障碍物，或者已经走过，或者是死路
                return false;
            }
        }
    }
    
    // 递归解决罗汉塔问题
    // 输出移动方向
    public void tower(int tier, char a, char b, char c) {
        String arrow = " -> ";
        // 只有一个盘直接到c
        if (tier == 1) {
            System.out.println(a + arrow + c);
        } else {
            // 当有多个盘时，将上面的盘移动到b
            tower(tier - 1, a, c, b);
            // 将最下面一个盘移动到c
            System.out.println(a + arrow + c);
            // 将b塔的盘移动到c
            tower(tier - 1, b, a, c);
        }
        /*
        形参abc不是固定对应实参ABC三根柱子，而是“起始”、“过度”、“终点”三根柱子
        “起始”、“过度”、“终点”是形参！形参！形参！
        不同情况下我们的“起始”、“过度”、“终点”是不同的
        else 代码块中的内容：
        起始问题A上的tier挪到C，BC为空可以任意挪动
        A上面的一摞（tier-1）挪到 B ，所以“起始”=A 、“过度”=C、“终点”=B
        A(底下&最大) ->C
        B上面的一摞（tier-1）挪回A, 所以“起始”=B 、“过度”=C、“终点”=A
        （tier-1）挪回A之后，之前A最底下的已经挪到C最底下了
        目前C上面的为最大，不影响AB移动，可以理解为空
        现在问题回到了“A上的num-1挪到 C，BC为空可以任意挪动”
        循环完成游戏
        
        摘于B站弹幕
         */
    }
    
    // 解决八皇后问题
    /**
     * <p>用于遍历这次的情况</p>
     * @param nums
     *              要打印的数组
     */
    public void print(int[] nums) {
        System.out.println("\n第" + (++nums[nums.length - 1]) + "次输出结果如下：");
        for (int i = 0; i < nums.length - 1; i++) {// 遍历除了最后一个以外的元素
            System.out.print(nums[i] + "\t");
        }
        System.out.println();
    }
    
    /**
     * <p>这是由于检测该位置是否可以放棋子</p>
     * @param nums
     *              数组
     * @param where
     *              下标
     * @param num
     *              列数
     * @return
     *              可不可以放
     */
    public boolean can(int[] nums, int where, int num) {
        for (int i = where - 1, j = 1; i >= 0; i--, j++) {
            // 如果上，左上，右上有棋子就返回false
            if (nums[i] == num) {
                return false;
            } else if (nums[i] == num + j) {
                return false;
            } else if (nums[i] == num - j) {
                return false;
            }
        }
        return true;
    }
    
    /**
     * <p>八皇后主方法</p>
     * @param nums
     *              数组
     * @param where
     *              下标
     */
    public void rightQueens (int[]nums, int where) {
        for (int i = 1; i < nums.length; i++) {
            if (can(nums, where, i)) {
                nums[where] = i;// 下棋
                if (where == nums.length - 2) {// 最后一行，打印数组
                    print(nums);
                } else {
                    rightQueens(nums, where + 1);// 没到最后执行下一行
                }
            }
        }
    }
}

/**
 * 关于方法重载
 */
class OverLoad {
    /*
    为起名和记名的需要，可以进行方法重载
    方法名一样
    形参列表必须不同，不是名字不同，而是个数类型顺序不同
    返回类型随意
     */
    public int m(int i) {
        return i * i;
    }
    public int m(int i, int j) {
        return i * j;
    }
    public void m(String a) {
        System.out.println(a);
    }
}

/**
 * 关于可变参数
 */
class VariableParameters {
    /*
    java可以在同一个类中多个同名同功能但参数个数不同的方法，封装成一个方法
    通过可变参数实现
    
    语法：
    访问修饰符 返回类型方法名(数据类型... 形参名)
    
    可变参数的使用可以参考数组
    
    细节：
    可变参数的实参可以0-多
    实参也可以是数组
    可变参数本质是数组
    可变参数可以和普通参数一起放在形参列表，但可变参数在最后
    形参列表只能有一个可变参数
     */
    public void manyNum(int... nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        System.out.println(sum);
    }
}

/**
 * 关于作用域
 */
class VariableScope {
    /*
    在java中主要的变量是成员变量和局部变量
    局部变量就是在成员方法中的变量
    作用域分类：
        全局变量：属性，作用域为整个类体
        局部变量：除了属性以外的变量，作用域为定义它的代码块中
    全局变量可以不赋值就使用，因为有默认值
    局部变量必须赋值后使用
    
    属性和局部变量可以重名，访问时遵循就近原则
    在同一个成员方法中两个局部变量不能重名
    属性生命周期较长，随着对象创建而创建，随着对象销毁而销毁
    局部变量生命周期较短，随着代码块执行而创建，随着代码块结束而销毁，即存在于方法调用过程中
    全局变量可以跨类调用和本类使用
    局部变量只能在同类同方法调用
    全局变量可以加访问修饰符，局部变量不可以
     */
    public int a = 1;
    public void say() {
        int a = 2;
        System.out.println(a);// 重名就近，2
    }
    void ad() {
        System.out.println(a);// 输出1
    }
}

/**
 * 关于构造器
 */
class Constructor {
    /*
    当在创建一个对象的属性的时候就直接给属性赋值
    就要使用构造器
    构造器本质上是一个方法
    所以可以重载
    如果没有构造器，就会生成默认的无参构造器
    如果自己定义了构造器就会覆盖原有的构造器，除非显示定义一下
     */
    String a;
    int b;
    public Constructor (String pA, int pB) {
        a = pA;
        b = pB;
    }
}

/**
 * 关于this
 */
class This {
    /*
    什么是this
    虚拟机会给每个对象分配一个this
     */
    int age;
    public This(int age) {
        /*
        如果我们这样写：
        age = age;
        那就是在构造器里的age自娱自乐，和属性age没有关系
         */
        // 正确写法
        this.age = age;
    }
    /*
    在深入理解一下this：
    在属性中有种引用数据类型，指向一个方法区的地址
    而this可以理解成引用数据类型指向堆空间里的本方法
    简单来说，调用哪个对象，this就是哪个对象
     */
    /*
    this细节：
    this可以用于访问本类的属性、方法、构造器
    this用于区分类的属性和当前变量
    访问成员方法的语法：this.方法名(参数列表);
    访问构造器语法：this(参数列表); !!注意只能在构造器中使用!!即只能在构造器访问另一个构造器
    !!要进行访问构造器时必须放在第一个语句!!
    this不能在类定义的外部使用，只能在类定义的方法中使用
     */
    public This() {
        this(2);
        System.out.println("无形参构造器");
    }
    public void f1() {
        System.out.println("f1");
    }
    public void f2() {
        // 调用f1
        System.out.println("f2");
        f1();
        // or
        this.f1();
    }
}