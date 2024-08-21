package progress.change;

import java.util.Date;
import java.util.Scanner;

public class Interface {
    String s = "";
    
    // 保存信息
    public void save(String str) {
        s += str + "\n";
    }
    
    // 默认界面
    public void defaultInterface() {
        System.out.println("-----------Change menu-----------\n         1 Change details\n         2 Earnings are boo" +
                "ked\n         3 Consumption\n         4 Quit\n");
    }
    
    // 输出保存的信息
    public void one() {
        System.out.println("-----------Change details-----------\n" + s);
    }
    
    // 输入收入
    public void two() {
        Scanner scanner = new Scanner(System.in);
        int money;
        System.out.println("Please enter the amount of income");
        int input = scanner.nextInt();
        if (input > 0) {
            money = input;
        } else {
            System.out.println("Input error, data must be an integer greater than 0, finished");
            return;
        }
        Date date = new Date();
        save("Earnings are booked: " + " The amount of income: " + money + " " + date.toString());
    }
    
    // 输入消费
    public void three() {
        Scanner scanner = new Scanner(System.in);
        int money;
        String way;
        System.out.println("Please enter the place of consumption");
        way = scanner.next();
        System.out.println("Please enter the consumption amount");
        int input = scanner.nextInt();
        if (input > 0) {
            money = input;
        } else {
            System.out.println("Input error, data must be an integer greater than 0, finished");
            return;
        }
        Date date = new Date();
        save("The place of consumption: " + way + " The consumption amount: " + money + " " + date.toString());
    }
}
