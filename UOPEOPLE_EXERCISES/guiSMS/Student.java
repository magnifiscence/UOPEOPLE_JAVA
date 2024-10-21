package guiSMS;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Student {
    private String id;
    private String name;
    private String major;
    private ArrayList<String> courses;
    private Map<String, String> grades;

    public Student(String id, String name, String major) {
        this.id = id;
        this.name = name;
        this.major = major;
        this.courses = new ArrayList<>();
        this.grades = new HashMap<>();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getMajor() {
        return major;
    }

    public ArrayList<String> getCourses() {
        return courses;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public void enrollCourse(String course) {
        courses.add(course);
    }

    public void assignGrade(String course, String grade) {
        grades.put(course, grade);
    }

    public String getGrade(String course) {
        return grades.get(course);
    }
}
