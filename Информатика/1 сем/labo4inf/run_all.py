with open("4.py", "r", encoding="utf-8") as c4:
	code_c4 = c4.read()

with open("lib.py", "r", encoding="utf-8") as lib:
	code_lib = lib.read()

with open("reg.py", "r", encoding="utf-8") as reg:
	code_reg = reg.read()

exec(code_c4)
exec(code_lib)
exec(code_reg)