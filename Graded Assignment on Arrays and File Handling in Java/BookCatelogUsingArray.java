import java.time.LocalDate;
import java.util.Arrays;
import java.util.Scanner;

public class BookCatelogUsingArray {

    public static Scanner sc = new Scanner(System.in);
    public static char flag = 'Y';
    public static String bookID = "0";
    public static int option;
    public static String[][] bookData = new String[4][5];

    public static void main(String[] args) {

        libraryDataAssining();

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
                    displayBookList(bookData);

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
            if (flag == 'N') {
                System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
                System.out.println("--------------Thank you for visiting  SmartPoint!-------------");
                System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");

            }
        }

    }

    public static void libraryDataAssining() {
        String[] row1 = { "101", "HTML and CSS", "Jon Duckett", "Available", "Null" };
        String[] row2 = { "102", "JavaScript: The Good Parts", "Douglas C", "Available", "Null" };
        String[] row3 = { "103", "Learning Web Design", "Jennifer N", "Available", "Null" };
        String[] row4 = { "104", "Responsive Web Design", "Ben Frain", "Mk001", "2023-08-04" };

        // assigning data to multidimention array
        bookData = new String[4][5];
        bookData[0] = row1;
        bookData[1] = row2;
        bookData[2] = row3;
        bookData[3] = row4;

        System.out.println(":::Book details assigned successfuly:::");

    }

    public static void displayBookList(String[][] bookInfo) {
        // Printing the elements of the multidimensional array
        int availCount = 0;
        System.out.println("----------------------------------------------------------------------------");
        for (int i = 0; i < bookInfo.length; i++) {
            for (int j = 0; j < bookInfo[i].length; j++) {
                // System.out.print(bookInfo[i][j] + " ");
                if (j == 0) {
                    System.out.println("Book ID      :" + bookInfo[i][j]);
                } else if (j == 1) {
                    System.out.println("Book Name    :" + bookInfo[i][j]);
                } else if (j == 2) {
                    System.out.println("Author       :" + bookInfo[i][j]);
                } else if (j == 3) {
                    if (bookInfo[i][j].equals("Available")) {
                        availCount++;
                    }
                    System.out.println("Availability :" + bookInfo[i][j]);
                } else if (j == 4) {
                    System.out.println("Issue Date   :" + bookInfo[i][j]);
                }
            }
            System.out.println("*************************************************************");
        }
        System.out.println("Available books in Library are :" + availCount);
        System.out.println("-----------------------------------------------------------------------------");
        System.out.print("Enter Y to return to the main menu or N to Exit : ");
        flag = sc.next().charAt(0);

    }

    public static void issueBook(String bookID) {
        boolean avail = false;
        for (int i = 0; i < bookData.length; i++) {
            for (int j = 0; j < bookData[i].length; j++) {
                if (j == 0 && bookData[i][j].equals(bookID) && bookData[i][3].equals("Available")) {
                    System.out.println("-------------Book Detail---------------- ");
                    System.out.println("****************************************");
                    System.out.println("Book ID      :" + bookData[i][j]);
                    System.out.println("Book Name    :" + bookData[i][1]);
                    System.out.println("Author       :" + bookData[i][2]);
                    System.out.println("****************************************");
                    avail = true;
                    System.out.print("Enter StudentID: ");
                    String studentID = sc.next();
                    System.out.print("Enter C to confirm: ");
                    char confirm = sc.next().charAt(0);
                    if (confirm == 'c' || confirm == 'C') {
                        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
                        System.out.println("BookID: " + bookID + " is Issued to  " + studentID);
                        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");

                        bookData[i][3] = studentID;
                        bookData[i][4] = LocalDate.now().toString();
                    } else {
                        System.out.println("------------------------------------------------------------");
                        System.out.println("Book issue process canceled");
                        System.out.println("----------------------------------------------------------------");
                    }

                }

            }
        }
        if (!avail) {
            System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
            System.out.println("<------Book is not available in library------> ");
            System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");

        }
        System.out.print("Enter Y to return to the main menu or N to Exit:");
        flag = sc.next().charAt(0);
    }

    public static void returnBook(String bookID) {
        boolean bookAvail = false;
        for (int i = 0; i < bookData.length; i++) {
            for (int j = 0; j < bookData[i].length; j++) {
                if (bookData[i][j].equals(bookID) && !bookData[i][3].equals("Available")) {
                    bookAvail = true;
                    String[] Issueddate = bookData[i][4].split("-");
                    int Issuedyear = Integer.parseInt(Issueddate[0]);
                    int Issuedmoth = Integer.parseInt(Issueddate[1]);
                    int Issuedday = Integer.parseInt(Issueddate[2]);

                    LocalDate currentDate = LocalDate.now();
                    int year = currentDate.getYear();
                    int month = currentDate.getMonthValue();
                    int day = currentDate.getDayOfMonth();

                    int DelayedDays = ((day - Issuedday) + ((month - Issuedmoth) * 30)
                            + ((year - Issuedyear) * 365)) - 7;

                    // calculating charges for delayed day .. per day 10 rupee
                    int Charges = DelayedDays * 10;

                    System.out.println("-------------Book Details---------------- ");
                    System.out.println("****************************************");
                    System.out.println("Book ID            : " + bookID);
                    System.out.println("Book Title         : " + bookData[i][1]);
                    System.out.println("Author             : " + bookData[i][2]);
                    System.out.println("StudentID          : " + bookData[i][3]);
                    System.out.println("Issue Date         : " + bookData[i][4]);
                    System.out.println("Delayed by         :" + (day - Issuedday) + " days " + (month - Issuedmoth)
                            + " month " + (year - Issuedyear) + " year");
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
                        System.out.println("BookID: " + bookID + " is returned back");
                        System.out.println("-------------------------------------------------------------------");
                        bookData[i][3] = "Available";
                        bookData[i][4] = "Null";

                    } else {

                        System.out.println("Something went wrong .Again do the  same process");
                    }

                }
            }
        }
        if (bookAvail == false) {
            System.out.println("Yor are returnning wrong book");
        }
        System.out.print("Enter Y to return to the main menu or N to Exit:");
        flag = sc.next().charAt(0);
    }

}