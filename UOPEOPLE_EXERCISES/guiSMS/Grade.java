package guiSMS;

public class Grade {
    private Student student;
    private String courseId;
    private String grade;

    public Grade(Student student, String courseId, String grade) {
        this.student = student;
        this.courseId = courseId;
        this.grade = grade;
    }

    public Student getStudent() {
        return student;
    }

    public String getCourseId() {
        return courseId;
    }

    public String getGrade() {
        return grade;
    }
}
