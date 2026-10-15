package eventflow;

import java.time.LocalDate;
import java.util.Scanner;

import eventflow.data.DataStore;
import eventflow.model.Activity;
import eventflow.model.ActivityConflict;
import eventflow.model.Event;
import eventflow.model.Participant;
import eventflow.model.Registration;
import eventflow.model.Staff;
import eventflow.model.User;
import eventflow.model.Venue;

public class Main {

    static Scanner sc = new Scanner(System.in);


    // =========================================================
    // MAIN
    // =========================================================

    public static void main(String[] args) {

        DataStore.loadSampleData();

        System.out.println("==============================================");
        System.out.println("        EVENTFLOW EVENT MANAGEMENT");
        System.out.println("==============================================");

        while (true) {

            System.out.println("\n========== MAIN MENU ==========");

            System.out.println("1. Admin Login");
            System.out.println("2. User Login");
            System.out.println("3. Exit");

            System.out.print("Enter choice: ");

            int choice = readInt();

            switch (choice) {

                case 1:
                    adminLogin();
                    break;

                case 2:
                    userLogin();
                    break;

                case 3:
                    System.out.println(
                            "\nThank you for using EventFlow."
                    );
                    return;

                default:
                    System.out.println(
                            "Invalid choice."
                    );
            }
        }
    }


    // =========================================================
    // ADMIN LOGIN
    // =========================================================

    static void adminLogin() {

        System.out.println(
                "\n========== ADMIN LOGIN =========="
        );

        System.out.print("Username: ");
        String username = sc.nextLine();

        System.out.print("Password: ");
        String password = sc.nextLine();

        if (username.equals("admin")
                && password.equals("admin123")) {

            System.out.println(
                    "\nAdmin login successful."
            );

            adminMenu();

        } else {

            System.out.println(
                    "Invalid admin credentials."
            );
        }
    }


    // =========================================================
    // USER LOGIN
    // =========================================================

    static void userLogin() {

        System.out.println(
                "\n========== USER LOGIN =========="
        );

        System.out.print("Username: ");
        String username = sc.nextLine();

        System.out.print("Password: ");
        String password = sc.nextLine();

        User loggedUser = null;

        for (User user : DataStore.users) {

            if (user.getUsername().equals(username)
                    && user.getPassword().equals(password)) {

                loggedUser = user;
                break;
            }
        }

        if (loggedUser != null) {

            System.out.println(
                    "\nLogin successful."
            );

            System.out.println(
                    "Welcome, "
                            + loggedUser.getName()
                            + "!"
            );

            userMenu(loggedUser);

        } else {

            System.out.println(
                    "Invalid username or password."
            );
        }
    }


    // =========================================================
    // ADMIN MENU
    // =========================================================

    static void adminMenu() {

        while (true) {

            System.out.println(
                    "\n=============================================="
            );

            System.out.println(
                    "              ADMIN DASHBOARD"
            );

            System.out.println(
                    "=============================================="
            );

            System.out.println("1. Event Management");
            System.out.println("2. Venue Management");
            System.out.println("3. Activity Management");
            System.out.println("4. Staff Management");
            System.out.println("5. Participant Management");
            System.out.println("6. Registration Management");
            System.out.println("7. Search & Indexing");
            System.out.println("8. Schedule & Constraints");
            System.out.println("9. Resource Allocation");
            System.out.println("10. Event Analytics");
            System.out.println("11. Performance Analysis");
            System.out.println("12. Logout");

            System.out.print("Enter choice: ");

            int choice = readInt();

            switch (choice) {

                case 1:
                    eventManagement();
                    break;

                case 2:
                    venueManagement();
                    break;

                case 3:
                    activityManagement();
                    break;

                case 4:
                    staffManagement();
                    break;

                case 5:
                    participantManagement();
                    break;

                case 6:
                    registrationManagement();
                    break;

                case 7:
                    System.out.println(
                            "\nSearch & Indexing algorithms will be implemented next."
                    );
                    break;

                case 8:
                    System.out.println(
                            "\nSchedule & Constraints will be implemented next."
                    );
                    break;

                case 9:
                    System.out.println(
                            "\nResource Allocation will be implemented next."
                    );
                    break;

                case 10:
                    System.out.println(
                            "\nEvent Analytics will be implemented next."
                    );
                    break;

                case 11:
                    System.out.println(
                            "\nPerformance Analysis will be implemented next."
                    );
                    break;

                case 12:
                    System.out.println(
                            "Admin logged out."
                    );
                    return;

                default:
                    System.out.println(
                            "Invalid choice."
                    );
            }
        }
    }


    // =========================================================
    // USER MENU
    // =========================================================

    static void userMenu(User loggedUser) {

        while (true) {

            System.out.println(
                    "\n=============================================="
            );

            System.out.println(
                    "               USER DASHBOARD"
            );

            System.out.println(
                    "=============================================="
            );

            System.out.println("1. View Events");
            System.out.println("2. Search Events");
            System.out.println("3. View Event Details");
            System.out.println("4. Register for Event");
            System.out.println("5. Cancel Registration");
            System.out.println("6. My Registrations");
            System.out.println("7. Search Activities");
            System.out.println("8. Event Suggestions");
            System.out.println("9. Venue Information");
            System.out.println("10. Logout");

            System.out.print("Enter choice: ");

            int choice = readInt();

            switch (choice) {

                case 1:
                    viewEvents();
                    break;

                case 2:
                    searchEvents();
                    break;

                case 3:
                    viewEventDetails();
                    break;

                case 4:
                    registerForEvent(loggedUser);
                    break;

                case 5:
                    cancelRegistration(loggedUser);
                    break;

                case 6:
                    viewMyRegistrations(loggedUser);
                    break;

                case 7:
                    searchActivities();
                    break;

                case 8:
                    System.out.println(
                            "\nEvent suggestion algorithms will be implemented next."
                    );
                    break;

                case 9:
                    viewVenues();
                    break;

                case 10:
                    System.out.println(
                            "User logged out."
                    );
                    return;

                default:
                    System.out.println(
                            "Invalid choice."
                    );
            }
        }
    }


    // =========================================================
    // EVENT MANAGEMENT
    // =========================================================

