package Project1;

public class Student {

    private String studentName;
    private int studentNum;

    Student(String studentName, int studentNum) {
        this.studentName = studentName;
        this.studentNum = studentNum;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentName='" + studentName + '\'' +
                ", studentNum=" + studentNum +
                '}';
    }
}
