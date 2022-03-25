package service;

import csv.csvReader;
import model.Course;
import model.Student;
import model.StudentEnrolment;
import repo.StudentEnrolmentManager;
import utility.DateConverter;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;

public class csvService {
    private final StudentEnrolmentManager sem;

    public csvService(StudentEnrolmentManager sem) {
        this.sem = sem;
    }

    private Student convertCsvToStudent(String csv){
        String[] fields = csv.split(",");
        String sid = fields[0].trim();
        String studentName = fields[1].trim();
        Date birthDate = null;
        try {
            birthDate = DateConverter.convertStringToDate(fields[2]);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return new Student(sid, studentName, birthDate);
    }

    private Course convertCsvToCourse(String csv){
        String[] fields = csv.split(",");
        String cid = fields[3].trim();
        String courseName = fields[4].trim();
        int credit = Integer.parseInt(fields[5]);

        return new Course(cid, courseName, credit);
    }

    private StudentEnrolment convertCsvToEnrolment(String csv){
        String[] fields = csv.split(",");
        Student student = sem.getStudentByID(fields[0]);
        Course course = sem.getCourseByID(fields[3]);
        String sem = fields[6];

        return new StudentEnrolment(student, course, sem);
    }

    public ArrayList<Student> getStudentsFromCSV(String fileName){
        csvReader reader = new csvReader(fileName);
        ArrayList<Student> students = new ArrayList<>();
        for (String row : reader.getAllEnrolment()){
            students.add(convertCsvToStudent(row));
        }
        return students;
    }

    public ArrayList<Course> getCoursesFromCSV(String fileName){
        csvReader reader = new csvReader(fileName);
        ArrayList<Course> courses = new ArrayList<>();
        for (String row : reader.getAllEnrolment()){
            courses.add(convertCsvToCourse(row));
        }
        return courses;
    }

    public ArrayList<StudentEnrolment> getEnrolmentsFromCSV(String fileName){
        csvReader reader = new csvReader(fileName);
        ArrayList<StudentEnrolment> enrolments = new ArrayList<>();
        for (String se : reader.getAllEnrolment()){
            enrolments.add(convertCsvToEnrolment(se));
        }
        return enrolments;
    }
}
