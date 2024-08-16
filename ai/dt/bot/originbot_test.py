import torch
import torchvision.transforms as transforms
import onnxruntime
import matplotlib.pyplot as plt
import numpy as np
import PIL.Image
import glob
import os

onnx_model_path = './best_line_follower_model_xy.onnx'

data_transform = transforms.Compose(
        [transforms.Resize([224,224]),         
         transforms.ToTensor(),
         transforms.Normalize(mean=[0.485, 0.456, 0.406], std=[0.229, 0.224, 0.225])])

path="./image_dataset/"
image_paths = glob.glob(os.path.join(path, '*.jpg'))
imag_num = len(image_paths)
idx = np.random.randint(imag_num)
image_path = image_paths[idx]
image = PIL.Image.open(image_path)
plt.subplot(121)
plt.imshow(image)
file_name=os.path.basename(image_path)
plt.title("x="+str(file_name.split("_")[1]))
plt.title("y="+str(file_name.split("_")[2]))


img = data_transform(image)
img = torch.unsqueeze(img, dim=0)
img = img.numpy()

resnet_session = onnxruntime.InferenceSession(onnx_model_path)
input_name = resnet_session.get_inputs()[0].name
out_name = resnet_session.get_outputs()[0].name
pred_onx = resnet_session.run([out_name], {input_name:img}) # 执行推断
print("onnx weights", pred_onx[0] )

xx=int((pred_onx[0][0][0]+1)*480)
plt.subplot(122)
plt.imshow(image)
plt.title("x="+str(xx))
plt.title("y="+str(xx))
plt.show()