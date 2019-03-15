/**
 * Title: Student.java
 * Abstract: This is the file that creates the student object and manipulates its data. It utilizes a hashmap that contains
 *           a key representing the course enrolled, and the current grade in the course.
 * Author: Edgar Morales Reyes
 * Date: 3/15/2019
 */

package Project1;

import java.util.HashMap;
import java.util.Map;

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
        double courseAverage = 0;
        System.out.print("Student Number: " + studentNum + '\n' +
                "Name: " + studentName + '\n' +
                "Courses Enrolled: \n");
        for(Map.Entry mapCoursesEnrolled : studentCourse.entrySet()){
            Course key = (Course) mapCoursesEnrolled.getKey();
            System.out.println(key.getCourseNum() + ": " + studentCourse.get(key));
            courseAverage+=studentCourse.get(key);
        }
        System.out.println("Course Average: " + courseAverage/studentCourse.size());
        return "";
    }
}