    static void eventManagement() {

        while (true) {

            System.out.println(
                    "\n========== EVENT MANAGEMENT =========="
            );

            System.out.println("1. Add Event");
            System.out.println("2. View Events");
            System.out.println("3. Search Event");
            System.out.println("4. View Event Details");
            System.out.println("5. Update Event");
            System.out.println("6. Delete Event");
            System.out.println("7. Sort Events");
            System.out.println("8. Find Event by ID");
            System.out.println("9. Back");

            System.out.print("Enter choice: ");

            int choice = readInt();

            switch (choice) {

                case 1:
                    addEvent();
                    break;

                case 2:
                    viewEvents();
                    break;

                case 3:
                    searchEvents();
                    break;

                case 4:
                    viewEventDetails();
                    break;

                case 5:
                    updateEvent();
                    break;

                case 6:
                    deleteEvent();
                    break;

                case 7:
                    sortEvents();
                    break;

                case 8:
                    findEvent();
                    break;

                case 9:
                    return;

                default:
                    System.out.println(
                            "Invalid choice."
                    );
            }
        }
    }


    // =========================================================
    // ADD EVENT
    // =========================================================

    static void addEvent() {

        System.out.println(
                "\n========== ADD EVENT =========="
        );

        System.out.print("Event ID: ");
        int id = readInt();

        if (findEventById(id) != null) {

            System.out.println(
                    "Event ID already exists."
            );

            return;
        }

        System.out.print("Event Name: ");
        String name = sc.nextLine();

        System.out.print("Description: ");
        String description = sc.nextLine();

        System.out.print("Category: ");
        String category = sc.nextLine();

        System.out.print("Date: ");
        String date = sc.nextLine();

        System.out.print("Time: ");
        String time = sc.nextLine();

        System.out.print("Venue ID: ");
        int venueId = readInt();

        if (findVenueById(venueId) == null) {

            System.out.println(
                    "Venue does not exist."
            );

            return;
        }

        System.out.print("Capacity: ");
        int capacity = readInt();

        if (capacity <= 0) {

            System.out.println(
                    "Capacity must be positive."
            );

            return;
        }

        Event event = new Event(
                id,
                name,
                description,
                category,
                date,
                time,
                venueId,
                capacity
        );

        DataStore.events.add(event);

        System.out.println(
                "Event added successfully."
        );
    }


    // =========================================================
    // VIEW EVENTS
    // =========================================================

    static void viewEvents() {

        System.out.println(
                "\n================ EVENTS ================"
        );

        if (DataStore.events.isEmpty()) {

            System.out.println(
                    "No events available."
            );

            return;
        }

        System.out.printf(
                "%-5s %-20s %-15s %-12s %-10s %-10s%n",
                "ID",
                "EVENT",
                "CATEGORY",
                "DATE",
                "CAPACITY",
                "REGISTERED"
        );

        System.out.println(
                "--------------------------------------------------------------------------"
        );

        for (Event event : DataStore.events) {

            System.out.println(event);
        }
    }


    // =========================================================
    // SEARCH EVENTS
    // =========================================================

    static void searchEvents() {

        System.out.println(
                "\n========== SEARCH EVENT =========="
        );

        System.out.print(
                "Enter event name or category: "
        );

        String keyword =
                sc.nextLine().toLowerCase();

        boolean found = false;

        for (Event event : DataStore.events) {

            if (event.getEventName()
                    .toLowerCase()
                    .contains(keyword)
                    ||
                    event.getCategory()
                            .toLowerCase()
                            .contains(keyword)) {

                if (!found) {

                    System.out.printf(
                            "%-5s %-20s %-15s %-12s %-10s %-10s%n",
                            "ID",
                            "EVENT",
                            "CATEGORY",
                            "DATE",
                            "CAPACITY",
                            "REGISTERED"
                    );

                    found = true;
                }

                System.out.println(event);
            }
        }

        if (!found) {

            System.out.println(
                    "No matching event found."
            );
        }
    }


    // =========================================================
    // VIEW EVENT DETAILS
    // =========================================================

    static void viewEventDetails() {

        System.out.print(
                "\nEnter Event ID: "
        );

        int id = readInt();

        Event event = findEventById(id);

        if (event == null) {

            System.out.println(
                    "Event not found."
            );

            return;
        }

        System.out.println(
                "\n========== EVENT DETAILS =========="
        );

        System.out.println(
                "Event ID       : "
                        + event.getEventId()
        );

        System.out.println(
                "Event Name     : "
                        + event.getEventName()
        );

        System.out.println(
                "Description    : "
                        + event.getDescription()
        );

        System.out.println(
                "Category       : "
                        + event.getCategory()
        );

        System.out.println(
                "Date           : "
                        + event.getDate()
        );

        System.out.println(
                "Time           : "
                        + event.getTime()
        );

        System.out.println(
                "Venue ID       : "
                        + event.getVenueId()
        );

        System.out.println(
                "Capacity       : "
                        + event.getCapacity()
        );

        System.out.println(
                "Registered     : "
                        + event.getRegisteredCount()
        );

        System.out.println(
                "Available Seats: "
                        + (
                        event.getCapacity()
                                - event.getRegisteredCount()
                        )
        );
    }


    // =========================================================
    // UPDATE EVENT
    // =========================================================

    static void updateEvent() {

        System.out.print(
                "\nEnter Event ID: "
        );

        int id = readInt();

        Event event = findEventById(id);

        if (event == null) {

            System.out.println(
                    "Event not found."
            );

            return;
        }

        System.out.print(
                "New Event Name: "
        );

        event.setEventName(
                sc.nextLine()
        );

        System.out.print(
                "New Description: "
        );

        event.setDescription(
                sc.nextLine()
        );

        System.out.print(
                "New Category: "
        );

        event.setCategory(
                sc.nextLine()
        );

        System.out.print(
                "New Date: "
        );

        event.setDate(
                sc.nextLine()
        );

        System.out.print(
                "New Time: "
        );

        event.setTime(
                sc.nextLine()
        );

        System.out.print(
                "New Venue ID: "
        );

        int venueId = readInt();

        if (findVenueById(venueId) == null) {

            System.out.println(
                    "Venue does not exist."
            );

            return;
        }

        event.setVenueId(venueId);

        System.out.print(
                "New Capacity: "
        );

        int capacity = readInt();

        if (capacity <
                event.getRegisteredCount()) {

            System.out.println(
                    "Capacity cannot be less than registered participants."
            );

            return;
        }

        event.setCapacity(capacity);

        System.out.println(
                "Event updated successfully."
        );
    }


