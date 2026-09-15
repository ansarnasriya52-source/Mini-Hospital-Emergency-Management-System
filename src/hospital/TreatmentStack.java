package hospital;

import java.util.Stack;

public class TreatmentStack {

    Stack<TreatmentRecord> treatmentStack;

    public TreatmentStack() {
        treatmentStack = new Stack<>();
    }

//Add completed treatment to stack
public void push(TreatmentRecord record) {
 treatmentStack.push(record);

 System.out.println("Treatment record added for Patient ID: "
         + record.patientId);
}

//Remove the most recently completed treatment
public TreatmentRecord pop() {

 if (treatmentStack.isEmpty()) {
     System.out.println("Treatment history is empty.");
     return null;
 }

 TreatmentRecord record = treatmentStack.pop();

 System.out.println("Treatment record removed for Patient ID: "
         + record.patientId);

 return record;
}

//Display all treatment records
public void displayTreatments() {

 if (treatmentStack.isEmpty()) {
     System.out.println("No treatment records found.");
     return;
 }

 System.out.println("Treatment History:");

 for (TreatmentRecord record : treatmentStack) {
     record.displayTreatment();
 }
}
}