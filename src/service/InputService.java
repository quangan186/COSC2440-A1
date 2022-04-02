package service;

import utility.Input;

public class InputService {
    private final Input sidInput;
    private final Input cidInput;
    private final Input semesterInput;
    private final Input writeReport;

    public InputService() {
        this.sidInput = new Input("Student ID: ");
        this.cidInput = new Input("Course ID: ");
        this.semesterInput = new Input("Semester: ");
        this.writeReport = new Input("Do you want to save the report? (y/n): ");
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

    public String getWriteReport() {
        return writeReport.getInput();
    }
}
