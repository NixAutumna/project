# -*- coding: UTF-8 -*-
"""
@Description  ：关于异常处理
@Author       ：NixAutumna
@CreateDate   ：2024/8/21 22:45
"""

# 错误分为语法错误和异常
# 语法错误在编译前可以发现
# 异常是在执行时检测到的错误
# 但是语法错误也继承了异常
# 出现异常会导致程序崩溃
# 需要异常处理方法

try:
    # 可能出现异常的代码,在异常发生后直接进入except字句
    print(6 / 0)
except ZeroDivisionError:  # 希望出现什么异常或什么都不写表示全部异常,可以在后面as 别名然后通过别名调取异常信息
    # 当有多个异常捕获字句时一旦一个捕获成功不执行后面的expect字句,如果全部expect都不合适则执行完finally后崩溃
    print("error")
except (NameError, FileNotFoundError) as e:  # 可以一次捕获多种异常
    pass
else:
    # 在没有异常的情况怎么执行,可以不写
    pass
finally:
    # 在执行完except或else后执行的代码,可以不写
    pass

# raise可以主动触发异常
try:
    raise Exception("异常信息")
except Exception as e:
    print(f"{e}    {type(e)}")


# 未处理的异常会抛给调用者
def f1():
    print(10 / 0)


try:
    f1()
except ZeroDivisionError:
    pass


# 通过新建异常类来自定义异常,异常需要直接或间接继承Exception
# 异常类需要简单,提供与异常相关的属性,以Error结尾命名
class AError(Exception):
    pass
