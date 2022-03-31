package service;

import utility.Input;

public class InputService {
    private final Input sidInput;
    private final Input cidInput;
    private final Input semesterInput;

    public InputService() {
        this.sidInput = new Input("Student ID: ");
        this.cidInput = new Input("Course ID: ");
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
