package Project1;

public class Course {
    private int courseNum;
    private String courseName;
    private int courseCapacity;
    private String courseLocation;

    public Course(int courseNum, String courseName, int courseCapacity, String courseLocation) {
        this.courseNum = courseNum;
        this.courseName = courseName;
        this.courseCapacity = courseCapacity;
        this.courseLocation = courseLocation;
    }

    void updateLocation(String newLocation) {
        this.courseLocation = newLocation;
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
