from re import *

with open("3.txt", "r", encoding="utf-8") as file:
	for line in file:
		check = len(findall(r"^([А-Я])[а-я]+\s\1\.\1\.\sP3112", line))
		if(not check):
			print(line[0:-1])
			