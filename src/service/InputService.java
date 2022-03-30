package service;

import model.Course;
import model.Student;
import repo.StudentEnrolmentManager;
import utility.Input;

public class InputService {
    private final Input sidInput;
    private final Input cidInput;
    private final Input semesterInput;

    public InputService(StudentEnrolmentManager sem) {
        this.sidInput = new Input("Student ID: ");
        Student s = sem.getStudentByID(sidInput.toString());
        if (s == null){
            System.out.println(sidInput + " does not exist");
        }

        this.cidInput = new Input("Course ID: ");
        Course c = sem.getCourseByID(cidInput.toString());
        if (c == null){
            System.out.println(cidInput + " does not exist");
        }

        this.semesterInput = new Input("Semester: ");
    }

    public String getSidInput() {
        return sidInput.getInput();
    }

    public String getCidInput() {
        return cidInput.getInput();
    }

    public String getSemesterInput() {
        return semesterInput.getInput();
    }


}
