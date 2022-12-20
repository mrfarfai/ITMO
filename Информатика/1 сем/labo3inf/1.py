from re import *

smile = escape(";<|");

texts = [
"qwe ;<| qweqwe qweq qwe ';<|", 
";<|asd ;<|;<| asd dasa ",
";|< aasdasd |;< gdf |<; :<|",
"test ;<|;<|;<| zxcxc ;|<",
"rty rty rty rty dfg assdf |<;<|"
];

for text in texts:
	print(len(findall(smile, text)))

