package progress.poly;

/**
 * @Description : 关于多态参数
 * @Author : NixAutumna
 * @CreateTime : 2024/8/21 22:45
 */

public class PolyParameter {
    
    public static void main(String[] args) {
        BaseEmployee tom = new Manager("Tom", 10000, 8000);
        BaseEmployee jack = new Staff("jack", 5000);
        Test test = new Test();
        System.out.println(test.showEmpAnnual(tom));
        System.out.println(test.showEmpAnnual(jack));
        test.testWork(tom);
        test.testWork(jack);
    }
}

class BaseEmployee {
    public String name;
    private double monthly;
    
    public double getMonthly() {
        return monthly;
    }
    
    public void setMonthly(double monthly) {
        this.monthly = monthly;
    }
    
    public double getAnnual() {
        return getMonthly() * 12;
    }
}

class Staff extends BaseEmployee {
    
    public Staff(String name, double monthly) {
        this.name = name;
        setMonthly(monthly);
    }
    
    public double getMonthly() {
        return super.getMonthly();
    }
    
    public void work() {
        System.out.println(name + " is working");
    }
}

class Manager extends BaseEmployee {
    public double bonus;
    
    public Manager(String name, double monthly, double bonus) {
        this.name = name;
        setMonthly(monthly);
        this.bonus = bonus;
    }
    
    public double getBonus() {
        return bonus;
    }
    
    public double getAnnual() {
        return getBonus() + (getMonthly() * 12);
    }
    
    public void manage() {
        System.out.println(name + " is managing");
    }
}

class Test {
    
    public double showEmpAnnual(BaseEmployee e) {
        return e.getAnnual();
    }
    
    public void testWork(BaseEmployee e) {
        if (e instanceof Staff) {
            ((Staff) e).work();
        } else if (e instanceof Manager) {
            ((Manager) e).manage();
        }
    }
}