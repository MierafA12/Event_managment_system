import java.util.*;
import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

// Base class Event
class Event {
    String eventName, date, time, location, description, organizer;

    public Event(String eventName, String date, String time, String location, String description, String organizer) {
        this.eventName = eventName;
        this.date = date;
        this.time = time;
        this.location = location;
        this.description = description;
        this.organizer = organizer;
    }

    public void displayEvent() {
        System.out.println("\n----------------------------------------");
        System.out.println("Event Name: " + eventName);
        System.out.println("Date: " + date);
        System.out.println("Time: " + time);
        System.out.println("Location: " + location);
        System.out.println("Description: " + description);
        System.out.println("Organizer: " + organizer);
        System.out.println("----------------------------------------");
    }

    public String toFileString() {
        return eventName + "," + date + "," + time + "," + location + "," + description + "," + organizer;
    }

    public static Event fromFileString(String line) {
        String[] parts = line.split(",");
        if (parts.length < 6) {
            throw new IllegalArgumentException("Invalid event data: " + line);
        }
        return new Event(parts[0], parts[1], parts[2], parts[3], parts[4], parts[5]);
    }
}

// Class to store user registration details
class Registration {
    String eventName;
    String userName;
    String phoneNumber;
    String email;
    int age;

    public Registration(String eventName, String userName, String phoneNumber, String email, int age) {
        this.eventName = eventName;
        this.userName = userName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.age = age;
    }

    public void displayRegistration() {
        System.out.println("\n----------------------------------------");
        System.out.println("Event Name: " + eventName);
        System.out.println("User Name: " + userName);
        System.out.println("Phone Number: " + phoneNumber);
        System.out.println("Email: " + email);
        System.out.println("Age: " + age);
        System.out.println("----------------------------------------");
    }

    public String toFileString() {
        return eventName + "," + userName + "," + phoneNumber + "," + email + "," + age;
    }

    public static Registration fromFileString(String line) {
        String[] parts = line.split(",");
        if (parts.length < 5) {
            throw new IllegalArgumentException("Invalid registration data: " + line);
        }
        return new Registration(parts[0], parts[1], parts[2], parts[3], Integer.parseInt(parts[4]));
    }
}

// Admin class
class Admin {
    private ArrayList<Event> eventList = new ArrayList<>();
    private static final String EVENT_FILE = "C:\\Users\\Hp\\javafile\\event.txt";

    public void createEvent(String eventName, String date, String time, String location, String description, String organizer) {
        Event newEvent = new Event(eventName, date, time, location, description, organizer);
        eventList.add(newEvent);
        saveEventsToFile();
        System.out.println("\n----------------------------------------");
        System.out.println("Event Created Successfully!");
        System.out.println("----------------------------------------");
    }

    public boolean updateEvent(int index, String eventName, String date, String time, String location, String description, String organizer) {
        if (index >= 1 && index <= eventList.size()) {
            Event updatedEvent = new Event(eventName, date, time, location, description, organizer);
            eventList.set(index - 1, updatedEvent);
            saveEventsToFile();
            System.out.println("\n----------------------------------------");
            System.out.println("Event Updated Successfully!");
            System.out.println("----------------------------------------");
            return true;
        }
        return false;
    }

    public void deleteEvent(int index) {
        if (index >= 1 && index <= eventList.size()) {
            eventList.remove(index - 1);
            saveEventsToFile();
            System.out.println("\n----------------------------------------");
            System.out.println("Event Deleted Successfully!");
            System.out.println("----------------------------------------");
        } else {
            System.out.println("\n----------------------------------------");
            System.out.println("Invalid Event Index!");
            System.out.println("----------------------------------------");
        }
    }

    public void viewEvents() {
        if (eventList.isEmpty()) {
            System.out.println("\n----------------------------------------");
            System.out.println("No Events Available!");
            System.out.println("----------------------------------------");
        } else {
            System.out.println("\n----------------------------------------");
            System.out.println("Available Events:");
            System.out.println("----------------------------------------");
            for (int i = 0; i < eventList.size(); i++) {
                System.out.println("\nEvent ID: " + (i + 1));
                eventList.get(i).displayEvent();
            }
        }
    }

    public void viewRegistrations(User user) {
        ArrayList<Registration> registrations = user.getRegistrations();
        if (registrations.isEmpty()) {
            System.out.println("\n----------------------------------------");
            System.out.println("No Registrations Available!");
            System.out.println("----------------------------------------");
        } else {
            System.out.println("\n----------------------------------------");
            System.out.println("Registered Users:");
            System.out.println("----------------------------------------");
            for (int i = 0; i < registrations.size(); i++) {
                System.out.println("\nRegistration ID: " + (i + 1));
                registrations.get(i).displayRegistration();
            }
        }
    }

