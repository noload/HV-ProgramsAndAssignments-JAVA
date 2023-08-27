package AppointmentManagementSystem;

import java.util.Scanner;

public class AppointmentManagementApp {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DataAccess d = new DataAccess();
        boolean flag = true;
        while (flag) {
            System.out.println("------------------------------------------------------");
            System.out.println("<------------Appointment Management System------------>");
            System.out.println("------------------------------------------------------");

            System.out.println("1. View Visitor List");
            System.out.println("2. Add New Visitor");
            System.out.println("3. Book an Appointment");
            System.out.println("4. Edit Visitor's Details");
            System.out.println("5. View Appointment Schedule");
            System.out.println("6.Cancel Appointment");
            System.out.println("--------------@@--------------@@----------------@@--------");
            System.out.println("------@@--------------@@---------------@@-------------------");
            System.out.print("Enter your choice :");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    Visitor.getVisitorList();
                    break;
                case 2:

                    Visitor.addNewVisitor();

                    System.out.print("Do  u want to book an appointment now y /n ");
                    String confirm = sc.next();
                    if (!confirm.equalsIgnoreCase("y")) {
                        break;
                    }

                case 3:

                    Clinic.bookAppointment();
                    break;
                case 4:
                    System.out.println("case 4");
                    Visitor.editVisitorDetails();

                    break;
                case 5:

                    Clinic.viewScheduledAppointment();
                    break;
                case 6:
                    Clinic.cancelAppointment();
                    break;
                default:
                    flag = false;
                    break;
            }
        }
    }
}
