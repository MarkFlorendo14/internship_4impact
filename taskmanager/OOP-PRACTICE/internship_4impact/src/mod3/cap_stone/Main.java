package mod3.cap_stone;
import java.util.Scanner;

public class Main {
    public static void main (String[] args){
        Scanner scanner = new Scanner(System.in);
        EnrollmentService service = new EnrollmentService();

        while (true) {
            //choicessss
            System.out.println("\n\n=== Student Management System ===");
            System.out.println("1. Add Student");
            System.out.println("2. Add Course");
            System.out.println("3. Enroll Student in Course");
            System.out.println("4. List All Students");
            System.out.println("5. List All Courses");
            System.out.println("6. View Course Enrollments");
            System.out.println("7. Exit");
            System.out.print("Choose an option: ");

            int choice = Integer.parseInt(scanner.nextLine());

            switch(choice) {
                //Print out students
                case 1:
                    System.out.println("Enter name: ");
                    String studentName = scanner.nextLine();
                    System.out.print("Enter student ID: ");
                    int studentID = Integer.parseInt(scanner.nextLine());
                    Student student = new Student(studentName, studentID);
                    service.addStudent(student);
                    break;

                case 2:
                    //ADd course and max capacity
                    System.out.print("Enter course name: ");
                    String courseName = scanner.nextLine();
                    System.out.print("Enter course code: ");
                    String courseCode = scanner.nextLine();
                    System.out.print("Enter max capacity: ");
                    int maxCapacity = Integer.parseInt(scanner.nextLine());
                    Course course = new Course(courseName, courseCode, maxCapacity);
                    service.addCourse(course);
                    break;

                case 3:
                    //enroll students in course
                        System.out.print("Enter student ID: ");
                        int id = Integer.parseInt(scanner.nextLine());

                        System.out.print("Enter course code: ");
                        String code = scanner.nextLine();

                    try {
                        service.enrollinCourse(id, code);
                        System.out.println("Enrolled successfully!");
                    } catch (EnrollmentException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case 4:
                    service.listAllStudents();
                    break;

                case 5:
                    service.listAllCourses();
                    break;

                case 6:

                    break;

                case 7:
                    System.out.println("Goodbye!");
                    return;

                default:
                    System.out.println("Invalid option, try again.");


            }
        }
    }
}
