package repo;

import model.Course;
import model.Student;
import model.StudentEnrolment;

import java.util.ArrayList;

public interface StudentEnrolmentManager {
    boolean addEnrolment(String studentID, String courseID, String semester);
    boolean deleteEnrolment(String studentID, String courseID, String semester);
    StudentEnrolment getOneEnrolment(String studentID, String courseID, String semester);
    ArrayList<StudentEnrolment> getAllEnrolments();
    ArrayList<Course> getAllCourses();
    ArrayList<Student> getAllStudents();
    Student getStudentByID(String studentID);
    Course getCourseByID(String courseID);
}
