import java.util.*;
class Admin {
    String username;
    int password;
    static ArrayList<EventDetails> events = new ArrayList<>();

    class EventDetails {
        String name;
        String date;
        String time;
        String location;

        EventDetails(String name, String date, String time, String location) {
            this.name = name;
            this.date = date;
            this.time = time;
            this.location = location;
        }

        @Override
        public String toString() {
            return "Event Name: " + name + ", Date: " + date + ", Time: " + time + ", Location: " + location;
        }
    }

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

    void update_events() {
        Scanner update_info = new Scanner(System.in);
        System.out.println("Enter the event name to update:");
        String eventname = update_info.nextLine();
        for (EventDetails event : events) {
            if (event.name.equals(eventname)) {
                System.out.println("Enter new event name:");
                event.name = update_info.nextLine();
                System.out.println("Enter new event date:");
                event.date = update_info.nextLine();
                System.out.println("Enter new event time:");
                event.time = update_info.nextLine();
                System.out.println("Enter new event location:");
                event.location = update_info.nextLine();
                System.out.println("Event updated successfully.");
                return;
            }
        }
        System.out.println("No event found with the given name. Please enter a valid event name.");
    }

    void delete_events() {
        Scanner choose = new Scanner(System.in);
        System.out.println("Enter the event name you want to delete:");
        String eventname = choose.nextLine();
        Iterator<EventDetails> iterator = events.iterator();
        while (iterator.hasNext()) {
            EventDetails event = iterator.next();
            if (event.name.equals(eventname)) {
                iterator.remove();
                System.out.println("Event deleted successfully.");
                return;
            }
        }
        System.out.println("Event not found.");
    }

    void display_event_registration() {
        if (events.isEmpty()) {
            System.out.println("No events available.");
        } else {
            System.out.println("Available Events:");
            for (EventDetails event : events) {
                System.out.println(event);
            }
        }
    }

    void delete_user_registration() {
        System.out.println("Feature not implemented yet.");
    }

    void AdminLogin() {
        Scanner choose = new Scanner(System.in);
        System.out.println("Enter username:");
        String username = choose.nextLine();
        System.out.println("Enter password:");
        int password = choose.nextInt();
        if (password == 0) {
            System.out.println("Password is required. Please enter a valid password.");
        } else if (password == 1234) {
            System.out.println("Welcome Admin " + username);
            AdminMenu();
        } else {
            System.out.println("Incorrect password. Please enter a valid password.");
        }
    }

    void AdminMenu() {
        Scanner choose = new Scanner(System.in);
        while (true) {
            System.out.println("Admin Menu");
            System.out.println("1. Create event");
            System.out.println("2. Update event");
            System.out.println("3. Delete event");
            System.out.println("4. Display events and registrations");
            System.out.println("5. Delete user registration");
            System.out.println("6. Logout");
            System.out.println("Enter your choice from the menu:");
            int choice1 = choose.nextInt();
            choose.nextLine(); // Consume newline
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
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}

class User extends Admin {
    User() {
    }

    void display_events() {
        if (events.isEmpty()) {
            System.out.println("No events available.");
        } else {
            System.out.println("Available Events:");
            for (EventDetails event : events) {
                System.out.println(event);
            }
        }
    }

    void register_event() {
        Scanner choose = new Scanner(System.in);
        System.out.println("Enter the event name to register:");
        String eventname = choose.nextLine();
        for (EventDetails event : events) {
            if (event.name.equals(eventname)) {
                System.out.println("Registration successful for event: " + eventname);
                return;
            }
        }
        System.out.println("Event not found. Please enter a valid event name.");
    }

    void search_events() {
        Scanner choose = new Scanner(System.in);
        System.out.println("Enter the event name to search:");
        String eventname = choose.nextLine();
        for (EventDetails event : events) {
            if (event.name.contains(eventname)) {
                System.out.println(event);
                return;
            }
        }
        System.out.println("No events found matching the given name.");
    }

    void UserMenu() {
        Scanner choose = new Scanner(System.in);
        while (true) {
            System.out.println("User Menu");
            System.out.println("1. Display events");
            System.out.println("2. Register for event");
            System.out.println("3. Search events");
            System.out.println("4. Exit");
            System.out.println("Enter your choice from the menu:");
            int choice = choose.nextInt();
            choose.nextLine(); // Consume newline
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
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}

public class Event {
    public static void main(String[] args) {
        while (true) {
            Scanner menu = new Scanner(System.in);
            System.out.println("Event Management System");
            System.out.println("Menu:");
            System.out.println("1. Admin");
            System.out.println("2. User");
            System.out.println("3. Exit");
            System.out.println("Enter your choice:");
            int choice = menu.nextInt();
            menu.nextLine(); // Consume newline

            if (choice == 1) {
                Admin admin = new Admin();
                admin.AdminLogin();
            } else if (choice == 2) {
                User user = new User();
                user.UserMenu();
            } else if (choice == 3) {
                System.out.println("Exiting the program...");
                System.exit(0);
            } else {
                System.out.println("Invalid choice, please enter a valid choice.");
            }
        }
    }
}
