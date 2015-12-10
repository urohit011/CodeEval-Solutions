import sys
file = open(sys.argv[1], 'r')

for line in file :
	
	d = {}
	
	for char in line:
		try:
			v = d[char]
			d[char] = v + 1
		
		except:
			d[char] = 1
	
	for char in line :
		if d[char] is 1:
			print(char)
			break

file.close()
