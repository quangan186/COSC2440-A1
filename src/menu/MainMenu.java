package menu;

import csv.CsvReader;
import repo.StudentEnrolmentManager;
import repo.StudentEnrolmentManagerImpl;
import service.InputService;
import utility.Input;

import java.io.File;

public class MainMenu {
    private final CourseMenu courseMenu;
    private final StudentMenu studentMenu;
    private final EnrolmentMenu enrolmentMenu;
    private final Input inputCsv;
    private final InputService inputService;
    StudentEnrolmentManagerImpl semi = new StudentEnrolmentManagerImpl();

    public MainMenu(StudentEnrolmentManager sem) {
        this.courseMenu = new CourseMenu(sem);
        this.studentMenu = new StudentMenu(sem);
        this.enrolmentMenu = new EnrolmentMenu(sem);
        this.inputCsv = new Input("Do you want to use your csv file? (y/n): ");
        this.inputService = new InputService();
    }

    public void menu(){
        System.out.println("------------------------------------------------------------");
        System.out.println("Which one you want to see? ");
        System.out.println("1. Manage courses");
        System.out.println("2. Manage enrolments");
        System.out.println("3. Manage students");
        System.out.println("4. Quit");
    }

    public void CSV(){
        String decision = inputCsv.getInput();
        while (!decision.isEmpty()){
            if (decision.equalsIgnoreCase("n")){
                semi.populateData("default.csv");
                break;
            }
            else if (decision.equalsIgnoreCase("y")){
                while (true){
                    String csv = inputService.getCsvInput();
                    File f = new File(csv);
                    if (f.exists() && !f.isDirectory()){
                        semi.populateData(csv);
                        break;
                    }
                }
            } else {
                System.out.println("Cannot find csv file");
            }
        }
    }

    public void run() {
        System.out.println("--------------- Student Enrolment Management ---------------");
        CSV();
        while (true) {
            menu();
            Input input = new Input("Your choice: ");
            String choice = input.getInput();
            switch (choice) {
                case "1" -> courseMenu.run();
                case "2" -> enrolmentMenu.run();
                case "3" -> studentMenu.run();
                case "4" -> {
                    System.out.println("Thank you for using our system!");
                    return;
                }
                default -> System.out.println("------------------------------------------------------------\nInvalid input");
            }
        }
    }
}
