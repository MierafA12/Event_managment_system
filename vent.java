import java.util.*;

class Admin {
    String username;
    int password;
    ArrayList<EventDetails> events = new ArrayList<>();

    // Constructor for Admin class
    Admin(String username, int password) {
        this.username = username;
        this.password = password;
    }

    // Method to create events
    void create_events() {
        Scanner event_info = new Scanner(System.in);
        System.out.println("Enter event name:");
        String eventname = event_info.nextLine();
        System.out.println("Enter event date:");
        String eventdate = event_info.nextLine();
        System.out.println("Enter event time:");
        String eventtime = event_info.nextLine();
        System.out.println("Enter event location:");
        String eventlocation = event_info.nextLine();
        EventDetails event = new EventDetails(eventname, eventdate, eventtime, eventlocation);
        events.add(event);
        System.out.println("Event created successfully.");
    }

    // Method to update events (placeholder)
    void update_events() {
        Scanner update_info = new Scanner(System.in);
        System.out.println("Enter the event name to update:");
        String eventname = update_info.nextLine();
    }

    // Method to delete events
    void delete_events() {
        Scanner choose = new Scanner(System.in);
        System.out.println("Enter event name you want to delete:");
        String eventname = choose.nextLine();
        for (EventDetails event : events) {
            if (event.name.equals(eventname)) {
                events.remove(event);
                System.out.println("Event deleted successfully.");
                return;
            }
        }
        System.out.println("Event not found.");
    }

    // Method to display event registration (placeholder)
    void display_event_registration() {}

    // Method to delete user registration (placeholder)
    void delete_user_registration() {}

    // Method to handle Admin login
    void AdminLogin() {
        Scanner choose = new Scanner(System.in);
        System.out.println("Enter username:");
        String username = choose.nextLine();
        System.out.println("Enter password:");
        int password = choose.nextInt();
        if (password == 1234) {
            System.out.println("Welcome Admin " + username);
            AdminMenu();
        } else {
            System.out.println("Incorrect password, please enter a valid password.");
        }
    }

    // Admin menu with options
    void AdminMenu() {
        Scanner choose = new Scanner(System.in);
        while (true) {
            System.out.println("Admin Menu:");
            System.out.println("1. Create event");
            System.out.println("2. Update event");
            System.out.println("3. Delete event");
            System.out.println("4. Display event and registration");
            System.out.println("5. Delete user registration");
            System.out.println("6. Logout");
            System.out.println("Enter your choice:");
            int choice1 = choose.nextInt();
            switch (choice1) {
                case 1:
                    create_events();
                    break;
                case 2:
                    update_events();
                    break;
                case 3:
                    delete_events();
                    break;
                case 4:
                    display_event_registration();
                    break;
                case 5:
                    delete_user_registration();
                    break;
                case 6:
                    System.out.println("Logging out...");
                    return;  // Logout and return to main menu
                default:
                    System.out.println("Invalid choice, please enter a valid option.");
            }
        }
    }
}

class User {
    String username;
    int password;
    ArrayList<EventDetails> events = new ArrayList<>();

    // Constructor for User class
    User(String username, int password) {
        this.username = username;
        this.password = password;
    }

    // Method to display events (placeholder)
    void display_events() {}

    // Method to register for an event (placeholder)
    void register_event() {}

    // Method to search events (placeholder)
    void search_events() {}

    // User menu with options
    void UserMenu() {
        Scanner choose = new Scanner(System.in);
        while (true) {
            System.out.println("User Menu:");
            System.out.println("1. Display events");
            System.out.println("2. Register for event");
            System.out.println("3. Search events");
            System.out.println("4. Logout");
            System.out.println("Enter your choice:");
            int choice = choose.nextInt();
            switch (choice) {
                case 1:
                    display_events();
                    break;
                case 2:
                    register_event();
                    break;
                case 3:
                    search_events();
                    break;
                case 4:
                    System.out.println("Logging out...");
                    return;  // Logout and return to main menu
                default:
                    System.out.println("Invalid choice, please enter a valid option.");
            }
        }
    }
}

class EventDetails {
    String name;
    String date;
    String time;
    String location;

    // Constructor for EventDetails class
    EventDetails(String name, String date, String time, String location) {
        this.name = name;
        this.date = date;
        this.time = time;
        this.location = location;
    }

    // Method to display event details
    public String toString() {
        return "Event Name: " + name + ", Date: " + date + ", Time: " + time + ", Location: " + location;
    }
}

public class vent {
    public static void main(String[] args) {
        Scanner menu = new Scanner(System.in);
        while (true) {  // Infinite loop for returning to the main menu after logout
            System.out.println("Event Management System");
            System.out.println("Menu:");
            System.out.println("1. Admin");
            System.out.println("2. User");
            System.out.println("3. Exit");
            System.out.println("Enter your choice:");
            int choice = menu.nextInt();

            if (choice == 1) {
                Admin admin = new Admin("admin", 1234);
                admin.AdminLogin();  // Admin login will call AdminMenu
            } else if (choice == 2) {
                User user = new User("user", 1234);
                user.UserMenu();  // User menu will be called
            } else if (choice == 3) {
                System.out.println("Exiting system...");
                break;  // Exit the program
            } else {
                System.out.println("Invalid choice, please enter a valid choice.");
            }
        }
    }
}
