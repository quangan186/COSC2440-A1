package menu;

import repo.StudentEnrolmentManager;
import service.InputService;
import service.StudentService;

import java.util.Scanner;

public class StudentMenu {
    private final StudentService studentService;
    private final InputService inputService;

    public StudentMenu(StudentEnrolmentManager sem) {
        this.studentService = new StudentService(sem);
        this.inputService = new InputService(sem);
    }

    public void viewStudents(){
        studentService.display(studentService.getAllStudents());
    }

    public void viewAllStudentsInOneCourse(){
        String cid = inputService.getCidInput();
        if (cid.isEmpty()) return;
        String semester = inputService.getSemesterInput();
        if (semester.isEmpty()) return;
        studentService.display(studentService.getAllStudentsInOneCourse(cid, semester));
    }

    public void menu(){
        System.out.println("Which do you want to see: ");
        System.out.println("1. View all students");
        System.out.println("2. View all students in one course");
        System.out.println("3. Back");
    }
}