    // =========================================================
    // DELETE EVENT
    // =========================================================

    static void deleteEvent() {

        System.out.print(
                "\nEnter Event ID: "
        );

        int id = readInt();

        Event event = findEventById(id);

        if (event == null) {

            System.out.println(
                    "Event not found."
            );

            return;
        }

        DataStore.events.remove(event);

        System.out.println(
                "Event deleted successfully."
        );
    }


    // =========================================================
    // SORT EVENTS
    // =========================================================

    static void sortEvents() {

        DataStore.events.sort(
                (e1, e2) ->
                        e1.getEventName()
                                .compareToIgnoreCase(
                                        e2.getEventName()
                                )
        );

        System.out.println(
                "Events sorted by name."
        );

        viewEvents();
    }


    // =========================================================
    // FIND EVENT
    // =========================================================

    static void findEvent() {

        System.out.print(
                "\nEnter Event ID: "
        );

        int id = readInt();

        Event event =
                findEventById(id);

        if (event == null) {

            System.out.println(
                    "Event not found."
            );

        } else {

            System.out.println(
                    "Event found:"
            );

            System.out.println(event);
        }
    }


    // =========================================================
    // VENUE MANAGEMENT
    // =========================================================

    static void venueManagement() {

        while (true) {

            System.out.println(
                    "\n========== VENUE MANAGEMENT =========="
            );

            System.out.println("1. Add Venue");
            System.out.println("2. View Venues");
            System.out.println("3. Search Venue");
            System.out.println("4. Update Venue");
            System.out.println("5. Delete Venue");
            System.out.println("6. Find Venue by ID");
            System.out.println("7. Back");

            System.out.print(
                    "Enter choice: "
            );

            int choice = readInt();

            switch (choice) {

                case 1:
                    addVenue();
                    break;

                case 2:
                    viewVenues();
                    break;

                case 3:
                    searchVenue();
                    break;

                case 4:
                    updateVenue();
                    break;

                case 5:
                    deleteVenue();
                    break;

                case 6:
                    findVenue();
                    break;

                case 7:
                    return;

                default:
                    System.out.println(
                            "Invalid choice."
                    );
            }
        }
    }


    // =========================================================
    // ADD VENUE
    // =========================================================

    static void addVenue() {

        System.out.println(
                "\n========== ADD VENUE =========="
        );

        System.out.print("Venue ID: ");
        int id = readInt();

        if (findVenueById(id) != null) {

            System.out.println(
                    "Venue ID already exists."
            );

            return;
        }

        System.out.print("Venue Name: ");
        String name = sc.nextLine();

        System.out.print("Capacity: ");
        int capacity = readInt();

        System.out.print("Facilities: ");
        String facilities = sc.nextLine();

        DataStore.venues.add(
                new Venue(
                        id,
                        name,
                        capacity,
                        facilities
                )
        );

        System.out.println(
                "Venue added successfully."
        );
    }


    // =========================================================
    // VIEW VENUES
    // =========================================================

    static void viewVenues() {

        System.out.println(
                "\n================ VENUES ================"
        );

        if (DataStore.venues.isEmpty()) {

            System.out.println(
                    "No venues available."
            );

            return;
        }

        System.out.printf(
                "%-5s %-22s %-10s %-35s%n",
                "ID",
                "VENUE",
                "CAPACITY",
                "FACILITIES"
        );

        System.out.println(
                "--------------------------------------------------------------------------"
        );

        for (Venue venue :
                DataStore.venues) {

            System.out.println(venue);
        }
    }


    // =========================================================
    // SEARCH VENUE
    // =========================================================

    static void searchVenue() {

        System.out.print(
                "\nEnter venue name: "
        );

        String keyword =
                sc.nextLine().toLowerCase();

        boolean found = false;

        for (Venue venue :
                DataStore.venues) {

            if (venue.getVenueName()
                    .toLowerCase()
                    .contains(keyword)) {

                System.out.println(venue);

                found = true;
            }
        }

        if (!found) {

            System.out.println(
                    "Venue not found."
            );
        }
    }


    // =========================================================
    // UPDATE VENUE
    // =========================================================

    static void updateVenue() {

        System.out.print(
                "\nEnter Venue ID: "
        );

        int id = readInt();

        Venue venue =
                findVenueById(id);

        if (venue == null) {

            System.out.println(
                    "Venue not found."
            );

            return;
        }

        System.out.print(
                "New Venue Name: "
        );

        venue.setVenueName(
                sc.nextLine()
        );

        System.out.print(
                "New Capacity: "
        );

        venue.setCapacity(
                readInt()
        );

        System.out.print(
                "New Facilities: "
        );

        venue.setFacilities(
                sc.nextLine()
        );

        System.out.println(
                "Venue updated successfully."
        );
    }


    // =========================================================
    // DELETE VENUE
    // =========================================================

    static void deleteVenue() {

        System.out.print(
                "\nEnter Venue ID: "
        );

        int id = readInt();

        Venue venue =
                findVenueById(id);

        if (venue == null) {

            System.out.println(
                    "Venue not found."
            );

            return;
        }

        DataStore.venues.remove(venue);

        System.out.println(
                "Venue deleted successfully."
        );
    }


    // =========================================================
    // FIND VENUE
    // =========================================================

    static void findVenue() {

        System.out.print(
                "\nEnter Venue ID: "
        );

        int id = readInt();

        Venue venue =
                findVenueById(id);

        if (venue == null) {

            System.out.println(
                    "Venue not found."
            );

        } else {

            System.out.println(
                    "Venue found:"
            );

            System.out.println(venue);
        }
    }


    // =========================================================
    // ACTIVITY MANAGEMENT
    // =========================================================

