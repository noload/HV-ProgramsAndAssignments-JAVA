def quickSort(arr):
    left=[]
    right=[]
    if len(arr)<= -1:
        return -1
    else:
        pivot=arr[0]
        left=[i for i in arr[1:] if pivot<=i]
        right=[i for i in arr[1:] if pivot>i]
    return quickSort(left) + [pivot]+ quickSort(right)


if __name__=="__main__":
    arr=[10.30,20,50,30,70,30,54]
    result=quickSort(arr)
    print(result)