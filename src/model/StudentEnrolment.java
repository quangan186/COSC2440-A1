package model;

public class StudentEnrolment {
    private Student student;
    private Course course;
    private String sem;

    public Student getStudent() {
        return student;
    }

    public Course getCourse() {
        return course;
    }

    public String getSem() {
        return sem;
    }

    public StudentEnrolment(Student student, Course course, String sem) {
        this.student = student;
        this.course = course;
        this.sem = sem;
    }

    @Override
    public String toString() {
        return "StudentEnrolment{" +
                "student=" + student +
                ", course=" + course +
                ", sem='" + sem + '\'' +
                '}';
    }
}
