package service;

import model.Course;
import model.Student;
import model.StudentEnrolment;
import repo.StudentEnrolmentManager;
import utility.DateConverter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class EnrolmentService {
    private final StudentEnrolmentManager sem;

    public EnrolmentService(StudentEnrolmentManager sem) {
        this.sem = sem;
    }

    public void display(ArrayList<StudentEnrolment> enrolmentList){
        for (StudentEnrolment se : enrolmentList){
            System.out.printf("""
                            - Student ID: %s
                            - Student name: %s
                            - Birthdate: %s
                            - Course ID: %s
                            - Course name: %s
                            - Credit: %d
                            - Semester: %s
                                                
                            """, se.getStudent().getStudentID(), se.getStudent().getName(),
                    DateConverter.convertDateToString(se.getStudent().getBirthDate()), se.getCourse().getCourseID(), se.getCourse().getCourseName(),
                    se.getCourse().getCredit(), se.getSem());
        }
    }

    public ArrayList<StudentEnrolment> getAllEnrolments(){
        Set<StudentEnrolment> set = new HashSet<>(sem.getAllEnrolment());
        sem.getAllEnrolment().clear();
        sem.getAllEnrolment().addAll(set);
        return sem.getAllEnrolment();
    }

    public ArrayList<StudentEnrolment> getAllEnrolmentsInOneSemester(String semester){
        Set<StudentEnrolment> set = new HashSet<>(sem.getAllEnrolmentsInOneSemester(semester));
        sem.getAllEnrolmentsInOneSemester(semester).clear();
        sem.getAllEnrolmentsInOneSemester(semester).addAll(set);
        return sem.getAllEnrolmentsInOneSemester(semester);
    }

    public StudentEnrolment getOneEnrolment(String studentID, String courseID, String semester){
        return sem.getOneEnrolment(studentID, courseID, semester);
    }

    public boolean addEnrolment(String studentID, String courseID, String semester){
        return sem.addEnrolment(studentID, courseID, semester);
    }

    public boolean deleteEnrolment(String studentID, String courseID, String semester){
        return sem.deleteEnrolment(studentID, courseID, semester);
    }

}
