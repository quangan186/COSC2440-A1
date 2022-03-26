package service;

import model.Course;
import model.Student;
import model.StudentEnrolment;
import repo.StudentEnrolmentManager;

import java.util.ArrayList;

public class StudentService {
    private StudentEnrolmentManager sem;

    public StudentService(StudentEnrolmentManager sem) {
        this.sem = sem;
    }

    public void displayOnTable(ArrayList<Student> studentList){

    }

    public ArrayList<Student> getAllStudents(){
        return sem.getAllStudents();
    }

    public ArrayList<Student> getAllStudentsInOneCourse(String courseID, String semester){
        ArrayList<Student> students = new ArrayList<>();
        for (StudentEnrolment se : sem.getAllEnrolment()){
            if (se.getCourse().getCourseID().equals(courseID) && se.getSem().equals(semester)){
                students.add(se.getStudent());
            }
        }
        return students;
    }

}
