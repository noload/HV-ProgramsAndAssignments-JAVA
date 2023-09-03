def rotateArraytoRight(arr,times):
    for i in range(times):
        last=arr[len(arr)-1]
        # print(last)
        for i in range(len(arr)-1-1,-1,-1):
            arr[i+1]=arr[i]
        arr[0]=last

    return arr





if __name__=="__main__":
    arr=[10,20,30,40]
    print("Initial Array ->",arr)
    times=int(input("Enter how many time you want to shift the array .."))
    print("after shifting right")
    print(rotateArraytoRight(arr,times))