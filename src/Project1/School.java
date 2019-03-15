/**
 * Title: School.java
 * Abstract: This is the main school file that manipulates all the other java objects such as instructors, courses, and students.
 * Author: Edgar Morales Reyes
 * Date: 3/15/2019
 */

package Project1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class School {
    private String name;

    private HashMap<Integer ,Course> courses = new HashMap<>();
    private HashMap<Integer ,Instructor> instructors = new HashMap<>();
    private HashMap<Integer , Student> students = new HashMap<>();

    School(String name) {
        this.name = name;
    }

    void readData(String filename) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            String line;

            for (int i = 0; i < 3; i++) {
                line = reader.readLine();

                int end = Integer.parseInt(line);
                for (int j = 0; j < end; j++) {
                    line = reader.readLine();
                    String[] fileInput = new String[line.split(",").length];
                    fileInput = line.split(",");
                    switch (i) {
                        case 0:
                            int instructorNum = Integer.parseInt(fileInput[0]);
                            if(instructors.containsKey(instructorNum)) {
                                System.out.println("Instructor info reading failed - Employee number " + instructorNum + " already used.");
                                break;
                            }
                            instructors.put(instructorNum, new Instructor(instructorNum, fileInput[1], fileInput[2], fileInput[3]));
                            break;
                        case 1:
                            int courseNum = Integer.parseInt(fileInput[0]);
                            if(courses.containsKey(courseNum)) {
                                System.out.println("Course info reading failed - Course number " + courseNum + " already used.");
                                break;
                            }
                            int cap = Integer.parseInt(fileInput[2]);
                            courses.put(courseNum, new Course(courseNum, fileInput[1], cap, fileInput[3]));
                            break;
                        case 2:
                            int studentNum = Integer.parseInt(fileInput[0]);
                            if(students.containsKey(studentNum)) {
                                System.out.println("Student info reading failed - Student ID " + studentNum + " already used.");
                                break;
                            }
                            students.put(studentNum, new Student(studentNum, fileInput[1]));
                            break;
                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found. Try Again.");
        } catch (IOException e) {
            System.out.println("Error occurred.");
        }
        System.out.println("Done.");
    }

    void schoolInfo() {
        System.out.println("School Name: " + this.name);
        System.out.println("Instructor Information");
        for(Map.Entry mapInstructor : instructors.entrySet()) {
            Integer key = (Integer)mapInstructor.getKey();
            System.out.println(instructors.get(key).getInstructorName());
        }
        System.out.println("Course Information");
        for(Map.Entry mapCourse : courses.entrySet()) {
            Integer key = (Integer)mapCourse.getKey();
            System.out.println(courses.get(key).getCourseName());
        }
        System.out.println("Student Information");
        for(Map.Entry mapStudent : students.entrySet()) {
            Integer key = (Integer)mapStudent.getKey();
            System.out.println(students.get(key).getStudentName());
        }
    }

    void searchByEmail(String email) {
        System.out.println("Search key: " + email);
        for(Map.Entry mapInstructor : instructors.entrySet()) {
            Integer key = (Integer)mapInstructor.getKey();
            if(instructors.get(key).getEmail().equals(email)){
                System.out.println("Employee Number: " + instructors.get(key).getInstructorNum());
                System.out.println("Name: " + instructors.get(key).getInstructorName());
                System.out.println("Phone: " + instructors.get(key).getPhoneNum());
                return;
            }
        }
        System.out.println("No employee with email " + email);
    }

    void addInstructor(int instructorNum, String name, String email, String phoneNum) {
        if(instructors.containsKey(instructorNum)) {
            System.out.println("Instructor addition failed - Instructor with employee number " + instructorNum + " already exists.");
            return;
        }
        instructors.put(instructorNum, new Instructor(instructorNum, name, email, phoneNum));
    }

    void addCourse (int courseNum, String courseName, int courseCapacity, String location) {
        if(courses.containsKey(courseNum)) {
            System.out.println("Course addition failed - Course number " + courseNum + " already used.");
            return;
        }
        courses.put(courseNum, new Course(courseNum, courseName, courseCapacity, location));
    }


    void addStudent(int studentNum, String studentName) {
        if(students.containsKey(studentNum)) {
            System.out.println("Student addition failed - Student with ID " + studentName + " already exists.");
            return;
        }
        students.put(studentNum, new Student(studentNum, studentName));
    }

    void assignInstructor(int courseNum, int instructorNum) {
        if(!instructors.containsKey(instructorNum)) {
            System.out.println("Instructor " + instructorNum + " does not exist.");
            return;
        }
        if(!courses.containsKey(courseNum)) {
            System.out.println("Course " + courseNum + " does not exist.");
            return;
        }
        if(instructors.get(instructorNum).getInstructorCourse().containsKey(courseNum)) {
            System.out.println("Instructor is already teaching course " + courses.get(courseNum).getCourseName());
            return;
        }
        instructors.get(instructorNum).getInstructorCourse().put(courseNum, courses.get(courseNum));
    }

    void register(int courseNum, int studentNum) {
        if(!students.containsKey(studentNum)) {
            System.out.println("Student " + studentNum + " does not exist.");
            return;
        }
        if(courses.get(courseNum).getCurrCapacity() == courses.get(courseNum).getCourseCapacity()) {
            System.out.println("Registration failed - Class is full");
            return;
        }
        if(!courses.containsKey(courseNum)) {
            System.out.println("Course " + courseNum + " does not exist.");
            return;
        }
        if(courses.get(courseNum).getCourseStudents().containsKey(studentNum)) {
            System.out.println("Student " +  studentNum + " " + students.get(studentNum).getStudentName() + " is already enrolled in " + courseNum + ".");
            return;
        }
        courses.get(courseNum).getCourseStudents().put(studentNum, students.get(studentNum));
        students.get(studentNum).getStudentCourse().put(courses.get(courseNum), 0.0);
        courses.get(courseNum).setCurrCapacity(courses.get(courseNum).getCurrCapacity() + 1);
    }

    void putScore(int courseNum, int studentNum, double studentScore) {
        if(!students.containsKey(studentNum)){
            System.out.println("Student " + studentNum + " does not exist.");
            return;
        }
        if(!courses.containsKey(courseNum)) {
            System.out.println("Course " + courseNum + " does not exist.");
            return;
        }
        if(!courses.get(courseNum).getCourseStudents().containsKey(studentNum)) {
            System.out.println("Student " +  studentNum + " " + students.get(studentNum).getStudentName() + " is not enrolled in " + courseNum + ".");
            return;
        }
        courses.get(courseNum).getCourseStudentsGrade().put(studentNum, studentScore);
        students.get(studentNum).getStudentCourse().put(courses.get(courseNum), studentScore);
    }

    void unRegister(int courseNum, int studentNum) {
        if(!courses.containsKey(courseNum)) {
            System.out.println("UnRegistration failed - Course does not exists.");
            return;
        }
        if(!students.containsKey(studentNum)) {
            System.out.println("UnRegistration failed - Student does not exists");
            return;
        }
        if(!courses.get(courseNum).getCourseStudents().containsKey(studentNum)) {
            System.out.println("UnRegistration failed - Student is not registered in the course.");
            return;
        }
        courses.get(courseNum).getCourseStudents().get(studentNum).getStudentCourse().remove(courseNum);
        courses.get(courseNum).getCourseStudents().remove(studentNum);
        courses.get(courseNum).getCourseStudentsGrade().remove(studentNum);
        courses.get(courseNum).setCurrCapacity(courses.get(courseNum).getCurrCapacity() - 1);
    }

    void courseInfo() {
        System.out.println("Number of Courses: " + courses.size());
        for(Map.Entry mapCourse : courses.entrySet()) {
            Integer key = (Integer) mapCourse.getKey();
            System.out.println(courses.get(key).getCourseNum() + ": " + courses.get(key).getCurrCapacity() + " enrolled");
        }
    }

    void courseInfo(int courseNum) {
        for(Map.Entry mapInstructors : instructors.entrySet()) {
            Integer key = (Integer) mapInstructors.getKey();
            if(instructors.get(key).getInstructorCourse().containsKey(courseNum)) {
                System.out.println("Course Number: " + courseNum);
                System.out.println("Instructor: " + instructors.get(key).getInstructorName());
                System.out.println("Course Title: " + instructors.get(key).getInstructorCourse().get(courseNum).getCourseName());
                System.out.println("Room: " + instructors.get(key).getInstructorCourse().get(courseNum).getCourseLocation());
                System.out.println("Total Enrolled: " + instructors.get(key).getInstructorCourse().get(courseNum).getCurrCapacity());
                System.out.println("Course Average: " + instructors.get(key).getInstructorCourse().get(courseNum).getGradeAverage());
            }
        }
    }

    void deleteCourse(int courseNum) {
        if(!courses.containsKey(courseNum)) {
            System.out.println("Course deletion failed - Course does not exists.");
            return;
        }
        if(courses.get(courseNum).getCurrCapacity() > 0) {
            System.out.println("Course deletion failed - Enrolled student(s) in the class.");
            return;
        } else if(courses.get(courseNum).getCurrCapacity() == 0) {
            courses.remove(courseNum);
            System.out.println("Course deletion completed.");
        }
    }

    Course getCourse(int courseNum) {
        if(courses.containsKey(courseNum)){
            return courses.get(courseNum);
        }
        System.out.println("Course doesn't exist. Returning null object..");
        return null;
    }

    Instructor getInstructor(int courseNum) {
        for(Map.Entry mapInstructors : instructors.entrySet()) {
            Integer key = (Integer) mapInstructors.getKey();

            if(instructors.get(key).getInstructorCourse().containsKey(courseNum)) {
                return instructors.get(key);
            }
        }
        System.out.println("Instructor doesn't exist. Returning null object..");
        return null;
    }

    Student getStudent(int studentNum) {
        if(students.containsKey(studentNum)) {
            return students.get(studentNum);
        }
        return null;
    }

    void graduateStudent(int studentNum) {
        if(!students.containsKey(studentNum)) {
            System.out.println("Graduation failed - Student does not exist.");
            return;
        }
        boolean unregistered = false;
        for(Map.Entry mapCourses: courses.entrySet()) {
            Integer key = (Integer) mapCourses.getKey();
            if(courses.get(key).getCourseStudents().containsKey(studentNum)) {
                unRegister(courses.get(key).getCourseNum(), studentNum);
                unregistered = true;
            }
        }
        if(unregistered ) {
            this.students.remove(studentNum);
        }
    }
}
