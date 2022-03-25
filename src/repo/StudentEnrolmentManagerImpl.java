package repo;

import model.Course;
import model.Student;
import model.StudentEnrolment;

import java.util.ArrayList;

public class StudentEnrolmentManagerImpl implements StudentEnrolmentManager{
    private final ArrayList<StudentEnrolment> enrolmentList = new ArrayList<>();
    private final ArrayList<Student> studentList = new ArrayList<>();
    private final ArrayList<Course> courseList = new ArrayList<>();

    public void populateData() {
        populateStudents();
        populateCourses();
        populateEnrolments();
    }

    private void populateStudents() {

    }

    private void populateCourses() {

    }

    private void populateEnrolments() {

    }

    public StudentEnrolment addEnrolment(String studentID, String courseID, String sem){

    }

    public boolean deleteEnrolment(String studentID, String courseID, String sem){

    }

    public StudentEnrolment getOneEnrolment(){

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
        Student std = null;
        for (Student student : studentList){
            if (student.getStudentID().equals(studentID)){
                std = student;
            }
        }
        return std;
    }

    public Course getCourseByID(String courseID){
        Course c = null;
        for (Course course : courseList){
            if (course.getCourseID().equals(courseID)){
                c = course;
            }
        }
        return c;
    }
}
