package menu;

import csv.CsvWriter;
import model.Course;
import repo.StudentEnrolmentManager;
import service.CourseService;
import service.CsvService;
import service.InputService;
import utility.Input;

import java.util.ArrayList;

public class CourseMenu {
    private final CourseService courseService;
    private final InputService inputService;
    private final CsvService csvService;

    public CourseMenu(StudentEnrolmentManager sem) {
        this.inputService = new InputService();
        this.courseService = new CourseService(sem);
        csvService = new CsvService(sem);
    }

    public void viewCourses(){
        System.out.println("------------------------------------------------------------\n");
        courseService.display(courseService.getAllCourses());
    }

    public void viewAllCoursesInOneSemester(){
        System.out.println("------------------------------------------------------------");
        String semester = inputService.getSemesterInput();
        if (!csvService.getAllSemester("default.csv").contains(semester)){
            System.out.println("------------------------------------------------------------");
            System.out.println("Cannot not find semester");
            return;
        }
        System.out.println("------------------------------------------------------------\n");
        ArrayList<Course> courses = courseService.getAllCoursesInOneSemester(semester);
        courseService.display(courses);
        System.out.println("------------------------------------------------------------");
        String saveReport = inputService.getWriteReport();
        while (!saveReport.isEmpty()){
            switch (saveReport.toLowerCase()) {
                case "y" -> {
                    System.out.println("Saved");
                    CsvWriter csvWriter = new CsvWriter("courses", semester);
                    csvWriter.writeFile(courses);
                    return;
                }
                case "n" -> {
                    System.out.println("------------------------------------------------------------");
                    return;
                }
                default -> {
                    System.out.println("------------------------------------------------------------");
                    System.out.println("Invalid input");
                    return;
                }
            }
        }
    }

    public void viewCoursesStudentLearnInOneSemester(){
        System.out.println("------------------------------------------------------------");
        String sid = inputService.getSidInput();
        if (!csvService.getAllStudentID("default.csv").contains(sid)){
            System.out.println("------------------------------------------------------------");
            System.out.println("Cannot not find student ID");
            return;
        }

        String semester = inputService.getSemesterInput();
        if (!csvService.getAllSemester("default.csv").contains(semester)){
            System.out.println("------------------------------------------------------------");
            System.out.println("Cannot not find semester");
            return;
        }

        ArrayList<Course> courses = courseService.getCoursesStudentLearnsInOneSemester(sid, semester);

        if (courses.size() == 0){
            System.out.println("------------------------------------------------------------");
            System.out.println("No courses found");
        } else {
            courseService.display(courses);
            System.out.println("------------------------------------------------------------");
            String saveReport = inputService.getWriteReport();
            while (!saveReport.isEmpty()){
                switch (saveReport.toLowerCase()){
                    case "y":
                        System.out.println("Saved");
                        CsvWriter csvWriter = new CsvWriter("courses", sid, semester);
                        csvWriter.writeFile(courses);
                    case "n":
                        System.out.println("------------------------------------------------------------");
                        return;
                    default:
                        System.out.println("------------------------------------------------------------");
                        System.out.println("Invalid input");
                        return;
                }
            }
        }

    }

    public void menu(){
        System.out.println("------------------------------------------------------------");
        System.out.println("Which one you want to see?");
        System.out.println("1. View courses");
        System.out.println("2. View courses in one semester");
        System.out.println("3. View courses student learn in one semester");
        System.out.println("4. Back");
    }

    public void run(){
        while (true){
            menu();
            Input input = new Input("Your choice: ");
            String choice = input.getInput();
//            System.out.println();
            switch (choice) {
                case "1" -> viewCourses();
                case "2" -> viewAllCoursesInOneSemester();
                case "3" -> viewCoursesStudentLearnInOneSemester();
                case "4" -> {
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
