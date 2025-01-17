
import java.util.*;
class Admin{
    String username;
    int password;
    ArrayList<EventDetails> events = new ArrayList<>();
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
    }

    void create_events(){
        Scanner event_info = new Scanner(System.in) ; 
        System.out.println("Enter event name");
        String eventname = event_info.nextLine();
        System.out.println("Enter event date");
        String eventdate = event_info.nextLine();
        System.out.println("Enter event time");
        String eventtime = event_info.nextLine();
        System.out.println("Enter event location");
        String eventlocation = event_info.nextLine();
        EventDetails event = new EventDetails(eventname, eventdate, eventtime, eventlocation);
        events.add(event);
        System.out.println("Event created successfully.");
        
    };

void update_events(){
    Scanner update_info = new Scanner(System.in) ; 
    System.out.println("Enter the event name to update");
    String eventname = update_info.nextLine();
 
}

void delete_events(){
    Scanner choose = new Scanner(System.in);
    System.out.println("enter username");
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

void display_event_registration(){
}
void delete_user_registration(){

}

   void AdminLogin (){
        Scanner choose = new Scanner(System.in);
        System.out.println("enter username");
        String username = choose.nextLine();
        System.out.println("enter password");
        int password = choose.nextInt();
        if (password==0){
            System.out.println("password is required, please enter a valid password");
        }
         else if(password==1234){
            System.out.println("Welcome Admin"+" "+username);
            AdminMenu();
            }
            else{
                System.out.println("Incorrect password, please enter a valid password");
            }
            }

void AdminMenu() {
    Scanner choose = new Scanner(System.in);
    while (true){
    System.out.println("Admin Menu");
    System.out.println("1.Create event");
    System.out.println("2.Update event");
    System.out.println("3.Delete event");
    System.out.println("4.Display event and registration");
    System.out.println("5.delete user registration");
    System.out.println("6.logout");
    System.out.println("Enter your choice from the menu");
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
      
    
        }
   } 
}   
}
    


class User extends Admin{
    User(){

    }
    void UserMenu() {
        Scanner choose = new Scanner(System.in);
        System.out.println("User Menu");
        System.out.println("1.Display events");
        System.out.println("2.Register for event");
        System.out.println("3.search events");
        System.out.println("Enter your choice from the menu");
        int choice = choose.nextInt();
    }
}
public class Event {
    public static void main(String[] args) {
        Scanner menu = new Scanner(System.in);
        System.out.println("Event Management System");
        System.out.println("Menu:");
        System.out.println("1. Admin");
        System.out.println("2. User");
        System.out.println("Enter your choice:");
        int choice = menu.nextInt();

        if (choice == 1) {
            Admin admin = new Admin();
            admin.AdminLogin();
        } else if (choice == 2) {
            User user = new User();
            user.UserMenu();
        } else {
            System.out.println("Invalid choice, please enter a valid choice.");
        }
    }
}
