import torchvision
import torch
import onnx
model = torchvision.models.resnet18(pretrained=False)
model.fc = torch.nn.Linear(512,2)
model.load_state_dict(torch.load('./best_line_follower_model_xy.pth'))
device = torch.device("cuda:0" if torch.cuda.is_available() else 'cpu')
model = model.to(device)
model.eval()
x = torch.randn(1, 3, 224, 224, requires_grad=True).to(device)
torch_out = model(x)
torch.onnx.export(model,
                    x,
                    "./best_line_follower_model_xy.onnx",
                    export_params=True,
                    opset_version=11,
                    do_constant_folding=True,
                    input_names=['input'],
                    output_names=['output'])
net = onnx.load("./best_line_follower_model_xy.onnx")
onnx.checker.check_model(net)
onnx.helper.printable_graph(net.graph)