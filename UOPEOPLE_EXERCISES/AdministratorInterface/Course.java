package AdministratorInterface;

public class Course {
    private String courseCode;
    private String name;
    private int maxCapacity;
    private static int totalEnrolledStudents = 0;

    public Course(String courseCode, String name, int maxCapacity) {
        this.courseCode = courseCode;
        this.name = name;
        this.maxCapacity = maxCapacity;
    }

    // Getter for courseCode
    public String getCourseCode() {
        return courseCode;
    }

    // Getter for name
    public String getName() {
        return name;
    }

    // Getter for maxCapacity
    public int getMaxCapacity() {
        return maxCapacity;
    }

    // Static method to retrieve total number of enrolled students
    public static int getTotalEnrolledStudents() {
        return totalEnrolledStudents;
    }

    // Method to enroll a student
    public void enrollStudent() {
        if (totalEnrolledStudents < maxCapacity) {
            totalEnrolledStudents++;
        } else {
            System.out.println("Course capacity reached.");
        }
    }

}
