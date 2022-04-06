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

    /**
     * get Student ID input
     * @return String
     */
    public String getSidInput() {
        return sidInput.getInput();
    }

    /**
     * get Course ID input
     * @return String
     */
    public String getCidInput() {
        return cidInput.getInput();
    }

    /**
     * get Semester ID input
     * @return String
     */
    public String getSemesterInput() {
        return semesterInput.getInput();
    }

    /**
     * get Write report input
     * @return String
     */
    public String getWriteReport() {
        return writeReport.getInput();
    }
}
