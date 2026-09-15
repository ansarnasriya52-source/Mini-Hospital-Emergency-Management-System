package hospital;

import java.util.Scanner;

public class HospitalManagementSystem {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        PatientBST patientBST = new PatientBST();
        EmergencyQueue emergencyQueue = new EmergencyQueue();
        TreatmentStack treatmentStack = new TreatmentStack();
        PatientVisitHistory visitHistory = new PatientVisitHistory();

        int choice;

        do {
            System.out.println("\n==============================================");
            System.out.println("   MINI HOSPITAL EMERGENCY MANAGEMENT SYSTEM");
            System.out.println("==============================================");
            System.out.println("1. Add Patient");
            System.out.println("2. Search Patient");
            System.out.println("3. Delete Patient");
            System.out.println("4. Display All Patients");
            System.out.println("5. Add Emergency Patient");
            System.out.println("6. Treat Next Patient");
            System.out.println("7. Display Waiting Queue");
            System.out.println("8. Add Treatment Record");
            System.out.println("9. Remove Latest Treatment");
            System.out.println("10. Display Treatment History");
            System.out.println("11. Add Patient Visit");
            System.out.println("12. Remove Visit");
            System.out.println("13. Search Visit");
            System.out.println("14. Display Visit History");
            System.out.println("0. Exit");
            System.out.println("==============================================");

            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                // 1. Add Patient
                case 1:
                    System.out.print("Enter Patient ID: ");
                    int patientId = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter Patient Name: ");
                    String patientName = scanner.nextLine();

                    System.out.print("Enter Age: ");
                    int age = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter Contact Number: ");
                    String contactNumber = scanner.nextLine();

                    System.out.print("Enter Medical Condition: ");
                    String medicalCondition = scanner.nextLine();

                    Patient patient = new Patient(
                            patientId,
                            patientName,
                            age,
                            contactNumber,
                            medicalCondition
                    );

                    patientBST.insert(patient);

                    System.out.println("Patient added successfully.");
                    break;

                // 2. Search Patient
                case 2:
                    System.out.print("Enter Patient ID to search: ");
                    int searchId = scanner.nextInt();

                    Patient foundPatient = patientBST.search(searchId);

                    if (foundPatient != null) {
                        System.out.println("\nPatient Found:");
                        foundPatient.displayPatient();
                    } else {
                        System.out.println("Patient not found.");
                    }
                    break;

                // 3. Delete Patient
                case 3:
                    System.out.print("Enter Patient ID to delete: ");
                    int deleteId = scanner.nextInt();

                    Patient patientToDelete = patientBST.search(deleteId);

                    if (patientToDelete != null) {
                        patientBST.delete(deleteId);
                        System.out.println("Patient deleted successfully.");
                    } else {
                        System.out.println("Patient not found.");
                    }
                    break;

                // 4. Display Patients
                case 4:
                    System.out.println("\n--- Patient Records ---");
                    patientBST.displayPatients();
                    break;

                // 5. Add Emergency Patient
                case 5:
                    System.out.print("Enter Patient ID: ");
                    int emergencyId = scanner.nextInt();
                    scanner.nextLine();

                    Patient emergencyPatient = patientBST.search(emergencyId);

                    if (emergencyPatient != null) {
                        emergencyQueue.enqueue(emergencyPatient);
                    } else {
                        System.out.println("Patient not found in patient records.");
                    }
                    break;

                // 6. Treat Next Patient
                case 6:
                    System.out.println("\n--- Treat Next Patient ---");
                    Patient nextPatient = emergencyQueue.dequeue();

                    if (nextPatient != null) {
                        System.out.println("Now treating:");
                        nextPatient.displayPatient();
                    }
                    break;

                // 7. Display Queue
                case 7:
                    System.out.println("\n--- Emergency Waiting Queue ---");
                    emergencyQueue.displayQueue();
                    break;

                // 8. Add Treatment
                case 8:
                    System.out.print("Enter Patient ID: ");
                    int treatmentPatientId = scanner.nextInt();
                    scanner.nextLine();

                    Patient treatmentPatient =
                            patientBST.search(treatmentPatientId);

                    if (treatmentPatient != null) {

                        System.out.print("Enter Treatment: ");
                        String treatment = scanner.nextLine();

                        System.out.print("Enter Doctor Name: ");
                        String doctorName = scanner.nextLine();

                        TreatmentRecord record = new TreatmentRecord(
                                treatmentPatient.patientId,
                                treatmentPatient.patientName,
                                treatment,
                                doctorName
                        );

                        treatmentStack.push(record);

                    } else {
                        System.out.println("Patient not found.");
                    }
                    break;

                // 9. Remove Latest Treatment
                case 9:
                    System.out.println("\n--- Remove Latest Treatment ---");
                    treatmentStack.pop();
                    break;

                // 10. Display Treatment History
                case 10:
                    System.out.println("\n--- Treatment History ---");
                    treatmentStack.displayTreatments();
                    break;

                // 11. Add Visit
                case 11:
                    System.out.print("Enter Visit ID: ");
                    int visitId = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter Visit Date (YYYY-MM-DD): ");
                    String visitDate = scanner.nextLine();

                    System.out.print("Enter Doctor Name: ");
                    String visitDoctor = scanner.nextLine();

                    System.out.print("Enter Diagnosis: ");
                    String diagnosis = scanner.nextLine();

                    System.out.print("Enter Treatment: ");
                    String visitTreatment = scanner.nextLine();

                    Visit visit = new Visit(
                            visitId,
                            visitDate,
                            visitDoctor,
                            diagnosis,
                            visitTreatment
                    );

                    visitHistory.addVisit(visit);

                    System.out.println("Visit added successfully.");
                    break;

                // 12. Remove Visit
                case 12:
                    System.out.print("Enter Visit ID to remove: ");
                    int removeVisitId = scanner.nextInt();

                    visitHistory.removeVisit(removeVisitId);
                    break;

                // 13. Search Visit
                case 13:
                    System.out.print("Enter Visit ID to search: ");
                    int searchVisitId = scanner.nextInt();

                    Visit foundVisit =
                            visitHistory.searchVisit(searchVisitId);

                    if (foundVisit != null) {
                        System.out.println("\nVisit Found:");
                        foundVisit.displayVisit();
                    } else {
                        System.out.println("Visit not found.");
                    }
                    break;

                // 14. Display Visit History
                case 14:
                    System.out.println("\n--- Patient Visit History ---");
                    visitHistory.displayVisitHistory();
                    break;

                // Exit
                case 0:
                    System.out.println("Thank you for using the system.");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }

        } while (choice != 0);

        scanner.close();
    }
}