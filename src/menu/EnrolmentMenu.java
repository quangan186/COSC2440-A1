package menu;

import model.StudentEnrolment;
import repo.StudentEnrolmentManager;
import service.EnrolmentService;

import java.awt.*;
import java.util.Locale;
import java.util.Scanner;

public class EnrolmentMenu {
    private final EnrolmentService enrolmentService;

    public EnrolmentMenu(StudentEnrolmentManager sem) {
        this.enrolmentService = new EnrolmentService(sem);
    }

    public void viewEnrolments(){
        enrolmentService.display(enrolmentService.getAllEnrolments());
    }
    public void viewEnrolmentsInOneSemester(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Semester: ");
        String semester = sc.nextLine() + "\n";
        enrolmentService.display(enrolmentService.getAllEnrolmentsInOneSemester(semester));
    }
    public void viewEnrolmentInOneSemester(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Student ID: ");
        String sid = sc.nextLine() + "\n";
        System.out.print("Course ID: ");
        String cid = sc.nextLine() + "\n";
        System.out.print("Semester: ");
        String semester = sc.nextLine() + "\n";
        System.out.println(enrolmentService.getOneEnrolment(sid, cid, semester));
    }

    public void addOneEnrolment(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Student ID: ");
        String sid = sc.nextLine() + "\n";
        System.out.print("Course ID: ");
        String cid = sc.nextLine() + "\n";
        System.out.print("Semester: ");
        String semester = sc.nextLine() + "\n";
        if(enrolmentService.addEnrolment(sid, cid, semester)){
            System.out.println("Enrolled successful");
        } else{
            System.out.println("Enrolled unsuccessful\n Please try again");
        }
    }

    public void deleteOneEnrolment(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Student ID: ");
        String sid = sc.nextLine() + "\n";
        System.out.print("Course ID: ");
        String cid = sc.nextLine() + "\n";
        System.out.print("Semester: ");
        String semester = sc.nextLine() + "\n";
        if(enrolmentService.deleteEnrolment(sid, cid, semester)){
            System.out.println("Dropped successful");
        } else{
            System.out.println("Dropped unsuccessful\n Please try again");
        }
    }

    public void updateEnrolmentMenu(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Do you want to update the enrolment? (y/n): ");
        String choice = sc.nextLine() + "\n";
//        while (true){
//            if (choice.equalsIgnoreCase("y")){
//                System.out.println("1. Add enrolment");
//                System.out.println("2. Delete enrolment");
//
//            }
//        }

    }
}
