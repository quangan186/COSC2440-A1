package menu;

import com.sun.tools.javac.Main;
import csv.CsvWriter;
import model.Course;
import model.Student;
import repo.StudentEnrolmentManager;
import service.InputService;
import service.StudentService;
import utility.Input;

import java.util.ArrayList;

public class StudentMenu {
    private final StudentService studentService;
    private final InputService inputService;

    public StudentMenu(StudentEnrolmentManager sem) {
        this.studentService = new StudentService(sem);
        this.inputService = new InputService();

    }

    public void viewStudents(){
        studentService.display(studentService.getAllStudents());
    }

    public void viewAllStudentsInOneCourse(){
        String cid = inputService.getCidInput();
        if (cid.isEmpty()) return;
        String semester = inputService.getSemesterInput();
        if (semester.isEmpty()) return;
        ArrayList<Student> students = studentService.getAllStudentsInOneCourse(cid,semester);
        studentService.display(students);
        String saveReport = inputService.getWriteReport();
        while (!saveReport.isEmpty()){
            switch (saveReport.toLowerCase()){
                case "y":
                    CsvWriter csvWriter = new CsvWriter("students", semester);
                    csvWriter.writeFile(students);
                    System.out.println("Saved\n");
                case "n":
                    return;
                default:
                    System.out.println("Invalid input");
                    return;
            }
        }

    }

    public void menu(){
        System.out.println("Which do you want to see: ");
        System.out.println("1. View all students");
        System.out.println("2. View all students in one course");
        System.out.println("3. Back");
    }

    public void run() {
        while (true) {
            menu();
            Input input = new Input("Your choice: ");
            String choice = input.getInput();
            switch (choice) {
                case "1" -> viewStudents();
                case "2" -> viewAllStudentsInOneCourse();
                case "3" -> {
                    return;
                }
                default -> System.out.println("Invalid input");
            }
        }
    }
}
