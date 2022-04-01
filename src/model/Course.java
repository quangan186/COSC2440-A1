package model;

import java.util.Objects;

public class Course implements Model{
    private final String courseID;
    private final String courseName;
    private final int credit;

    public Course(String courseID, String courseName, int credit) {
        this.courseID = courseID;
        this.courseName = courseName;
        this.credit = credit;
    }

    public String getCourseID() {
        return courseID;
    }

    public String getCourseName() {
        return courseName;
    }

    public int getCredit() {
        return credit;
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseID='" + courseID + '\'' +
                ", courseName='" + courseName + '\'' +
                ", credit=" + credit +
                '}';
    }

    public String toCsvString(){
        return String.join(",", courseID, courseName, String.valueOf(credit)) + "\n";
    }

//    @Override
//    public boolean equals(Object obj) {
//        // TODO Auto-generated method stub
//        if(obj instanceof Course)
//        {
//            Course temp = (Course) obj;
//            if(this.courseID.equals(temp.courseID) && this.courseName.equals(temp.courseName) && this.credit == temp.credit)
//                return true;
//        }
//        return false;
//    }
//
//    @Override
//    public int hashCode() {
//        // TODO Auto-generated method stub
//
//        return (this.courseID.hashCode() + this.courseName.hashCode() + this.credit.hashCode() + this.description.hashCode());
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return credit == course.credit && Objects.equals(courseID, course.courseID) && Objects.equals(courseName, course.courseName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(courseID, courseName, credit);
    }
}