    static void activityManagement() {

        while (true) {

            System.out.println(
                    "\n========== ACTIVITY MANAGEMENT =========="
            );

            System.out.println("1. Add Activity");
            System.out.println("2. View Activities");
            System.out.println("3. Search Activity");
            System.out.println("4. Update Activity");
            System.out.println("5. Delete Activity");
            System.out.println("6. View Activity Conflicts");
            System.out.println("7. Find Activity by ID");
            System.out.println("8. Back");

            System.out.print(
                    "Enter choice: "
            );

            int choice = readInt();

            switch (choice) {

                case 1:
                    addActivity();
                    break;

                case 2:
                    viewActivities();
                    break;

                case 3:
                    searchActivities();
                    break;

                case 4:
                    updateActivity();
                    break;

                case 5:
                    deleteActivity();
                    break;

                case 6:
                    viewActivityConflicts();
                    break;

                case 7:
                    findActivity();
                    break;

                case 8:
                    return;

                default:
                    System.out.println(
                            "Invalid choice."
                    );
            }
        }
    }


    // =========================================================
    // ADD ACTIVITY
    // =========================================================

    static void addActivity() {

        System.out.println(
                "\n========== ADD ACTIVITY =========="
        );

        System.out.print(
                "Activity ID: "
        );

        int id = readInt();

        if (findActivityById(id) != null) {

            System.out.println(
                    "Activity ID already exists."
            );

            return;
        }

        System.out.print(
                "Activity Name: "
        );

        String name = sc.nextLine();

        System.out.print(
                "Duration (minutes): "
        );

        int duration = readInt();

        System.out.print(
                "Capacity: "
        );

        int capacity = readInt();

        DataStore.activities.add(
                new Activity(
                        id,
                        name,
                        duration,
                        capacity
                )
        );

        System.out.println(
                "Activity added successfully."
        );
    }


    // =========================================================
    // VIEW ACTIVITIES
    // =========================================================

    static void viewActivities() {

        System.out.println(
                "\n================ ACTIVITIES ================"
        );

        System.out.printf(
                "%-8s %-25s %-12s %-10s%n",
                "ID",
                "ACTIVITY",
                "DURATION",
                "CAPACITY"
        );

        System.out.println(
                "------------------------------------------------------------"
        );

        for (Activity activity :
                DataStore.activities) {

            System.out.println(activity);
        }
    }


    // =========================================================
    // SEARCH ACTIVITIES
    // =========================================================

    static void searchActivities() {

        System.out.print(
                "\nEnter activity name: "
        );

        String keyword =
                sc.nextLine().toLowerCase();

        boolean found = false;

        for (Activity activity :
                DataStore.activities) {

            if (activity.getActivityName()
                    .toLowerCase()
                    .contains(keyword)) {

                System.out.println(activity);

                found = true;
            }
        }

        if (!found) {

            System.out.println(
                    "Activity not found."
            );
        }
    }


    // =========================================================
    // UPDATE ACTIVITY
    // =========================================================

    static void updateActivity() {

        System.out.print(
                "\nEnter Activity ID: "
        );

        int id = readInt();

        Activity activity =
                findActivityById(id);

        if (activity == null) {

            System.out.println(
                    "Activity not found."
            );

            return;
        }

        System.out.print(
                "New Activity Name: "
        );

        activity.setActivityName(
                sc.nextLine()
        );

        System.out.print(
                "New Duration: "
        );

        activity.setDuration(
                readInt()
        );

        System.out.print(
                "New Capacity: "
        );

        activity.setCapacity(
                readInt()
        );

        System.out.println(
                "Activity updated successfully."
        );
    }


    // =========================================================
    // DELETE ACTIVITY
    // =========================================================

    static void deleteActivity() {

        System.out.print(
                "\nEnter Activity ID: "
        );

        int id = readInt();

        Activity activity =
                findActivityById(id);

        if (activity == null) {

            System.out.println(
                    "Activity not found."
            );

            return;
        }

        DataStore.activities.remove(activity);

        System.out.println(
                "Activity deleted successfully."
        );
    }


    // =========================================================
    // VIEW ACTIVITY CONFLICTS
    // =========================================================

    static void viewActivityConflicts() {

        System.out.println(
                "\n========== ACTIVITY CONFLICTS =========="
        );

        if (DataStore.activityConflicts.isEmpty()) {

            System.out.println(
                    "No activity conflicts."
            );

            return;
        }

        System.out.printf(
                "%-10s %-15s %-15s %-30s%n",
                "ID",
                "ACTIVITY 1",
                "ACTIVITY 2",
                "REASON"
        );

        for (ActivityConflict conflict :
                DataStore.activityConflicts) {

            System.out.println(conflict);
        }
    }


    // =========================================================
    // FIND ACTIVITY
    // =========================================================

    static void findActivity() {

        System.out.print(
                "\nEnter Activity ID: "
        );

        int id = readInt();

        Activity activity =
                findActivityById(id);

        if (activity == null) {

            System.out.println(
                    "Activity not found."
            );

        } else {

            System.out.println(
                    "Activity found:"
            );

            System.out.println(activity);
        }
    }


    // =========================================================
    // STAFF MANAGEMENT
    // =========================================================

    static void staffManagement() {

        while (true) {

            System.out.println(
                    "\n========== STAFF MANAGEMENT =========="
            );

            System.out.println("1. Add Staff");
            System.out.println("2. View Staff");
            System.out.println("3. Search Staff");
            System.out.println("4. Update Staff");
            System.out.println("5. Delete Staff");
            System.out.println("6. Find Staff by Skill");
            System.out.println("7. Find Staff by ID");
            System.out.println("8. Back");

            System.out.print(
                    "Enter choice: "
            );

            int choice = readInt();

            switch (choice) {

                case 1:
                    addStaff();
                    break;

                case 2:
                    viewStaff();
                    break;

                case 3:
                    searchStaff();
                    break;

                case 4:
                    updateStaff();
                    break;

                case 5:
                    deleteStaff();
                    break;

                case 6:
                    findStaffBySkill();
                    break;

                case 7:
                    findStaff();
                    break;

                case 8:
                    return;

                default:
                    System.out.println(
                            "Invalid choice."
                    );
            }
        }
    }


    // =========================================================
    // ADD STAFF
    // =========================================================

