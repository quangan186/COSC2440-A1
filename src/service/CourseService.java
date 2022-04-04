package service;

import model.Course;
import model.StudentEnrolment;
import repo.StudentEnrolmentManager;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class CourseService {
    private final StudentEnrolmentManager sem;

    public CourseService(StudentEnrolmentManager sem) {
        this.sem = sem;
    }

    public void display(ArrayList<Course> courseList){
        for (Course course : courseList){
            System.out.printf("- Course ID: %s\n- Course name: %s\n- Credit: %d\n\n", course.getCourseID(), course.getCourseName(), course.getCredit());
        }
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

        Set<Course> set = new HashSet<>(courses);
        courses.clear();
        courses.addAll(set);
        return courses;
    }

    public ArrayList<Course> getCoursesStudentLearnsInOneSemester(String studentID, String semester){
        ArrayList<Course> courses = new ArrayList<>();
        for (StudentEnrolment se : sem.getAllEnrolment()){
            if (se.getSem().equals(semester) && se.getStudent().getStudentID().equals(studentID)){
                courses.add(se.getCourse());
            }
        }
        Set<Course> set = new HashSet<>(courses);
        courses.clear();
        courses.addAll(set);
        return courses;
    }
}