    public ArrayList<Event> getEvents() {
        return eventList;
    }

    public Event getEventByName(String eventName) {
        for (Event event : eventList) {
            if (event.eventName.equalsIgnoreCase(eventName)) {
                return event;
            }
        }
        return null;
    }

    private void saveEventsToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\Hp\\javafile\\event.txt"))) {
            for (Event event : eventList) {
                writer.write(event.toFileString());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("\n----------------------------------------");
            System.out.println("Error saving events to file: " + e.getMessage());
            System.out.println("----------------------------------------");
        }
    }

    public void loadEventsFromFile() {
        eventList.clear();
        File file = new File("C:\\Users\\Hp\\javafile\\event.txt");
        if (!file.exists()) {
            return;
        }
        try (BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\Hp\\javafile\\event.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                try {
                    eventList.add(Event.fromFileString(line));
                } catch (IllegalArgumentException e) {
                    System.out.println("\n----------------------------------------");
                    System.out.println(e.getMessage());
                    System.out.println("----------------------------------------");
                }
            }
        } catch (IOException e) {
            System.out.println("\n----------------------------------------");
            System.out.println("Error loading events from file: " + e.getMessage());
            System.out.println("----------------------------------------");
        }
    }

    public static boolean isValidDate(String date) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate eventDate = LocalDate.parse(date, formatter);
            LocalDate currentDate = LocalDate.now();
            if (eventDate.isBefore(currentDate)) {
                System.out.println("\n----------------------------------------");
                System.out.println("Error: Date cannot be in the past!");
                System.out.println("----------------------------------------");
                return false;
            }
            return true;
        } catch (DateTimeParseException e) {
            System.out.println("\n----------------------------------------");
            System.out.println("Error: Invalid date format! Please use YYYY-MM-DD.");
            System.out.println("----------------------------------------");
            return false;
        }
    }

    public static boolean isValidTime(String time) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
            LocalTime.parse(time, formatter);
            return true;
        } catch (DateTimeParseException e) {
            System.out.println("\n----------------------------------------");
            System.out.println("Error: Invalid time format! Please use HH:MM.");
            System.out.println("----------------------------------------");
            return false;
        }
    }
}

// User class
class User {
    private ArrayList<Registration> registeredEvents = new ArrayList<>();
    private static final String REGISTRATION_FILE = "C:\\Users\\Hp\\javafile\\registrations.txt";

    public void viewEvents(Admin admin) {
        admin.viewEvents();
    }

    public void registerForEvent(Admin admin, String eventName, String userName, String phoneNumber, String email, int age) {
        Event event = admin.getEventByName(eventName);
        if (event != null) {
            if (phoneNumber.length() == 10 && phoneNumber.matches("\\d+")) {
                Registration registration = new Registration(eventName, userName, phoneNumber, email, age);
                registeredEvents.add(registration);
                saveRegistrationsToFile();
                System.out.println("\n----------------------------------------");
                System.out.println("Successfully registered for: " + event.eventName);
                System.out.println("----------------------------------------");
            } else {
                System.out.println("\n----------------------------------------");
                System.out.println("Invalid phone number! It must be exactly 10 digits.");
                System.out.println("----------------------------------------");
            }
        } else {
            System.out.println("\n----------------------------------------");
            System.out.println("Event not found!");
            System.out.println("----------------------------------------");
        }
    }

    public ArrayList<Registration> getRegistrations() {
        return registeredEvents;
    }

    private void saveRegistrationsToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\Hp\\javafile\\registrations.txt"))) {
            for (Registration registration : registeredEvents) {
                writer.write(registration.toFileString());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("\n----------------------------------------");
            System.out.println("Error saving registrations to file: " + e.getMessage());
            System.out.println("----------------------------------------");
        }
    }

    public void loadRegistrationsFromFile() {
        registeredEvents.clear();
        File file = new File("C:\\Users\\Hp\\javafile\\registrations.txt");
        if (!file.exists()) {
            return;
        }
        try (BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\Hp\\javafile\\registrations.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                try {
                    registeredEvents.add(Registration.fromFileString(line));
                } catch (IllegalArgumentException e) {
                    System.out.println("\n----------------------------------------");
                    System.out.println(e.getMessage());
                    System.out.println("----------------------------------------");
                }
            }
        } catch (IOException e) {
            System.out.println("\n----------------------------------------");
            System.out.println("Error loading registrations from file: " + e.getMessage());
            System.out.println("----------------------------------------");
        }
    }
}

