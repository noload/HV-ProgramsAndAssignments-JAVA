package ArrayAssignment;

import java.util.Arrays;

// Question 3: Sort the Array elements in ascending order and descending order
public class Question3 {
    public static void main(String[] args) {
        int[] arrNum = { 23, 21, 44, 32, 12 };
        for (int i = 0; i < arrNum.length; i++) {
            for (int j = i; j < arrNum.length; j++) {
                if (arrNum[i] > arrNum[j]) {
                    int temp = arrNum[i];
                    arrNum[i] = arrNum[j];
                    arrNum[j] = temp;
                }
            }
        }
        System.out.print("The elements in ascending order: " + Arrays.toString(arrNum));
        for (int i = 0; i < arrNum.length; i++) {
            for (int j = i; j < arrNum.length; j++) {
                if (arrNum[i] < arrNum[j]) {
                    int temp = arrNum[i];
                    arrNum[i] = arrNum[j];
                    arrNum[j] = temp;
                }
            }
        }
        System.out.println();
        System.out.println("The elements in decending order: " + Arrays.toString(arrNum));

    }
}
