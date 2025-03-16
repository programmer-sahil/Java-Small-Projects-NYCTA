import java.util.*;

class Employee {
    int id;
    String name;
    String department;
    double salary;

    public Employee(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public void displayDetails() {
        System.out.println("Employee ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Department: " + department);
        System.out.println("Salary: " + salary);
    }
}

public class EmployeeManagementSystem {

    private static List<Employee> employees = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("Employee Management System");
            System.out.println("1. Add Employee");
            System.out.println("2. View Employee");
            System.out.println("3. Update Employee");
            System.out.println("4. Delete Employee");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline left-over

            switch (choice) {
                case 1:
                    addEmployee();
                    break;
                case 2:
                    viewEmployee();
                    break;
                case 3:
                    updateEmployee();
                    break;
                case 4:
                    deleteEmployee();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }

    private static void addEmployee() {
        System.out.print("Enter Employee ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();  // Consume newline
        System.out.print("Enter Employee Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Department: ");
        String department = scanner.nextLine();
        System.out.print("Enter Salary: ");
        double salary = scanner.nextDouble();

        employees.add(new Employee(id, name, department, salary));
        System.out.println("Employee added successfully!");
    }

    private static void viewEmployee() {
        System.out.print("Enter Employee ID to view: ");
        int id = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        Employee foundEmployee = null;
        for (Employee emp : employees) {
            if (emp.id == id) {
                foundEmployee = emp;
                break;
            }
        }

        if (foundEmployee != null) {
            foundEmployee.displayDetails();
        } else {
            System.out.println("Employee not found!");
        }
    }

    private static void updateEmployee() {
        System.out.print("Enter Employee ID to update: ");
        int id = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        Employee foundEmployee = null;
        for (Employee emp : employees) {
            if (emp.id == id) {
                foundEmployee = emp;
                break;
            }
        }

        if (foundEmployee != null) {
            System.out.print("Enter new Name: ");
            foundEmployee.name = scanner.nextLine();
            System.out.print("Enter new Department: ");
            foundEmployee.department = scanner.nextLine();
            System.out.print("Enter new Salary: ");
            foundEmployee.salary = scanner.nextDouble();
            System.out.println("Employee details updated successfully!");
        } else {
            System.out.println("Employee not found!");
        }
    }

    private static void deleteEmployee() {
        System.out.print("Enter Employee ID to delete: ");
        int id = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        Employee foundEmployee = null;
        for (Employee emp : employees) {
            if (emp.id == id) {
                foundEmployee = emp;
                break;
            }
        }

        if (foundEmployee != null) {
            employees.remove(foundEmployee);
            System.out.println("Employee deleted successfully!");
        } else {
            System.out.println("Employee not found!");
        }
    }
}
