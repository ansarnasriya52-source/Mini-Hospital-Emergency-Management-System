package hospital;

public class PatientBST {

    PatientNode root;

    public PatientBST() {
        root = null;
    }

    // Insert a new patient
    public void insert(Patient patient) {
        root = insertPatient(root, patient);
    }

    private PatientNode insertPatient(PatientNode root, Patient patient) {

        // If tree is empty
        if (root == null) {
            return new PatientNode(patient);
        }

        // Smaller Patient ID goes to the left
        if (patient.patientId < root.patient.patientId) {
            root.left = insertPatient(root.left, patient);
        }

        // Larger Patient ID goes to the right
        else if (patient.patientId > root.patient.patientId) {
            root.right = insertPatient(root.right, patient);
        }

        return root;
    }


//Search for a patient
public Patient search(int patientId) {
 PatientNode current = root;

 while (current != null) {

     if (patientId == current.patient.patientId) {
         return current.patient;
     }

     if (patientId < current.patient.patientId) {
         current = current.left;
     } else {
         current = current.right;
     }
 }

 return null;
}

 
//Delete a patient
public void delete(int patientId) {
 root = deletePatient(root, patientId);
}

private PatientNode deletePatient(PatientNode root, int patientId) {

 // Patient not found
 if (root == null) {
     return null;
 }

 // Search in left subtree
 if (patientId < root.patient.patientId) {
     root.left = deletePatient(root.left, patientId);
 }

 // Search in right subtree
 else if (patientId > root.patient.patientId) {
     root.right = deletePatient(root.right, patientId);
 }

 // Patient found
 else {

     // No left child
     if (root.left == null) {
         return root.right;
     }

     // No right child
     if (root.right == null) {
         return root.left;
     }

     // Two children
     PatientNode successor = root.right;

     while (successor.left != null) {
         successor = successor.left;
     }

     root.patient = successor.patient;

     root.right = deletePatient(root.right, successor.patient.patientId);
 }

 return root;
} 



//In-order traversal
public void displayPatients() {
 if (root == null) {
     System.out.println("No patients found.");
     return;
 }

 System.out.println("Patients in ascending order of Patient ID:");
 inOrder(root);
}

private void inOrder(PatientNode root) {

 if (root != null) {
     inOrder(root.left);

     root.patient.displayPatient();

     inOrder(root.right);
 }
}
}


