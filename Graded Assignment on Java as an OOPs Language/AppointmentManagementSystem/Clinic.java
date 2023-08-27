package AppointmentManagementSystem;

import java.time.LocalDate;
import java.util.Scanner;

public class Clinic {
    private LocalDate date;

    public LocalDate getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "Clinic [date=" + date + ", slot1=" + slot1 + ", slot2=" + slot2 + ", slot3=" + slot3 + "]";
    }

    public Clinic(LocalDate date, String slot1, String slot2, String slot3) {
        this.date = date;
        this.slot1 = slot1;
        this.slot2 = slot2;
        this.slot3 = slot3;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    private String slot1;
    private String slot2;
    private String slot3;

    public String getSlot1() {
        return slot1;
    }

    public void setSlot1(String slot1) {
        this.slot1 = slot1;
    }

    public String getSlot2() {
        return slot2;
    }

    public void setSlot2(String slot2) {
        this.slot2 = slot2;
    }

    public String getSlot3() {
        return slot3;
    }

    public void setSlot3(String slot3) {
        this.slot3 = slot3;
    }

    public static void bookAppointment() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your  VisitorID :");
        String visitorID = sc.next();
        String name = "";
        boolean visitorFound = false;
        for (Visitor visitor : DataAccess.visitorsInfo) {
            if (visitor.getVisitorID().equals(visitorID)) {
                visitorFound = true;
                name = visitor.getName();

                System.out.print("Select Appointment Date (YYYY-MM-DD):2023-08-11 : ");
                String d = sc.next();
                LocalDate date = LocalDate.parse(d);

                System.out.println("Available Time Slots:");
                for (Clinic clinic : DataAccess.clinicInfo) {
                    if (clinic.getDate().isEqual(date)) {
                        if (clinic.getSlot1().equalsIgnoreCase("null")) {
                            System.out.println("1. 09:00 AM - 10:00 AM");
                        }
                        if (clinic.getSlot2().equalsIgnoreCase("null")) {
                            System.out.println("2. 10:00 AM - 11:00 AM");
                        }
                        if (clinic.getSlot3().equalsIgnoreCase("null")) {
                            System.out.println("3. 11:00 AM - 12:00 AM");
                        }
                        System.out.println("----------------@@--------------------");
                        System.out.print("Enter yout choice : ");
                        int choice = sc.nextInt();
                        System.out.println("----------------@@--------------------");
                        switch (choice) {
                            case 1:
                                if (clinic.getSlot2().equals("null")) {
                                    System.out
                                            .println("**************************************************************");

                                    System.out.println("Selected Time Slot :" + choice);

                                    System.out.println(
                                            "Visitor " + name + " appointment on " + date
                                                    + " at 09:00 AM has been booked.");
                                    clinic.setSlot1(visitorID);
                                    DataAccess.loadClinicDataIntoFile();

                                    System.out
                                            .println("**************************************************************");
                                } else {
                                    System.out.println("Slot already booked May be you enter wrong choice ");
                                }
                                break;
                            case 2:
                                if (clinic.getSlot2().equals("null")) {
                                    System.out
                                            .println("**************************************************************");
                                    System.out.println("Selected Time Slot :" + choice);

                                    System.out.println(
                                            "Visitor " + name + " appointment on " + date
                                                    + " at 10:00 AM has been booked.");
                                    clinic.setSlot2(visitorID);
                                    DataAccess.loadClinicDataIntoFile();

                                    System.out
                                            .println("**************************************************************");
                                } else {
                                    System.out.println("Slot already booked May be you enter wrong choice ");
                                }
                                break;
                            case 3:
                                if (clinic.getSlot2().equals("null")) {
                                    System.out
                                            .println("**************************************************************");

                                    System.out.println("Selected Time Slot :" + choice);

                                    System.out.println(
                                            "Visitor " + name + " appointment on " + date
                                                    + " at 11:00 AM has been booked.");
                                    clinic.setSlot3(visitorID);
                                    DataAccess.loadClinicDataIntoFile();

                                    System.out
                                            .println("**************************************************************");
                                } else {
                                    System.out.println("Slot already booked May be you enter wrong choice ");
                                }
                                break;

                            default:
                                break;
                        }
                    }

                }
            }
        }
        if (!visitorFound) {
            System.out.println("Visitor ID not present");
        }
    }

    public static void viewScheduledAppointment() {
        Scanner sc = new Scanner(System.in);
        System.out.println("-----------@@----------------@@---------------@@---------------------@@------------------");
        System.out.print("Enter the Date for which you want to see appointment schedules.:2023-08-11:");
        String date = sc.nextLine();
        LocalDate d = LocalDate.parse(date);
        for (Clinic clinic : DataAccess.clinicInfo) {
            if (clinic.getDate().equals(d)) {
                if (clinic.getSlot1().equals("null")) {
                    System.out.println("1. 09:00 AM - 10:00 AM -->Available");
                } else {
                    System.out.println("1. 09:00 AM - 10:00 AM -->Booked" + " VisitorID :" + clinic.getSlot1());

                }

                if (clinic.getSlot2().equals("null")) {
                    System.out.println("2. 10:00 AM - 11:00 AM -->Available");

                } else {
                    System.out.println("2. 10:00 AM - 11:00 AM -->Booked" + " VisitorID :" + clinic.getSlot2());

                }

                if (clinic.getSlot3().equalsIgnoreCase("null")) {
                    System.out.println("3. 11:00 AM - 12:00 AM -->Available");
                } else {
                    System.out.println("3. 11:00 AM - 12:00 AM -->Booked" + " VisitorID :" + clinic.getSlot3());

                }

            }

        }
        System.out.println("-----------@@----------------@@---------------@@---------------------@@------------------");
    }

    public static void cancelAppointment() {
        Scanner sc = new Scanner(System.in);
        System.out.println("-----------@@----------------@@---------------@@---------------------@@------------------");
        System.err.print("Enter the Date for which you want to cancel apointment (2023-08-11) :");
        String date = sc.nextLine();
        System.out.println("------------------------------@@-------------------------");

        LocalDate d = LocalDate.parse(date);
        for (Clinic clinic : DataAccess.clinicInfo) {
            if (clinic.getDate().equals(d)) {
                if (!(clinic.getSlot1().equals("null") && clinic.getSlot2().equals("null")
                        && clinic.getSlot3().equalsIgnoreCase("null"))) {
                    if (clinic.getSlot1().equals("null")) {
                        System.out.println("1. 09:00 AM - 10:00 AM -->Available");
                    } else {
                        System.out.println("1. 09:00 AM - 10:00 AM -->Booked" + " VisitorID :" + clinic.getSlot1());

                    }

                    if (clinic.getSlot2().equals("null")) {
                        System.out.println("2. 10:00 AM - 11:00 AM -->Available");

                    } else {
                        System.out.println("2. 10:00 AM - 11:00 AM -->Booked" + " VisitorID :" + clinic.getSlot2());

                    }

                    if (clinic.getSlot3().equalsIgnoreCase("null")) {
                        System.out.println("3. 11:00 AM - 12:00 AM -->Available");
                    } else {
                        System.out.println("3. 11:00 AM - 12:00 AM -->Booked" + " VisitorID :" + clinic.getSlot3());

                    }
                    System.out.println("------------------------------@@-------------------------");

                    System.out.print("Enter the VisitorID to cancel the Visitor's appointment :");
                    String slot = sc.next();
                    if (clinic.getSlot1().equals(slot)) {
                        clinic.setSlot1("null");
                    } else if (clinic.getSlot2().equals(slot)) {
                        clinic.setSlot2("null");
                    } else if (clinic.getSlot3().equals(slot)) {
                        clinic.setSlot3("null");
                    } else {
                        System.out.println("Visitor ID is wrong ");
                    }
                    System.out.print("Enter C to confirm the appontment Cancellation :");
                    String confirm = sc.next();
                    if (confirm.equalsIgnoreCase("c")) {
                        DataAccess.loadClinicDataIntoFile();
                    }
                } else {
                    System.out.println("There is no Appontment Scheduled for a day");
                }
            }

        }

        System.out.println("-----------@@----------------@@---------------@@---------------------@@------------------");

    }
}
