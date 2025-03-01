package constracter;
import java.util.Scanner;
import java.util.Arrays;

public class ClassRoom {
    private String className; 
    private String[] students; 

   
  ClassRoom(String className, String[] students) {
        this.className = className;
        this.students = students;

        
        System.out.println("Class Name: " + className);
        System.out.println("Students: " + Arrays.toString(students));
    }

   
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

     
        System.out.print("Enter the class name: ");
        String className = scanner.nextLine();

       
        System.out.print("Enter the number of students: ");
        int numberOfStudents = scanner.nextInt();
        scanner.nextLine(); 

        
        String[] studentNames = new String[numberOfStudents];
        System.out.println("Enter the names of the students:");
        for (int i = 0; i < numberOfStudents; i++) {
            System.out.print("Student " + (i + 1) + ": ");
            studentNames[i] = scanner.nextLine();
        }

        
        new ClassRoom(className, studentNames);

  
    }
}
