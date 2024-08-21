# -*- coding: UTF-8 -*-
"""
@Description  ：关于数据容器
@Author       ：NixAutumna
@CreateDate   ：2024/8/21 22:45
"""

# 数据容器或称容器是一种数据类型
# 数据容器可以存放多个数据,每个数据被称作元素
# 存放的数据或称元素可以是任意类型

# list是可以存放多个数据的数据类型,是可变数据类型,其中数据是有序,可重,不定类型的
# 定义方式 list1 = [ele0, ele1, ..., elei, ..., elen]
# [], list()可以创建空列表
# 使用方式 ele = list1[index] 当index为i时ele = elei,index称为索引或下标,从最左边为0
# 向右依次增大,或从最右边为-1向左依次减小
# len(object)可以返回object的长度当object为容器
l = [1, 23.4, ["nix", True]]
print(l[2], type(l))
l[0] = "autumna"  # 通过此方法可以改变指定元素的值
print(l)
l.append([1, 2])  # 通过此方法在列表末尾增加元素
print(l)
del l[2]  # 通过此方法删除元素
print(l)


# 列表是可变数据,改变内容时不改变地址,这意味着当两个标识符指向同一个列表时,通过其中一个
# 标识符进行的操作可以通过另一个标识符体现
def aa(a):
    a[0] = 0


aa(l)
print(l)

# 列表生成式
# [f(x) for x in seq]可以生成一个列表
print([x ** 2 for x in range(7)])

# tuple可以存放多个不同类型数据,是不可变数据类型,其中数据是有序,可重,不定类型的
# 定义方法tuple1 = (ele0, ele1, ..., elei, ..., elen)
# (), tuple()可以创建空元组
# 使用方式 ele = tuple1[index] 当index为i时ele = elei,index称为索引或下标,从最左边为0
# 向右依次增大,或从最右边为-1向左依次减小
# 如果元组中存放了列表,则列表内的内容是可变的
# 定义单元素元组需要(ele,)的格式,在数据后需要带逗号否则不是元组
# 元组相比列表的优势:
# #1)在项目中,尤其是多线程环境中,有经验的程序员会考虑使用不变对象(一方面因为对象状态不能修改，所以可以避
# 免由此引起的不必要的程序错误:另一方面一个不变对象自动就是线程安全的，这样就可以省掉处理同步化的开销。可
# 以方便的被共享访问)。所以，如果不需要对元素进行添加、删除、修改的情况下，可以考虑使用元组
# 2)元组在创建时间和占用的空间上面都优于列表
# 3)元组能够对不需要修改的数据写保护


# str用于处理文本数据称为字符串,是由Unicode码组成的不可变序列,ord(char)可以返回char字符对应的Unicode码,相反可以使用chr(num)
# 02_variable中有字符串定义的相关方式
# "", str()可以创建空字符串
# str1[index]可以访问字符串中的字符,index称为索引或下标,从最左边为0
# 向右依次增大,或从最右边为-1向左依次减小
# 两个字符串可以比较,比较时从左到右依次比较码值若相等则比较下一个


# 对连续有序的支持索引的序列取出一个子序列叫做切片
# seq[start:end:step]表示在seq中从start取第一个再去后step个以此类推直到取到的值恰不超过end
# start默认为0,end默认为len(seq),step默认为1
# 步长可以为负数,表示反向取,这时start和end也需反向(使用负数的标记方法)
# 切片操作生成新序列并不影响原序列


# set是一种由不重复元素组成的无序容器
# 定义方法set1 = {ele0, ele1, ..., elei, ..., elen}
# 当定义时有重复元素会自动去除,取出时顺序和定义时顺序可能不同,但是每次取出的顺序相同
# 用for可以遍历set
# set()创建空集合, {}创建的是空字典
# len()可以返回集合长度
# ele in set检测ele是否是set中的元素
# add()加入元素,remove()移除元素
# union()求并集
# intersection()求交集
# set.difference(set2)求set2在set中的补集
# 集合的二元运算 | 求并集  & 求交集  - 求补集(或称差集)
# 类似列表集合也可以用生成式,不过需要注意生成的是无序的


# dict是一种储存key-value映射关系的容器
# 定义方法dict1 = {key0: value0, key1: value1, ..., keyi: valuei, ..., keyn: valuen}
# {}, dict()可以获得空字典
# 使用方法 valuei = dict1[keyi]
# key通常使用字符串或数字(必须是不可变类型且若为元组则元组中存放的也要是不可变类型),value可以是任何数据类型
# key是不重复的否则后面的值会覆盖前面的
# 字典不支持索引,需要用for遍历,for遍历时取出的是key,3.6版本后字典有序
dict1 = {
    "a": {1, 2, 3},
    "b": (1, 4, 2),
    "c": ["a", (1, 4)],
    "d": {"a": 1, "b": 2},
    "e": 2,
    "f": 213.44,
    "g": "asfa"
}
for i in dict1:
    print(i, type(i), dict1[i], type(dict1[i]))  # 单纯for取出的是key
print("-" * 40)
for i in dict1.values():
    print(i, type(i))  # 这样遍历value
print("-" * 40)
for i, j in dict1.items():
    print(i, type(i), j, type(j))  # 这样遍历键值对
# 通过dict[key]=value创建一个新键值对或者覆盖之前已有的键值对
dict1["a"] = 1
dict1["h"] = 5
print(dict1)
del dict1["h"]  # 删除键值对
print(dict1)
a = [1, 3, 4]
b = [1, 63, 2]
print({i: j for i, j in zip(a, b)})  # zip()返回两个列表索引相同的元素构成元组构成的列表


# 数据类型根据变量值变化时内存地址是否变化分为可变数据类型和不可变数据类型
# 不可变数据类型:int,float,bool,str,tuple
# 可变数据类型:list,set,dict
