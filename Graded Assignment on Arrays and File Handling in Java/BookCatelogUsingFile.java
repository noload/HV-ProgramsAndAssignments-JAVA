import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class BookCatelogUsingFile {
    public static String filename = "details.csv";
    public static Scanner sc = new Scanner(System.in);
    public static char flag = 'Y';
    public static String bookID = "0";
    public static int option;

    public static void main(String[] args) {

        while (flag == 'Y' || flag == 'y') {
            System.out.println(
                    "*******************************************************\r\n" +
                            "<-----------@@Welcome to the Unique Library@@------------>\r\n" +
                            "*******************************************************\r\n" +
                            "1.View the complete list of Books\n" +
                            "----------------------------------\n" +

                            "2.Issue a Book\r\n" +
                            "---------------\n" +

                            "3.Return a Book\r\n" +
                            "----------------\n" +
                            "4.Exit\r\n" +
                            "--------");

            System.out.println(
                    "##############################################################################################");
                    
                    
                   
                    System.out.print("Please choose an option from the above menu: ");
                    option = sc.nextInt();
                       
            
            switch (option) {
                case 1:
                    displayBookList(filename);
                    break;
                case 2:
                    System.out.println("-------------------------------------------------------------");
                    System.out.println("<---------------------  Issue the Book ----------------------->");
                    System.out.println("-------------------------------------------------------------");
                    System.out.print("Enter a Book ID : ");
                    bookID = sc.next();
                    issueBook(bookID);

                    break;
                case 3:
                    System.out.println("*********************************************************");
                    System.out.println("<-------------------- Return The Book ------------------->");
                    System.out.println("*********************************************************");
                    System.out.print("Enter the Book ID :");
                    bookID = sc.next();
                    returnBook(bookID);
                    break;
                case 4:

                    flag = 'N';
                    break;
                default:
                    break;

            }

        }

        sc.close();
        if (flag == 'N') {
            System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
            System.out.println("--------------Thank you for visiting  SmartPoint!-------------");
            System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");

        }
    }

    public static void displayBookList(String filename) {
        int count = 0;
        System.out.println("<--------------------List Of All Books---------------------> ");
        try {
            BufferedReader br = new BufferedReader(new FileReader(filename));
            String line;
            br.readLine();
            System.out.println("*********************************************");
            while ((line = br.readLine()) != null) {

                String arr[] = line.split(",");
                System.out.println("Book ID      : " + arr[0]);
                System.out.println("Book Title   : " + arr[1]);
                System.out.println("Author       : " + arr[2]);
                System.out.println("Availability : " + arr[3]);
                System.out.println("Issue Date   : " + arr[4]);
                System.out.println("*********************************************");
                if (arr[3].equals("Available")) {
                    count++;
                }
            }
            System.out.println("Total Available Books in Library : " + count);
            System.out.println("--------------------------------------------------------------------");
            br.close();
        } catch (Exception e) {
            e.printStackTrace();

        }
        System.out.print("Enter Y to return to the main menu or N to Exit : ");
        flag = sc.next().charAt(0);

    }

    public static void issueBook(String bookID) {
        boolean avail = false;
        try {
            BufferedReader br = new BufferedReader(new FileReader(filename));

            String line;
            String newData = "";
            br.readLine();
            while ((line = br.readLine()) != null) {
                // System.out.println(line);
                String arr[] = line.split(",");
                // System.out.println(Arrays.toString(arr));

                if (arr[0].equals(bookID) && arr[3].equals("Available")) {
                    System.out.println("-------------Book Detail---------------- ");
                    System.out.println("****************************************");
                    System.out.println("Book ID      : " + arr[0]);
                    System.out.println("Book Title   : " + arr[1]);
                    System.out.println("Author       : " + arr[2]);
                    System.out.println("****************************************");

                    avail = true;
                    System.out.print("Enter StudentID: ");
                    String studentID = sc.next();
                    System.out.print("Enter C to confirm: ");
                    char confirm = sc.next().charAt(0);
                    if (confirm == 'C' || confirm == 'c') {
                        // 101,HTML and CSS,Jon Duckett,Available,Null
                        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
                        System.out.println("BookID: " + bookID + " is Issued to  " + studentID);
                        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");

                        newData += System.lineSeparator() + bookID + "," + arr[1] + "," + arr[2] + ","
                                + studentID + ","
                                + LocalDate.now();
                    }

                } else {
                    newData += System.lineSeparator() + line;
                }
            }
            FileWriter objFileWriter = new FileWriter(filename);
            objFileWriter.write("Book ID,Book Title,Author,Availability,Issue Date");
            objFileWriter.write(newData);
            objFileWriter.close();
            br.close();
            if (avail == false) {
                System.out.println("Book not available");
            }

        } catch (Exception e) {
            e.printStackTrace();

        }

        System.out.print("Enter Y to return to the main menu or N to Exit:");
        flag = sc.next().charAt(0);

    }

    public static void returnBook(String bookID) {
        boolean bookAvail = true;

        try {
            BufferedReader br = new BufferedReader(new FileReader("details.csv"));
            String line;
            String newData = "";
            br.readLine();
            while ((line = br.readLine()) != null) {

                String[] arr = line.split(",");

                if (arr[0].equals(bookID) && !arr[3].equals("Available")) {
                    bookAvail = false;

                    // Seperating day , month, year of issued date
                    String issuedDate[] = arr[4].split("-");
                    int issuedyear = Integer.parseInt(issuedDate[0]);
                    int issuedmonth = Integer.parseInt(issuedDate[1]);
                    int issuedday = Integer.parseInt(issuedDate[2]);

                    // Finding current date and
                    LocalDate currentDate = LocalDate.now();

                    // seperating day month and year of current date
                    int year = currentDate.getYear();
                    int month = currentDate.getMonthValue();
                    int day = currentDate.getDayOfMonth();

                    // calculating delayed by how many days using (current days - issued days) - 7
                    // days allowed
                    int DelayedDays = ((day - issuedday) + ((month - issuedmonth) * 30)
                            + ((year - issuedyear) * 365)) - 7;

                    // calculating charges for delayed day .. per day 10 rupee
                    int Charges = DelayedDays * 10;

                    System.out.println("-------------Book Details---------------- ");
                    System.out.println("****************************************");
                    System.out.println("Book ID            : " + bookID);
                    System.out.println("Book Title         : " + arr[1]);
                    System.out.println("Author             : " + arr[2]);
                    System.out.println("StudentID          : " + arr[3]);
                    System.out.println("Issue Date         : " + arr[4]);
                    System.out.println("Delayed by         :" + (day - issuedday) + " days " + (month - issuedmonth)
                            + " month " + (year - issuedyear) + " year");
                    if (DelayedDays < 0) {
                        DelayedDays = 0;
                        Charges = 0;
                    }
                    System.out.println("Total delayed days : " + DelayedDays);
                    System.out.println("Delayed Charges    : " + Charges + " rupees");
                    System.out.println("****************************************");

                    System.out.println("-------------------------------------------------------------------");

                    System.out.print("Enter R to confirm the return: ");
                    char Return = sc.next().charAt(0);
                    if (Return == 'R' || Return == 'r') {
                        // 102,JavaScript: The Good Parts,Douglas C,Available,Null
                        System.out.println("BookID: " + bookID + " is returned back");
                        System.out.println("-------------------------------------------------------------------");

                        newData += System.lineSeparator() + bookID + "," + arr[1] + "," + arr[2]
                                + ",Available,Null";

                    } else {
                        newData += System.lineSeparator() + bookID + "," + arr[1] + "," + arr[2] + "," + arr[3] + ","
                                + arr[4];
                        System.out.println("Something went wrong .Again do the  same process");
                    }

                } else {
                    newData += System.lineSeparator() + line;
                }
            }

            if (bookAvail) {
                System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
                System.out.println("The book is already available in library. Kindly enter corret bookID.");
                System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");

            }
            FileWriter objFileWriter = new FileWriter(filename);
            objFileWriter.write("Book ID,Book Title,Author,Availability,Issue Date");
            objFileWriter.write(newData);
            objFileWriter.close();

            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.print("Enter Y to return to the main menu or N to Exit:");
        flag = sc.next().charAt(0);

    }
}
