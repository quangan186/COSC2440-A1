package menu;

import model.StudentEnrolment;
import repo.StudentEnrolmentManager;
import service.EnrolmentService;
import service.InputService;
import utility.Input;

import java.awt.*;
import java.util.Locale;
import java.util.Scanner;

public class EnrolmentMenu {
    private final EnrolmentService enrolmentService;
    private final InputService inputService;

    public EnrolmentMenu(StudentEnrolmentManager sem) {
        this.inputService = new InputService(sem);
        this.enrolmentService = new EnrolmentService(sem);
    }

    public void viewEnrolments(){
        enrolmentService.display(enrolmentService.getAllEnrolments());
    }
    public void viewEnrolmentsInOneSemester(){
//        Scanner sc = new Scanner(System.in);
//        System.out.print("Semester: ");
//        String semester = sc.nextLine() + "\n";
        String semester = inputService.getSemesterInput();
        enrolmentService.display(enrolmentService.getAllEnrolmentsInOneSemester(semester));
    }
    public void viewEnrolmentInOneSemester(){
//        Scanner sc = new Scanner(System.in);
//        System.out.print("Student ID: ");
//        String sid = sc.nextLine() + "\n";
//        System.out.print("Course ID: ");
//        String cid = sc.nextLine() + "\n";
//        System.out.print("Semester: ");
//        String semester = sc.nextLine() + "\n";
        String sid = inputService.getSidInput();
        String cid = inputService.getCidInput();
        String semester = inputService.getSemesterInput();
        System.out.println(enrolmentService.getOneEnrolment(sid, cid, semester));
    }

    public void addOneEnrolment(){
//        Scanner sc = new Scanner(System.in);
//        System.out.print("Student ID: ");
//        String sid = sc.nextLine() + "\n";
//        System.out.print("Course ID: ");
//        String cid = sc.nextLine() + "\n";
//        System.out.print("Semester: ");
//        String semester = sc.nextLine() + "\n";
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
//        Scanner sc = new Scanner(System.in);
//        System.out.print("Student ID: ");
//        String sid = sc.nextLine() + "\n";
//        System.out.print("Course ID: ");
//        String cid = sc.nextLine() + "\n";
//        System.out.print("Semester: ");
//        String semester = sc.nextLine() + "\n";
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

    public void updateEnrolmentMenu(String choice){
        String moreOrNot;
        while (choice.equalsIgnoreCase("y")){
            System.out.println("1. Add enrolment");
            System.out.println("2. Delete enrolment");
            Input decision = new Input("Your choice: ");
            switch (decision.getInput()){
                case "1":
                    addOneEnrolment();
                case "2":
                    deleteOneEnrolment();
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
}
