package service;

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

    /**
     * display enrolment object in the list
     * @param enrolmentList;
     */
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

    /**
     * call getAllEnrolment method in the system
     * @return ArrayList<StudentEnrolment>
     */
    public ArrayList<StudentEnrolment> getAllEnrolments(){
        Set<StudentEnrolment> set = new HashSet<>(sem.getAllEnrolments());
        sem.getAllEnrolments().clear();
        sem.getAllEnrolments().addAll(set);
        return sem.getAllEnrolments();
    }

    /**
     * Get all enrolments in one semester
     * @param semester;
     * @return ArrayList<StudentEnrolment>
     */
    public ArrayList<StudentEnrolment> getAllEnrolmentsInOneSemester(String semester){
        ArrayList<StudentEnrolment> enrolments = new ArrayList<>();
        for (StudentEnrolment se : sem.getAllEnrolments()){
            if (se.getSem().equals(semester)){
                enrolments.add(se);
            }
        }
        Set<StudentEnrolment> set = new HashSet<>(enrolments);
        enrolments.clear();
        enrolments.addAll(set);
        return enrolments;
    }

    /**
     * get one enrolment in the enrolment list
     * @param studentID;
     * @param courseID;
     * @param semester;
     * @return StudentEnrolment
     */
    public StudentEnrolment getOneEnrolment(String studentID, String courseID, String semester){
        return sem.getOneEnrolment(studentID, courseID, semester);
    }

    /**
     * call addEnrolment method in the system
     * @param studentID;
     * @param courseID;
     * @param semester;
     * @return boolean
     */
    public boolean addEnrolment(String studentID, String courseID, String semester){
        return sem.addEnrolment(studentID, courseID, semester);
    }

    /**
     * call deleteEnrolment method in the system
     * @param studentID;
     * @param courseID;
     * @param semester;
     * @return boolean
     */
    public boolean deleteEnrolment(String studentID, String courseID, String semester){
        return sem.deleteEnrolment(studentID, courseID, semester);
    }

}
