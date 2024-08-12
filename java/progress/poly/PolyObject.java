package progress.poly;

/**
 * 关于对象的多态
 * @auther Bai_YiA2
 */
public class PolyObject {
    /*
    对象的多态，一个对象的编译类型和运行类型可以不一致
    编译类型在定义对象的时候就确定了，不可以改变
    运行类型可以变化
    编译类型看定义时“=”的左边，运行类型看“=”右边
     */
    public static void main(String[] args) {
        /*
        多态的向上转型
        本质：父类的引用指向了子类的对象
        语法：父类类型 引用名 = new 子类类型();
        可以调用父类中的所有成员（在遵守访问权限的前提下）
        不能调用子类特有成员
        运行效果看子类的具体实现，调用方法的时候先从子类开始查找
         */
        BaseAnimal dog = new Dog("little yellow");
        BaseFood bone = new Bone("big bone");
        BaseAnimal cat = new Cat("big white");
        BaseFood fish = new Fish("delicious fish");
        Feed feed = new Feed();
        feed.feed(dog, bone);
        feed.feed(cat, fish);
        
        /*
        多态的向下转型
        语法：子类类型 引用名 = (子类类型) 父类引用
        只能强转父类的应用，不能强转父类的对象
        要求父类的引用必须指向当前目标类型的对象
        可以调用子类的所有成员
         */
        BaseAnimal nini = new Cat("nini");
        // 此时如果想调用cat的eatMouse方法
        // nini.eatMouse;直接这样会报错Cannot resolve symbol 'eatMouse'
        // 需要将编译类型将nini转成Cat类，就可以调用了
        Cat catNini = (Cat) nini;
        catNini.eatMouse();
        // 要求父类的引用必须指向当前目标类型的对象!!
        // 也就是说，nini在分配空间的时候运行类型必须是Cat
        
        // 属性没有重写之说，属性的值看编译类型
        BaseAnimal dog1 = new Dog("a dog");
        System.out.println(dog1.num);// 编译类型是BaseAnimal所以是0
        BaseAnimal animal = new BaseAnimal();
        System.out.println(animal.num);// 编译类型是BaseAnimal所以是0
        Dog dog2 = new Dog("dog");
        System.out.println(dog2.num);// 编译类型是Dog所以是1
    }
}

//使用食物喂食动物
class BaseFood {
    private String name;
    
    public String getName() {
        return name;
    }
    
    public BaseFood(String name) {
        this.name = name;
    }
}

class BaseAnimal {
    private String name;
    
    public BaseAnimal() {
    }
    
    public String getName() {
        return name;
    }
    
    public BaseAnimal(String name) {
        this.name = name;
    }
    
    public int num = 0;
}

class Feed {
    public void feed(BaseAnimal animal, BaseFood food) {
        System.out.println(animal.getName() + " eat " + food.getName());
    }
}

class Dog extends BaseAnimal {
    public Dog(String name) {
        super(name);
    }
    public int num = 1;
}

class Cat extends BaseAnimal {
    public Cat() {}
    public Cat(String name) {
        super(name);
    }
    public void eatMouse() {
        System.out.println(getName() + " eat a mouse");
    }
}

class Bone extends BaseFood {
    public Bone(String name) {
        super(name);
    }
}

class Fish extends BaseFood {
    public Fish(String name) {
        super(name);
    }
}

class Husky extends Dog {
    public Husky() {
        super("a husky");
    }
}