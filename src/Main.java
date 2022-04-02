import csv.CsvReader;
import menu.MainMenu;
import repo.StudentEnrolmentManager;
import repo.StudentEnrolmentManagerImpl;
import service.CsvService;

public class Main {
    public static void main(String[] args) {
        StudentEnrolmentManagerImpl semi = new StudentEnrolmentManagerImpl();
        semi.populateData();
        MainMenu mainMenu = new MainMenu(semi);
        mainMenu.run();
//        CsvReader reader = new CsvReader("default.csv");
//        StudentEnrolmentManager sem = new StudentEnrolmentManagerImpl();
//        CsvService service = new CsvService(sem);
//        System.out.println(service.getAllStudentID("default.csv"));
//        System.out.println(service.getAllCourseID("default.csv"));
//        System.out.println(service.getAllSemester("default.csv"));
    }
}
