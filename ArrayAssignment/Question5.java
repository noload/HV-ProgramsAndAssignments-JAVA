package ArrayAssignment;

import java.util.Arrays;

// WAP in Java to shift all the array elements having value as one to the end of an array.
public class Question5 {
    public static void main(String[] args) {
        int[] arrNum = {3, 1, 4, 1, 2, 1, 8, 3, 2, 1};
        int newArr[]=new int[arrNum.length];
        int count=0;
        for (int i=0;i<arrNum.length-1;i++) {
            if(arrNum[i]!=1){
                newArr[i]=arrNum[i];
            }else{
                count=count+1;
            }
           
               
            }

            for(int k=0;k<newArr.length;k++){
                 
            }

        }
        
    }

