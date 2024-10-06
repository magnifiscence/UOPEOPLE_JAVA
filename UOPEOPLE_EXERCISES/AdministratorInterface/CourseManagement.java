package AdministratorInterface;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CourseManagement {
    private static List<Course> courses = new ArrayList<>();
    private static Map<Student, Map<Course, Integer>> studentGrades = new HashMap<>();

    // Method to add a new course
    public static void addCourse(String courseCode, String name, int maxCapacity) {
        Course course = new Course(courseCode, name, maxCapacity);
        courses.add(course);
    }

    // Method to enroll a student in a course
    public static void enrollStudent(Student student, Course course) {
        student.enrollInCourse(course);
        course.enrollStudent();
    }

    // Method to assign a grade to a student for a course
    public static void assignGrade(Student student, Course course, int grade) {
        student.assignGrade(course, grade);
        studentGrades.computeIfAbsent(student, k -> new HashMap<>()).put(course, grade);
    }

    // Method to calculate the overall grade for a student
    public static double calculateOverallGrade(Student student) {
        Map<Course, Integer> grades = studentGrades.get(student);
        if (grades == null || grades.isEmpty()) {
            return 0;
        }
        int totalGrades = 0;
        for (int grade : grades.values()) {
            totalGrades += grade;
        }
        return (double) totalGrades / grades.size();
    }

    // Method to find a course by course code
    public static Course findCourse(String courseCode) {
        for (Course course : courses) {
            if (course.getCourseCode().equals(courseCode)) {
                return course;
            }
        }
        return null;
    }

    // Method to get the list of all courses
    public static List<Course> getCourses() {
        return courses;
    }
}
