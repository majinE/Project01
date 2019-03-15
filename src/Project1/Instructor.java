/**
 * Title: Instructor.java
 * Abstract: This java file is used to create new instructors and assign courses to them. A hashmap holds all the
 *           data for the Course assigned and the key value is the course number.
 * Author: Edgar Morales Reyes
 * Date: 3/15/2019
 */

package Project1;

import java.util.HashMap;
import java.util.Map;

public class Instructor {

    private int instructorNum;
    private String instructorName;
    private String email;
    private String phoneNum;
    private HashMap<Integer, Course> instructorCourse = new HashMap<>();

    public Instructor(int instructorNum, String instructorName, String email, String phoneNum) {
        this.instructorNum = instructorNum;
        this.instructorName = instructorName;
        this.email = email;
        this.phoneNum = phoneNum;
    }

    public int getInstructorNum() {
        return instructorNum;
    }

    public String getInstructorName() {
        return instructorName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public HashMap<Integer, Course> getInstructorCourse() {
        return instructorCourse;
    }

    @Override
    public String toString() {
        System.out.print("Instructor Number: " + this.instructorNum + '\n' +
                "Name: " + this.instructorName + '\n' +
                "Courses Teaching:\n");
                for(Map.Entry mapCoursesTeaching : this.instructorCourse.entrySet()) {
                    Integer key = (Integer) mapCoursesTeaching.getKey();
                    System.out.print(this.instructorCourse.get(key).getCourseNum() + ": " + this.instructorCourse.get(key).getCurrCapacity() + " enrolled\n");
                }
                return "";
    }

}
