import java.util.Objects; // Still needed for safe null checks in isEqual

public class Student {

    // Instance variables (attributes)
    private int studentId;
    private String name;

    // 1) Parameterized constructor to initialize the objects
    public Student(int studentId, String name) {
        this.studentId = studentId;
        this.name = name;
    }

    // 2) Static function isEqual() to check whether the two objects are equal
    public static boolean isEqual(Student s1, Student s2) {
        // Handle cases where one or both objects might be null
        if (s1 == null && s2 == null) {
            return true; // Both null
        }
        if (s1 == null || s2 == null) {
            return false; // One is null, the other isn't
        }

        // If both objects are not null, compare their attributes
        boolean idsMatch = (s1.studentId == s2.studentId);
        boolean namesMatch = Objects.equals(s1.name, s2.name); // Null-safe name comparison

        // Return true only if both ID and name match
        return idsMatch && namesMatch;
    }

    // 3) Main method to create objects, test isEqual(), and print the result
    public static void main(String[] args) {
        // Create some Student objects
        Student student1 = new Student(101, "Alice");
        Student student2 = new Student(102, "Bob");
        Student student3 = new Student(101, "Alice"); // Same details as student1
        Student student4 = new Student(101, "Alicia"); // Same ID, different name
        Student student5 = null;
        Student student6 = null;

        // Test the isEqual method and print results
        System.out.println("Comparing student1 and student3:");
        if (Student.isEqual(student1, student3)) {
            System.out.println("Result: Objects are equal."); // Expected
        } else {
            System.out.println("Result: Objects are NOT equal.");
        }
        System.out.println("---");

        System.out.println("Comparing student1 and student2:");
        if (Student.isEqual(student1, student2)) {
            System.out.println("Result: Objects are equal.");
        } else {
            System.out.println("Result: Objects are NOT equal."); // Expected
        }
        System.out.println("---");

        System.out.println("Comparing student1 and student4:");
         if (Student.isEqual(student1, student4)) {
            System.out.println("Result: Objects are equal.");
        } else {
            System.out.println("Result: Objects are NOT equal."); // Expected (different names)
        }
        System.out.println("---");

        System.out.println("Comparing student1 and student5 (null):");
         if (Student.isEqual(student1, student5)) {
            System.out.println("Result: Objects are equal.");
        } else {
            System.out.println("Result: Objects are NOT equal."); // Expected
        }
        System.out.println("---");

        System.out.println("Comparing student5 (null) and student6 (null):");
         if (Student.isEqual(student5, student6)) {
            System.out.println("Result: Objects are equal."); // Expected
        } else {
            System.out.println("Result: Objects are NOT equal.");
        }
        System.out.println("---");
    }
}