# -*- coding: UTF-8 -*-
"""
@Description  ：简单面向对象
@Author       ：NixAutumna
@CreateDate   ：2024/8/21 22:45
"""

# 一个类相当于一个数据类型,当类被具体化后成为实例
class C:
    name = None  # 定义在类中的变量称为属性

    def __init__(self, age):  # 构造方法/构造器,在初始化对象时自动调用,和方法一样构造方法也不能重载,构造方法无返回值
        self.age = age  # 在构造函数动态生成属性
        print("init")

    def aa(self, a):  # 成员方法,参数列表需要有一个self表示当前对象,在调用时隐式的传入,用self访问成员变量
        print(self.name)

    # 以下对象bool值为False
    # False
    # 0
    # None
    # 空字符串
    # 空列表
    # 空字典
    # 空元组
    # 空集合

    __address = "xx.123"  # 在变量名或方法名的前面加上__可以让变量或方法变成私有的,即只能在类内部访问

    def __bb(self):
        print(self.__address)

    def cc(self):  # 通过公有的方法调用,这种把部分属性方法设为私有并提供公有方法访问的方式叫做封装
        self.__bb()


c = C(3)
c.aa(1)
# 由于python会动态创建属性,所以会出现以下伪私有属性的情况,但是这是一个全新的address,和在类中的address不同
c.__address = 1
print(c.__address)
c.cc()


class Father:  # 当多个类存在共同属性/方法时可以将重复部分抽象成父类又称基类,这样子类(派生类)不用再定义这些方法,object是所有类的父类
    __aa = "a"
    a = "b"

    def __init__(self, b, c):
        self.b = b
        self.c = c

    def aa(self):
        print(self.a)


class Father2:
    a = "c"


class Son(Father, Father2):  # 通过子类名(父类名)实现继承,python可以多继承,当多个父类存在同名时优先使用靠左的
    a = 1  # 子类重新定义父类属性或者方法称为重写或覆盖

    def __init__(self, b, c, d):
        super().__init__(b, c)  # 当父类和子类有相同方法时需要用super().xx调用父类的xx
        Father.aa(self)  # 或通过父类名访问但是这时访问方法需要传入self
        self.d = d

    def aa(self):
        print(self.a)  # 子类可以调用父类的非私有方法和属性


son = Son(4, 2, 3)
son.aa()

# 类型注解可以提示变量的类型,当不遵守时不报错但有警告
# 语法:    变量: 类型
a: int = 234
b = 11.23  # type:float


def aaaaaaa(s: str) -> int:  # 形参列表中用变量:类型,加箭头表示返回值类型
    return ord(s)


from typing import Union

d: Union[int, str] = 1  # 表示int或str
d = "d"


# 不同对象调用相同方法表现不同状态称为多态
# 多态作用多在继承关系上
# 多态的关键是子类对象可以传递给父类类型
# python的方法参数并没有严格类型限制,所以他的多态并不严谨
# python中的多态并不着重于类型本身,更侧重于是否有要调用的方法
class AAA:
    def aaa(self):
        print("aaa")


class BBB(AAA):
    def aaa(self):
        print("bbb")


class CCC(AAA):
    def aaa(self):
        print("ccc")


def output(a: AAA):
    a.aaa()


bbb = BBB()
ccc = CCC()
output(bbb)
output(ccc)  # 传统意义的多态


class AAAA:
    def aaa(self):
        print("aaaa")


def out(obj):
    obj.aaa()


aaa = AAA()
aaaa = AAAA()
out(aaa)
out(aaaa)  # 变种多态


# isinstance(obj,?)可以判断obj是不是?类型或?的子类类型,若?为元组则其中之一满足前述规则即可
# 调用对象成员时,会和对象本身动态关联


# 形如__xxx__的方法称为魔术方法,其在类或对象某些事件发生时会自动执行
# 运算符,for循环,类操作都基于魔术方法
# 常见魔术方法及对应功能
# __init__          初始化对象的成员
# __str__(self)     对象转为字符串时的行为:print(obj)或str(obj)
# __eq__(self,other)定义等号的行为:self == other
# __lt__(self,other)定义小于号的行为:self < other
# __le__(self,other)定义小于等于号的行为:self <= other
# __ne__(self,other)定义不等号的行为:self != other
# __gt__(self,other)定义大于号的行为:self > other
# __ge__(self,other)定义大于等于号的行为:self >= other


# 当类被创建后,他本身成为一个class对象
class CCC:
    a = 1

    def aa(self):
        print("aa")

    @staticmethod
    def bb():  # 加入@staticmethod声明一个静态方法,静态方法不需要self
        print("bb")


print(CCC.a)  # 类本身做对象使用
CCC.aa(CCC)
CCC.bb()  # 调用静态方法
CCC().bb()  # CCC()相当于匿名地实例化了CCC

# 抽象类
# 默认情况下python没有抽象类
# 模块abc下ABC类为定义抽象基类提供基础
# 只要继承ABC并用@abstractmethod声明抽象方法则这个类为抽象类
# 抽象类不能实例化
from abc import ABC
from abc import abstractmethod


class Abs(ABC):
    @abstractmethod
    def fun(self):
        pass

    def fun2(self):  # 抽象类中可以有普通方法需要用子类调用
        print("f2")


class Spe(Abs):
    def fun(self):
        print("f")  # 若子类不实现抽象方法则子类也是抽象类
