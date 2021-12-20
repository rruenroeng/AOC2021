import array
f = open("input2.txt", "r")
count = 0
lineCount = 0
arrayPlace= 0
curr = 9999999
filled = False
content = f.readlines()
arr = array.array("i",[9999,9999,9999])
for line in content:
    if filled:
        last = curr
        curr = arr[0]+arr[1]+arr[2]
        if curr>last:
            count+=1
    arr[arrayPlace]=int(line)
    print(arr[arrayPlace])
    lineCount+=1
    arrayPlace=lineCount%3
    if arrayPlace==2:
        filled = True
print(count)