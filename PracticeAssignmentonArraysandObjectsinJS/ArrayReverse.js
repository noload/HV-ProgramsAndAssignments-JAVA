arr= ["apple", "banana", "cherry"]
let i=0;
let j=arr.length-1
console.log("Array Before Sorting ",arr);
while (i<j) {
    temp=arr[i];
    arr[i]=arr[j]
    arr[j]=temp

    i++;
    j--;
}
console.log("Array After Sorting ",arr);