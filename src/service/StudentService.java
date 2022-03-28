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

    public void display(ArrayList<Student> studentList){
        for (Student student : studentList){
            System.out.printf("- Student ID: %s\n- Student name: %s\n- Birthdate: %s\n\n", student.getStudentID(),
                    student.getName(), student.getBirthDate());
        }
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
