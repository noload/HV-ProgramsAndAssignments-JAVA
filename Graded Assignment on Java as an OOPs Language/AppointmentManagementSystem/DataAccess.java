package AppointmentManagementSystem;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DataAccess {
    static String visitorFile = "AppointmentManagementSystem/visitorDetails.csv";
    static String appointmentFile = "AppointmentManagementSystem/appointmentList.csv";
    public static List<Visitor> visitorsInfo = new ArrayList<Visitor>();
    public static List<Clinic> clinicInfo = new ArrayList<>();

    public DataAccess() {
        loadClinicDetails();
        loadVisitorDetails();
    }

    public static List<Visitor> loadVisitorDetails() {
        try {
            BufferedReader br = new BufferedReader(new FileReader(visitorFile));
            String line;
            // Name,Age,PhoneNumber,AppointmentDetails
            // Vaibhav,25,88888,HeadAck
            br.readLine();
            while ((line = br.readLine()) != null) {
                String arr[] = line.split(",");
                String visitorID = arr[0];
                String name = arr[1];
                int age = Integer.parseInt(arr[2].trim());
                String phNo = arr[3];
                String AppDetails = arr[4];
                visitorsInfo.add(new Visitor(visitorID, name, age, phNo,AppDetails));

            }
            br.close();
        } catch (Exception e) {

        }
        return visitorsInfo;
    }

    public static List<Clinic> loadClinicDetails() {
        try {
            BufferedReader br = new BufferedReader(new FileReader(appointmentFile));
            String line;
            // Date,Slot1,Slot2,Slot2
            // 2023-08-11,null,null,null
            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] arr = line.split(",");
                LocalDate date = LocalDate.parse(arr[0]);
                String slot1 = arr[1];
                String slot2 = arr[2];
                String slot3 = arr[3];

                clinicInfo.add(new Clinic(date, slot1, slot2, slot3));

            }
            br.close();
        } catch (Exception e) {
            e.getMessage();
        }
        return clinicInfo;
    }

    public static void loadVisitorDataIntoFile() {
        String updatedData = "";
        for (Visitor visitor : DataAccess.visitorsInfo) {
            updatedData += System.lineSeparator() + visitor.getVisitorID() + "," + visitor.getName() + ","
                    + visitor.getAge() + "," + visitor.getPhoneNumber() + "," + visitor.getAppointmentDetails();

        }
        try {
            FileWriter fw = new FileWriter(visitorFile);
            fw.write("VisitorID,Name,Age,PhoneNumber,AppointmentDetails");
            fw.append(updatedData);
            fw.close();
        } catch (Exception e) {
            e.getMessage();
        }
    }

    public static void loadClinicDataIntoFile() {
        String updatedData = "";
        for (Clinic clinic : DataAccess.clinicInfo) {
            updatedData += System.lineSeparator() + clinic.getDate() + "," + clinic.getSlot1() + ","
                    + clinic.getSlot2() + "," + clinic.getSlot3();

        }
        try {
            FileWriter fw = new FileWriter(appointmentFile);
            fw.write("Date,Slot1,Slot2,Slot3");
            fw.append(updatedData);
            fw.close();
        } catch (Exception e) {
            e.getMessage();
        }
    }

}