// Main class to test functionality
public class EventManagmentsystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Admin admin = new Admin();
        User user = new User();

        admin.loadEventsFromFile();
        user.loadRegistrationsFromFile();

        while (true) {
            System.out.println("\n========================================");
            System.out.println("Event Management System");
            System.out.println("========================================");
            System.out.println("|       1. Admin Menu   | ");
            System.out.println("|       2. User Menu    | ");
            System.out.println("|       3. Exit         | ");
            System.out.println("========================================");
            System.out.print("Enter your choice: ");

            int mainChoice;
            try {
                mainChoice = scanner.nextInt();
                scanner.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("\n----------------------------------------");
                System.out.println("Invalid input! Please enter a number.");
                System.out.println("----------------------------------------");
                scanner.nextLine();
                continue;
            }

            if (mainChoice == 1) {
                System.out.println("\n----------------------------------------");
                System.out.print("Enter Username: ");
                String username = scanner.nextLine();
                System.out.print("Enter Password: ");
                String password = scanner.nextLine();
                System.out.println("----------------------------------------");

                if (username.equals("admin") && password.equals("1234")) {
                    System.out.println("\n----------------------------------------");
                    System.out.println("Login Successful!");
                    System.out.println("----------------------------------------");
                    while (true) {
                        System.out.println("\n========================================");
                        System.out.println("Admin Menu");
                        System.out.println("========================================");
                        System.out.println("|       1. Create Event       |");
                        System.out.println("|       2. Update Event       |");
                        System.out.println("|       3. Delete Event       |");
                        System.out.println("|       4. View Events        |");
                        System.out.println("|       5. View Registrations |");
                        System.out.println("|       6. Log Out            |");
                        System.out.println("========================================");
                        System.out.print("Enter your choice: ");

                        int choice;
                        try {
                            choice = scanner.nextInt();
                            scanner.nextLine();
                        } catch (InputMismatchException e) {
                            System.out.println("\n----------------------------------------");
                            System.out.println("Invalid input! Please enter a number.");
                            System.out.println("----------------------------------------");
                            scanner.nextLine();
                            continue;
                        }

                        if (choice == 6) {
                            System.out.println("Logging out...");
                            break;
                        }

                        switch (choice) {
                            case 1:
                                System.out.println("\n----------------------------------------");
                                System.out.print("Enter Event Name: ");
                                String name = scanner.nextLine();
                                System.out.print("Enter Date (YYYY-MM-DD): ");
                                String date = scanner.nextLine();
                                if (!Admin.isValidDate(date)) {
                                    continue;
                                }
                                System.out.print("Enter Time (HH:MM): ");
                                String time = scanner.nextLine();
                                if (!Admin.isValidTime(time)) {
                                    continue;
                                }
                                System.out.print("Enter Location: ");
                                String location = scanner.nextLine();
                                System.out.print("Enter Description: ");
                                String description = scanner.nextLine();
                                System.out.print("Enter Organizer: ");
                                String organizer = scanner.nextLine();
                                admin.createEvent(name, date, time, location, description, organizer);
                                break;
                            case 2:
                                System.out.println("\n----------------------------------------");
                                // Removed admin.viewEvents() from here
                                int updateIndex;
                                while (true) {
                                    System.out.print("Enter Event Index to Update (or 0 to cancel): ");
                                    try {
                                        updateIndex = scanner.nextInt();
                                        scanner.nextLine();
                                        if (updateIndex == 0) {
                                            System.out.println("\n----------------------------------------");
                                            System.out.println("Update cancelled.");
                                            System.out.println("----------------------------------------");
                                            break;
                                        }
                                        if (updateIndex >= 1 && updateIndex <= admin.getEvents().size()) {
                                            System.out.print("Enter New Event Name: ");
                                            String newName = scanner.nextLine();
                                            System.out.print("Enter New Date (YYYY-MM-DD): ");
                                            String newDate = scanner.nextLine();
                                            if (!Admin.isValidDate(newDate)) {
                                                continue;
                                            }
                                            System.out.print("Enter New Time (HH:MM): ");
                                            String newTime = scanner.nextLine();
                                            if (!Admin.isValidTime(newTime)) {
                                                continue;
                                            }
                                            System.out.print("Enter New Location: ");
                                            String newLocation = scanner.nextLine();
                                            System.out.print("Enter New Description: ");
                                            String newDescription = scanner.nextLine();
                                            System.out.print("Enter New Organizer: ");
                                            String newOrganizer = scanner.nextLine();
                                            admin.updateEvent(updateIndex, newName, newDate, newTime, newLocation, newDescription, newOrganizer);
                                            break;
                                        } else {
                                            System.out.println("\n----------------------------------------");
                                            System.out.println("Invalid Event Index! Please enter a valid index between 1 and " + admin.getEvents().size());
                                            System.out.println("----------------------------------------");
                                        }
                                    } catch (InputMismatchException e) {
                                        System.out.println("\n----------------------------------------");
                                        System.out.println("Invalid input! Please enter a number.");
                                        System.out.println("----------------------------------------");
                                        scanner.nextLine();
                                    }
                                }
                                break;
                            case 3:
                                System.out.println("\n----------------------------------------");
                                System.out.print("Enter Event Index to Delete: ");
                                int deleteIndex;
                                try {
                                    deleteIndex = scanner.nextInt();
                                } catch (InputMismatchException e) {
                                    System.out.println("\n----------------------------------------");
                                    System.out.println("Invalid input! Please enter a number.");
                                    System.out.println("----------------------------------------");
                                    scanner.nextLine();
                                    continue;
                                }
                                admin.deleteEvent(deleteIndex);
                                break;
                            case 4:
                                admin.viewEvents();
                                break;
                            case 5:
                                admin.viewRegistrations(user);
                                break;
                            default:
                                System.out.println("\n----------------------------------------");
                                System.out.println("Invalid Choice! Please try again.");
                                System.out.println("----------------------------------------");
                        }
                    }
                } else {
                    System.out.println("Invalid inputs!");
                }
            } else if (mainChoice == 2) {
                while (true) {
                    System.out.println("\n========================================");
                    System.out.println("User Menu");
                    System.out.println("========================================");
                    System.out.println("|      1. View Events         |");
                    System.out.println("|      2. Register for Event  |");
                    System.out.println("|      3. Exit             |");
                    System.out.println("========================================");
                    System.out.print("Enter your choice: ");

                    int userChoice;
                    try {
                        userChoice = scanner.nextInt();
                        scanner.nextLine();
                    } catch (InputMismatchException e) {
                        System.out.println("\n----------------------------------------");
                        System.out.println("Invalid input! Please enter a number.");
                        System.out.println("----------------------------------------");
                        scanner.nextLine();
                        continue;
                    }

                    if (userChoice == 3) {
                        System.out.println("\n----------------------------------------");
                        System.out.println("Logging out...");
                        System.out.println("----------------------------------------");
                        break;
                    }

                    switch (userChoice) {
                        case 1:
                            user.viewEvents(admin);
                            break;
                        case 2:
                            System.out.println("\n----------------------------------------");
                            System.out.print("Enter Event Name: ");
                            String eventName = scanner.nextLine();
                            System.out.print("Enter Your Name: ");
                            String userName = scanner.nextLine();
                            System.out.print("Enter Your Phone Number (10 digits): ");
                            String phoneNumber = scanner.nextLine();
                            if (!phoneNumber.matches("\\d{10}")) {
                                System.out.println("\n----------------------------------------");
                                System.out.println("Invalid phone number! It must be exactly 10 digits.");
                                System.out.println("----------------------------------------");
                                continue;
                            }
                            System.out.print("Enter Your Email: ");
                            String email = scanner.nextLine();
                            System.out.print("Enter Your Age: ");
                            int age;
                            try {
                                age = scanner.nextInt();
                                scanner.nextLine();
                            } catch (InputMismatchException e) {
                                System.out.println("\n----------------------------------------");
                                System.out.println("Invalid age input! Please enter a number.");
                                System.out.println("----------------------------------------");
                                scanner.nextLine();
                                continue;
                            }
                            user.registerForEvent(admin, eventName, userName, phoneNumber, email, age);
                            break;
                        default:
                            System.out.println("\n----------------------------------------");
                            System.out.println("Invalid Choice! Please try again.");
                            System.out.println("----------------------------------------");
                    }
                }
            } else if (mainChoice == 3) {
                System.out.println("\n----------------------------------------");
                System.out.println("Exiting the system. Thank you!");
                System.out.println("----------------------------------------");
                break;
            } else {
                System.out.println("\n----------------------------------------");
                System.out.println("Invalid Choice! Please try again.");
                System.out.println("----------------------------------------");
            }
        }

        scanner.close();
    }
}