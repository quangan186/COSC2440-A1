package repo;

import model.Course;
import model.Student;
import model.StudentEnrolment;

import java.util.ArrayList;

public interface StudentEnrolmentManager {
    StudentEnrolment addEnrolment(String studentID, String courseID, String sem);
    boolean deleteEnrolment(String studentID, String courseID, String sem);
    StudentEnrolment getOneEnrolment(String studentID, String courseID, String sem);
    ArrayList<StudentEnrolment> getAllEnrolment();
    ArrayList<Course> getAllCourses();
    ArrayList<Student> getAllStudents();
    ArrayList<StudentEnrolment> getAllEnrolmentsInOneSemester(String sem);
    Student getStudentByID(String studentID);
    Course getCourseByID(String courseID);
}
