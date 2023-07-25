package ArrayAssignment;
// Description: WAP in Java to print all the array elements in reverse order.

import java.util.Arrays;

// Sample input : arrNum = {31, 42, 25, 21, 56,  61, 13, 45, 76, 55}

// Output : The elements in reverse order - 

// 55, 76, 45, 13, 61, 56, 21, 25, 42, 31
public class Question2 {
    public static void main(String[] args) {
        int[] arr = { 31, 42, 25, 21, 56, 61, 13, 45, 76, 55 };
        System.out.println("The elements in reverse order - ");
        for (int i = (arr.length) - 1; i > 0; i--) {

            System.out.print(arr[i] + " ");
        }
        // System.out.println(Arrays.toString(arr));
    }
}