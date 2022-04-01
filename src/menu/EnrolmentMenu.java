package menu;

import repo.StudentEnrolmentManager;
import service.CourseService;
import service.EnrolmentService;
import service.InputService;
import utility.Input;

public class EnrolmentMenu {
    private final EnrolmentService enrolmentService;
    private final InputService inputService;
    private final CourseService courseService;

    public EnrolmentMenu(StudentEnrolmentManager sem) {
        this.inputService = new InputService();
        this.enrolmentService = new EnrolmentService(sem);
        this.courseService = new CourseService(sem);
    }

    public void viewEnrolments(){
        enrolmentService.display(enrolmentService.getAllEnrolments());
    }
    public void viewEnrolmentsInOneSemester(){
        String semester = inputService.getSemesterInput();
        enrolmentService.display(enrolmentService.getAllEnrolmentsInOneSemester(semester));
    }
    public void viewOneEnrolmentInOneSemester(){
        String sid = inputService.getSidInput();
        String cid = inputService.getCidInput();
        String semester = inputService.getSemesterInput();
        System.out.println(enrolmentService.getOneEnrolment(sid, cid, semester));
    }

    public void addOneEnrolment(){
        String sid = inputService.getSidInput();
        String cid = inputService.getCidInput();
        String semester = inputService.getSemesterInput();
        if(enrolmentService.addEnrolment(sid, cid, semester)){
            System.out.println("Enrolled successful");
        } else{
            System.out.println("Enrolled unsuccessful\n Please try again");
            inputService.getSidInput();
            inputService.getCidInput();
            inputService.getSemesterInput();
        }
    }

    public void deleteOneEnrolment(){
        String sid = inputService.getSidInput();
        if (sid.isEmpty()) return;
        String cid = inputService.getCidInput();
        if (cid.isEmpty()) return;
        String semester = inputService.getSemesterInput();
        if(enrolmentService.deleteEnrolment(sid, cid, semester)){
            System.out.println("Dropped successful");
        } else{
            System.out.println("Dropped unsuccessful\n Please try again");
            inputService.getSidInput();
            inputService.getCidInput();
            inputService.getSemesterInput();
        }
    }

    public void updateEnrolmentMenu(String s){
        while (s.equalsIgnoreCase("y")){
            courseService.display(courseService.getAllCourses());
            System.out.println("1. Add enrolment");
            System.out.println("2. Delete enrolment");
            System.out.println("3. Back");
            Input choice = new Input("Your choice: ");
            String decision = choice.getInput();
            switch (decision){
                case "1":
                    addOneEnrolment();
                    break;
                case "2":
                    deleteOneEnrolment();
                    break;
                case "3":
                    return;
                default:
                    System.out.println("Invalid input\n");
            }
        }
    }

    public void menu(){
        System.out.println("Which do you want to see: ");
        System.out.println("1. View all enrolments");
        System.out.println("2. View all enrolments in one semester");
        System.out.println("3. View one enrolment in one semester");
        System.out.println("4. Back");
    }

    public void run() {
        while (true) {
            menu();
            Input input = new Input("Your choice: ");
            String choice = input.getInput();
            switch (choice) {
                case "1" -> {
                    viewEnrolments();
                    System.out.println("Do you want to update enrolment? (y/n): ");
                    String addOrRemove = input.getInput();
                    updateEnrolmentMenu(addOrRemove);
                }
                case "2" -> viewEnrolmentsInOneSemester();
                case "3" -> viewOneEnrolmentInOneSemester();
                case "4" -> {
                    return;
                }
                default -> System.out.println("Invalid input");
            }
        }
    }
}
