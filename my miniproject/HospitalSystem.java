import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Patient {
    private int id;
    private String name;
    private int age;
    private String disease;

    public Patient(int id, String name, int age, String disease) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.disease = disease;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public int getAge() { return age; }
    public String getDisease() { return disease; }

    public void setName(String name) { this.name = name; }
    public void setAge(int age) { this.age = age; }
    public void setDisease(String disease) { this.disease = disease; }

    @Override
    public String toString() {
        return "Patient ID: " + id + ", Name: " + name + 
               ", Age: " + age + ", Disease: " + disease;
    }
}

public class HospitalSystem {
    private static Map<Integer, Patient> patientRecords = new HashMap<>();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        int choice;
        do {
            System.out.println("\n===== HOSPITAL PATIENT RECORD SYSTEM =====");
            System.out.println("1. Add Patient");
            System.out.println("2. View Patient");
            System.out.println("3. Update Patient");
            System.out.println("4. Delete Patient");
            System.out.println("5. Show All Patients");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1: addPatient(); break;
                case 2: viewPatient(); break;
                case 3: updatePatient(); break;
                case 4: deletePatient(); break;
                case 5: showAllPatients(); break;
                case 6: System.out.println("Exiting..."); break;
                default: System.out.println("Invalid choice!");
            }
        } while (choice != 6);
    }

    private static void addPatient() {
        System.out.print("Enter Patient ID: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Age: ");
        int age = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Disease: ");
        String disease = sc.nextLine();

        Patient p = new Patient(id, name, age, disease);
        patientRecords.put(id, p);
        System.out.println("Patient added successfully!");
    }

    private static void viewPatient() {
        System.out.print("Enter Patient ID to view: ");
        int id = sc.nextInt();
        Patient p = patientRecords.get(id);
        if (p != null)
            System.out.println(p);
        else
            System.out.println("Patient not found!");
    }

    private static void updatePatient() {
        System.out.print("Enter Patient ID to update: ");
        int id = sc.nextInt();
        sc.nextLine();
        Patient p = patientRecords.get(id);

        if (p != null) {
            System.out.print("Enter new Name: ");
            p.setName(sc.nextLine());
            System.out.print("Enter new Age: ");
            p.setAge(sc.nextInt());
            sc.nextLine();
            System.out.print("Enter new Disease: ");
            p.setDisease(sc.nextLine());
            System.out.println("Patient updated successfully!");
        } else {
            System.out.println("Patient not found!");
        }
    }

    private static void deletePatient() {
        System.out.print("Enter Patient ID to delete: ");
        int id = sc.nextInt();
        if (patientRecords.remove(id) != null)
            System.out.println("Patient deleted successfully!");
        else
            System.out.println("Patient not found!");
    }

    private static void showAllPatients() {
        if (patientRecords.isEmpty()) {
            System.out.println("No patient records found!");
        } else {
            for (Patient p : patientRecords.values()) {
                System.out.println(p);
            }
        }
    }
}