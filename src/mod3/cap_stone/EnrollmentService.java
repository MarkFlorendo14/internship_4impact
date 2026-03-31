package mod3.cap_stone;

import java.util.ArrayList;
import java.util.HashMap;

public class EnrollmentService {
    private HashMap<String, Course> courseRegistry = new HashMap<>();
    private ArrayList<Student> students = new ArrayList<>();

    public void enrollinCourse(int studentID, String courseCode) throws EnrollmentException {
        //find the student from the list
        Student foundStudent = null;
        for (Student s : students) {
            if (s.getStudentID() == studentID) {
                foundStudent = s;

            }
        }
        //find the course from the HashMap
        Course foundCourse = courseRegistry.get(courseCode);

        //check if they exist
        if (foundStudent == null) {
            throw new EnrollmentException("Student not found!");
        }
        if (foundCourse == null) {
            throw new EnrollmentException("Course not found!");
        }

        //check if course is full
        if (foundCourse.getStudentList().size() >= foundCourse.getMaxCapacity()) {
            throw new EnrollmentException("Course is full!");
        }

        //enroll
        foundCourse.getStudentList().add(foundStudent);
        foundStudent.enroll(foundCourse);
    }

    public void addCourse(Course course) {
        courseRegistry.put(course.getCourseCode(), course);
        System.out.println("Course successfully added! \n");
    }

    public void addStudent(Student student) {
        students.add(student);
        System.out.println("Student successfully added! \n");

    }
    public void listAllStudents(){
        System.out.print("List of students: ");
        for (Student s : students) {
            System.out.println("\n" + s);
        }
    }
    public void listAllCourses(){
        for (Course c : courseRegistry.values()) {
            System.out.println(c.getCourseCode() + " - " + c.getCourseName());
        }
    }

}
