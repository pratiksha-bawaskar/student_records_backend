package com.example.student_records;

import java.util.Scanner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.model.Student;
import com.example.service.StudentService;

@Component
public class StudentApp implements CommandLineRunner {

    private final StudentService service = new StudentService();

    @Override
    public void run(String... args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n--- Student Record Menu ---");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Choose option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // consume newline
                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Course: ");
                    String course = scanner.nextLine();
                    service.addStudent(new Student(id, name, course));
                }
                case 2 -> service.viewAllStudents();
                case 3 -> {
                    System.out.print("Enter ID to update: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter new Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter new Course: ");
                    String course = scanner.nextLine();
                    service.updateStudent(id, name, course);
                }
                case 4 -> {
                    System.out.print("Enter ID to delete: ");
                    int id = scanner.nextInt();
                    service.deleteStudent(id);
                }
                case 5 -> {
                    running = false;
                    System.out.println("Exiting...");
                }
                default -> System.out.println("Invalid choice.");
            }
        }
        scanner.close();
    }
}
