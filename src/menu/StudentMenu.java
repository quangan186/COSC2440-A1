package menu;

import repo.StudentEnrolmentManager;
import service.StudentService;

import java.util.Scanner;

public class StudentMenu {
    private final StudentService studentService;

    public StudentMenu(StudentEnrolmentManager sem) {
        this.studentService = new StudentService(sem);
    }

    public void viewStudents(){
        studentService.display(studentService.getAllStudents());
    }

    public void viewAllStudentsInOneCourse(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Course ID: ");
        String cid = sc.nextLine();
        System.out.print("Semester: ");
        String semester = sc.nextLine();
        studentService.display(studentService.getAllStudentsInOneCourse(cid, semester));
    }
}
