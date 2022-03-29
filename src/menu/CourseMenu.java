package menu;

import repo.StudentEnrolmentManager;
import service.CourseService;

import java.util.Scanner;

public class CourseMenu {
    private final CourseService courseService;

    public CourseMenu(StudentEnrolmentManager sem) {
        this.courseService = new CourseService(sem);
    }

    public void viewCourses(){
        courseService.display(courseService.getAllCourses());
    }
    public void viewAllCoursesInOneSemester(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Semester: ");
        String semester = sc.nextLine();
        courseService.display(courseService.getAllCoursesInOneSemester(semester));
    }

    public void viewCoursesStudentLearnInOneSemester(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Student ID: ");
        String sid = sc.nextLine() + "\n";
        System.out.print("Semester: ");
        String semester = sc.nextLine() + "\n";
        courseService.display(courseService.getCoursesStudentLearnsInOneSemester(sid, semester));
    }

    public void menu(){
        System.out.println("1. View courses");
        System.out.println("2. View courses in one semester");
        System.out.println("3. View courses student learn in one semester");
        System.out.println("Which one you want to see?");
    }

//    private String inputChoice() {
//        Scanner sc = new Scanner(System.in);
//        System.out.print("Your choice: ");
//        return sc.nextLine();
//    }
//
//    private String yesNoInput(){
//        Scanner sc = new Scanner(System.in);
//        System.out.print("Do you want to see more (y/n): ");
//        return sc.nextLine();
//    }
}
