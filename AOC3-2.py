import array
f = open("binary1.txt", "r")
f2 = open("binary1.txt", "r")
count = 0
outStr = ""
outStr2 = ""
outStr3 = ""

content = f.readlines()
f.seek(0)
content2 = f.readlines()
f.seek(0)
content3 = f.readlines()
arr = array.array("i",[0,0,0,0,0,0,0,0,0,0,0,0])
arr2 = array.array("i",[0,0,0,0,0,0,0,0,0,0,0,0])
for x in range(12):
    if (x>0): 
            content = [y for y in content if y[x-1]==mostCommon]
            print(content)
    for line in content:
        if line[x] == '1':
            arr[x]+=1
        else: 
            arr[x]+=-1
    if arr[x]<0: mostCommon = "0"
    else: mostCommon = "1"
    if (len(content)==1):
        outStr=content[0]
        print(outStr)
    outStr3 += mostCommon
    
# print(content2)
for x in range(12):
    if (x>0): 
            content2 = [y for y in content2 if y[x-1]==leastCommon]
            # print(content2)
    for line in content2:
        if line[x] == '1':
            arr2[x]+=1
        else: 
            arr2[x]+=-1
    print("arr2: " + str(arr2[x]))
    if arr2[x]<0: leastCommon = "1"
    else: 
        leastCommon = "0"
    # 3521070, 11867310, 5045418, 5587605,7477490
    if (len(content2)==1):
        outStr2=content2[0]

ogr = int(outStr3, base=2)
CO2SR = int(outStr2, base=2)
print(content)
print("outStr " + outStr)
print()
print(content2)
print("outStr2 " + outStr2)
print(arr)
print(arr2)

print("ogr " + str(ogr))
print("CO2SR " + str(CO2SR))
print(ogr*CO2SR)