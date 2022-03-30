import menu.MainMenu;
import repo.StudentEnrolmentManagerImpl;

public class Main {
    public static void main(String[] args) {
        StudentEnrolmentManagerImpl semi = new StudentEnrolmentManagerImpl();
        semi.populateData();
        MainMenu mainMenu = new MainMenu(semi);
        mainMenu.run();
    }
}
