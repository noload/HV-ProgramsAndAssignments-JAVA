# def bubbleSorting(arr):
#     for i in range(len(arr)):
#         for j in range(len(arr)):
#             #Asending order
#             # if(arr[i]<arr[j]):
#             #     temp=arr[i]
#             #     arr[i]=arr[j]
#             #     arr[j]=temp
            
#             #in Decending order
#             if(arr[i]>arr[j]):
#                 temp=arr[i]
#                 arr[i]=arr[j]
#                 arr[j]=temp
#     return arr            


def __bubblesort__(arr):
    length = len(arr) 
    for i in range(length):
        for j in range(0, length-i-1):
            if arr [j] > arr [j+1]:
                arr[j+1], arr[j] = arr[j], arr[j+1]
    return arr

# def bubbleSort(arr):
#     for i in range(len(arr)):
#         j=0
#         if(j<len(arr)):
#             j=i+1
#         else:
#             j=len(arr)
#         if(arr[i]>arr[j]):
#             temp=arr[i]
#             arr[i]=arr[j]
#             arr[j]=temp
#     return arr


if __name__=="__main__":
    arr=[10,30,50,20,80,70,90,30,10]
    # array=bubbleSorting(arr)
    # array=bubbleSort(arr)
    array=__bubblesort__(arr)
    print(array)































