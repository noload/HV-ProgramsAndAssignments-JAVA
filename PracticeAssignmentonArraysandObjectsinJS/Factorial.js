
// Recursive Way
function factorial(n) {
    if(n ==  1){
        return 1
    }
    return fact=n * factorial(n - 1)
    
}
console.log("Factorial is ",factorial(5))

