arr1=[1, 3, 5]
arr2=[2, 4, 6]
MargeArray=[]
let i=0;
let j=0;
let k=0;
while(i<arr1.length || j<arr2.length){
    if(arr1[i] < arr2[j]){
        MargeArray[k]=arr1[i];
        i++;

    }else{
        MargeArray[k]=arr2[j]
        j++;
       
    }
    

    k++;
}
console.log("Marged Array is ",MargeArray)