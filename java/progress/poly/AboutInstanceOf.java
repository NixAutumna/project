package progress.poly;
/**
 * 关于instanceof
 * @auther Bai_YiA2
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
