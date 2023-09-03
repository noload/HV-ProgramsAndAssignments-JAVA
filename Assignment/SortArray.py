# Implement a Python function to sort an array of integers using the quicksort algorithm. Include both the recursive and iterative versions of the algorithm.
# Linked List Intersection:


#using recursive method
def quicksort(arr):
    if not arr:
        return arr
        
    pivot=arr[0]
    left=[]
    right=[]
    left=[x for x in arr[1:] if x<=pivot]
    right=[x for x in arr[1:] if x>pivot]
    return quicksort(left)+[pivot]+quicksort(right)

# def quickSort(arr):
#     pivot=arr[0]
#     low=0
#     for 

if __name__=="__main__":
    arr=[10,50,30,40,10,60]
    print(quicksort(arr))
