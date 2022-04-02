package service;

import csv.CsvReader;
import model.Course;
import model.Student;
import model.StudentEnrolment;
import repo.StudentEnrolmentManager;
import utility.DateConverter;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class CsvService {
    private final StudentEnrolmentManager sem;

    public CsvService(StudentEnrolmentManager sem) {
        this.sem = sem;
    }

    private Student convertRowToStudent(String csv){
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

    private Course convertRowToCourse(String csv){
        String[] fields = csv.split(",");
        String cid = fields[3].trim();
        String courseName = fields[4].trim();
        int credit = Integer.parseInt(fields[5]);

        return new Course(cid, courseName, credit);
    }

    private StudentEnrolment convertRowToEnrolment(String csv){
        String[] fields = csv.split(",");
        String sem = fields[6];

        return new StudentEnrolment(convertRowToStudent(csv), convertRowToCourse(csv), sem);
    }

    public ArrayList<Student> getStudentsFromCSV(String fileName){
        CsvReader reader = new CsvReader(fileName);
        ArrayList<Student> students = new ArrayList<>();
        for (String row : reader.getAllEnrolment()){
            students.add(convertRowToStudent(row));
        }
        return students;
    }

    public ArrayList<Course> getCoursesFromCSV(String fileName){
        CsvReader reader = new CsvReader(fileName);
        ArrayList<Course> courses = new ArrayList<>();
        for (String row : reader.getAllEnrolment()){
            courses.add(convertRowToCourse(row));
        }
        return courses;
    }

    public ArrayList<StudentEnrolment> getEnrolmentsFromCSV(String fileName){
        CsvReader reader = new CsvReader(fileName);
        ArrayList<StudentEnrolment> enrolments = new ArrayList<>();
        for (String se : reader.getAllEnrolment()){
            enrolments.add(convertRowToEnrolment(se));
        }
        return enrolments;
    }

    public ArrayList<String> getAllStudentID(String fileName){
        CsvReader reader = new CsvReader(fileName);
        ArrayList<String> sidList = new ArrayList<>(reader.getColumn(0));
        Set<String> set = new HashSet<>(sidList);
        sidList.clear();
        sidList.addAll(set);
        return sidList;
    }

    public ArrayList<String> getAllCourseID(String fileName){
        CsvReader reader = new CsvReader(fileName);
        ArrayList<String> cidList = new ArrayList<>(reader.getColumn(3));
        Set<String> set = new HashSet<>(cidList);
        cidList.clear();
        cidList.addAll(set);
        return cidList;
    }

    public ArrayList<String> getAllSemester(String fileName){
        CsvReader reader = new CsvReader(fileName);
        ArrayList<String> semList = new ArrayList<>(reader.getColumn(6));
        Set<String> set = new HashSet<>(semList);
        semList.clear();
        semList.addAll(set);
        return semList;
    }

}
