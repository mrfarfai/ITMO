from time import *

tm = time()
tab = 0
not_first = 0
yml = ""
content = ""
is_open = False

def settabs(tab):
	tabs = ""
	for i in range(tab):
		tabs += "\t"
	return tabs

def rep_tab(line):
	i = line.find("\t")
	while i != -1:
		line = line[:i] + "\\t" + line[i + 1:]
		i = line.find("\t")
	return line

def brackets(line):
	idx = line.find("\\t")
	if idx != -1:
		return "\"" + line + "\""
	else:
		return line

with open("input.xml", "r", encoding="utf-8") as file:
	for line in file:
		o_tag = ""
		c_tag = ""

		if not_first:
			idx_of_ot_open = line.find('<')
			idx_of_ot_close = line.find('>')

			idx_of_ct_open = line.rfind('</')
			idx_of_ct_close = line.rfind('>')

			if idx_of_ot_open != -1 and idx_of_ot_open != idx_of_ct_open:
				o_tag = line[idx_of_ot_open + 1 : idx_of_ot_close]
			if idx_of_ct_open != -1:
				c_tag = line[idx_of_ct_open + 2 : idx_of_ct_close]

			if o_tag and c_tag:
				yml += "\n" + settabs(tab) + o_tag + ': '
				content += line[idx_of_ot_close + 1 : idx_of_ct_open]
				yml += brackets(rep_tab(content))
				content = ""
				is_open = False
			
			elif o_tag:
				yml += "\n" + settabs(tab) + o_tag + ': '
				content += line[idx_of_ot_close + 1 : -1]
				tab += 1
				is_open = True
			
			elif c_tag:
				if is_open:
					content += "\\n" + line[ : idx_of_ct_open]
					yml += brackets(rep_tab(content))
					content = ""
				tab -= 1
				is_open = False

			else:
				content += "\\n" + rep_tab(line[:-1])
				

		not_first += 1

with open("4.yaml", "w", encoding="utf-8") as o:
	o.write(yml[1:])

print("Время работы реализации =", time() - tm, "мс")
