print("i = ",end= " ")
i = int(input())
for r in range(1,50):
	if 2 ** r >= r + i + 1:
		print(r)
		break