    static void addStaff() {

        System.out.println(
                "\n========== ADD STAFF =========="
        );

        System.out.print(
                "Staff ID: "
        );

        int id = readInt();

        if (findStaffById(id) != null) {

            System.out.println(
                    "Staff ID already exists."
            );

            return;
        }

        System.out.print(
                "Staff Name: "
        );

        String name = sc.nextLine();

        System.out.print(
                "Skills: "
        );

        String skills = sc.nextLine();

        DataStore.staff.add(
                new Staff(
                        id,
                        name,
                        skills
                )
        );

        System.out.println(
                "Staff added successfully."
        );
    }


    // =========================================================
    // VIEW STAFF
    // =========================================================

    static void viewStaff() {

        System.out.println(
                "\n================ STAFF ================"
        );

        System.out.printf(
                "%-8s %-25s %-40s%n",
                "ID",
                "NAME",
                "SKILLS"
        );

        System.out.println(
                "--------------------------------------------------------------------------"
        );

        for (Staff staff :
                DataStore.staff) {

            System.out.println(staff);
        }
    }


    // =========================================================
    // SEARCH STAFF
    // =========================================================

    static void searchStaff() {

        System.out.print(
                "\nEnter staff name: "
        );

        String keyword =
                sc.nextLine().toLowerCase();

        boolean found = false;

        for (Staff staff :
                DataStore.staff) {

            if (staff.getStaffName()
                    .toLowerCase()
                    .contains(keyword)) {

                System.out.println(staff);

                found = true;
            }
        }

        if (!found) {

            System.out.println(
                    "Staff not found."
            );
        }
    }


    // =========================================================
    // UPDATE STAFF
    // =========================================================

    static void updateStaff() {

        System.out.print(
                "\nEnter Staff ID: "
        );

        int id = readInt();

        Staff staff =
                findStaffById(id);

        if (staff == null) {

            System.out.println(
                    "Staff not found."
            );

            return;
        }

        System.out.print(
                "New Staff Name: "
        );

        staff.setStaffName(
                sc.nextLine()
        );

        System.out.print(
                "New Skills: "
        );

        staff.setSkills(
                sc.nextLine()
        );

        System.out.println(
                "Staff updated successfully."
        );
    }


    // =========================================================
    // DELETE STAFF
    // =========================================================

    static void deleteStaff() {

        System.out.print(
                "\nEnter Staff ID: "
        );

        int id = readInt();

        Staff staff =
                findStaffById(id);

        if (staff == null) {

            System.out.println(
                    "Staff not found."
            );

            return;
        }

        DataStore.staff.remove(staff);

        System.out.println(
                "Staff deleted successfully."
        );
    }


    // =========================================================
    // FIND STAFF BY SKILL
    // =========================================================

    static void findStaffBySkill() {

        System.out.print(
                "\nEnter skill: "
        );

        String skill =
                sc.nextLine().toLowerCase();

        boolean found = false;

        for (Staff staff :
                DataStore.staff) {

            if (staff.getSkills()
                    .toLowerCase()
                    .contains(skill)) {

                System.out.println(staff);

                found = true;
            }
        }

        if (!found) {

            System.out.println(
                    "No staff found with that skill."
            );
        }
    }


    // =========================================================
    // FIND STAFF
    // =========================================================

    static void findStaff() {

        System.out.print(
                "\nEnter Staff ID: "
        );

        int id = readInt();

        Staff staff =
                findStaffById(id);

        if (staff == null) {

            System.out.println(
                    "Staff not found."
            );

        } else {

            System.out.println(
                    "Staff found:"
            );

            System.out.println(staff);
        }
    }


    // =========================================================
    // PARTICIPANT MANAGEMENT
    // =========================================================

    static void participantManagement() {

        while (true) {

            System.out.println(
                    "\n========== PARTICIPANT MANAGEMENT =========="
            );

            System.out.println("1. Add Participant");
            System.out.println("2. View Participants");
            System.out.println("3. Search Participant");
            System.out.println("4. Update Participant");
            System.out.println("5. Delete Participant");
            System.out.println("6. View Participants by Event");
            System.out.println("7. Back");

            System.out.print(
                    "Enter choice: "
            );

            int choice = readInt();

            switch (choice) {

                case 1:
                    addParticipant();
                    break;

                case 2:
                    viewParticipants();
                    break;

                case 3:
                    searchParticipant();
                    break;

                case 4:
                    updateParticipant();
                    break;

                case 5:
                    deleteParticipant();
                    break;

                case 6:
                    viewParticipantsByEvent();
                    break;

                case 7:
                    return;

                default:
                    System.out.println(
                            "Invalid choice."
                    );
            }
        }
    }


    // =========================================================
    // ADD PARTICIPANT
    // =========================================================

    static void addParticipant() {

        System.out.println(
                "\n========== ADD PARTICIPANT =========="
        );

        System.out.print(
                "Participant ID: "
        );

        int id = readInt();

        if (findParticipantById(id) != null) {

            System.out.println(
                    "Participant ID already exists."
            );

            return;
        }

        System.out.print(
                "Participant Name: "
        );

        String name = sc.nextLine();

        System.out.print(
                "Email: "
        );

        String email = sc.nextLine();

        System.out.print(
                "Phone: "
        );

        String phone = sc.nextLine();

        System.out.print(
                "Event ID: "
        );

        int eventId = readInt();

        Event event =
                findEventById(eventId);

        if (event == null) {

            System.out.println(
                    "Event does not exist."
            );

            return;
        }

        if (event.getRegisteredCount()
                >= event.getCapacity()) {

            System.out.println(
                    "Event is full."
            );

            return;
        }

        Participant participant =
                new Participant(
                        id,
                        name,
                        email,
                        phone,
                        eventId
                );

        DataStore.participants.add(
                participant
        );

        event.setRegisteredCount(
                event.getRegisteredCount() + 1
        );

        System.out.println(
                "Participant added successfully."
        );
    }


    // =========================================================
    // VIEW PARTICIPANTS
    // =========================================================

    static void viewParticipants() {

        System.out.println(
                "\n================ PARTICIPANTS ================"
        );

        if (DataStore.participants.isEmpty()) {

            System.out.println(
                    "No participants available."
            );

            return;
        }

        System.out.printf(
                "%-8s %-22s %-30s %-15s %-10s%n",
                "ID",
                "NAME",
                "EMAIL",
                "PHONE",
                "EVENT ID"
        );

        System.out.println(
                "--------------------------------------------------------------------------------"
        );

        for (Participant participant :
                DataStore.participants) {

            System.out.println(participant);
        }
    }


