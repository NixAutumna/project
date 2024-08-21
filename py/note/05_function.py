# -*- coding: UTF-8 -*-
"""
@Description  ：关于函数
@Author       ：NixAutumna
@CreateDate   ：2024/8/21 22:45
"""

# 为了完成某一个功能的程序指令集合称为函数
# 函数包括系统函数和自定义函数
# def name(parameter):
#     statements
#     return ret
# parameter是函数参数,(parameter)称为形参列表,形参列表可以有多个参数例如(a, b, c)
# 返回值是ret,没有return语句相当于ret=None
def aa(a, b):
    print(a + b)


# 函数定义后需要调用才会执行
# 通过name(parameter)调用,(parameter)称为实参列表
print(aa(1, 4))


# 在存在同名函数时调用离调用语句最近的函数,函数不可以重载
# 一般情况实参个数和顺序要和形参一样称为位置参数


# 函数可以返回多个值例如return a, b
def bb(a, b):
    return a, b


x, y = bb(1, 2)
print(x, y)
# 调用时用name(形状名=实参)的方式可以不按顺序传入实参,称为关键字参数
x, y = bb(b=2, a=1)
print(x, y)


# 在形参列表可以通过(形参名=默认值)指定当该形参不被传入时的默认值,称为默认参数或缺省参数,需要放在参数列表后面
def cc(a, b=3):
    return a, b


print(cc(1))


# 通过(*形参名)可以接受不定长的实参列表,称为可变参数或不定长参数,若传入位置参数则储存在tuple
def dd(*args):
    print(args, type(args))


dd(2, 3)


# 如果被用关键字参数传入则存在dict且形参列表需改成(**形参名)
def ee(**args):
    print(str(args), type(args))


ee(a=1, b=2)


# 对传入的字符串或数值,函数内的变动不影响函数外的值
def ff(a):
    a += 1
    print(a)


x = 1
ff(x)
print(x)


# 在函数中调用本函数叫做递归
# 每执行一次函数会开一个新栈空间
# 每个函数中的变量是独立的
# 函数执行完毕或执行到return时会返回,谁调用就把结果返回给谁
# 函数同样可以当做参数传入函数
# 通过def定义的函数是有名称的可以重复使用
# 通过lambda定义只使用一次的匿名函数
# lambda 不需要括号的形参列表 : 一行语句,不需要return,该语句的结果就是返回值
def gg(fun, a, b):
    return fun(a, b)


print(gg(lambda a, b: a if a > b else b, 1, 2))

# 定义在函数外的变量在整个程序范围内都可以使用有全局作用域称为全局变量
# 定义在函数内的变量只能在函数范围内使用拥有局部作用域称为局部变量
n1 = 100  # 全局变量


def hh():
    n1 = 200  # 局部变量
    print(n1)  # 当函数内外变量重名的时候就近匹配


def ii():
    global n1  # global表明使用全局变量n1
    n1 = 200
    print(n1)


print(n1)
