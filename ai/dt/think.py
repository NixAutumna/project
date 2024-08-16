#!/usr/bin/env python3
# -*- coding: utf-8 -*-

import rclpy  # ROS2 Python接口库
from rclpy.node import Node  # ROS2 节点类
from geometry_msgs.msg import Twist  # 字符串消息类型

"""
创建一个发布者节点
"""


class PublisherNode(Node):

    def __init__(self, name):
        super().__init__(name)  # ROS2节点父类初始化
        self.pub = self.create_publisher(Twist, "cmd_vel", 10)  # 创建发布者对象（消息类型、话题名、队列长度）
        self.timer = self.create_timer(2.0, self.timer_callback)  # 创建一个定时器（单位为秒的周期，定时执行的回调函数）
        self.count = 0

    def timer_callback(self):  # 创建定时器周期执行的回调函数
        msg = Twist()  # 创建一个String类型的消息对象
        msg.linear.x = 0.3
        msg.angular.z = 1.0 if self.count % 2 == 0 else -1.0
        self.pub.publish(msg)  # 发布话题消息
        self.get_logger().info(f"{self.count}  publishing:{msg.linear.x}  {msg.angular.z}")  # 输出日志信息，提示已经完成话题发布
        self.count += 1


def main(args=None):  # ROS2节点主入口main函数
    rclpy.init(args=args)  # ROS2 Python接口初始化
    node = PublisherNode("think")  # 创建ROS2节点对象并进行初始化
    rclpy.spin(node)  # 循环等待ROS2退出
    node.destroy_node()  # 销毁节点对象
    rclpy.shutdown()  # 关闭ROS2 Python接口
