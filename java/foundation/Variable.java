package foundation;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 关于数据结构
 * @author Bai_YiA2
 * @version 1.0
 */
public class Variable {
    public static void main(String[] args) {

        /*
        关于转义字符
        \t  一个制表位
        \\  一个\
        \n  换行
        \r  回车，但是没有换行就回到第一位
         */

        // !!!警告：在实际开发中不能使用a,b,n1,n2命名变量
        /**
         * 关于基本类型
         * @author Bai_YiA2
         * @version 1.0
         */

        /**
         * 关于整数类型
         */
        // 字节byte，占1个字节，储存范围是-128 ~ 127
        byte n1 = -128;
        byte n2 = 127;
        // 短整型short，占2个字节，储存范围是-32768 ~ 32767
        short n3 = -32768;
        short n4 = 32767;
        // 整型int，占4字节，储存范围是-2147483648 ~ 2147483647
        int n5 = -2147483648;
        int n6 = 2147483647;
        // 长整型long，占8字节，储存范围是-9223372036854775808 ~ 9223372036854775807
        long n7 = -9223372036854775808L;
        long n8 = 9223372036854775807L;
        /*
        整数类型默认为int
        如果赋值long类型需要在后面加L或l
        为了和1分辨，一般使用L
         */

        /**
         * 关于浮点类型
         */
        // 单精度float，占4字节，储存范围是-3.4028E38 ~ 3.4028E38
        float n9 = -3.4028E38F;
        float n10 = 3.4028E38F;
        // 双精度double，占8字节，储存范围是-1.7976E308 ~ 1.7976E308
        double n11 = -1.7976E308;
        double n12 = 1.7976E308;
        /*
        浮点数在计算机中储存机制
        浮点数 = 符号位 + 指数位 + 尾数位
        浮点数默认类型是double
        赋值给float时在后面需要加F或f
        浮点数都是近似数
         */

        /**
         * 关于布尔类型
         */
        // 布尔类型boolean，占1字节，储存true或者false
        boolean b1 = true;
        boolean b2 = false;
        /*
        布尔变量一般用于逻辑运算
        不能为null
         */

        /**
         * 关于字符类型
         */
        // 字符类型char，占2字节，可以存放一个转义符、汉字、字母、数字
        char c1 = '\t';
        char c2 = '甲';
        char c3 = 'a';
        char c4 = '1';
        char c5 = 97;
        /*
        字符型储存到计算机中，就是储存对应的码值
        c5就是a
        c3在储存是就是变成97储存
         */

        /*
        关于字符编码表
        ASCLL，一个字节，128个字符
        Unicode，两个字节，但固定大小，浪费空间
        utf-8，大小可变，字母1个字节，汉字3个字节
        gbk，较广范围表示汉字，字母1个字节，汉字2个字节
        gb2312，可以表示汉字，范围比gbk小
        big5，繁体中文，台湾香港较为常见
         */
        /*
        基本数据类型的赋值机制：
        值传递
        只将值赋给另一个
        如：
        int n1 = 1;
        int n2 = n1;
        n2 = 80;
        那么：
        n1 == 1
        n2 == 80
        也就是说：
        n1只将自己的值给了n2
        n2之后和n1没有关系
         */

        /**
         * 关于自动转化
         * @auther Bai_YiA2
         * @version 1.0
         */
        /*
        在进行赋值或运算时，小精度自动转换成大精度的数据类型
        转换路线
        char -> int
        byte -> short -> int -> long -> float -> double
        在多个数据类型进行混合运算时，自动先转成容量最大的数据类型再计算
        byte、short和char不会自动转换
        但是他们可以进行运算，先转成int
        boolean不参与转换
         */
        System.out.println('a' + 123 + 12343.352);

        /**
         * 关于强制转换
         * @auther Bai_YiA2
         * @version 1.0
         */
        /*
        当数据从大到小转换时，会使用强制转换
        强转符号只针对最近数生效，可以使用小括号提升优先级
        char可以保存int的常量值，不能保存变量值，需要强转
        byte和short进行运算时当做int处理
         */
        int n13 = (int)1232456.2343;

        // 将基本数据类型和字符串之间转换
        // 将基本数据类型转字符串，只需要 + ""
        String s1 = 49 + "";
        // 将字符串转化为基本数据类型需要使用包装类
        // 注意：需要字符串是一个可以转为此类型的数字
        byte n14 = Byte.parseByte(s1);
        short n15 = Short.parseShort(s1);
        int n16 = Integer.parseInt(s1);
        long n17 = Long.parseLong(s1);
        float n18 = Float.parseFloat(s1);
        double n19 = Double.parseDouble(s1);
        // 在包装给boolean时如果字符串是true则为true，其他都是false
        String s2 = "a";
        boolean b3 = Boolean.parseBoolean(s2);
        // 将String转char，就是在String的第几位取出一个字符
        char c6 = s1.charAt(0);
        // 注意：计算机中第一个的下标是0，第二个的下标是1，以此类推

        /**
         * 关于引用数据类型
         * @author Bai_YiA2
         * @version 1.0
         */
        /**
         * 关于数组
         */
        /*
        数组的定义：
        1.动态初始化
        第一种用法：
        数据类型 数组名[] = new 数据类型[长度];
        或数据类型[] 数组名 = new 数据类型[长度];
        长度表示这个数组所含的数据个数
        第二种用法：
        // 声明数组，没有存储空间
        数据类型[] 数组名;
        或数据类型 数组名[];
        // 创建数组
        数组名 = new 数据类型[长度];
        2.静态初始化：
        数据类型 数组名[] = {元素值};
        // 换成动态初始化
        double[] a = {1, 23, 4};
        <=>
        double[] a = new double[3];
        a [0] = 1;
        a [1] = 23;
        a [2] = 4;
        静态初始化比动态初始化更加简洁，但如果需要一个个数据加入数组则动态初始化较为方便

        数组的引用：
        数组名[下标];
         */
        // 创建一个Scanner方法
        Scanner scanner = new Scanner(System.in);
        // 创建一个double数组，长度为5
        double[] scores = new double[5];
//        // 或者
//        double[] scores;// 声明变量，scores == null;
//        scores = new double[5];// 分配空间
        // scores.length表示数组长度
        // 循环输入数据
        for(int i = 0; i < scores.length; i++) {
            System.out.println("请输入第" + (i + 1) + "的值");
            // 将输入的数据放到第i个元素
            scores[i] = scanner.nextDouble();
        }
        // 循环输出数组的每一个元素，遍历数组
        for(int i = 0; i < scores.length; i++) {
            System.out.println(scores[i]);
        }
        // 或
        System.out.println(Arrays.toString(scores));
        /*
        数组使用细节：
        数组是多个相同类型数据的组合（可以是任何数据类型），实现对他们的统一管理（不能混用）
        数组创建后，若无赋值，则默认值为：
        byte, short, int, long == 0;
        float, double == 0.0;
        char == \u0000;
        boolean == false;
        String == null;
        使用数组：
        先开辟空间
        再给每个元素赋值
        最后使用
        数组下标从0开始，使用时不能超出指定范围
        数组是引用类型，数组型数据是对象
         */
        double[] someNumbers = {12, 435, 4536, 123456, 45, 456};
        double bigerNumber = 0.0;// 用于表示已知的最大数
        int bigerInWhere = 0;// 用于表示最大数的位置
        for (int  i = 0; i < someNumbers.length; i++) {
            // 当该元素比已知最大数大时，将它的值赋给已知最大数再将它所在的位置赋给最大数的位置
            if (someNumbers[i] >= bigerNumber) {
                bigerNumber = someNumbers[i];
                bigerInWhere = i;
            }
        }
        System.out.println("最大数是" + bigerNumber + "在第"
                + (bigerInWhere + 1) + "位");

        /*
        数组赋值机制：
        引用传递
        赋值为地址
        如：
        int[] a1 = {1, 34, 435, 3};
        int a2 = a1;
        a1[2] = 234;
        那么：
        a1[2] = 234;
        a2[2] = 234;
        也就是说，在传递之后，a1和a2就有关系了。
         */
        // 那么应该怎么实现像基本数据类型一样值传递呢？
        int[] a1 = {213, 324, 453, 123};
        // 创建一个新的数组a2创建新的数据空间，大小是a1的大小
        int[] a2 = new int[a1.length];
        // 遍历a1，将每个元素拷贝到对应位置
        for (int i = 0; i < a1.length; i++) {
            a2 [i] = a1 [i];
        }
        // 这样a1和a2就没有关系了

        // 将数组内的各个数据进行反转
        // 如：{213, 324, 453} => {453, 324, 213}
        // 先定义一个变量，用于存储一个数据防止变化后消失
        int temp;
        // 循环次数==长度除以二取整
        for (int i = 0; i < a1.length / 2; i++) {
            // temp储存他
            temp = a1[i];
            // 要交换的数==长度-1-下标
            a1[i] = a1[a1.length - 1 - i];
            // 在将temp的数取出换回
            a1[a1.length - 1 - i] = temp;
        }
        for (int i = 0; i < a1.length; i++) {
            System.out.print(a1[i] + "\t");
        }
        // 第二种方法：倒序赋值
        int[] a3 = new int[a1.length];
        for (int i = 0; i < a3.length; i++) {
            a3[i] = a1[a3.length - i - 1];
        }
        System.out.println();
        for (int i = 0; i < a3.length; i++) {
            System.out.print(a3[i] + "\t");
        }

        // 数组扩容，试将a3最后多一个元素
        int[] a4;// 用于扩容的变量
        for (char keyChar = 'y';keyChar == 'y';) {// 在a==n时结束循环
            // （其实可以用do--while）
            a4 = new int[a3.length + 1];// 扩容的变量长度为原变量长度+1
            for (int i = 0; i < a3.length; i++) {// 值传递
                a4[i] = a3[i];
            }
            System.out.println("你要再最后添加什么数字");
            a4[a4.length - 1] = scanner.nextInt();// 接收添加数字
            System.out.println("如果需要继续添加请输入y，结束请输入其他");
            keyChar = scanner.next().charAt(0);// 判断是否继续执行
            a3 = a4;// 将a4引用传递给a3
        }
        for (int i = 0; i < a3.length; i++) {
            System.out.print(a3[i] + "\t");
        } // 遍历输出a3

        // 数组缩减
        char keyChar;
        do{
            System.out.println("你要删除该数组的第几个元素");
            int deleteWhere = scanner.nextInt() - 1;// 接收输入，因为下标从0开始，所以减1
            a4 = new int[a3.length - 1];// 定义a4，比a3短一个元素
            for(int i = 0; i < a3.length; i++) {// 循环值传递
                if(i == deleteWhere){}// 在传递到删除数时不进行传递
                else if (i > deleteWhere) {
                    a4[i - 1] = a3[i];// 在比删除数大的时候a4下标加一1==a3的下标
                } else {
                    a4[i] = a3[i];// 在删除数小的时候单纯值传递
                }
            }
            System.out.println("你是否需要继续缩减？");
            keyChar = scanner.next().charAt(0);// 接收是否继续缩减
            a3 = a4;
        } while (keyChar == '是' && a3.length > 1);// 在输入是并且a3长度比1长
        // （可以继续减）时循环
        for (int i = 0; i < a3.length; i++) {
            System.out.print(a3[i] + "\t");
        } // 遍历输出a3
        System.out.println();

        /**
         * 关于排序
         */
        /*
        排序分为内部排序和外部排序

        内部排序：
        将所有数据加载到内部存储器中进行排序
        包括：交换式排序，选择式排序，插入式排序

        外部排序：
        数据量过大，导致无法全部加载到内存中，需要接住外部存储进行排序
        包括：合并排序法，直接合并排序法
         */
        // 冒泡排序
        // 将a3每一个元素从小到大按从前往后顺序排序
        // 一次次排序，每一次排序将一个最大数移到最后面
        for (int j = 0; j < a3.length; j++) {
            n1 = 0;
            bigerNumber = 0;// 用于储存单次循环的最大数，每次循环都要初始化
            bigerInWhere = 0;// 用于交换，每次循环都要初始化
            for (int i = 0; i < a3.length - j; i++) {// 将这次的最大数放在最后面
                if (a3[i] > bigerNumber) {
                    bigerNumber = a3[i];
                    bigerInWhere = i;// 报告最大数的位置，以便交换使用
                    n1++;
                }
            }
            temp = a3[a3.length - 1 -j];// 临时存储这个数，用于交换是不会消失
            a3[a3.length - 1 - j] = (int)bigerNumber;// 交换
            a3[bigerInWhere] = temp;// 交换
            if (n1 == bigerInWhere + 1) {// 满足这个条件意味着这个数组已经是一个有序的数组
                System.out.println(j);
                break;
            }
        }// 这种方法是一次循环找一个最大的，然后将最大的和最后的交换
//        int a = 0;
//        for( int i = 0; i < a3.length - 1; i++) {//外层循环是4次
//            a = 0;
//            for( int j = 0; j < a3.length - 1 - i; j++) {//4次比较-3次-2次-1次
//                //如果前面的数>后面的数，就交换
//                if(a3[j] > a3[j + 1]) {
//                    temp = a3[j];
//                    a3[j] = a3[j+1];
//                    a3[j+1] = temp;
//                    a++;
//                }
//            }
//            if (a == 0) {
//                break;// 如果==0说明没有交换，即数组有序
//            }
//        }// 这种方法是每次都判断前后那个大，如果前面大就将前后交换，实现每次最大数都是在最后
        for (int i = 0; i < a3.length; i++) {
            System.out.print(a3[i] + "\t");
        } // 遍历输出a3
        System.out.println();

        // 数组的查找
        /*
        常用查找方法有：
        顺序查找（按顺序一个个找）
        二分法（在数组有序的前提下，一半一半找）
         */
        // 现要求用顺序查找输入int是否再数组a3内
        System.out.println("What number do you want to find?");// 提示用户输入
        int keyInt = scanner.nextInt();// 接收输入
        for (int i = 0; i < a3.length; i++) {// 循环按顺序查找
            if (keyInt == a3[i]) {// 当找到了就输出位置并结束循环
                System.out.println("The number of " + keyInt + " are in the "
                        + (i + 1) + " of this array");
                b1 = false;// 不输出找不到语句
                break;
            }
        }
        if (b1) {// b1默认为true，如果没找到就不会变成false
            System.out.println("Sorry,the number of " + keyInt
                    + " are not in this array.");// 提示找不到数字
        }

        /**
         * 关于二维数组
         */
        /*
        二维数组的定义：
        1.动态初始化：
        第一种用法
        数据类型[][] 数组名 = new 数据类型[长度1][长度2];
        长度1表示这个二维数组含一维数组的个数
        长度2表示二维数组所含的一维数组所含的数据个数
        第二种用法
        // 先声明数组，并没有存储空间
        数据类型[][] 数组名;
        // 分配空间
        数组名 = new 数据类型[长度1][长度2];
        第三种用法（每一个一维数组的长度不同）
        数据类型[][] 数组名 = new 数据类型[长度1][]
        数据名[一维数组的下标] = new 数据类型[长度2] //如果没有这个一维数组就没有空间
        2.静态初始化：
        数据类型[][] 数组名 = {{数据}, {数据}......}


        二维数组的访问：
        数组名[数据所在的一维数组在他的二维数组的位置][数据在一维数组的位置];

        二维数组实际上是由多个一维数组组成的，各个一维数组长度不限制
        每个一维数组的长度不同的二维数组被称为列数不等的二维数组

        对于一维数组，声明方式有：
        数据类型[] 数组名;
        或数据类型 数组名[];
        两种
        对于二维数组，声明方式有：
        数据类型[][] 数组名;
        或数据类型[] 数组名[];
        或数据类型 数组名[][];
        三种
         */
        int[][] a5 = {{4, 6}, {1, 4, 5, 7}, {-2}};
        n2 = 0;
        for (int j = 0; j < a5.length; j++) {
            for (int i = 0; i < a5[j].length; i++) {
                n2 += a5[j][i];
            }
        }
        System.out.println(n2);
        System.out.println("你要一个几行的杨辉三角");// 提示输入行数
        int layer = scanner.nextInt();// 接收
        int[][] yhsj = new int[layer][];// 定义一个二维数组，没开每个一维数组的空间
//        for (int i = 0; i < layer; i ++) {// 开辟每一个一维数组的空间
//            yhsj[i] = new int[i + 1];
//        }// 修改致下一个for循环内部
        for (int j = 0; j < layer; j ++) {
            // 开空间
            yhsj[j] = new int[j + 1];
            // 头尾都是1
            yhsj[j][0] = 1;
            yhsj[j][yhsj[j].length - 1] = 1;
            // 超过2行就开始给中间数赋值
            if (j >= 2) {
                for (int i = 1; i < yhsj[j].length - 1; i++) {
                    // 等于上一行的上一个和上一行的这一个的和
                    yhsj[j][i] = yhsj[j - 1][i - 1] + yhsj[j - 1][i];
                }
            }// 关于以上的另一种处理方法
//            //给每个一维数组(行) 赋值
//            for(int j = 0; j < yhsj[i].length; j++){
//                //每一行的第一个元素和最后一个元素都是1
//                if(j == 0 || j == yhsj[i].length - 1) {
//                    yhsj[i][j] = 1;
//                } else {//中间的元素
//                    yhsj[i][j]  =  yhsj[i-1][j] + yhsji[i-1][j-1];
//                }
//            }
        }
        // 遍历输出
        for (int j = 0; j < yhsj.length; j++) {
            System.out.println();
            for (int i = 0; i < yhsj[j].length; i++) {
                System.out.print(yhsj[j][i] + "\t");
            }
        }
    }
}