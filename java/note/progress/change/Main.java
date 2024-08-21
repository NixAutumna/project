package progress.change;

import java.util.Scanner;

/**
 * @Description : 实现零钱通作业
 * @Author : NixAutumna
 * @CreateTime : 2024/8/21 22:45
 */

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Interface anInterface = new Interface();
        // 循环让用户输入
        boolean stay = true;
        int input;
        while (stay) {
            // 调用默认界面函数
            anInterface.defaultInterface();
            System.out.println("Please choose(1-4)");
            // 接受输入
            input = scanner.nextInt();
            switch (input) {
                case 1 :
                    // 输出第一种选择
                    anInterface.one();
                    break;
                case 2 :
                    // 输出第二种选择
                    anInterface.two();
                    break;
                case 3 :
                    // 输出第三种选择
                    anInterface.three();
                    break;
                case 4 :
                    // 输出第四种选择
                    stay = false;
                    break;
            }
        }
    }
}
