# coding   : utf-8
# @Version : 1.0
# @Author  : NixAutumna
# @File    : file1.py
# @Time    : 2024/8/6 23:44

__all__ = ["f1", "f2"]  # 规定from 模块名 import *时导入哪些函数变量或类


def f1():
    print("f1")


def f2():
    print("f2")


def f3():
    print("f3")


if __name__ == "__main__":  # __name__在模块不作为主程序运行时为模块名,作为主程序运行时为__main__
    f1()
    f2()
f1()  # 会在导入模块时执行
