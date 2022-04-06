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

    /**
     * display object in the list
     * @param courseList;
     */
    public void display(ArrayList<Course> courseList){
        for (Course course : courseList){
            System.out.printf("- Course ID: %s\n- Course name: %s\n- Credit: %d\n\n", course.getCourseID(), course.getCourseName(), course.getCredit());
        }
    }

    /**
     * Call the list of courses in the system
     * @return ArrayList<Course>
     */
    public ArrayList<Course> getAllCourses(){
        return sem.getAllCourses();
    }

    /**
     * Get all courses in one semester
     * @param semester;
     * @return ArrayList<Course>
     */
    public ArrayList<Course> getAllCoursesInOneSemester(String semester){
        ArrayList<Course> courses = new ArrayList<>();
        for (StudentEnrolment se : sem.getAllEnrolments()){
            if (se.getSem().equals(semester)){
                courses.add(se.getCourse());
            }
        }

        Set<Course> set = new HashSet<>(courses);
        courses.clear();
        courses.addAll(set);
        return courses;
    }

    /**
     * Get list of courses that a student learns in one semester
     * @param studentID;
     * @param semester;
     * @return ArrayList<Course>
     */
    public ArrayList<Course> getCoursesStudentLearnsInOneSemester(String studentID, String semester){
        ArrayList<Course> courses = new ArrayList<>();
        for (StudentEnrolment se : sem.getAllEnrolments()){
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
