// MVCTest.java
public class MVCTest {
    public static void main(String[] args) {

        // Create Model
        Student student = new Student("S001", "Alice", "A");

        // Create View
        StudentView view = new StudentView();

        // Create Controller
        StudentController controller = new StudentController(student, view);

        System.out.println("Initial details:");
        controller.updateView();

        // Update via controller
        controller.setStudentName("Alice Johnson");
        controller.setStudentGrade("A+");

        System.out.println("\nAfter update:");
        controller.updateView();
    }
}