    // =========================================================
    // SEARCH PARTICIPANT
    // =========================================================

    static void searchParticipant() {

        System.out.print(
                "\nEnter participant name or email: "
        );

        String keyword =
                sc.nextLine().toLowerCase();

        boolean found = false;

        for (Participant participant :
                DataStore.participants) {

            if (participant.getParticipantName()
                    .toLowerCase()
                    .contains(keyword)
                    ||
                    participant.getEmail()
                            .toLowerCase()
                            .contains(keyword)) {

                System.out.println(participant);

                found = true;
            }
        }

        if (!found) {

            System.out.println(
                    "Participant not found."
            );
        }
    }


    // =========================================================
    // UPDATE PARTICIPANT
    // =========================================================

    static void updateParticipant() {

        System.out.print(
                "\nEnter Participant ID: "
        );

        int id = readInt();

        Participant participant =
                findParticipantById(id);

        if (participant == null) {

            System.out.println(
                    "Participant not found."
            );

            return;
        }

        System.out.print(
                "New Name: "
        );

        participant.setParticipantName(
                sc.nextLine()
        );

        System.out.print(
                "New Email: "
        );

        participant.setEmail(
                sc.nextLine()
        );

        System.out.print(
                "New Phone: "
        );

        participant.setPhone(
                sc.nextLine()
        );

        System.out.print(
                "New Event ID: "
        );

        int newEventId = readInt();

        Event newEvent =
                findEventById(newEventId);

        if (newEvent == null) {

            System.out.println(
                    "New event does not exist."
            );

            return;
        }

        int oldEventId =
                participant.getEventId();

        if (oldEventId != newEventId) {

            if (newEvent.getRegisteredCount()
                    >= newEvent.getCapacity()) {

                System.out.println(
                        "New event is full."
                );

                return;
            }

            Event oldEvent =
                    findEventById(oldEventId);

            if (oldEvent != null
                    && oldEvent.getRegisteredCount() > 0) {

                oldEvent.setRegisteredCount(
                        oldEvent.getRegisteredCount() - 1
                );
            }

            newEvent.setRegisteredCount(
                    newEvent.getRegisteredCount() + 1
            );

            participant.setEventId(
                    newEventId
            );
        }

        System.out.println(
                "Participant updated successfully."
        );
    }


    // =========================================================
    // DELETE PARTICIPANT
    // =========================================================

    static void deleteParticipant() {

        System.out.print(
                "\nEnter Participant ID: "
        );

        int id = readInt();

        Participant participant =
                findParticipantById(id);

        if (participant == null) {

            System.out.println(
                    "Participant not found."
            );

            return;
        }

        Event event =
                findEventById(
                        participant.getEventId()
                );

        if (event != null
                && event.getRegisteredCount() > 0) {

            event.setRegisteredCount(
                    event.getRegisteredCount() - 1
            );
        }

        DataStore.participants.remove(
                participant
        );

        System.out.println(
                "Participant deleted successfully."
        );
    }


    // =========================================================
    // VIEW PARTICIPANTS BY EVENT
    // =========================================================

    static void viewParticipantsByEvent() {

        System.out.print(
                "\nEnter Event ID: "
        );

        int eventId = readInt();

        Event event =
                findEventById(eventId);

        if (event == null) {

            System.out.println(
                    "Event not found."
            );

            return;
        }

        System.out.println(
                "\nParticipants for Event: "
                        + event.getEventName()
        );

        boolean found = false;

        for (Participant participant :
                DataStore.participants) {

            if (participant.getEventId()
                    == eventId) {

                System.out.println(participant);

                found = true;
            }
        }

        if (!found) {

            System.out.println(
                    "No participants registered."
            );
        }
    }


    // =========================================================
    // REGISTRATION MANAGEMENT
    // =========================================================

    static void registrationManagement() {

        while (true) {

            System.out.println(
                    "\n========== REGISTRATION MANAGEMENT =========="
            );

            System.out.println("1. Create Registration");
            System.out.println("2. View Registrations");
            System.out.println("3. Search Registration");
            System.out.println("4. Update Registration Status");
            System.out.println("5. Cancel Registration");
            System.out.println("6. View Registrations by Event");
            System.out.println("7. Back");

            System.out.print(
                    "Enter choice: "
            );

            int choice = readInt();

            switch (choice) {

                case 1:
                    createRegistration();
                    break;

                case 2:
                    viewRegistrations();
                    break;

                case 3:
                    searchRegistration();
                    break;

                case 4:
                    updateRegistrationStatus();
                    break;

                case 5:
                    cancelRegistrationByAdmin();
                    break;

                case 6:
                    viewRegistrationsByEvent();
                    break;

                case 7:
                    return;

                default:
                    System.out.println(
                            "Invalid choice."
                    );
            }
        }
    }


    // =========================================================
    // CREATE REGISTRATION - ADMIN
    // =========================================================

    static void createRegistration() {

        System.out.println(
                "\n========== CREATE REGISTRATION =========="
        );

        System.out.print(
                "Registration ID: "
        );

        int registrationId = readInt();

        if (findRegistrationById(
                registrationId) != null) {

            System.out.println(
                    "Registration ID already exists."
            );

            return;
        }

        System.out.print(
                "User ID: "
        );

        int userId = readInt();

        if (findUserById(userId) == null) {

            System.out.println(
                    "User does not exist."
            );

            return;
        }

        System.out.print(
                "Event ID: "
        );

        int eventId = readInt();

        Event event =
                findEventById(eventId);

        if (event == null) {

            System.out.println(
                    "Event does not exist."
            );

            return;
        }

        if (event.getRegisteredCount()
                >= event.getCapacity()) {

            System.out.println(
                    "Event is full."
            );

            return;
        }

        if (hasActiveRegistration(
                userId,
                eventId)) {

            System.out.println(
                    "User is already registered for this event."
            );

            return;
        }

        String code =
                generateRegistrationCode(
                        eventId
                );

        Registration registration =
                new Registration(
                        registrationId,
                        userId,
                        eventId,
                        code,
                        LocalDate.now().toString(),
                        "ACTIVE"
                );

        DataStore.registrations.add(
                registration
        );

        event.setRegisteredCount(
                event.getRegisteredCount() + 1
        );

        System.out.println(
                "\nRegistration created successfully."
        );

        System.out.println(
                "Registration Code: "
                        + code
        );
    }


