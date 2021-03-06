package menu;

import repo.StudentEnrolmentManager;
import service.CourseService;
import service.CsvService;
import service.EnrolmentService;
import service.InputService;
import utility.DateConverter;
import utility.Input;

public class EnrolmentMenu {
    private final EnrolmentService enrolmentService;
    private final InputService inputService;
    private final CourseService courseService;
    private final CsvService csvService;

    public EnrolmentMenu(StudentEnrolmentManager sem) {
        this.inputService = new InputService();
        this.enrolmentService = new EnrolmentService(sem);
        this.courseService = new CourseService(sem);
        csvService = new CsvService(sem);
    }

    /**
     * display all enrollments
     */
    private void viewEnrolments(){
        System.out.println("------------------------------------------------------------\n");
        enrolmentService.display(enrolmentService.getAllEnrolments());
    }

    /**
     * display all enrollments in one semester
     */
    private void viewEnrolmentsInOneSemester(){
        System.out.println("------------------------------------------------------------");
        String semester = inputService.getSemesterInput();
        if (!csvService.getAllSemester("default.csv").contains(semester)){
            System.out.println("------------------------------------------------------------");
            System.out.println("Cannot not find semester");
            return;
        }
        System.out.println("------------------------------------------------------------\n");
        enrolmentService.display(enrolmentService.getAllEnrolmentsInOneSemester(semester));
    }

    /**
     * display the enrolment gotten from the list
     */
    private void viewOneEnrolmentInOneSemester(){
        System.out.println("------------------------------------------------------------");
        String sid = inputService.getSidInput();
        if (!csvService.getAllStudentID("default.csv").contains(sid)){
            System.out.println("------------------------------------------------------------");
            System.out.println("Cannot not find student ID");
            return;
        }

        String cid = inputService.getCidInput();
        if (!csvService.getAllCourseID("default.csv").contains(cid)){
            System.out.println("------------------------------------------------------------");
            System.out.println("Cannot not find course ID");
            return;
        }

        String semester = inputService.getSemesterInput();
        if (!csvService.getAllSemester("default.csv").contains(semester)){
            System.out.println("Cannot not find semester");
            return;
        }
        System.out.println("------------------------------------------------------------");
        if (enrolmentService.getOneEnrolment(sid, cid, semester) == null){
            System.out.println("No enrolment found");
        }
        else {
            System.out.printf("""
                            
                            - Student ID: %s
                            - Student name: %s
                            - Birthdate: %s
                            - Course ID: %s
                            - Course name: %s
                            - Credit: %d
                            - Semester: %s
                                                                         
                            """, enrolmentService.getOneEnrolment(sid, cid, semester).getStudent().getStudentID(),
                    enrolmentService.getOneEnrolment(sid, cid, semester).getStudent().getName(),
                    DateConverter.convertDateToString(enrolmentService.getOneEnrolment(sid, cid, semester).getStudent().getBirthDate()),
                    enrolmentService.getOneEnrolment(sid, cid, semester).getCourse().getCourseID(),
                    enrolmentService.getOneEnrolment(sid, cid, semester).getCourse().getCourseName(),
                    enrolmentService.getOneEnrolment(sid, cid, semester).getCourse().getCredit(),
                    enrolmentService.getOneEnrolment(sid, cid, semester).getSem());
        }

    }

    /**
     * call and display addEnrolment method in the system
     */
    private void addOneEnrolment(){
        System.out.println("------------------------------------------------------------");
        String sid = inputService.getSidInput();
        if (!csvService.getAllStudentID("default.csv").contains(sid)){
            System.out.println("------------------------------------------------------------");
            System.out.println("Cannot not find student ID");
            return;
        }

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

        if(enrolmentService.addEnrolment(sid, cid, semester)){
            System.out.println("------------------------------------------------------------");
            System.out.println("Enrolled successful");
        } else{
            System.out.println("------------------------------------------------------------");
            System.out.println("Enrolled unsuccessful");
        }
    }

    /**
     * call and display deleteEnrolment method in the system
     */
    private void deleteOneEnrolment(){
        System.out.println("------------------------------------------------------------");
        String sid = inputService.getSidInput();
        if (!csvService.getAllStudentID("default.csv").contains(sid)){
            System.out.println("------------------------------------------------------------");
            System.out.println("Cannot not find student ID");
            return;
        }

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

        if(enrolmentService.deleteEnrolment(sid, cid, semester)){
            System.out.println("------------------------------------------------------------");
            System.out.println("Dropped successful");
        } else{
            System.out.println("------------------------------------------------------------");
            System.out.println("Dropped unsuccessful");
        }
    }

    /**
     * display update menu contains add and delete functions
     */
    private void updateEnrolmentMenu(String s){
        while (s.equalsIgnoreCase("y")){
            System.out.println("------------------------------------------------------------");
            courseService.display(courseService.getAllCourses());
            System.out.println("------------------------------------------------------------");
            System.out.println("1. Add enrolment");
            System.out.println("2. Delete enrolment");
            System.out.println("3. Back");
            Input choice = new Input("Your choice: ");
            String decision = choice.getInput();
            switch (decision){
                case "1":
                    addOneEnrolment();
                    return;
                case "2":
                    deleteOneEnrolment();
                    return;
                case "3":
                    return;
                default:
                    System.out.println("------------------------------------------------------------");
                    System.out.println("Invalid input");
                    return;
            }
        }
    }

    /**
     * display Enrolment menu
     */
    private void menu(){
        System.out.println("------------------------------------------------------------");
        System.out.println("Which do you want to see? ");
        System.out.println("1. View all enrolments");
        System.out.println("2. View all enrolments in one semester");
        System.out.println("3. View one enrolment in one semester");
        System.out.println("4. Back");
    }

    /**
     * run the Enrolment menu
     */
    public void run() {
        while (true) {
            menu();
            Input input = new Input("Your choice: ");
            String choice = input.getInput();
            System.out.println();
            switch (choice) {
                case "1" -> {
                    viewEnrolments();
                    System.out.println("------------------------------------------------------------");
                    Input update = new Input("Do you want to update enrolment? (y/n): ");
                    String addOrRemove = update.getInput();
                    updateEnrolmentMenu(addOrRemove);
                }
                case "2" -> viewEnrolmentsInOneSemester();
                case "3" -> viewOneEnrolmentInOneSemester();
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
