from re import *

text = input()
#text = "Мамa пaпа qwe привет"

print(findall(r"\b[а-яА-я]*[a-zA-Z]+[а-яА-я]*", text))