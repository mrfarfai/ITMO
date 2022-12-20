from re import *

smile = escape(input());
text = input()

print(len(findall(smile, text)))