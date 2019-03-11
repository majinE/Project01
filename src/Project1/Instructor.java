package Project1;

public class Instructor {

    private int instructorNum;
    private String instructorName;
    private String email;
    private String phoneNum;

    public Instructor(int instructorNum, String instructorName, String email, String phoneNum) {
        this.instructorNum = instructorNum;
        this.instructorName = instructorName;
        this.email = email;
        this.phoneNum = phoneNum;
    }

    @Override
    public String toString() {
        return "Instructor{" +
                "instructorNum=" + instructorNum +
                ", instructorName='" + instructorName + '\'' +
                ", email='" + email + '\'' +
                ", phoneNum='" + phoneNum + '\'' +
                '}';
    }

}
