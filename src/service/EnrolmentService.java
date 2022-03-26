package service;

import model.StudentEnrolment;
import repo.StudentEnrolmentManager;

import java.util.ArrayList;

public class EnrolmentService {
    private final StudentEnrolmentManager sem;

    public EnrolmentService(StudentEnrolmentManager sem) {
        this.sem = sem;
    }

    public void displayOnTable(ArrayList<StudentEnrolment> enrolmentList){

    }

    public ArrayList<StudentEnrolment> getAllEnrolments(){
        return sem.getAllEnrolment();
    }

    public StudentEnrolment addEnrolment(String studentID, String courseID, String semester){
        return sem.addEnrolment(studentID, courseID, semester);
    }

    public boolean deleteEnrolment(String studentID, String courseID, String semester){
        return sem.deleteEnrolment(studentID, courseID, semester);
    }

}
