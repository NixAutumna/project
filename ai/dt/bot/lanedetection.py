#!/usr/bin/env python3
# -*- coding: utf-8 -*-
import math

import rclpy, cv2
from rclpy.node import Node
from sensor_msgs.msg import Image
from geometry_msgs.msg import Twist
from geometry_msgs.msg import PointStamped
import numpy as np
from std_msgs.msg import Bool


class LaneDetection(Node):
    def __init__(self):
        super().__init__('lanedetection')
        self.get_logger().info("Start lane keeping.")

        self.point_sub = self.create_subscription(PointStamped, '/racing_track_center_detection',
                                                  self.point_callback, 10)
        self.cmd_vel_pub = self.create_publisher(Twist, 'cmd_vel', 10)
        # self.obs_sub = self.create_subscription(Bool, '/has_obs',self.obs_callback,10)

        self.twist = Twist()
        self.point = PointStamped()
        # self.has_obs = 0

    def on_shutdown(self):
        self.twist.linear.x = 0.0
        self.twist.angular.z = 0.0
        self.cmd_vel_pub.publish(self.twist)

        # def obs_callback(self, msg):

    #    self.has_obs = msg.data

    def point_callback(self, msg):
        self.point = msg

        # self.point.point.x   识别出来的X坐标
        # self.point.point.y   识别出来的y坐标

        self.twist.linear.x = 0.3  # 小车速度
        self.twist.angular.z = (math.acos((x - 480) / (math.sqrt(x ** 2 + y ** 2)))) / 0.01  # 小车转角

        self.cmd_vel_pub.publish(self.twist)


def main(args=None):
    rclpy.init(args=args)
    lanedetection = LaneDetection()
    try:
        rclpy.spin(lanedetection)
    except KeyboardInterrupt:
        lanedetection.on_shutdown()
        lanedetection.destroy_node()
        rclpy.shutdown()


if __name__ == '__main__':
    main()
