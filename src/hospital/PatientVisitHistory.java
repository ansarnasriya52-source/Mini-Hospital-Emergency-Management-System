package hospital;

public class PatientVisitHistory {

    VisitNode head;

    public PatientVisitHistory() {
        head = null;
    }

    // Add a new visit
    public void addVisit(Visit visit) {

        VisitNode newNode = new VisitNode(visit);

        if (head == null) {
            head = newNode;
            return;
        }

        VisitNode current = head;

        while (current.next != null) {
            current = current.next;
        }

        current.next = newNode;
    }

//Remove a visit using Visit ID
public void removeVisit(int visitId) {

 if (head == null) {
     System.out.println("Visit history is empty.");
     return;
 }

 // If the first visit has the given ID
 if (head.visit.visitId == visitId) {
     head = head.next;
     System.out.println("Visit ID " + visitId + " removed.");
     return;
 
 }
 VisitNode current = head;

 while (current.next != null) {

     if (current.next.visit.visitId == visitId) {
         current.next = current.next.next;
         System.out.println("Visit ID " + visitId + " removed.");
         return;
     }

     current = current.next;
 }

 System.out.println("Visit ID " + visitId + " not found.");
}

//Search for a visit using Visit ID
public Visit searchVisit(int visitId) {

 VisitNode current = head;

 while (current != null) {

     if (current.visit.visitId == visitId) {
         return current.visit;
     }

     current = current.next;
 }

 return null;
}

//Display all previous visits
public void displayVisitHistory() {

 if (head == null) {
     System.out.println("No previous visits found.");
     return;
 }

 System.out.println("Patient Visit History:");

 VisitNode current = head;

 while (current != null) {
     current.visit.displayVisit();
     current = current.next;
 }
}
}