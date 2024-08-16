# reading Video
import cv2
import numpy as np
import uuid
import os

a = -1
b = -1


def mouse_callback(event, x, y, flags, userdata):
    global a
    global b
    if event == cv2.EVENT_LBUTTONDOWN:
        imageWithCircle = userdata.copy()
        cv2.circle(imageWithCircle, (x,y), 25, (0,0,255), -1)
        cv2.imshow("image", imageWithCircle)
        a,b=x,y
        
   
def main():  
    name = " "
    cap = cv2.VideoCapture("./record.avi")  #修改成车道线视频文件所在位置
    ret = cap.isOpened()
    cv2.namedWindow("image", cv2.WINDOW_NORMAL)
    cv2.resizeWindow("image", 960, 224)
    while(ret):
        ret, frame = cap.read()
        if ret == True:
            cv2.imshow("frame",frame)    
            k = cv2.waitKey(200)
            if( k == ord('q')):
                break
            if(k==13):
                cropImage = frame[100:324,:,:].copy()
                cv2.imshow("image",cropImage)
                cv2.setMouseCallback("image", mouse_callback, cropImage) 
                if a != -1 and b != -1:
                    name = 'xy_%03d_%03d_%s' % (a, b, uuid.uuid1())
                    cv2.imwrite('./image_dataset/' + name + '.jpg', cropImage)    
                    
 
    cv2.waitKey(0)
    cap.release()
    cv2.destroyAllWindows()
    
if __name__ == '__main__':
    main()