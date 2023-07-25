package ArrayAssignment;

public class Question1 {
    public static void main(String[] args) {

        int arrNum[] = { 31, 42, 25, 21, 56, 61, 13, 45, 76, 55 };
        int sum = 0;
        for (int i = 0; i < arrNum.length; i++) {
            sum += arrNum[i];
            for (int j = i; j < arrNum.length; j++) {
                if (arrNum[i] > arrNum[j]) {
                    int tmp = arrNum[i];
                    arrNum[i] = arrNum[j];
                    arrNum[j] = tmp;
                }
            }
            // System.out.println();
        }

        System.out.println("The element with the Minimum value: " + arrNum[0]);
        System.out.println("The element with the Maximum value: " + arrNum[arrNum.length - 1]);
        System.out.println("Average of all array element : " + (sum / (arrNum.length)));
        System.out.println("Total number of array elements (Count). " + arrNum.length);

    }
}