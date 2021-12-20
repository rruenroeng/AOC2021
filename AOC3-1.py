import array
f = open("binary1.txt", "r")
count = 0
outStr = ""
outStr2 = ""

content = f.readlines()
arr = array.array("i",[0,0,0,0,0,0,0,0,0,0,0,0])
for line in content:
    print(line)
    for x in range(12):
        if line[x] == '1':
            arr[x]+=1
        else: 
            arr[x]+=-1
for i in arr:
    if i > 0:
        outStr += "1"
        outStr2 += "0"
    else:
        outStr += "0"
        outStr2 += "1"
print(outStr)
gamma = int(outStr, base=2)
epsilon = int(outStr2, base=2)
print(gamma*epsilon)