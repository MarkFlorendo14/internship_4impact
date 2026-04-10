package mod3.cap_stone;
import java.util.ArrayList;

public class Student extends People {
    //init fields here
    private int studentID;
    //Creation of ArrayList object na tumatanggap lang ng data from Course constructor/class
    private ArrayList<Course> enrolledCourses = new ArrayList<>();

    //Constructor for student object
    public Student(String name, int studentID) {
        super(name);
        this.studentID = studentID;
    }
    //Add courses for specific student lang
    public void enroll(Course course){
        enrolledCourses.add(course);
    }
    //role issue

    public int getStudentID(){
        return studentID;
    }

    @Override
    public String getRole() {
        return "Student";
    }
}
