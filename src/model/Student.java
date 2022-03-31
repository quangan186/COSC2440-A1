package model;

import utility.DateConverter;

import java.text.ParseException;
import java.util.Date;

public class Student {
    private final String studentID;
    private final String name;
    private final Date birthDate;

    public Student(String studentID, String name, Date birthDate) {
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

}
