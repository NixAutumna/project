# -*- coding: UTF-8 -*-
"""
@Description  ：关于模块
@Author       ：NixAutumna
@CreateDate   ：2024/8/21 22:45
"""

# 模块是一个以.py作为后缀的py文件
# 模块可以定义函数,类和变量,模块里可以包含可执行代码
# 模块有利于更好的管理项目
# 导入模块格式:
# 1.import 模块名              使用时:模块名.xx    xx表示函数或类或变量名
# 2.from 模块名 import xx      使用时:xx(直接使用)  xx表示函数或类或变量名
# 3.from 模块名 import *       可以直接使用模块中所有变量函数类
# 4.在以上方法末尾加上as别名则使用时import后面的标识符将替换成别名
import file1
import file2
file1.f1()
file2.f1()


from file1 import f1
f1()


from file1 import *  # 这时无法执行f3()
f1()


from file1 import f2 as a
a()  # 这时调用file1.f2
