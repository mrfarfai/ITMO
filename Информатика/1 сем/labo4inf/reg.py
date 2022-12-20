from re import *
from time import *

tm = time()
tab = 0
not_first = 0
reg = ""
content = ""
is_open = False

def settabs(tab):
	tabs = ""
	for i in range(tab):
		tabs += "\t"
	return tabs

def rep_tab(line):
	return sub(r"\t", r"\\t", line)

def brackets(line):
	count = len(findall("\\t", line))
	if count:
		return "\"" + line + "\""
	else:
		return line

with open("input.xml", "r", encoding="utf-8") as file:
	for line in file:

		if not_first:
			open_close = findall(r"(<([\w\d]+)>.*</\2>)", line)
			open_ = findall(r"<[\w\d]+>.*", line)
			close_ = findall(r".*</[\w\d]+>", line)

			if len(open_close):
				reg += "\n" + settabs(tab) + findall(r"<([\w\d]+)>.*", open_close[0][0])[0] + ": "
				content += findall(r"<[\w\d]+>(.*)</[\w\d]+>", open_close[0][0])[0]
				reg += brackets(rep_tab(content))
				content = ""
				is_open = False

			elif len(open_):
				reg += "\n" + settabs(tab) + findall(r"<([\w\d]+)>", open_[0])[0] + ": "
				content += findall(r"<[\w\d]+>(.*)", open_[0])[0]
				tab += 1
				is_open = True

			elif len(close_):
				if is_open:
					content += "\\n" + findall(r"(.*)</[\w\d]+>", close_[0])[0]
					reg += brackets(rep_tab(content))
					content = ""
				tab -= 1
				is_open = False

			else:
				content += "\\n" + rep_tab(line[:-1])

		not_first += 1


with open("reg.yaml", "w", encoding="utf-8") as o:
	o.write(reg[1:])

print("Время работы с регулярными выражениями =", time() - tm, "мс")
