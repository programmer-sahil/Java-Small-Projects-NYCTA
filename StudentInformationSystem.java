// Project 4: Student Information System in Java (Intermediate Project)

// Importing necessary libraries for scanner and linked list operations
import java.util.Scanner;

// Student class to represent student information
class Student {
    // Attributes of the Student class (Encapsulation)
    private int id;
    private String name;
    private String department;
    private double grade;

    // Constructor to initialize student data
    public Student(int id, String name, String department, double grade) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.grade = grade;
    }

    // Getter and Setter methods (Encapsulation)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    // Method to display student information
    public void displayStudentDetails() {
        System.out.println("ID: " + id + ", Name: " + name + ", Department: " + department + ", Grade: " + grade);
    }
}

// LinkedList class to store student data
class StudentLinkedList {
    private class Node {
        Student student;
        Node next;

        public Node(Student student) {
            this.student = student;
            this.next = null;
        }
    }

    private Node head; // Head of the list

    // Method to add a student to the linked list
    public void addStudent(Student student) {
        Node newNode = new Node(student);
        if (head == null) {
            head = newNode; // If list is empty, set new node as head
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next; // Traverse the list
            }
            temp.next = newNode; // Add new node at the end
        }
    }

    // Method to display all students
    public void displayAllStudents() {
        Node temp = head;
        if (temp == null) {
            System.out.println("No students in the list.");
            return;
        }
        while (temp != null) {
            temp.student.displayStudentDetails();
            temp = temp.next; // Move to the next node
        }
    }

    // Method to search a student by ID using a Linear Search (could be improved with Binary Search Tree)
    public Student searchStudentById(int id) {
        Node temp = head;
        while (temp != null) {
            if (temp.student.getId() == id) {
                return temp.student; // Return student if ID matches
            }
            temp = temp.next;
        }
        return null; // Return null if student is not found
    }
}

// Binary Search Tree class to perform student search by ID
class StudentBST {
    private class TreeNode {
        Student student;
        TreeNode left, right;

        public TreeNode(Student student) {
            this.student = student;
            this.left = this.right = null;
        }
    }

    private TreeNode root;

    // Insert a student into the binary search tree
    public void insertStudent(Student student) {
        root = insertRecursive(root, student);
    }

    private TreeNode insertRecursive(TreeNode root, Student student) {
        if (root == null) {
            return new TreeNode(student);
        }
        if (student.getId() < root.student.getId()) {
            root.left = insertRecursive(root.left, student);
        } else if (student.getId() > root.student.getId()) {
            root.right = insertRecursive(root.right, student);
        }
        return root;
    }

    // Search a student by ID using Binary Search
    public Student searchStudentById(int id) {
        return searchRecursive(root, id);
    }

    private Student searchRecursive(TreeNode root, int id) {
        if (root == null) {
            return null;
        }
        if (id == root.student.getId()) {
            return root.student; // Found the student
        }
        return (id < root.student.getId()) ? searchRecursive(root.left, id) : searchRecursive(root.right, id);
    }
}

// Main class to manage user interaction and menu
public class StudentInformationSystem {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentLinkedList studentList = new StudentLinkedList();
        StudentBST studentBST = new StudentBST();

        while (true) {
            // Display menu options to the user
            System.out.println("Student Information System");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Search Student by ID (LinkedList)");
            System.out.println("4. Search Student by ID (BST)");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    // Add a student
                    System.out.print("Enter Student ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter Student Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Department: ");
                    String department = scanner.nextLine();
                    System.out.print("Enter Grade: ");
                    double grade = scanner.nextDouble();
                    Student student = new Student(id, name, department, grade);
                    studentList.addStudent(student);
                    studentBST.insertStudent(student);
                    System.out.println("Student added successfully!");
                    break;
                case 2:
                    // View all students
                    System.out.println("All Students:");
                    studentList.displayAllStudents();
                    break;
                case 3:
                    // Search student by ID using LinkedList
                    System.out.print("Enter Student ID to search (LinkedList): ");
                    int searchId1 = scanner.nextInt();
                    Student foundStudent1 = studentList.searchStudentById(searchId1);
                    if (foundStudent1 != null) {
                        foundStudent1.displayStudentDetails();
                    } else {
                        System.out.println("Student not found!");
                    }
                    break;
                case 4:
                    // Search student by ID using Binary Search Tree
                    System.out.print("Enter Student ID to search (BST): ");
                    int searchId2 = scanner.nextInt();
                    Student foundStudent2 = studentBST.searchStudentById(searchId2);
                    if (foundStudent2 != null) {
                        foundStudent2.displayStudentDetails();
                    } else {
                        System.out.println("Student not found!");
                    }
                    break;
                case 5:
                    // Exit the program
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}
