package model;

import utility.DateConverter;

public class StudentEnrolment implements Model{
    private final Student student;
    private final Course course;
    private final String sem;

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

    public String toCsvString(){
        return String.join(",", student.getStudentID(), student.getName(),
                DateConverter.convertDateToString(student.getBirthDate()), course.getCourseID(), course.getCourseName(),
                String.valueOf(course.getCredit()), sem) + "\n";
    }
}
