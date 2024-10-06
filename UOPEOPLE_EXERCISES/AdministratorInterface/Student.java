package AdministratorInterface;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Student {
    private String name;
    private String id;
    private List<Course> enrolledCourses;
    private Map<Course, Integer> grades;

    public Student(String name, String id) {
        this.name = name;
        this.id = id;
        this.enrolledCourses = new ArrayList<>();
        this.grades = new HashMap<>();
    }

    // Getter and Setter for name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Getter and Setter for id
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    // Getter for enrolledCourses
    public List<Course> getEnrolledCourses() {
        return enrolledCourses;
    }

    // Method to enroll in a course
    public void enrollInCourse(Course course) {
        enrolledCourses.add(course);
    }

    // Method to assign grade
    public void assignGrade(Course course, int grade) {
        grades.put(course, grade);
    }

    // Method to calculate overall grade
    public double calculateOverallGrade() {
        int totalGrades = 0;
        for (int grade : grades.values()) {
            totalGrades += grade;
        }
        return grades.size() > 0 ? (double) totalGrades / grades.size() : 0;
    }
}
