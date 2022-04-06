package repo;

import model.Course;
import model.Student;
import model.StudentEnrolment;
import service.CsvService;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class StudentEnrolmentManagerImpl implements StudentEnrolmentManager{
    private final ArrayList<StudentEnrolment> enrolmentList = new ArrayList<>();
    private final ArrayList<Student> studentList = new ArrayList<>();
    private final ArrayList<Course> courseList = new ArrayList<>();
    private final CsvService csvService;

    public StudentEnrolmentManagerImpl() {
        csvService = new CsvService(this);
    }

    /***
     * Populate the sets from csv file
     */
    public void populateData() {
        populateStudents();
        populateCourses();
        populateEnrolments();
    }

    /***
     * Populate the student set
     */
    private void populateStudents() {
        studentList.clear();
        studentList.addAll(csvService.getStudentsFromCSV("default.csv"));
    }

    /***
     * Populate the course set
     */

    private void populateCourses() {
        courseList.clear();
        courseList.addAll(csvService.getCoursesFromCSV("default.csv"));
    }

    /***
     * Populate the enrollment set
     */
    private void populateEnrolments() {
        enrolmentList.clear();
        enrolmentList.addAll(csvService.getEnrolmentsFromCSV("default.csv"));
    }

    /***
     * add new enrollment to the set
     * @param studentID;
     * @param courseID;
     * @param semester;
     * @return boolean
     */
    public boolean addEnrolment(String studentID, String courseID, String semester){
        Student s = getStudentByID(studentID);
        Course c = getCourseByID(courseID);
        if (getOneEnrolment(studentID, courseID, semester) == null && getSemestersInOneCourse(courseID).contains(semester)){
            StudentEnrolment newEnrolment = new StudentEnrolment(s, c, semester);
            enrolmentList.add(newEnrolment);
            return true;
        }
        return false;
    }

    /***
     * get all semesters the course is available
     * @param courseID;
     * @return ArrayList<String>
     */
    private ArrayList<String> getSemestersInOneCourse(String courseID){
        ArrayList<String> semList = new ArrayList<>();
        for (StudentEnrolment se : getAllEnrolments()){
            if (se.getCourse().getCourseID().equals(courseID)){
                semList.add(se.getSem());
            }
        }
        return semList;
    }

    /***
     * remove enrollment from the set
     * @param studentID;
     * @param courseID;
     * @param semester;
     * @return boolean
     */
    public boolean deleteEnrolment(String studentID, String courseID, String semester){
        if (getOneEnrolment(studentID, courseID, semester) != null){
            enrolmentList.remove(getOneEnrolment(studentID, courseID, semester));
            return true;
        }
        return false;
    }

    /***
     * get one enrollment in the set
     * @param studentID;
     * @param courseID;
     * @param semester;
     * @return StudentEnrolment
     */
    public StudentEnrolment getOneEnrolment(String studentID, String courseID, String semester){
        for (StudentEnrolment se : enrolmentList){
            if (se.getStudent().getStudentID().equals(studentID) && se.getCourse().getCourseID().equals(courseID) &&
                    se.getSem().equals(semester)){
                return se;
            }
        }
        return null;
    }

    /***
     * get enrollment set as a ArrayList
     * @return ArrayList<StudentEnrolment>
     */
    public ArrayList<StudentEnrolment> getAllEnrolments(){
        Set<StudentEnrolment> set = new HashSet<>(enrolmentList);
        enrolmentList.clear();
        enrolmentList.addAll(set);
        return enrolmentList;
    }

    /***
     * get course set as a ArrayList
     * @return ArrayList<Course>
     */
    public ArrayList<Course> getAllCourses(){
        Set<Course> set = new HashSet<>(courseList);
        courseList.clear();
        courseList.addAll(set);
        return  courseList;
    }

    /***
     * get student set as a ArrayList
     * @return ArrayList<Student>
     */
    public ArrayList<Student> getAllStudents(){
        ArrayList<Student> students = studentList;
        Set<Student> set = new HashSet<>(students);
        students.clear();
        students.addAll(set);
        return students;
    }

    /***
     * get one student in the set
     * @param studentID;
     * @return Student
     */
    public Student getStudentByID(String studentID){
        for (Student student : studentList){
            if (student.getStudentID().equals(studentID)){
               return student;
            }
        }
        return null;
    }

    /***
     * get one course in the set
     * @param courseID;
     * @return Course
     */
    public Course getCourseByID(String courseID){
        for (Course course : courseList){
            if (course.getCourseID().equals(courseID)){
                return course;
            }
        }
        return null;
    }
}
