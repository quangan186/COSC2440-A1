package menu;

import repo.StudentEnrolmentManager;
import utility.Input;

import java.util.Scanner;

public class MainMenu {
    private final CourseMenu courseMenu;
    private final StudentMenu studentMenu;
    private final EnrolmentMenu enrolmentMenu;

    public MainMenu(StudentEnrolmentManager sem) {
        this.courseMenu = new CourseMenu(sem);
        this.studentMenu = new StudentMenu(sem);
        this.enrolmentMenu = new EnrolmentMenu(sem);
    }

    private void menu(){
        System.out.println("---------- Student Enrolment Management ----------");
        System.out.println("Which one you want to see: ");
        System.out.println("1. Manage courses");
        System.out.println("2. Manage enrolments");
        System.out.println("3. Manage students");
        System.out.println("4. Quit");
    }

    public void run() {
        menu();
        String decision;
        while (true) {
            Input input = new Input("Your choice: ");
            String choice = input.getInput();
            switch (choice) {
                case "1":
                    courseMenu.menu();
                    Input courseChoice = new Input("What do you want to see: ");
                    decision = courseChoice.getInput();
                    switch (decision) {
                        case "1":
                            courseMenu.viewCourses();
                        case "2":
                            courseMenu.viewAllCoursesInOneSemester();
                        case "3":
                            courseMenu.viewCoursesStudentLearnInOneSemester();
                        case "4":
                            menu();
                        default:
                            System.out.println("Invalid input");
                            courseChoice.getInput();
                    }
                case "2":
                    enrolmentMenu.menu();
                    Input enrolmentChoice = new Input("What do you want to see: ");
                    decision = enrolmentChoice.getInput();
                    switch (decision) {
                        case "1":
                            enrolmentMenu.viewEnrolments();
                            System.out.println("Do you want to update enrolment? (y/n): ");
                            String addOrRemove = input.getInput();
                            enrolmentMenu.updateEnrolmentMenu(addOrRemove);
                        case "2":
                            enrolmentMenu.viewEnrolmentsInOneSemester();
                        case "3":
                            enrolmentMenu.viewEnrolmentInOneSemester();
                        case "4":
                            menu();
                        default:
                            System.out.println("Invalid input");
                    }
                case "3":
                    studentMenu.menu();
                    Input studentChoice = new Input("What do you want to see: ");
                    decision = studentChoice.getInput();
                    switch (decision) {
                        case "1":
                            studentMenu.viewStudents();
                        case "2":
                            studentMenu.viewAllStudentsInOneCourse();
                        case "3":
                            menu();
                        default:
                            System.out.println("Invalid input");

                    }
                case "4":
                    System.out.println("Thank you for using our system!");
                    break;
                default:
                    System.out.println("Invalid input");
            }
        }

    }
}
