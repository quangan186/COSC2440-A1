package service;

import model.Student;
import model.StudentEnrolment;
import repo.StudentEnrolmentManager;
import utility.DateConverter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class StudentService {
    private final StudentEnrolmentManager sem;

    public StudentService(StudentEnrolmentManager sem) {
        this.sem = sem;
    }

    public void display(ArrayList<Student> studentList){
        for (Student student : studentList){
            System.out.printf("- Student ID: %s\n- Student name: %s\n- Birthdate: %s\n\n", student.getStudentID(),
                    student.getName(), DateConverter.convertDateToString(student.getBirthDate()));
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
        Set<Student> set = new HashSet<>(students);
        students.clear();
        students.addAll(set);
        return students;
    }

}
