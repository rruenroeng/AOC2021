import array
f = open("input3.txt", "r")
count = 0
lineCount = 0
distance = 0
aim = 0
height = 0
arrayPlace= 0
curr = 0
content = f.readlines()
# arr = array.array("i",[9999,9999,9999])
for line in content:
    direction = line.split()
    if direction[0] == 'forward':
        distance+=int(direction[1])
        height+=aim*int(direction[1])
    if direction[0] == 'down':
        aim += int(direction[1])
    if direction[0] == "up":
        aim -= int(direction[1])
print(distance * height)