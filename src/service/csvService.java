package service;

import model.Course;
import model.Student;
import model.StudentEnrolment;
import repo.StudentEnrolmentManager;
import utility.DateConverter;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;

public class csvService {
    private StudentEnrolmentManager sem;

    public csvService(StudentEnrolmentManager sem) {
        this.sem = sem;
    }

    private Student convertCsvToStudent(String csv){
        String[] fields = csv.split(",");
        String sid = fields[0].trim();
        String studentName = fields[1].trim();
        Date birthDate = null;
        try {
            birthDate = DateConverter.convertStringToDate(fields[2]);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return new Student(sid, studentName, birthDate);
    }

    private Course convertCsvToCourse(String csv){
        String[] fields = csv.split(",");
        String cid = fields[3].trim();
        String courseName = fields[4].trim();
        int credit = Integer.parseInt(fields[5]);

        return new Course(cid, courseName, credit);
    }

    private StudentEnrolment convertCsvToEnrolment(String csv){
        String[] fields = csv.split(",");
        String sem = fields[6].trim();
        return new StudentEnrolment(convertCsvToStudent(csv), convertCsvToCourse(csv), sem);
    }

//    public ArrayList<Student> getStudentsFromCSV(String fileName){
//
//    }
//
//    public ArrayList<Course> getCoursesFromCSV(String fileName){
//
//    }
//
//    public ArrayList<StudentEnrolment> getEnrolmentsFromCSV(String fileName){
//
//    }
}
