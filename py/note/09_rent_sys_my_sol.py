# -*- coding: UTF-8 -*-
"""
@Description  ：房屋出租系统作业
@Author       ：NixAutumna
@CreateDate   ：2024/8/21 22:45
"""

main_face = """
===========房屋出租系统菜单===========
           1 新 增 房 源
           2 查 找 房 屋
           3 删除房屋信息
           4 修改房屋信息
           5 房 屋 列 表
           6 退      出
请选择(1-6):
"""


class House:
    def __init__(self, name: str, tel: int, address: str, price: int, state: str):
        self.name = name
        self.tel = tel
        self.address = address
        self.price = price
        self.state = state

    def __str__(self):
        return f"{self.name}\t{self.tel}\t{self.address}\t{self.price}\t{self.state}"


houses = []


def main():
    i = int(input(main_face))
    if 1 <= i <= 6:
        return i
    else:
        print("请输入1-6的整数")
        return main()


def add():
    print("===========添加房屋===========")
    name = input("姓名:")
    tel = int(input("电话:"))
    address = input("地址:")
    price = int(input("价格:"))
    state = input("状态:")
    print("===========添加成功===========")
    houses.append(House(name, tel, address, price, state))


def find():
    print("===========查找房屋===========")
    i = int(input("请输入需要查找的id:"))
    if 1 <= i <= len(houses):
        print("编号\t房主\t电话\t地址\t月租\t状态")
        print(f"{i}\t{str(houses[i - 1])}")
    else:
        print("你查找的id不存在")
        find()


def delite():
    print("===========删除房屋===========")
    i = int(input("请输入需要删除的房屋编号(-1退出):"))
    if i == -1:
        return
    elif 1 <= i <= len(houses):
        b = input("请确定(y/n)")
        if b == "y":
            del houses[i - 1]
            print("===========删除成功===========")
        else:
            delite()
    else:
        print("你查找的id不存在")
        delite()


def change():
    print("===========更改房屋===========")
    i = int(input("请输入需要修改的房屋编号(-1退出):"))
    if i == -1:
        return
    elif 1 <= i <= len(houses):
        name = input(f"姓名({houses[i - 1].name}):")
        tel = int(input(f"电话({houses[i - 1].tel}):"))
        address = input(f"地址({houses[i - 1].address}):")
        price = int(input(f"租金({houses[i - 1].price}):"))
        state = input(f"状态({houses[i - 1].state}):")
        houses[i - 1] = House(name, tel, address, price, state)
        print("===========更改成功===========")
    else:
        print("你查找的id不存在")
        change()


def display():
    print("===========房屋列表===========")
    print("编号\t房主\t电话\t地址\t月租\t状态")
    for i in range(len(houses)):
        print(f"{i + 1}\t{str(houses[i])}")
    print("===========列表结束===========")


def out():
    b = input("请确定(y/n)")
    if b == "y":
        print("已退出")
        return False
    else:
        return True


if __name__ == '__main__':
    con = True
    while con:
        a = main()
        if a == 1:
            add()
        elif a == 2:
            find()
        elif a == 3:
            delite()
        elif a == 4:
            change()
        elif a == 5:
            display()
        else:
            con = out()
