package csv;

import model.Course;
import model.Student;
import model.StudentEnrolment;
import repo.StudentEnrolmentManager;

import java.util.ArrayList;

public class csvService {
    private StudentEnrolmentManager sem;
    private String fileName;

    public csvService(StudentEnrolmentManager sem, String fileName) {
        this.sem = sem;
        this.fileName = fileName;
    }

    public String[] getAllEnrolments(){
        return new String[0];
    }

    private Student convertCsvToStudent(){

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
