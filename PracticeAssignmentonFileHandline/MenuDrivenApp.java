package PracticeAssignmentonFileHandline;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class MenuDrivenApp {

    public static Scanner sc = new Scanner(System.in);
    public static String flag = "y";
    public static String fullPath;
    public static String filename;
    public static String data;

    public static void main(String[] args) {

        while (flag.equalsIgnoreCase("y")) {
            System.out.println("<----Menu based app - File Operations in Java---->\n" +
                    "-------------------------------------------------------------------------------");
            System.out.println("1.Create a new folder\r\n" + //
                    "\r\n" + //
                    "2.Create a new text file\r\n" + //
                    "\r\n" + //
                    "3.Write into a text file \r\n" + //
                    "\r\n" + //
                    "4.Append data to a text file\r\n" + //
                    "\r\n" + //
                    "5.Rename a file\r\n" + //
                    "\r\n" + //
                    "6.Delete a File");
            System.out.println("--------------------------------------------------------------------");

            System.out.print("Please enter the Menu: ");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Please enter the Folder-name to be Created: ");
                    String folderName = sc.next();
                    System.out.print("Please enter the Path where you wish to save a new folder: ");
                    String path1 = sc.next();
                    fullPath = path1 + folderName;
                    createFolder(fullPath);
                    break;
                case 2:
                    System.out.print("Please enter the Filename to be Created: ");
                    filename = sc.next();
                    System.out.print("Please enter the Path where you wish to save a new file: ");
                    String filepath = sc.next();
                    fullPath = filepath + filename;
                    createFile(fullPath);
                    break;
                case 3:
                    System.out.println("Enter the file name.");
                    filename = sc.next();
                    sc.nextLine();
                    System.out.println("Enter the data to be written into file");
                    System.out.print("Data : ");
                    data = sc.nextLine();
                    System.out.println("--------------------------------------");
                    writeIntoFile(filename, data);

                    break;
                case 4:
                    System.out.print("Enter  file name ");
                    filename = sc.next();
                    sc.nextLine();
                    System.out.println("Enter extra data");
                    data = sc.nextLine();
                    appenData(filename, data);
                    break;
                case 5:
                    System.out.print("Enter the path ");
                    String path2 = sc.next();
                    System.out.print("Please enter the File-Name: ");
                    filename = sc.next();
                    String fullPath1 = path2 + filename;
                    System.out.println("Please enter new File-Name: ");
                    String newFile = sc.next();
                    String fullPath2 = path2 + newFile;
                    File oldfile = new File(fullPath1);
                    File newfile = new File(fullPath2);
                    if (oldfile.renameTo(newfile)) {
                        System.out.println("File renamed successfully");
                    } else {
                        System.out.println("Something went wrong");
                    }
                    System.out.print("Press 'Y' to go back to the Main File-Operations Menu:");
                    flag = sc.next();

                    break;
                case 6:
                    // System.out.print("Enter the path ");
                    // String path3=sc.next();
                    // System.out.print("Please enter the File-Name: ");
                    // filename=sc.next();
                    // String fullPath3=path3+filename;
                    // System.out.println(fullPath3);

                    File file3 = new File("E:\\JavaPrograms\\hi");
                    System.out.println(file3.delete());

                    break;
                default:
                    break;
            }

        }
    }

    public static void createFolder(String path) {
        File file = new File(path);

        if (file.mkdir()) {
            System.out.println("@@Folder created successfully@@");
        } else {
            System.out.println("something went wrong");
        }
        System.out.print("Press 'Y' to go back to the Main File-Operations Menu:");
        flag = sc.next();
    }

    public static void createFile(String fullPath) {
        try {
            File file = new File(fullPath);
            if (file.exists()) {
                System.out.println("File already exist");
            } else {
                if (file.createNewFile()) {
                    System.out.println("<----@@File created Successfully@@---->");
                } else {
                    System.out.println("<----!!!something went wrong!!!---->");
                }

            }
        } catch (IOException e) {
            e.getMessage();
        }

        System.out.print("Press 'Y' to go back to the Main File-Operations Menu:");
        flag = sc.next();

    }

    public static void writeIntoFile(String filename, String data) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(filename));
            bw.write(data);
            bw.close();
            System.out.println("Data written successfully");
        } catch (Exception e) {
            e.getMessage();
        }

        System.out.print("Press 'Y' to go back to the Main File-Operations Menu:");
        flag = sc.next();
    }

    public static void appenData(String filename, String data) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(filename, true));
            bw.write(data);
            bw.close();
            System.out.println("Data  added successfully");

        } catch (Exception e) {
            System.out.println("not appended");
            e.getMessage();
        }

        System.out.print("Press 'Y' to go back to the Main File-Operations Menu:");
        flag = sc.next();
    }

}
