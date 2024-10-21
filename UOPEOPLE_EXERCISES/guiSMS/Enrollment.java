package guiSMS;

public class Enrollment {
    private Student student;
    private String courseId;

    public Enrollment(Student student, String courseId) {
        this.student = student;
        this.courseId = courseId;
    }

    public Student getStudent() {
        return student;
    }

    public String getCourseId() {
        return courseId;
    }
}
