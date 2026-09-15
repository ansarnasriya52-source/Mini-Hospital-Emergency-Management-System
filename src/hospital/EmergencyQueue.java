package hospital;

import java.util.LinkedList;
import java.util.Queue;

public class EmergencyQueue {

    Queue<Patient> waitingQueue;

    public EmergencyQueue() {
        waitingQueue = new LinkedList<>();
    }

//Add patient to emergency queue
public void enqueue(Patient patient) {
 waitingQueue.offer(patient);
 System.out.println("Patient " + patient.patientId + " added to emergency queue.");
}

//Remove the next patient from emergency queue
public Patient dequeue() {

 if (waitingQueue.isEmpty()) {
     System.out.println("Emergency queue is empty.");
     return null;
 }

 Patient patient = waitingQueue.poll();

 System.out.println("Patient " + patient.patientId
         + " removed from emergency queue.");

 return patient;
}


//Display all patients waiting in the queue
public void displayQueue() {

 if (waitingQueue.isEmpty()) {
     System.out.println("No patients are waiting in the emergency queue.");
     return;
 }

 System.out.println("Patients currently waiting:");

 for (Patient patient : waitingQueue) {
     System.out.println("Patient ID: " + patient.patientId
             + " | Name: " + patient.patientName);
 }
}
}