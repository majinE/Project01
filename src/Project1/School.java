package Project1;

import java.util.ArrayList;

public class School {
    private String name;

    private ArrayList<Course> courses = new ArrayList<>();
    private ArrayList<Instructor> instructors = new ArrayList<>();
    private ArrayList<Student> students = new ArrayList<>();

    School(String name) {
        this.name = name;
    }

    void readData(String filename) {

    }

    void schoolInfo() {

    }

    void searchByEmail(String email) {

    }

    void addInstructor(int instructorNum, String name, String email, String phoneNum) {

    }

    void addCourse (int courseNum, String courseName, int courseCapacity, String location) {

    }

    void assignInstructor(int courseNum, int instructorNum) {

    }

    void register(int courseNum, int studentNum) {

    }

    void putScore(int courseNum, int studentNum, double studentScore) {

    }

    void unRegister(int courseNum, int studentNum) {

    }

    void courseInfo() {

    }

    void courseInfo(int courseNum) {
        System.out.println("TEST");
    }

    void deleteCourse(int courseNum) {

    }

    void addStudent(int studentNum, String studentName) {

    }

    Course getCourse(int courseNum) {

    }

    Instructor getInstructor(int intructorNum) {

    }

    Student getStudent(int studentNum) {

    }

    void graduateStudent(int studentNum) {

    }
}
