# -*- coding: UTF-8 -*-
"""
@Description  ：程序控制结构相关
@Author       ：NixAutumna
@CreateDate   ：2024/8/21 22:45
"""

# 顺序控制:从上倒下按序执行,定义变量时采用合法的前向引用


# 分支控制:让程序有选择的执行

# 单分支:通过
#     if (condition):
#         statements
# 做到当condition=True时执行statements,python通过缩进区分代码块
if 4 > 1:
    print("4>1")

# 双分支:通过
#     if (condition):
#         statements
#     else:
#         statements1
# 做到当condition=True时执行statements,相反时执行statements1
if float(input()) > float(input()):
    print(">")
else:
    print("<")

# 多分支:通过
#     if (condition):
#         statements
#     elif (condition1):
#         statements1
#     ...
#     elif (coditioni):
#         statementsi
#     ...
#     else:
#         statementsn
# 做到当coditioni为True时执行statementsi,都不满足执行statementsn,若多个codition同时满足则执行statementsmin

# 嵌套分支:在分支结构中又嵌套一个分支结构
# 里面的分支称为内层分支,外面称为外层分支


# 循环结构

# for循环
# for x in sequence:
#     statements
# x遍历sequence,顺次从sequence中取出值赋给x
for i in "abc":
    print(i + " ")
# range(start, stop, step)是一个以start为第一个元素,下一个元素比上个元素多step,最后一个元素恰小于stop的序列
# start,stop,step为int,start默认为0,step默认为1
print(list(range(1, 11, 3)))
# for x in sequence:
#     statements
# else:
#     statements1
# 当for因为sequence没值可取而循环时执行statements1
for i in range(10):
    print(i)
    # if i == 9:
    #     break
    # 执行上面语句则无法输出finish
else:
    print("finish")

# while循环
# while condition:
#     statements
# 当condition为True时执行statements
# 同样可以在后面加入else
# while condition:
#     statements
# else:
#     statements1
# 当condition为False时执行statement1
i = 1
while i <= 10:
    print(i)
    if i == 9:
        break
    i += 1
else:
    print("finish")

# 嵌套循环:在循环结构中又嵌套一个循环结构
# 里面的循环称为内层循环,外面称为外层循环
# 打印n层金字塔
n = int(input("层数"))
for i in range(n):
    if i == 0:
        for j in range(n - 1):
            print(" ", end="")
        print("*")
    elif 0 < i < n - 1:
        for j in range(n - i - 1):
            print(" ", end="")
        print("*", end="")
        for j in range(2 * (i - 1) + 1):
            print(" ", end="")
        print("*")
    else:
        for j in range(2 * n - 2):
            print("*", end="")
        print("*")

# break跳出最近循环体以及他的else部分(如有)
# for循环被break后循环的控制变量保持当前值

# continue结束最近循环体本次循环进入下一次循环(如有)

# return跳出函数
