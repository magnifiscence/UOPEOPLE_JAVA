import java.util.ArrayList;
import java.util.Scanner;

public class StudentManagement {
    // Static list to store all student objects
    private static ArrayList<Student> students = new ArrayList<>();

    // Method to add a new student to the list
    public static void addStudent(String name, int id, int age, String grade) {
        students.add(new Student(name, id, age, grade));
    }

    // Method to update an existing student's information
    public static void updateStudent(int id, String newName, int newAge, String newGrade) {
        for (Student student : students) {
            if (student.getId() == id) {
                student.setName(newName);
                student.setAge(newAge);
                student.setGrade(newGrade);
                return;
            }
        }
        System.out.println("Student ID not found.");
    }

    // Method to view a specific student's information by ID
    public static void viewStudent(int id) {
        for (Student student : students) {
            if (student.getId() == id) {
                System.out.println(student);
                return;
            }
        }
        System.out.println("Student ID not found.");
    }

    // Method to view all students' information
    public static void viewAllStudents() {
        for (Student student : students) {
            System.out.println(student);
        }
    }

    // Main method to run the program
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Scanner object to read user input
        try {
            while (true) {
                // Display menu options
                System.out.println("1. Add Student");
                System.out.println("2. Update Student");
                System.out.println("3. View Student");
                System.out.println("4. View All Students");
                System.out.println("5. Exit");
                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt(); // Read user's choice
                switch (choice) {
                    case 1:
                        // Add a new student
                        System.out.print("Enter name: ");
                        String name = scanner.next();
                        System.out.print("Enter ID: ");
                        int id = scanner.nextInt();
                        System.out.print("Enter age: ");
                        int age = scanner.nextInt();
                        System.out.print("Enter grade: ");
                        String grade = scanner.next();
                        addStudent(name, id, age, grade);
                        break;
                    case 2:
                        // Update an existing student
                        System.out.print("Enter ID of student to update: ");
                        int updateId = scanner.nextInt();
                        System.out.print("Enter new name: ");
                        String newName = scanner.next();
                        System.out.print("Enter new age: ");
                        int newAge = scanner.nextInt();
                        System.out.print("Enter new grade: ");
                        String newGrade = scanner.next();
                        updateStudent(updateId, newName, newAge, newGrade);
                        break;
                    case 3:
                        // View a specific student
                        System.out.print("Enter ID of student to view: ");
                        int viewId = scanner.nextInt();
                        viewStudent(viewId);
                        break;
                    case 4:
                        // View all students
                        viewAllStudents();
                        break;
                    case 5:
                        // Exit the program
                        return;
                    default:
                        // Handle invalid choices
                        System.out.println("Invalid choice. Please try again.");
                }
            }
        } finally {
            scanner.close(); // Close the scanner to prevent resource leaks
        }
    }
}
