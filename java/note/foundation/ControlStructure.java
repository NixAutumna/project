package foundation;

import java.util.Scanner;

/**
 * @Description : 关于程序控制结构
 * @Author : NixAutumna
 * @CreateTime : 2024/8/21 22:45
 */

public class ControlStructure {
    public static void main(String[] args) {

        // 关于接收输入：先导入Scanner包，创建一个新的Scanner方法
        // 用.next接收字符串，
        // .nextInt接收int类型
        Scanner scanner = new Scanner(System.in);

        /**
         * 关于if的用法
         * @author NixAutumna
         * @version 1.0
         */
        /*
        if的用法(单分支)
        if (条件表达式) {
            代码块
        }
        如果条件表达式成立，执行代码块
         */
        System.out.println("请输入年龄");
        int age = scanner.nextInt();
        if (age >= 18) {
            System.out.println("你已经成人，需要对自己的行为负责，送入监狱");
        }
        /*
         if--else的用法(双分支)
        if (条件表达式) {
            代码块
        } else {
            代码块2
        }
        如果条件表达式成立，执行代码块
        不成立执行代码块2
         */
        if (age >= 18) {
            System.out.println("你已经成人，需要对自己的行为负责，送入监狱");
        } else {
            System.out.println("你还未成人，请做一个好少年，送入少管所");
        }
        /*
        if--else if--else的用法(多分支)
        if (条件表达式1) {
        代码块1
         } else if (条件表达式2) {
        代码块2
        } else {
        代码块3
         }
         if后那个条件成立就执行他的代码块
        如果那个成立了就不执行后面的if语句
        都不成立执行else
        只能有一个入口（只能执行if--else if--else中的一个代码块）
        可以没有else，都不成立一个入口都没有
         */
        // 提示输入信用值
        System.out.println("请输入信用值(1-100)");
        // 用in1变量接收输入
        int in1 = scanner.nextInt();
        if (in1 == 100) {
            System.out.println("信用极好");
        } else if (in1 < 100 && in1 >= 80) {// 当信用值在100和80之间时输出信用优秀
            System.out.println("信用优秀");
        } else if (in1 < 80 && in1 >= 60) {// 当信用值在80和60之间时输出信用一般
            System.out.println("信用一般");
        } else {// 都不是输出信用不及格
            System.out.println("信用不及格");
        }
        /*
        嵌套分支：
        在一个分支里面再来一个分支
        嵌套最好不要超过三层，否则可读性不好
         */
        // 判断信用是否再1-100之间
        if (in1 >= 0 && in1 <= 100) {
            // 当信用值等于100时输出信用极好，这是嵌套在if里面的if--elseif结构
            if (in1 == 100) {
                System.out.println("信用极好");
            } else if (in1 < 100 && in1 >= 80) {// 当信用值在100和80之间时输出信用优秀
                System.out.println("信用优秀");
            } else if (in1 < 80 && in1 >= 60) {// 当信用值在80和60之间时输出信用一般
                System.out.println("信用一般");
            } else {// 都不是输出信用不及格
                System.out.println("信用不及格");
            }
        } else {
            System.out.println("信用分需要在0-100之间:/");

        }

        /**
         * 关于Switch的使用
         * @author NixAutumna
         * @version 1.0
         */
        /*
        swtich的使用：
        switch关键字，表示Switch分支
        表达式对应一个值
        case常量1：当值==1，执行语句1
        break：退出swtich
        和那个case值匹配就执行那个语句块
        一个都匹配不上，执行default
        细节：（表达式指switch后面的表达式）
        表达式数据类型应于每一个case后的常量一致，或者可以自动转化
        表达式返回值必须是byte,short,int,char,enum,String类型
        case句子的值必须是常量或常量表达式，不是变量
        没有匹配的case时执行default，default可以没有
        当一个case匹配成功就会一直执行下去，跳过接下来的case判断条件，
        直到break，否则就一直执行到switch结尾（穿透）
        用switch做区间判断的方法：将数字除以一个值再强转成int，然后匹配
         */
        double score = scanner.nextDouble();
        if (score <= 100 && score >= 0) {
            switch ((int) (score / 60)) {
                case 0:
                    System.out.println("不合格");
                    break;
                case 1:
                    System.out.println("合格");
                    break;
            }
        } else {
            System.out.println("输入有误");
        }
        // 对于穿透，不一定是坏处，也可以用于判断区间，并让代码更整洁
        System.out.println("请输入月份");
        int month = scanner.nextInt();
        switch (month) {
            case 3:
            case 4:
            case 5:
                System.out.println("春季");
                break;
            case 6:
            case 7:
            case 8:
                System.out.println("夏季");
                break;
            case 9:
            case 10:
            case 11:
                System.out.println("秋季");
                break;
            case 12:
            case 1:
            case 2:
                System.out.println("冬季");
                break;
            default:
                System.out.println("输入有误");
        }
        /*
        对于switch和if--else之间选择：
        判断数值不多，且类型是byte,short,int,char,enum,String时建议使用switch
        对区间判断，结果为boolean值，建议使用if
         */

        /**
         * 关于for循环
         * @author NixAutumna
         * @version 1.0
         */
        /*
        for(循环变量初始化;循环条件;循环变量迭代) {
            循环代码块;
         }
        初始化循环变量，在循环条件内，一直循环执行循环代码块，每一次执行后都会执行一次循环变量迭代，
        当不在循环条件内后退出for循环

        循环条件只能返回一个Boolean值
        for循环的循环变量初始化和循环变量迭代可以写到其他地方，但是分号不能省略，
        如果没有循环条件，那么就是一个无限循环
        如果循环变量初始化写在for后面的括号中，那么只能在for循环中使用（作用域）
        在循环变量初始化、循环变量迭代时，可以有多条语句，中间用逗号隔开

        for循环体现的编程思想:
        化繁为简：将复杂的需求拆解成为简单的需求，逐步完成
        先死后活：先考虑特别再考虑统法
         */
        int count = 0;
        for (int i = 1; i <= 100; i++) {
            if (i % 9 == 0) {
                count++;
            }
        }
        System.out.println(count);
        // 具体操作：
        int num1 = 0;
        int num2 = scanner.nextInt();
        int num3 = num2;
        for (; num1 <= num2; num1++, num3--) {
            System.out.println(num1 + "+" + num3 + "=" + num2);
        }

        /**
         * 关于while的用法
         * @author NixAutumna
         * @version 1.0
         */
        /*
        循环变量初始化;
        while (循环条件) {
            循环代码块;
            循环变量迭代;
        }
        对于while，和for差不多，只是循环变量初始化和迭代换了一个地方
         */
        int num4 = scanner.nextInt();
        int j = 0;
        while (j <= num4) {
            System.out.println(j + "+" + (num4 - j) + "+" + "=" + num4);
            j++;
        }

        /**
         * 关于Do--while
         * @author NixAutumna
         * @version 1.0
         */
        /*
        do--while的使用：
        循环变量初始化
        do {
            循环代码块;
            循环变量迭代;
        } while(循环条件)
        do--while循环会先执行代码块再判断是否再执行下一次
         */
        String inputString1;
        char StringToChar;
        char huan = '还';
        do {
            System.out.println("你**还不还钱?!");
            inputString1 = scanner.next();
            // 接收输入的第一个字符
            StringToChar = inputString1.charAt(0);
        } while (StringToChar != huan);// 如果不说还就循环
        /*
        嵌套循环：
        把循环放在循环内部，嵌套不超过3层
        总循环次数是每层循环次数的积
         */
        for (int num5 = 1; num5 < 10; num5++) {// 设置第一个乘数，在每一次循环后加1
            // 设置第二个乘数，在每一次循环后加一且小于第一个乘数
            for (int num6 = 1; num6 <= num5; num6++) {
                System.out.print(num6 + "*" + num5 + "=" + (num5 * num6) + '\t');
                // 打印每一个乘法式子后空一个制表位
            }
            System.out.println();// 换行
        }
        System.out.println("请输入层数");
        int totalLevel = scanner.nextInt();
        int i = 1;
        char s = ' ';
        while (i <= totalLevel) {// 每层打印层数减一个空格
            for (int i1 = 1; i1 <= totalLevel - i; i1++) {// 打的空格是总层数-当前层
                System.out.print(s);
            }
            System.out.print("*");
            if (i > 1 && i < totalLevel) {// 在层数>1时才会打空格
                // 空格个数==（层数-1）*2-1
                int space = (i - 1) * 2 - 1;
                for (int spaceNum = 1; spaceNum <= space; spaceNum++) {
                    System.out.print(s);
                }// 打出
                System.out.print("*");
            } else if (i == totalLevel) {
                for (int i6 = 1; i6 <= (totalLevel - 1) * 2; i6++) {
                    System.out.print("*");
                }
                break;
            }
            i++;
            System.out.println();
        }

        /**
         * 关于break的使用
         * @author NixAutumna
         * @version 1.0
         */
        /*
        Math.random()
        可以返回一个<1 && >=0的数
         */
        int num = 1;
        int random;
        for (; ; ) {
            random = (int) (Math.random() * 100) + 1;
            if (random == 97) {
                break;
            }
            num++;
        }
        System.out.println(num);
        /*
        Break的使用：
        当循环执行到break时，会跳出当前循环
        可以在break语句后面指定退出那一层
        最好不用标签
         */

        /**
         * 关于continue
         * @author NixAutumna
         * @version 1.0
         */
        /*
        关于continue的用法
        可以结束本次循环
        !!不是跳出!!
        可以使用标签，像break
        结束标签所在的那次循环
        无标签默认结束最近循环
         */
        label1:
        for (int w = 0; w < 4; w++) {// 循环执行4次，默认条件
            for (int k = 0; k < 10; k++) {// 默认条件执行10次
                if (k == 2) {
                    continue label1;// 在i == 2也就是第三次的时候结束那次循环
                    // 则不会输出i = 2和之后的算式
                }
                System.out.println("k = " + k);
            }
        }

        /**
         * 关于return的使用
         * @author NixAutumna
         * @version 1.0
         */
        /*
         * 关于return
         * 结束该方法
         * 如果写在main方法中
         * 则结束程序
         * 具体使用看Object类
         */
    }
}