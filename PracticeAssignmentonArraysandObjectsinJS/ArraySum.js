
function  sum(arr) {
    sum=0;
    for(let i=0;i<arr.length;i++){
        sum+=arr[i]
    }
    return sum;
}

arr=[2,4,6,3,5,7]
console.log("Array Sum is = ",sum(arr));