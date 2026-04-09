package mod3.cap_stone;
import java.util.ArrayList;

public class Course {
    private String courseName;
    private String courseCode;
    private int maxCapacity;
    private ArrayList<Student> studentList = new ArrayList<>();

    public Course(String courseName, String courseCode, int maxCapacity){
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.maxCapacity = maxCapacity;
    }

    public String getCourseName(){
        return courseName;
    }
    public String getCourseCode(){
        return courseCode;
    }
    public int getMaxCapacity(){
        return maxCapacity;
    }
    public ArrayList<Student> getStudentList() {
        return studentList;
    }
}
