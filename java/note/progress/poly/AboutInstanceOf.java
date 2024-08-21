package progress.poly;

/**
 * @Description : 关于instanceof
 * @Author : NixAutumna
 * @CreateTime : 2024/8/21 22:45
 */

public class AboutInstanceOf {
    public static void main(String[] args) {
        // instanceof 比较操作符，判断对象类型是否是某类型或某类型的子类型
        Dog dog = new Dog("dog");
        System.out.println(dog instanceof Dog);
        System.out.println(dog instanceof Object);
        System.out.println(dog instanceof BaseAnimal);
        System.out.println(dog instanceof Husky);
        
    }
}
