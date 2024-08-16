#!/usr/bin/env python
# -*- coding: UTF-8 -*-

import rclpy
from rclpy.node import Node
from std_msgs.msg import Bool
from sensor_msgs.msg import LaserScan
from rclpy.qos import qos_profile_sensor_data

class YDlidarDetector(Node):
    def __init__(self):
        super().__init__('obstacle_detection')
        self.get_logger().info("LiDAR is OK")

        self.laser_sub = self.create_subscription(LaserScan, '/scan', self.laser_callback, rclpy.qos.qos_profile_sensor_data)        
        self.pub = self.create_publisher(Bool, '/has_obs', 10)
        self.min_dist = 0
        self.has_obs = Bool()        

    def laser_callback(self, msg):
        minIndex = int(len(msg.ranges)/2)

        # goes throgh  array and find minimum  on the right 
        
        for i in range (minIndex-25,minIndex+25):
            #print(msg.ranges[i])
            if msg.ranges[i] > 0.1 :
                if msg.ranges[i] < msg.ranges[minIndex] :
                    minIndex = i
        
        
        # calculate distance
        self.min_dist = msg.ranges[minIndex]

        #public message
        if 0.01 < self.min_dist < 0.3 :
            print("min_dist["+str(i)+"] = "+ str(self.min_dist) + ", stop") 
     
            self.has_obs.data = True
            
        else:
            self.has_obs.data = False
        
        self.pub.publish(self.has_obs)

def main(args=None):
    rclpy.init(args=args)    
    lidardetector = YDlidarDetector()
    rclpy.spin(lidardetector)
    lidardetector.destroy_node()
    rclpy.shutdown()

if __name__ == '__main__':
    main()
