import os
from PIL import Image

path = os.path.dirname(os.path.abspath(__file__))

print(path);

def change(fname):
	global path;
	im1 = Image.open(path+"\\"+fname)
	im1.convert('RGB').save(fname[0:len(fname)-4], "PNG", optimize=True)
	#im1.save(path+"\\"+fname[0:len(fname)-3]+"png")
x = 0
for filename in os.listdir(path):
	x +=1

print(x);test