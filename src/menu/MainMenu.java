package menu;

import repo.StudentEnrolmentManager;

import utility.Input;

public class MainMenu {
    private final CourseMenu courseMenu;
    private final StudentMenu studentMenu;
    private final EnrolmentMenu enrolmentMenu;

    public MainMenu(StudentEnrolmentManager sem) {
        this.courseMenu = new CourseMenu(sem);
        this.studentMenu = new StudentMenu(sem);
        this.enrolmentMenu = new EnrolmentMenu(sem);
    }

    public void menu(){
//        System.out.println("------------------------------------------------------------");
        System.out.println("Which one you want to see? ");
        System.out.println("1. Manage courses");
        System.out.println("2. Manage enrolments");
        System.out.println("3. Manage students");
        System.out.println("4. Quit");
    }

    public void run() {
        System.out.println("--------------- Student Enrolment Management ---------------");
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
