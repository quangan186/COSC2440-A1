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

    private void viewStudents(){
        System.out.println("------------------------------------------------------------");
        studentService.display(studentService.getAllStudents());
    }

    private void viewAllStudentsInOneCourse(){
        System.out.println("------------------------------------------------------------");
        String cid = inputService.getCidInput();
        if (!csvService.getAllCourseID("default.csv").contains(cid)){
            System.out.println("------------------------------------------------------------");
            System.out.println("Cannot not find course ID");
            return;
        }

        String semester = inputService.getSemesterInput();
        if (!csvService.getAllSemester("default.csv").contains(semester)){
            System.out.println("------------------------------------------------------------");
            System.out.println("Cannot not find semester");
            return;
        }

        ArrayList<Student> students = studentService.getAllStudentsInOneCourse(cid,semester);

        if (students.size() == 0){
            System.out.println("------------------------------------------------------------");
            System.out.println("No students found");
        } else {
            studentService.display(students);

            System.out.println("------------------------------------------------------------");

            String saveReport = inputService.getWriteReport();
            while (!saveReport.isEmpty()){
                switch (saveReport.toLowerCase()){
                    case "y":
                        CsvWriter csvWriter = new CsvWriter("students", semester);
                        csvWriter.writeFile(students);
                        System.out.println("Saved");
                        return;
                    case "n":
                        return;
                    default:
                        System.out.println("------------------------------------------------------------");
                        System.out.println("Invalid input");
                        return;
                }
            }
        }


    }

    private void menu(){
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
                    System.out.println("------------------------------------------------------------");
                    return;
                }
                default -> {
                    System.out.println("------------------------------------------------------------");
                    System.out.println("Invalid input");
                }
            }
        }
    }
}
