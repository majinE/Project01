package Project1;

import java.util.HashMap;

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
        return "Employee Number: " + this.instructorNum + '\n' +
                "Name: " + this.instructorName + '\n' +
                "Phone: " + this.phoneNum;
    }

}
