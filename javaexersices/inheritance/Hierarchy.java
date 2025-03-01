package inheritance;

import java.util.Scanner;

class Employee {
    String name;
    String address;
    double salary;
    String jobTitle;

    public Employee(String name, String address, double salary, String jobTitle) {
        this.name = name;
        this.address = address;
        this.salary = salary;
        this.jobTitle = jobTitle;
    }

    public double calculateTax() {
        if (salary <= 150) {
            return 0;
        } else if (salary > 150 && salary <= 500) {
            return salary * 0.10;
        } else if (salary > 500 && salary <= 1400) {
            return salary * 0.15;
        } else if (salary > 1400 && salary <= 2350) {
            return salary * 0.20;
        } else if (salary > 2350 && salary <= 3350) {
            return salary * 0.25;
        } else if (salary > 3350 && salary <= 5000) {
            return salary * 0.30;
        } else {
            return salary * 0.35;
        }
    }

    public double calculatePension() {
        return salary * 0.06;
    }

    public double calculateNetSalary() {
        double tax = calculateTax();
        double pension = calculatePension();
        return salary - (tax + pension);
    }

    public void displayDetails() {
        System.out.println("Name: " + name);
        System.out.println("Address: " + address);
        System.out.println("Job Title: " + jobTitle);
        System.out.println("Salary: " + salary);
        System.out.println("Tax: " + calculateTax());
        System.out.println("Pension: " + calculatePension());
        System.out.println("Net Salary: " + calculateNetSalary());
    }
}

class Manager extends Employee {
    public Manager(String name, String address, double salary) {
        super(name, address, salary, "Manager");
    }
}

class Developer extends Employee {
    public Developer(String name, String address, double salary) {
        super(name, address, salary, "Developer");
    }
}

class Programmer extends Employee {
    public Programmer(String name, String address, double salary) {
        super(name, address, salary, "Programmer");
    }
}

public class Hierarchy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get Manager details
        System.out.println("Enter Manager's details:");
        System.out.print("Name: ");
        String managerName = scanner.nextLine();
        System.out.print("Address: ");
        String managerAddress = scanner.nextLine();
        System.out.print("Salary: ");
        double managerSalary = scanner.nextDouble();
        scanner.nextLine();  

        Manager manager = new Manager(managerName, managerAddress, managerSalary);

        // Get Developer details
        System.out.println("\nEnter Developer's details:");
        System.out.print("Name: ");
        String developerName = scanner.nextLine();
        System.out.print("Address: ");
        String developerAddress = scanner.nextLine();
        System.out.print("Salary: ");
        double developerSalary = scanner.nextDouble();
        scanner.nextLine();  

        Developer developer = new Developer(developerName, developerAddress, developerSalary);

        // Get Programmer details
        System.out.println("\nEnter Programmer's details:");
        System.out.print("Name: ");
        String programmerName = scanner.nextLine();
        System.out.print("Address: ");
        String programmerAddress = scanner.nextLine();
        System.out.print("Salary: ");
        double programmerSalary = scanner.nextDouble();

        Programmer programmer = new Programmer(programmerName, programmerAddress, programmerSalary);

        // Displaying details for all employees
        System.out.println("\nManager Details:");
        manager.displayDetails();

        System.out.println("\nDeveloper Details:");
        developer.displayDetails();

        System.out.println("\nProgrammer Details:");
        programmer.displayDetails();

        scanner.close();  
    }
}
