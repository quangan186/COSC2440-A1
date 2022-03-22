package model;

import java.util.Date;

public class Student {
    private String studentID;
    private String name;
    private Date birthDate;

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
}
