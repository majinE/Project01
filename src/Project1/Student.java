package Project1;

import java.util.HashMap;

public class Student {

    private int studentNum;
    private String studentName;
    private HashMap<Course, Double> studentCourse = new HashMap<>();

    Student(int studentNum, String studentName) {
        this.studentNum = studentNum;
        this.studentName = studentName;
    }

    public int getStudentNum() {
        return studentNum;
    }

    public String getStudentName() {
        return studentName;
    }

    public HashMap<Course, Double> getStudentCourse() {
        return studentCourse;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentNum='" + studentNum + '\'' +
                ", studentName=" + studentName +
                '}';
    }
}
