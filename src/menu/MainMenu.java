package menu;

import repo.StudentEnrolmentManager;

import java.util.Scanner;

public class MainMenu {
//    private CourseMenu courseMenu;
//    private StudentMenu studentMenu;
//    private EnrolmentMenu enrolmentMenu;
    private StudentEnrolmentManager sem;

    public void run(){
//        boolean isRun = true;
//        String choice;
//        System.out.println("---------- Student Enrolment Management ----------");
//        while (isRun){
//            System.out.println("Which one you want to see: ");
//            System.out.println("1. Manage courses");
//            System.out.println("2. Manage enrolments");
//            System.out.println("3. Manage students");
//            choice = inputField();
//            switch (choice){
//                case "1":
//
//            }
//
//        }
    }

    public String inputField(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Your choice: ");
        return sc.nextLine();
    }

    public void quit(){

    }
}
