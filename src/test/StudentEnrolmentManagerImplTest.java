import model.Course;
import model.Student;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import repo.StudentEnrolmentManagerImpl;

import static org.junit.jupiter.api.Assertions.*;

class StudentEnrolmentManagerImplTest {
    private StudentEnrolmentManagerImpl semi = new StudentEnrolmentManagerImpl();

    @BeforeEach
    void setUp(){
        semi = new StudentEnrolmentManagerImpl();
        semi.populateData();
    }

    @Test
    void addEnrolment() {
        assertTrue(semi.addEnrolment("S101312", "COSC3321", "2021A"));
        assertFalse(semi.addEnrolment("S101312", "COSC4030", "2020C"));
    }

    @Test
    void deleteEnrolment() {
        semi.addEnrolment("S101312", "COSC4030", "2020C");
        assertFalse(semi.deleteEnrolment("S101312", "COSC3321", "2021A"));
        assertTrue(semi.deleteEnrolment("S101312", "COSC4030", "2020C"));
    }

    @Test
    void getOneEnrolment() {
        Assertions.assertNotNull(semi.getOneEnrolment("S101312", "COSC4030", "2020C"));
        Assertions.assertNull(semi.getOneEnrolment("S101312", "COSC3321", "2021A"));
    }

    @Test
    void getAllEnrolmentsInOneSemester() {
        Assertions.assertEquals(semi.getAllEnrolmentsInOneSemester("2020C").size(), 6);
        Assertions.assertEquals(semi.getAllEnrolmentsInOneSemester("2020B").size(), 2);
        Assertions.assertEquals(semi.getAllEnrolmentsInOneSemester("2021A").size(), 7);
    }

    @Test
    void getAllEnrolment() {
        Assertions.assertEquals(semi.getAllEnrolment().size(), 15);
    }

    @Test
    void getAllCourses() {
        Assertions.assertEquals(semi.getAllCourses().size(), 4);
    }

    @Test
    void getAllStudents() {
        Assertions.assertEquals(semi.getAllStudents().size(), 10);
    }

    @Test
    void getStudentByID() {
        Student student = new Student("S024680", "Diablo", null);
        semi.getAllStudents().add(student);
        Student foundStudent = semi.getStudentByID("S024680");
        assertNotNull(foundStudent);
        assertEquals(student.getStudentID(), foundStudent.getStudentID());
        assertEquals(student.getName(), foundStudent.getName());
        assertEquals(student.getBirthDate(), foundStudent.getBirthDate());
        assertNull(semi.getStudentByID("S123456"));
    }

    @Test
    void getCourseByID() {
        Course course = new Course("COSC2000", "Intro to Programming", 12);
        semi.getAllCourses().add(course);
        Course foundCourse = semi.getCourseByID("COSC2000");
        assertNotNull(foundCourse);
        assertEquals(foundCourse.getCourseID(), course.getCourseID());
        assertEquals(foundCourse.getCourseName(), course.getCourseName());
        assertEquals(foundCourse.getCredit(), course.getCredit());
        assertNull(semi.getCourseByID("COSC1234"));
    }
}