def _insertionSort_(arr):
    for i in range(1, len(arr)):
        
        j = i-1
        while(j >= 0 and arr[i] < arr[j]):
            arr[j+1] = arr[j]
            j -=1

        arr[j+1] = arr[i]

if __name__=="__main__":
    arr = [25,24,26,5,8]
    print("Before Sorting",arr)
    _insertionSort_(arr)
    print("After Sorting",arr)