    // =========================================================
    // VIEW REGISTRATIONS
    // =========================================================

    static void viewRegistrations() {

        System.out.println(
                "\n================ REGISTRATIONS ================"
        );

        if (DataStore.registrations.isEmpty()) {

            System.out.println(
                    "No registrations available."
            );

            return;
        }

        System.out.printf(
                "%-8s %-10s %-10s %-20s %-15s %-12s%n",
                "REG ID",
                "USER ID",
                "EVENT ID",
                "CODE",
                "DATE",
                "STATUS"
        );

        System.out.println(
                "----------------------------------------------------------------------------"
        );

        for (Registration registration :
                DataStore.registrations) {

            System.out.println(registration);
        }
    }


    // =========================================================
    // SEARCH REGISTRATION
    // =========================================================

    static void searchRegistration() {

        System.out.println(
                "\n========== SEARCH REGISTRATION =========="
        );

        System.out.print(
                "Enter registration code: "
        );

        String code =
                sc.nextLine().trim();

        Registration registration =
                findRegistrationByCode(code);

        if (registration == null) {

            System.out.println(
                    "Registration not found."
            );

        } else {

            System.out.println(
                    "\nRegistration found:"
            );

            System.out.println(
                    registration
            );
        }
    }


    // =========================================================
    // UPDATE REGISTRATION STATUS
    // =========================================================

    static void updateRegistrationStatus() {

        System.out.print(
                "\nEnter Registration ID: "
        );

        int id = readInt();

        Registration registration =
                findRegistrationById(id);

        if (registration == null) {

            System.out.println(
                    "Registration not found."
            );

            return;
        }

        System.out.println(
                "Current Status: "
                        + registration.getStatus()
        );

        System.out.println(
                "1. ACTIVE"
        );

        System.out.println(
                "2. CANCELLED"
        );

        System.out.print(
                "Choose new status: "
        );

        int choice = readInt();

        if (choice == 1) {

            if (registration.getStatus()
                    .equalsIgnoreCase("ACTIVE")) {

                System.out.println(
                        "Registration is already active."
                );

                return;
            }

            Event event =
                    findEventById(
                            registration.getEventId()
                    );

            if (event == null) {

                System.out.println(
                        "Event not found."
                );

                return;
            }

            if (event.getRegisteredCount()
                    >= event.getCapacity()) {

                System.out.println(
                        "Event is full."
                );

                return;
            }

            registration.setStatus(
                    "ACTIVE"
            );

            event.setRegisteredCount(
                    event.getRegisteredCount() + 1
            );

            System.out.println(
                    "Registration activated."
            );

        } else if (choice == 2) {

            if (registration.getStatus()
                    .equalsIgnoreCase("CANCELLED")) {

                System.out.println(
                        "Registration is already cancelled."
                );

                return;
            }

            Event event =
                    findEventById(
                            registration.getEventId()
                    );

            if (event != null
                    && event.getRegisteredCount() > 0) {

                event.setRegisteredCount(
                        event.getRegisteredCount() - 1
                );
            }

            registration.setStatus(
                    "CANCELLED"
            );

            System.out.println(
                    "Registration cancelled."
            );

        } else {

            System.out.println(
                    "Invalid choice."
            );
        }
    }


    // =========================================================
    // CANCEL REGISTRATION - ADMIN
    // =========================================================

    static void cancelRegistrationByAdmin() {

        System.out.print(
                "\nEnter Registration ID: "
        );

        int id = readInt();

        Registration registration =
                findRegistrationById(id);

        if (registration == null) {

            System.out.println(
                    "Registration not found."
            );

            return;
        }

        if (registration.getStatus()
                .equalsIgnoreCase("CANCELLED")) {

            System.out.println(
                    "Registration is already cancelled."
            );

            return;
        }

        Event event =
                findEventById(
                        registration.getEventId()
                );

        if (event != null
                && event.getRegisteredCount() > 0) {

            event.setRegisteredCount(
                    event.getRegisteredCount() - 1
            );
        }

        registration.setStatus(
                "CANCELLED"
        );

        System.out.println(
                "Registration cancelled successfully."
        );
    }


    // =========================================================
    // VIEW REGISTRATIONS BY EVENT
    // =========================================================

    static void viewRegistrationsByEvent() {

        System.out.print(
                "\nEnter Event ID: "
        );

        int eventId = readInt();

        Event event =
                findEventById(eventId);

        if (event == null) {

            System.out.println(
                    "Event not found."
            );

            return;
        }

        System.out.println(
                "\nRegistrations for: "
                        + event.getEventName()
        );

        boolean found = false;

        for (Registration registration :
                DataStore.registrations) {

            if (registration.getEventId()
                    == eventId) {

                System.out.println(
                        registration
                );

                found = true;
            }
        }

        if (!found) {

            System.out.println(
                    "No registrations found."
            );
        }
    }


    // =========================================================
    // USER - REGISTER FOR EVENT
    // =========================================================

    static void registerForEvent(
            User loggedUser) {

        System.out.println(
                "\n========== REGISTER FOR EVENT =========="
        );

        viewEvents();

        System.out.print(
                "\nEnter Event ID: "
        );

        int eventId = readInt();

        Event event =
                findEventById(eventId);

        if (event == null) {

            System.out.println(
                    "Event not found."
            );

            return;
        }

        if (event.getRegisteredCount()
                >= event.getCapacity()) {

            System.out.println(
                    "Sorry, this event is full."
            );

            return;
        }

        if (hasActiveRegistration(
                loggedUser.getUserId(),
                eventId)) {

            System.out.println(
                    "You are already registered for this event."
            );

            return;
        }

        int registrationId =
                generateRegistrationId();

        String code =
                generateRegistrationCode(
                        eventId
                );

        Registration registration =
                new Registration(
                        registrationId,
                        loggedUser.getUserId(),
                        eventId,
                        code,
                        LocalDate.now().toString(),
                        "ACTIVE"
                );

        DataStore.registrations.add(
                registration
        );

        event.setRegisteredCount(
                event.getRegisteredCount() + 1
        );

        System.out.println(
                "\n=============================================="
        );

        System.out.println(
                "       REGISTRATION SUCCESSFUL"
        );

        System.out.println(
                "=============================================="
        );

        System.out.println(
                "Registration ID : "
                        + registrationId
        );

        System.out.println(
                "Event           : "
                        + event.getEventName()
        );

        System.out.println(
                "Registration Code: "
                        + code
        );

        System.out.println(
                "Date            : "
                        + LocalDate.now()
        );

        System.out.println(
                "Status          : ACTIVE"
        );
    }


