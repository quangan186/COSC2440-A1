package menu;

import repo.StudentEnrolmentManager;
import service.CourseService;
import service.InputService;

import java.util.Scanner;

public class CourseMenu {
    private final CourseService courseService;
    private final InputService inputService;

    public CourseMenu(StudentEnrolmentManager sem) {
        this.inputService = new InputService(sem);
        this.courseService = new CourseService(sem);
    }

    public void viewCourses(){
        courseService.display(courseService.getAllCourses());
    }
    public void viewAllCoursesInOneSemester(){
        String semester = inputService.getSemesterInput();
        if (semester.isEmpty()) return;
        courseService.display(courseService.getAllCoursesInOneSemester(semester));
    }

    public void viewCoursesStudentLearnInOneSemester(){
        String sid = inputService.getSidInput();
        if (sid.isEmpty()) return;
        String semester = inputService.getSemesterInput();
        if (semester.isEmpty()) return;
        courseService.display(courseService.getCoursesStudentLearnsInOneSemester(sid, semester));
    }

    public void menu(){
        System.out.println("Which one you want to see?");
        System.out.println("1. View courses");
        System.out.println("2. View courses in one semester");
        System.out.println("3. View courses student learn in one semester");
        System.out.println("4. Back");
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
