# Mini Hospital Emergency Management System

## Introduction

The Mini Hospital Emergency Management System is a Java-based console application developed to manage basic hospital emergency operations using different data structures.

The system demonstrates how data structures can be used to manage patient records, emergency patients, treatment records, and patient visit history.

## Objectives

- Manage patient records efficiently.
- Store patient records using a Binary Search Tree.
- Manage emergency patients using a Queue.
- Manage treatment records using a Stack.
- Manage patient visit records using a Singly Linked List.
- Provide search, insertion, deletion, and display operations.
- Demonstrate the practical use of data structures in Java.

## Data Structures Used

### 1. Binary Search Tree (BST)

The Binary Search Tree is used to store patient records based on the Patient ID.

Operations:
- Insert patient
- Search patient
- Delete patient
- Display patients in ascending Patient ID order

### 2. Queue

A Queue is used to manage emergency patients.

Operations:
- Enqueue emergency patient
- Dequeue the next patient
- Display waiting patients
- Handle an empty queue

The Queue follows the FIFO (First In, First Out) principle.

### 3. Stack

A Stack is used to store treatment records.

Operations:
- Add treatment record
- Remove the latest treatment record
- Display treatment history
- Handle an empty stack

The Stack follows the LIFO (Last In, First Out) principle.

### 4. Singly Linked List

A Singly Linked List is used to manage patient visit records.

Operations:
- Add visit
- Remove visit
- Search visit
- Display visit history

## Technologies Used

- Java
- Visual Studio Code
- Git
- GitHub

## Project Structure

```text
Mini-Hospital-Emergency-Management-System
│
├── src
│   └── hospital
│       ├── EmergencyQueue.java
│       ├── HospitalManagementSystem.java
│       ├── Patient.java
│       ├── PatientBST.java
│       ├── PatientNode.java
│       ├── PatientVisitHistory.java
│       ├── TreatmentRecord.java
│       ├── TreatmentStack.java
│       ├── Visit.java
│       └── VisitNode.java
│
└── README.md
