package service;

import model.Course;
import model.StudentEnrolment;
import repo.StudentEnrolmentManager;

import java.util.ArrayList;

public class CourseService {
    private final StudentEnrolmentManager sem;

    public CourseService(StudentEnrolmentManager sem) {
        this.sem = sem;
    }

    public void displayOnTable(ArrayList<Course> courseList){

    }

    public ArrayList<Course> getAllCourses(){
        return sem.getAllCourses();
    }

    public ArrayList<Course> getAllCoursesInOneSemester(String semester){
        ArrayList<Course> courses = new ArrayList<>();
        for (StudentEnrolment se : sem.getAllEnrolment()){
            if (se.getSem().equals(semester)){
                courses.add(se.getCourse());
            }
        }
        return courses;
    }

    public ArrayList<Course> getCoursesStudentLearnsInOneSemester(String studentID, String semester){
        ArrayList<Course> courses = new ArrayList<>();
        for (StudentEnrolment se : sem.getAllEnrolment()){
            if (se.getSem().equals(semester) && se.getStudent().getStudentID().equals(studentID)){
                courses.add(se.getCourse());
            }
        }
        return courses;
    }
}
