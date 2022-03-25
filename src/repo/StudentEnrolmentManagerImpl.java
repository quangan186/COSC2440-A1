package repo;

import model.Course;
import model.Student;
import model.StudentEnrolment;
import service.csvService;

import java.util.ArrayList;

public class StudentEnrolmentManagerImpl implements StudentEnrolmentManager{
    private final ArrayList<StudentEnrolment> enrolmentList = new ArrayList<>();
    private final ArrayList<Student> studentList = new ArrayList<>();
    private final ArrayList<Course> courseList = new ArrayList<>();
    private final csvService csvService;

    public StudentEnrolmentManagerImpl(service.csvService csvService) {
        this.csvService = new csvService(this);
    }

    public void populateData() {
        populateStudents();
        populateCourses();
        populateEnrolments();
    }

    private void populateStudents() {
        studentList.addAll(csvService.getStudentsFromCSV("default.csv"));
    }

    private void populateCourses() {
        courseList.addAll(csvService.getCoursesFromCSV("default.csv"));
    }

    private void populateEnrolments() {
        enrolmentList.addAll(csvService.getEnrolmentsFromCSV("default.csv"));
    }

    public StudentEnrolment addEnrolment(String studentID, String courseID, String sem){
        if (getOneEnrolment(studentID, courseID, sem) != null){
            enrolmentList.add(getOneEnrolment(studentID, courseID, sem));
        }
        return null;
    }

    public boolean deleteEnrolment(String studentID, String courseID, String sem){
        if (getOneEnrolment(studentID, courseID, sem) != null){
            enrolmentList.remove(getOneEnrolment(studentID, courseID, sem));
            return true;
        }
        return false;
    }

    public StudentEnrolment getOneEnrolment(String studentID, String courseID, String sem){
        for (StudentEnrolment se : enrolmentList){
            if (se.getStudent().getStudentID().equals(studentID) && se.getCourse().getCourseID().equals(courseID) &&
                    se.getSem().equals(sem)){
                return se;
            }
        }
        return null;
    }

    public ArrayList<StudentEnrolment> getAllEnrolment(){
        return enrolmentList;
    }
    public ArrayList<Course> getAllCourses(){
        return  courseList;
    }
    public ArrayList<Student> getAllStudents(){
        return studentList;
    }

    public Student getStudentByID(String studentID){
        for (Student student : studentList){
            if (student.getStudentID().equals(studentID)){
               return student;
            }
        }
        return null;
    }

    public Course getCourseByID(String courseID){
        for (Course course : courseList){
            if (course.getCourseID().equals(courseID)){
                return course;
            }
        }
        return null;
    }
}
