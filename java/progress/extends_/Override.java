package progress.override_;
/**
 * 关于方法重写
 * @auther NixAutumna
 */
public class Override {
    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.cry();
    }
}

/*
方法重写，又叫方法覆盖
简单来说，方法重写就是子类有一个方法A
他和父类（或祖宗类） 的一个方法B的名称、返回类型、参数都一样
那么说A覆盖（重写）了B

首先注意：参数、方法名要一致，返回类型一致或是父类返回类型的子类
且子类方法不能缩小父类方法的访问权限
 */
class BaseAnimal {
    public void cry() {
        System.out.println("动物叫");
    }
}

class Dog extends BaseAnimal {
    public void cry() {
        System.out.println("汪汪汪");
    }
}