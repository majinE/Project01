package Project1;

import java.util.HashMap;
import java.util.Map;

public class Course {
    private int courseNum;
    private String courseName;
    private int courseCapacity;
    private String courseLocation;
    private int currCapacity;
    private HashMap<Integer, Student> courseStudents = new HashMap<>();
    private HashMap<Integer, Double> courseStudentsGrade = new HashMap<>();

    public Course(int courseNum, String courseName, int courseCapacity, String courseLocation) {
        this.courseNum = courseNum;
        this.courseName = courseName;
        this.courseCapacity = courseCapacity;
        this.courseLocation = courseLocation;
    }

    public int getCourseNum() {
        return courseNum;
    }

    public String getCourseName() {
        return courseName;
    }

    public int getCourseCapacity() {
        return courseCapacity;
    }

    public String getCourseLocation() {
        return courseLocation;
    }

    public HashMap<Integer, Student> getCourseStudents() {
        return courseStudents;
    }

    public HashMap<Integer, Double> getCourseStudentsGrade() {
        return courseStudentsGrade;
    }

    public int getCurrCapacity() {
        return currCapacity;
    }

    public void setCurrCapacity(int currCapacity) {
        this.currCapacity = currCapacity;
    }

    public void updateLocation(String newLocation) {
        this.courseLocation = newLocation;
    }

    public double getGradeAverage() {
        double sum = 0.0;
        for(Map.Entry mapGrades : this.courseStudentsGrade.entrySet()) {
            Integer key = (Integer) mapGrades.getKey();
            sum+=this.courseStudentsGrade.get(key);
        }
        return (sum/this.currCapacity);
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseNum=" + courseNum +
                ", courseName='" + courseName + '\'' +
                ", courseCapacity=" + courseCapacity +
                ", courseLocation='" + courseLocation + '\'' +
                '}';
    }

}
