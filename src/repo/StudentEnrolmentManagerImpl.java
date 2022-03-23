package repo;

import model.Course;
import model.Student;
import model.StudentEnrolment;

import java.util.ArrayList;

public class StudentEnrolmentManagerImpl implements StudentEnrolmentManager{
    private final ArrayList<StudentEnrolment> enrolments = new ArrayList<>();
    private final ArrayList<Student> students = new ArrayList<>();
    private final ArrayList<Course> courses = new ArrayList<>();

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

    public StudentEnrolment addEnrolment(){

    }

    public boolean deleteEnrolment(){

    }
    public StudentEnrolment getOneEnrolment(){

    }
    public ArrayList<StudentEnrolment> getAllEnrolment(){
        return enrolments;
    }
    public ArrayList<Course> getAllCourses(){
        return  courses;
    }
    public ArrayList<Student> getAllStudents(){
        return students;
    }
}
