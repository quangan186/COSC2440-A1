package service;

import model.Course;
import model.Student;
import model.StudentEnrolment;
import repo.StudentEnrolmentManager;

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
        String studentName = fields[2].trim();
        Date birthDate = null;
    }

    private Course convertCsvToCourse(){

    }

    private Student convertCsvToEnrolment(){

    }

    public ArrayList<Student> getStudentsFromCSV(String fileName){

    }

    public ArrayList<Course> getCoursesFromCSV(String fileName){

    }

    public ArrayList<StudentEnrolment> getEnrolmentsFromCSV(String fileName){

    }
}
