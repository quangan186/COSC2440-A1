//package menu;
//
//import repo.StudentEnrolmentManager;
//import service.EnrolmentService;
//
//import java.awt.*;
//import java.util.Scanner;
//
//public class EnrolmentMenu {
//    private EnrolmentService enrolmentService;
//
//    public EnrolmentMenu(StudentEnrolmentManager sem) {
//        this.enrolmentService = new EnrolmentService(sem);
//    }
//
//    public void viewEnrolments(){
//        enrolmentService.display(enrolmentService.getAllEnrolments());
//    }
//    public void viewEnrolmentsInOneSemester(){
//        Scanner sc = new Scanner(System.in);
//        System.out.print("Semester: ");
//        String semester = sc.nextLine() + "\n";
//        enrolmentService.display(enrolmentService.getAllEnrolmentsInOneSemester(semester));
//    }
//    public void viewEnrolmentInOneSemester(){
//        Scanner sc = new Scanner(System.in);
//        System.out.print("Student ID: ");
//        String sid = sc.nextLine() + "\n";
//        System.out.print("Course ID: ");
//        String cid = sc.nextLine() + "\n";
//        System.out.print("Semester: ");
//        String semester = sc.nextLine() + "\n";
//        System.out.println(enrolmentService.getOneEnrolment(sid, cid, semester));
//    }
//
//    public void addOneEnrolment(){
//
//    }
//
//    public void deleteOneEnrolment(){
//
//    }
//
//    public void updateEnrolment(){
//
//    }
//}
