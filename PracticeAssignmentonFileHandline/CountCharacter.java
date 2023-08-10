package PracticeAssignmentonFileHandline;

import java.io.File;
import java.io.FileReader;

public class CountCharacter {
    public static void main(String[] args) {
        File file = new File("E:\\JavaPrograms\\PracticeAssignmentonFileHandline\\HeroVired.txt");

        // method1
        try {
            FileReader fr = new FileReader(file);
            int i;
            int count = 0;
            while ((i = fr.read()) != -1) {
                count++;
                // System.out.println((char)i);
            }
            System.out.println("Total Number of character in file are :" + count);
        } catch (Exception e) {
            e.getMessage();
        }
        // method 2
        System.out.println("Total number of character in file are :" + file.length());
    }
}
