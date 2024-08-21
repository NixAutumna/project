package progress.poly;

/**
 * @Description : 关于多态数组
 * @Author : NixAutumna
 * @CreateTime : 2024/8/21 22:45
 */

public class PloyArray {
    public static void main(String[] args) {
        Person[] people = new Person[3];
        people[0] = new Student("NixAutumna", 13, 800);
        people[1] = new Teacher("Violet", 13, 50000.99);
        people[2] = new Person("ers", 1, 1);
        for (int i = 0; i < people.length; i++) {
            if (people[i] instanceof Student) {
                Student student = (Student) people[i];
                student.doing();
                // 或者
                ((Student) people[i]).doing();
            } else if (people[i] instanceof Teacher) {
                Teacher teacher = (Teacher) people[i];
                teacher.did();
                // 同理也可以
                ((Teacher) people[i]).did();
            } else {
                System.out.println("" + people[i].getAge() + people[i].getName() + people[i].getSalaryOrScore());
            }
        }
    }
}

class Person {
    private String name;
    private int age;
    private double salaryOrScore;
    
    public Person(String name, int age, double salaryOrScore) {
        this.name = name;
        this.age = age;
        this.salaryOrScore = salaryOrScore;
    }
    
    public String getName() {
        return name;
    }
    
    public int getAge() {
        return age;
    }
    
    public double getSalaryOrScore() {
        return salaryOrScore;
    }
}

class Student extends Person {
    public Student(String name, int age, double salary) {
        super(name, age, salary);
    }
    
    public void doing() {
        System.out.println(getName() + " is " + getAge() + " years old ,he's score is " + getSalaryOrScore());
    }
}

class Teacher extends Person {
    public Teacher(String name, int age, double score) {
        super(name, age, score);
    }
    
    public void did() {
        System.out.println(getName() + " is " + getAge() + " years old ,she's Salary is " + getSalaryOrScore());
    }
}