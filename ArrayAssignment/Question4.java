package ArrayAssignment;

import java.util.Arrays;

// WAP in Java to print the Largest Prime number from the given array of integer number
public class Question4 {
    public static void main(String[] args) {
        boolean flag=false;
        int[] array = {2, 29, 51, 8, 4};
        int[] emptyArr=new int[array.length];
        for(int i=0; i<array.length; i++){
            boolean isPrime = true;
            
            //check to see if the numbers are prime
            for (int j=2; j<array[i]; j++){
                
                if(array[i]%j==0){
                    isPrime = false;
                    break;
                }
            }
            //print the number
            if(isPrime)
    
            emptyArr[i]= array[i];
            
        }
        for (int i = 0; i < emptyArr.length; i++) {
            for (int j = i; j < emptyArr.length; j++) {
                if (emptyArr[i] > emptyArr[j]) {
                    int temp = emptyArr[i];
                    emptyArr[i] = emptyArr[j];
                    emptyArr[j] = temp;
                }
            }
        }
        System.out.println("The Largest Prime number in given array: "+emptyArr[emptyArr.length-1]);

    }
}
