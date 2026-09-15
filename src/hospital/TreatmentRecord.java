package hospital;

public class TreatmentRecord {

    int patientId;
    String patientName;
    String treatment;
    String doctorName;

    public TreatmentRecord(int patientId, String patientName,
                           String treatment, String doctorName) {

        this.patientId = patientId;
        this.patientName = patientName;
        this.treatment = treatment;
        this.doctorName = doctorName;
    }

    public void displayTreatment() {
        System.out.println("Patient ID: " + patientId);
        System.out.println("Patient Name: " + patientName);
        System.out.println("Treatment: " + treatment);
        System.out.println("Doctor Name: " + doctorName);
        System.out.println("-----------------------------");
    }
}