package model;

import utility.DateConverter;

import java.util.Date;
import java.util.Objects;

public class Student implements Model{
    private final String studentID;
    private final String name;
    private final Date birthDate;

    public Student(String studentID, String name, Date birthDate){
        this.studentID = studentID;
        this.name = name;
        this.birthDate = birthDate;
    }

    public String getStudentID() {
        return studentID;
    }

    public String getName() {
        return name;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentID='" + studentID + '\'' +
                ", name='" + name + '\'' +
                ", birthDate=" + birthDate +
                '}';
    }
    public String toCsvString(){
        return String.join(",", studentID, name, DateConverter.convertDateToString(birthDate)) + "\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(studentID, student.studentID) && Objects.equals(name, student.name) && Objects.equals(birthDate, student.birthDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentID, name, birthDate);
    }
}
