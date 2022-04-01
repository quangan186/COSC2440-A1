package repo;

import model.Course;
import model.Student;
import model.StudentEnrolment;
import service.CsvService;

import java.util.ArrayList;

public class StudentEnrolmentManagerImpl implements StudentEnrolmentManager{
    private final ArrayList<StudentEnrolment> enrolmentList = new ArrayList<>();
    private final ArrayList<Student> studentList = new ArrayList<>();
    private final ArrayList<Course> courseList = new ArrayList<>();
    private final CsvService csvService;

    public StudentEnrolmentManagerImpl() {
        csvService = new CsvService(this);
    }

    public void populateData() {
        populateStudents();
        populateCourses();
        populateEnrolments();
    }

    private void populateStudents() {
        studentList.clear();
        studentList.addAll(csvService.getStudentsFromCSV("default.csv"));
    }

    private void populateCourses() {
        courseList.clear();
        courseList.addAll(csvService.getCoursesFromCSV("default.csv"));
    }

    private void populateEnrolments() {
        enrolmentList.clear();
        enrolmentList.addAll(csvService.getEnrolmentsFromCSV("default.csv"));
    }

    public boolean addEnrolment(String studentID, String courseID, String sem){
        Student s = getStudentByID(studentID);
        Course c = getCourseByID(courseID);
        StudentEnrolment newEnrolment = new StudentEnrolment(s, c, sem);
        if (getOneEnrolment(studentID, courseID, sem) != null){
            enrolmentList.add(newEnrolment);
            return true;
        }
        return false;
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

    public ArrayList<StudentEnrolment> getAllEnrolmentsInOneSemester(String sem) {
        ArrayList<StudentEnrolment> enrolments = new ArrayList<>();
        for (StudentEnrolment se : enrolmentList){
            if (se.getSem().equals(sem)){
                enrolments.add(se);
            }
        }
        return enrolments;
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
