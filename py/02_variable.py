# coding   : utf-8
# @Version : 1.0
# @Author  : NixAutumna
# @File    : 02_variable.py
# @Time    : 2024/7/30 14:33
import sys
from decimal import Decimal

# 标识符规则及规范
# 对对象命名的字符串叫标识符
# 规则:
# 由26个英文字母大小写,0-9,_组成
# 不可以用数字开头
# 不可以使用关键字,但可以包含
# 区分大小写
# 不能有空格
# 规范:
# 类名用大驼峰命名
# 字母小写,多个单词用下划线连接
# 常量全部大写
# 私有函数用两个下划线开头

# 关键字:
# False               class               from                or
# None                continue            global              pass
# True                def                 if                  raise
# and                 del                 import              return
# as                  elif                in                  try
# assert              else                is                  while
# async               except              lambda              with
# await               finally             nonlocal            yield
# break               for                 not


# 输出方式
a = 11345
b = "a"
c = 2134.29
d = "job"
# 1.用%输出
# 格式:print("...%?..." %(n))
# 效果:...n...
# ?代表一个字符,由n的类型决定
# 整数->%nd(n决定有几个字母的长度,如果n短于变量长度没作用,在n前面+0让多的位用0填充,如果不以0开头多的位数用空格填充);字符串->%s;%%输出一个%号
# 浮点数->%nf(n决定有几个字母的长度(小数点也算1个),如果n短于变量长度没作用,在n前面+0让多的位用0填充,如果不以0开头多的位数用空格填充,如果n前面带.则表示保留几位小数(四舍五入)
print("%06d %s %.1f %s" % (a, b, c, d))

# 2.用format()
# 格式:print("...{}...".format(n))
# 效果:...n...
print("{} {} {} {}".format(a, b, c, d))

# 3.用f-string
# 格式:print(f"...n...")
# 效果:...n...
print(f"{a} {b} {c} {d}")


# 输入方式
# 用input()可以接受不包括换行符的一行输入作为字符串,参数可以传入一个字符串作为输入提示


# 变量三要素:类型+名字+值
# 用type(x)输出x的类型
a = 1
print("a =", a, "类型", type(a))

# 变量先赋值后使用
# 类型指内存具体储存的值

# int
# int存储整数,最大长度是4300个数字
print(9 ** 888)
# 不同进制通过在数字前加入0n(n在不同进制用不同字母,不区分大小写)表示,输出时默认转成10进制
print(0x1AB4)  # 0x为前缀在后面写十六进制数字,字母不区分大小写
print(0o1532)  # 0o为前缀在后面写八进制数字
print(0b1011)  # 0b为前缀在后面写二进制数字
# python中int所占空间随数字增大而增大,最小占24[可能有版本差异,现在是28]字节,每次变大4字节
# 用sys.getsizeof()返回对象所占空间大小
print(sys.getsizeof(0))
print(sys.getsizeof(1))
print(sys.getsizeof(2))
print(sys.getsizeof(2 ** 128))
print(sys.getsizeof(2 ** 1024))

# float
# float存储小数
print(type(5.1))
print(type(.51))  # 整数部分为0时0可省略
print(type(3.53e-4))  # aeb表示ax10^b,e不区分大小写
print(f"浮点存储范围是{sys.float_info.min}到{sys.float_info.max}")  # 即2.2250738585072014e-308到1.7976931348623157e+308
print(8.1 / 3)  # 浮点运算会造成精度损失
print(Decimal("8.1") / Decimal("3"))

# bool
# bool存储True或False
print(1 > 2)
# bool和其他类型比较时True视为1,False视为0
print(1 == True)
print(0 == False)
if 0:
    print()
else:
    print("0被视为False")
if -1:
    print("非0值视为True")

# str
# str储存一串字符
print(type("1a"))  # 用""包裹起来表示str
print(type('as'))  # 用''包起来也表示str
print(type("say 'hi'"))  # 可以在"中正常使用'反之一样
print("str" + "ing")  # +可以拼接字符串
print(type('a'))  # python中没有char,单字符被视为str
print("""
   asfda as:"'24./)(&*&^*%#$#$&!~$
faef adfea,s.e  
we       dax
""")  # 用三个引号包裹可以使字符串按原样输出
# 在字符串前面加r可以让字符串内容中转义符不起作用
print(r"apple\table\nobody\run")
print("apple\table\nobody\run")
# 说明:Python仅保存一份相同且不可变字符串，不同的值被存放在字符串的驻留池中，Python的驻留机制对相同的字符
# 串只保留一份拷贝，后续创建相同字符串时，不会开辟新空间，而是把该字符串的地址赋给新创建的变量'
s1 = "aa"
s2 = "aa"
print(id(s1) == id(s2))  # id返回对象的内存地址
# 当满足下列其一时(pyCharm有改动,以下对原生python适用):
# 1.字符串由26个英文字母大小写,0-9,_组成;
# 2.字符串长度为0或1;
# 3.是由[-5,256]的整数数字组成
# 且在运行前可确定具体值时,出现驻留机制
# 好处:当需要值相同的字符串时，可以直接从字符串池里拿来使用，避免频繁的创建和销毁，提升效率和节约内存


# 类型转换方式
# 隐式类型转换:
# 1.随着值的变化而变化;
# 2.运算时自动向高精度转化
a = 1
a = 1.1
a = 'a'
a = 1
a = 0.1 + a

# 显示类型转换,用类型名作为函数名传入其他类型参数返回类型为函数名的值,不影响原变量的类型
print(type(str(1)))  # int,float都可以转为str,反之需要str形式上和结果类型一致
print(type(float(1)))  # int转float会增加.0
print(type(int("1")), int(1.9))  # float转int忽略小数部分

# 数值和字符串是不可变数据类型,数据改变时内存地址相应改变