    // =========================================================
    // USER - CANCEL REGISTRATION
    // =========================================================

    static void cancelRegistration(
            User loggedUser) {

        System.out.println(
                "\n========== CANCEL REGISTRATION =========="
        );

        System.out.print(
                "Enter Registration ID: "
        );

        int registrationId = readInt();

        Registration registration =
                findRegistrationById(
                        registrationId
                );

        if (registration == null) {

            System.out.println(
                    "Registration not found."
            );

            return;
        }

        if (registration.getUserId()
                != loggedUser.getUserId()) {

            System.out.println(
                    "You can cancel only your own registration."
            );

            return;
        }

        if (registration.getStatus()
                .equalsIgnoreCase("CANCELLED")) {

            System.out.println(
                    "Registration is already cancelled."
            );

            return;
        }

        Event event =
                findEventById(
                        registration.getEventId()
                );

        if (event != null
                && event.getRegisteredCount() > 0) {

            event.setRegisteredCount(
                    event.getRegisteredCount() - 1
            );
        }

        registration.setStatus(
                "CANCELLED"
        );

        System.out.println(
                "Registration cancelled successfully."
        );
    }


    // =========================================================
    // USER - MY REGISTRATIONS
    // =========================================================

    static void viewMyRegistrations(
            User loggedUser) {

        System.out.println(
                "\n========== MY REGISTRATIONS =========="
        );

        boolean found = false;

        for (Registration registration :
                DataStore.registrations) {

            if (registration.getUserId()
                    == loggedUser.getUserId()) {

                System.out.println(
                        registration
                );

                found = true;
            }
        }

        if (!found) {

            System.out.println(
                    "You have no registrations."
            );
        }
    }


    // =========================================================
    // GENERATE REGISTRATION ID
    // =========================================================

    static int generateRegistrationId() {

        int maxId = 0;

        for (Registration registration :
                DataStore.registrations) {

            if (registration.getRegistrationId()
                    > maxId) {

                maxId =
                        registration.getRegistrationId();
            }
        }

        return maxId + 1;
    }


    // =========================================================
    // GENERATE REGISTRATION CODE
    // =========================================================

    static String generateRegistrationCode(
            int eventId) {

        int number =
                DataStore.registrations.size() + 1;

        String code =
                String.format(
                        "EVT-%d-%04d",
                        eventId,
                        number
                );

        while (findRegistrationByCode(code)
                != null) {

            number++;

            code =
                    String.format(
                            "EVT-%d-%04d",
                            eventId,
                            number
                    );
        }

        return code;
    }


    // =========================================================
    // CHECK ACTIVE REGISTRATION
    // =========================================================

    static boolean hasActiveRegistration(
            int userId,
            int eventId) {

        for (Registration registration :
                DataStore.registrations) {

            if (registration.getUserId()
                    == userId
                    &&
                    registration.getEventId()
                            == eventId
                    &&
                    registration.getStatus()
                            .equalsIgnoreCase(
                                    "ACTIVE"
                            )) {

                return true;
            }
        }

        return false;
    }


    // =========================================================
    // FIND REGISTRATION BY ID
    // =========================================================

    static Registration findRegistrationById(
            int registrationId) {

        for (Registration registration :
                DataStore.registrations) {

            if (registration.getRegistrationId()
                    == registrationId) {

                return registration;
            }
        }

        return null;
    }


    // =========================================================
    // FIND REGISTRATION BY CODE
    // =========================================================

    static Registration findRegistrationByCode(
            String code) {

        for (Registration registration :
                DataStore.registrations) {

            if (registration.getRegistrationCode()
                    .equalsIgnoreCase(code)) {

                return registration;
            }
        }

        return null;
    }


    // =========================================================
    // FIND USER BY ID
    // =========================================================

    static User findUserById(int userId) {

        for (User user : DataStore.users) {

            if (user.getUserId() == userId) {

                return user;
            }
        }

        return null;
    }


    // =========================================================
    // FIND PARTICIPANT BY ID
    // =========================================================

    static Participant findParticipantById(
            int participantId) {

        for (Participant participant :
                DataStore.participants) {

            if (participant.getParticipantId()
                    == participantId) {

                return participant;
            }
        }

        return null;
    }


    // =========================================================
    // FIND EVENT BY ID
    // =========================================================

    static Event findEventById(
            int eventId) {

        for (Event event :
                DataStore.events) {

            if (event.getEventId()
                    == eventId) {

                return event;
            }
        }

        return null;
    }


    // =========================================================
    // FIND VENUE BY ID
    // =========================================================

    static Venue findVenueById(
            int venueId) {

        for (Venue venue :
                DataStore.venues) {

            if (venue.getVenueId()
                    == venueId) {

                return venue;
            }
        }

        return null;
    }


    // =========================================================
    // FIND ACTIVITY BY ID
    // =========================================================

    static Activity findActivityById(
            int activityId) {

        for (Activity activity :
                DataStore.activities) {

            if (activity.getActivityId()
                    == activityId) {

                return activity;
            }
        }

        return null;
    }


    // =========================================================
    // FIND STAFF BY ID
    // =========================================================

    static Staff findStaffById(
            int staffId) {

        for (Staff staff :
                DataStore.staff) {

            if (staff.getStaffId()
                    == staffId) {

                return staff;
            }
        }

        return null;
    }


    // =========================================================
    // READ INTEGER SAFELY
    // =========================================================

    static int readInt() {

        while (true) {

            try {

                return Integer.parseInt(
                        sc.nextLine()
                );

            } catch (NumberFormatException e) {

                System.out.print(
                        "Enter a valid number: "
                );
            }
        }
    }
} 