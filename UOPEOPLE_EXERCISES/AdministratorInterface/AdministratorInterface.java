package AdministratorInterface;

import java.util.Scanner;

public class AdministratorInterface {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Add a new course");
            System.out.println("2. Enroll a student");
            System.out.println("3. Assign a grade");
            System.out.println("4. Calculate overall grade");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter course code: ");
                    String courseCode = scanner.nextLine();
                    System.out.print("Enter course name: ");
                    String courseName = scanner.nextLine();
                    System.out.print("Enter maximum capacity: ");
                    int maxCapacity = scanner.nextInt();
                    CourseManagement.addCourse(courseCode, courseName, maxCapacity);
                    System.out.println("Course added successfully.");
                    break;

                case 2:
                    System.out.print("Enter student name: ");
                    String studentName = scanner.nextLine();
                    System.out.print("Enter student ID: ");
                    String studentId = scanner.nextLine();
                    Student student = new Student(studentName, studentId);

                    System.out.print("Enter course code to enroll in: ");
                    courseCode = scanner.nextLine();
                    Course course = findCourse(courseCode);

                    if (course != null) {
                        CourseManagement.enrollStudent(student, course);
                        System.out.println("Student enrolled successfully in course: " + course.getName());
                    } else {
                        System.out.println("Course not found.");
                    }
                    break;

                case 3:
                    System.out.print("Enter student name: ");
                    studentName = scanner.nextLine();
                    System.out.print("Enter student ID: ");
                    studentId = scanner.nextLine();
                    student = new Student(studentName, studentId);

                    System.out.print("Enter course code: ");
                    courseCode = scanner.nextLine();
                    course = findCourse(courseCode);

                    System.out.print("Enter grade: ");
                    int grade = scanner.nextInt();

                    if (course != null) {
                        CourseManagement.assignGrade(student, course, grade);
                        System.out.println("Grade assigned successfully for course: " + course.getName());
                    } else {
                        System.out.println("Course not found.");
                    }
                    break;

                case 4:
                    System.out.print("Enter student name: ");
                    studentName = scanner.nextLine();
                    System.out.print("Enter student ID: ");
                    studentId = scanner.nextLine();
                    student = new Student(studentName, studentId);

                    double overallGrade = CourseManagement.calculateOverallGrade(student);
                    System.out.println("Overall grade for " + student.getName() + ": " + overallGrade);
                    break;

                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    // Helper method to find a course by its course code
    private static Course findCourse(String courseCode) {
        for (Course course : CourseManagement.getCourses()) {
            if (course.getCourseCode().equals(courseCode)) {
                return course;
            }
        }
        return null;
    }
}
