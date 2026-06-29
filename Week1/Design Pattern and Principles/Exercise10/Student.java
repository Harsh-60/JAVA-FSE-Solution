// ── Model ────────────────────────────────────────────────────────────────
public class Student {
    private String name;
    private String id;
    private String grade;

    public Student(String id, String name, String grade) {
        this.id    = id;
        this.name  = name;
        this.grade = grade;
    }

    // Getters & Setters
    public String getName()  { return name; }
    public String getId()    { return id; }
    public String getGrade() { return grade; }

    public void setName(String name)   { this.name = name; }
    public void setGrade(String grade) { this.grade = grade; }
}

// ── View ─────────────────────────────────────────────────────────────────
class StudentView {
    public void displayStudentDetails(String name, String id, String grade) {
        System.out.println("=== Student Details ===");
        System.out.println("ID    : " + id);
        System.out.println("Name  : " + name);
        System.out.println("Grade : " + grade);
        System.out.println("======================");
    }
}

// ── Controller ───────────────────────────────────────────────────────────
class StudentController {
    private Student     model;
    private StudentView view;

    public StudentController(Student model, StudentView view) {
        this.model = model;
        this.view  = view;
    }

    // Update model
    public void setStudentName(String name)   { model.setName(name); }
    public void setStudentGrade(String grade) { model.setGrade(grade); }

    // Read model
    public String getStudentName()  { return model.getName(); }
    public String getStudentGrade() { return model.getGrade(); }

    // Render view
    public void updateView() {
        view.displayStudentDetails(model.getName(), model.getId(), model.getGrade());
    }
}
