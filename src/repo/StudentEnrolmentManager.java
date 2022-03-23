package repo;

import model.Course;
import model.Student;
import model.StudentEnrolment;

import java.util.ArrayList;

public interface StudentEnrolmentManager {
    StudentEnrolment addEnrolment();
    boolean deleteEnrolment();
    StudentEnrolment getOneEnrolment();
    ArrayList<StudentEnrolment> getAllEnrolment();
    ArrayList<Course> getAllCourses();
    ArrayList<Student> getAllStudents();
}
