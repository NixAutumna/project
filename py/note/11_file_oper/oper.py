# coding   : utf-8
# @Version : 1.0
# @Author  : NixAutumna
# @File    : oper.py
# @Time    : 2024/8/10 19:48
import os.path
import time

# 储存数据的叫做文件
# 从文件到内存叫输入(input/I)
# 从内存到文件叫输出(output/O)
# 通常I/O分为文本I/O和二进制I/O
# 文本文件通常是记事本可以查看的如.py  .txt
# 二进制文件包括图片,音视频等,需要专门工具打开
# 处理不同类型文件时需要用对应方式打开处理
# 文件编码规定如何将可识别内容与二进制代码互相转化

# open函数可以打开file并返回对应的file object,打不开报OSError
# open(file, mode='r', buffering=-1, encoding='utf-8')file表示文件路径,可以是相对路径或绝对路径
# mode是文件打开模式,buffing是缓冲,encoding指定编码方式

# 用mode='w'调用open可以在目录存在的前提下创建文件,若该文件已经存在则覆盖原有文件创建一个新文件
f1 = open("x:/project/py/Notes/11_file_oper/f1.txt", 'w', encoding='utf-8')
print(f"创建文件{f1}\t{type(f1)}")
f1.close()

# 用mode='r'调用open可以在文件存在的前提下打开文件
f2 = open("x:/project/py/Notes/11_file_oper/f2.txt", 'r', encoding='utf-8')
content = f2.read()  # 这种方式读取全部文件,read方法可以传入参数表示读取几个字符(换行符也算)
print(content)
content = f2.readline()  # 这种方式一次读一行包括行末换行符
print(content, end='')
content = f2.readlines()  # 以行作为元素把整个文件当做列表返回
for line in content:
    print(line, end='')
for line in f2:
    print(line, end='')
f2.close()

# 写入文件,mode='a',表示在文件末尾追加
f3 = open("x:/project/py/Notes/11_file_oper/f1.txt", 'a', encoding='utf-8')
for i in range(10):
    f3.write("NixAutumna\n")
f3.close()

if os.path.exists("x:/project/py/Notes/11_file_oper/f1.txt"):  # 判断文件是否存在
    os.remove("x:/project/py/Notes/11_file_oper/f1.txt")  # 删除文件

if not os.path.isdir("x:/project/py/Notes/11_file_oper/d1"):  # 判断目录存在
    os.mkdir("x:/project/py/Notes/11_file_oper/d1")  # 创建一个单级目录

if not os.path.isdir("x:/project/py/Notes/11_file_oper/d2/d"):  # 判断目录存在
    os.makedirs("x:/project/py/Notes/11_file_oper/d2/d")  # 创建一个多级目录

if os.path.isdir("x:/project/py/Notes/11_file_oper/d1"):  # 判断目录存在
    os.rmdir("x:/project/py/Notes/11_file_oper/d1")  # 创建一个单级目录

if os.path.isdir("x:/project/py/Notes/11_file_oper/d2/d"):
    os.removedirs("x:/project/py/Notes/11_file_oper/d2/d")  # 删到不是空目录为止

f4 = os.stat("x:/project/py/Notes/11_file_oper/f2.txt")
print(f"文件大小{f4.st_size}\n最近访问时间{time.ctime(f4.st_atime)}\n"
      f"最近修改时间{time.ctime(f4.st_mtime)}\n创建时间{time.ctime(f4.st_ctime)}")  # time.ctime将返回的秒数转为正常格式的时间

# 当调用write()方法时并不直接写入文件而是写入缓冲区
# 通过flush()方法可以强制写入文件
# 使用close()的时候会执行flush功能
# 通过with open(...) as f:可以在字句中对文件当做f操作并在最后关闭文件
