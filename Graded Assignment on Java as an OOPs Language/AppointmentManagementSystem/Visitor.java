package AppointmentManagementSystem;

import java.time.LocalDate;
import java.util.Scanner;

import javax.xml.crypto.Data;

public class Visitor {
    private String visitorID;
    private String name;

    public String getVisitorID() {
        return visitorID;
    }

    public void setVisitorID(String visitorID) {
        this.visitorID = visitorID;
    }

    private int age;
    private String phoneNumber;
    private String appointmentDetails;

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Visitor [name=" + name + ", age=" + age + ", phoneNumber=" + phoneNumber + ", appointmentDetails="
                + appointmentDetails + "]";
    }

    public void setName(String name) {
        this.name = name;
    }

    // Constructor

    public int getAge() {
        return age;
    }

    public Visitor(String visitorID2, String name, int age, String phoneNumber, String appointmentDetails) {
        this.visitorID = visitorID2;
        this.name = name;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.appointmentDetails = appointmentDetails;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAppointmentDetails() {
        return appointmentDetails;
    }

    public void setAppointmentDetails(String appointmentDetails) {
        this.appointmentDetails = appointmentDetails;
    }

    public static String generateVisitorID() {
        System.out.println("Generating Visitor ID");
        Visitor last = DataAccess.visitorsInfo.get(DataAccess.visitorsInfo.size() - 1);
        String newID = last.getVisitorID();
        int newid = Integer.parseInt(newID);
        newid++;
        System.out.println("New VisitorID :" + newid);
        String finalID = String.valueOf(newid);
        return finalID;
    }

    public static void addNewVisitor() {
        System.out.println("<----------@@ ADDING NEW VISITOR DETAILS @@---------->");
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Visitor's Name : ");
        String name = sc.nextLine();
        System.out.print("Enter Visitor's Age : ");
        int age = sc.nextInt();
        System.out.print("Enter Visitor's phone Number :");
        String phno = sc.next();
        sc.nextLine();
        System.out.print("Enter Apointment Details :");
        String aptDetails = sc.nextLine();
        String visitorID = Visitor.generateVisitorID();
        System.out.println("-------------------@@-----------------------");
        System.out.print("Do you want to save the Visitor Details y /n :");
        String confirm = sc.next();
        System.out.println("-------------------@@-----------------------");

        if (confirm.equalsIgnoreCase("y")) {
            DataAccess.visitorsInfo.add(new Visitor(visitorID, name, age, phno, aptDetails));
            DataAccess.loadVisitorDataIntoFile();
            System.out.println("-------------------@@-----------------------");
            System.out.println("Visitor Details stored successfully ....");
            System.out.println("-------------------@@-----------------------");

        } else {
            System.out.println("-------------------@@-----------------------");

            System.out.println("Visitor Data not Stored ....");
            System.out.println("-------------------@@-----------------------");

        }
    }

    public static void editVisitorDetails() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Visitor ID :");
        String visitorID = sc.next();
        sc.nextLine();
        boolean found = false;
        for (Visitor visitor : DataAccess.visitorsInfo) {
            if (visitor.getVisitorID().equals(visitorID)) {
                found = true;
                System.out.println("<------------: Visitor Details :------------>");
                System.out.println("VisitorID          :" + visitor.getVisitorID());
                System.out.println("Visitor Name       :" + visitor.getName());
                System.out.println("Visitor Age        :" + visitor.getAge());
                System.out.println("Appontment Details :" + visitor.getAppointmentDetails());
                System.out.println("------------------------@@------------------------------");
                System.out.println("-----------@@ Enter New Visitor's Details @@----------");
                System.out.print("Enter Visitor's Name :");
                String name = sc.nextLine();

                System.out.print("Enter Visitor's Age :");
                int age = sc.nextInt();
                sc.nextLine();
                System.out.print("Enter Phone Number :");
                String phno = sc.nextLine();
                System.out.print("Enter Appointment Details :");
                String appDetails = sc.nextLine();
                System.out.println("*******************************************");
                visitor.setName(name);
                visitor.setAge(age);
                visitor.setPhoneNumber(phno);
                visitor.setAppointmentDetails(appDetails);
                System.out.print("Enter C to confirm the Changes :");
                String confirm = sc.next();

                if (confirm.equalsIgnoreCase("c")) {
                    DataAccess.loadVisitorDataIntoFile();
                    System.out.println("------------------------@@----------------------");
                    System.out.println("Visitor's Details got changed.......");
                    System.out.println("------------------------@@----------------------");

                } else {
                    System.out.println("------------------------@@----------------------");
                    System.out.println("You Selected Not To Confirm The Changeous");
                    System.out.println("------------------------@@----------------------");

                }

            }
        }
        if (!found) {
            System.out.println("-----------------@@------------------");
            System.out.println("Visitor's Details Not Found");
            System.out.println("-----------------@@------------------");

        }
    }

    public static void getVisitorList() {
        System.out.println("-------------------------@@---------------------------");
        System.out.println("<--------------@@ Visitors Details  @@--------------->");
        System.out.println("-------------------------@@---------------------------");
        for (Visitor visitor : DataAccess.visitorsInfo) {
            System.out.println("VisitorID          :" + visitor.getVisitorID());
            System.out.println("Visitor Name       :" + visitor.getName());
            System.out.println("Visitor Age        :" + visitor.getAge());
            System.out.println("Appontment Details :" + visitor.getAppointmentDetails());
            System.out.println("------------------------@@------------------------------");
        }
        System.out.println("Total Number of Visitors :" + DataAccess.visitorsInfo.size());
        System.out.println("------------------------@@------------------------------");

    }
}
