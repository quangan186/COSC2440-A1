package menu;

import csv.CsvWriter;
import model.Student;
import repo.StudentEnrolmentManager;
import service.CsvService;
import service.InputService;
import service.StudentService;
import utility.Input;

import java.util.ArrayList;

public class StudentMenu {
    private final StudentService studentService;
    private final InputService inputService;
    private final CsvService csvService;

    public StudentMenu(StudentEnrolmentManager sem) {
        this.studentService = new StudentService(sem);
        this.inputService = new InputService();
        csvService = new CsvService(sem);
    }

    public void viewStudents(){
        System.out.println("------------------------------------------------------------");
        studentService.display(studentService.getAllStudents());
    }

    public void viewAllStudentsInOneCourse(){
        System.out.println("------------------------------------------------------------");
        String cid = inputService.getCidInput();
        if (!csvService.getAllCourseID("default.csv").contains(cid)){
            System.out.println("Cannot not find course ID\n");
            return;
        }

        String semester = inputService.getSemesterInput();
        if (!csvService.getAllSemester("default.csv").contains(semester)){
            System.out.println("Cannot not find semester\n");
            return;
        }

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
        System.out.println("------------------------------------------------------------");
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
            System.out.println();
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
