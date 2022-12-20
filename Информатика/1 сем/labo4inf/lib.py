import xmlplain
from time import *

tm = time()

with open("input.xml", "r", encoding="utf-8") as file:
	xml = xmlplain.xml_to_obj(file.read(), strip_space=True, fold_dict=True)

with open("lib.yaml", "w", encoding="utf-8") as yml:
	xmlplain.obj_to_yaml(xml, yml)

print("Время работы с библиотеками =", time() - tm, "мс")