package ArrayAssignment;

// Question 6:   Find how many elements from Array A are present in the other Array B. and Print their frequencies.
public abstract class Question6 {
    public static void main(String[] args) {
        int[] arrSuperSet = { 3, 1, 3, 4, 1, 2, 1, 8, 3, 2, 1, 1, 3, 2, 3, 3, 4 };

        int[] arrSubSet = { 1, 2, 3, 5, 9 };

        for (int i = 0; i < arrSubSet.length; i++) {
            int count = 0;
            for (int j = 0; j < arrSuperSet.length; j++) {
                if (arrSubSet[i] == arrSuperSet[j]) {
                    count++;
                }

            }
            System.out.println("Frequency of " + arrSubSet[i] + " : " + count);
        }

    }
}
