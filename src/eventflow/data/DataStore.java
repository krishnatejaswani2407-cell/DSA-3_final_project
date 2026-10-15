package eventflow.data;

import java.util.ArrayList;
import java.util.List;

import eventflow.model.Activity;
import eventflow.model.ActivityConflict;
import eventflow.model.Event;
import eventflow.model.Participant;
import eventflow.model.Registration;
import eventflow.model.Staff;
import eventflow.model.User;
import eventflow.model.Venue;

public class DataStore {

    // =========================================================
    // DATA COLLECTIONS
    // =========================================================

    public static List<Event> events = new ArrayList<>();

    public static List<User> users = new ArrayList<>();

    public static List<Venue> venues = new ArrayList<>();

    public static List<Activity> activities = new ArrayList<>();

    public static List<ActivityConflict> activityConflicts =
            new ArrayList<>();

    public static List<Staff> staff = new ArrayList<>();

    public static List<Participant> participants =
            new ArrayList<>();

    public static List<Registration> registrations =
            new ArrayList<>();


    // =========================================================
    // LOAD SAMPLE DATA
    // =========================================================

    public static void loadSampleData() {

        events.clear();
        users.clear();
        venues.clear();
        activities.clear();
        activityConflicts.clear();
        staff.clear();
        participants.clear();
        registrations.clear();


        // =====================================================
        // USERS
        // =====================================================

        users.add(
                new User(
                        1,
                        "Admin",
                        "admin",
                        "admin123"
                )
        );

        users.add(
                new User(
                        2,
                        "Gnana",
                        "user",
                        "user123"
                )
        );


        // =====================================================
        // VENUES
        // =====================================================

        venues.add(
                new Venue(
                        1,
                        "Main Auditorium",
                        500,
                        "Projector, WiFi, Audio System"
                )
        );

        venues.add(
                new Venue(
                        2,
                        "Seminar Hall",
                        300,
                        "Projector, AC, WiFi"
                )
        );

        venues.add(
                new Venue(
                        3,
                        "Computer Lab",
                        150,
                        "Computers, WiFi"
                )
        );


        // =====================================================
        // EVENTS
        // =====================================================

        events.add(
                new Event(
                        101,
                        "TechFest",
                        "Technology innovation event",
                        "Technical",
                        "20-10-2026",
                        "10:00 AM",
                        1,
                        500
                )
        );

        events.add(
                new Event(
                        102,
                        "CodeSprint",
                        "Competitive programming event",
                        "Coding",
                        "22-10-2026",
                        "10:00 AM",
                        2,
                        300
                )
        );

        events.add(
                new Event(
                        103,
                        "AI Summit",
                        "Artificial intelligence and machine learning",
                        "AI",
                        "25-10-2026",
                        "09:00 AM",
                        1,
                        400
                )
        );

        events.add(
                new Event(
                        104,
                        "WebHack",
                        "Web development hackathon",
                        "Technical",
                        "28-10-2026",
                        "09:00 AM",
                        3,
                        150
                )
        );


        // =====================================================
        // ACTIVITIES
        // =====================================================

        activities.add(
                new Activity(
                        1,
                        "Coding Workshop",
                        90,
                        100
                )
        );

        activities.add(
                new Activity(
                        2,
                        "AI Seminar",
                        60,
                        150
                )
        );

        activities.add(
                new Activity(
                        3,
                        "Hackathon",
                        180,
                        100
                )
        );


        // =====================================================
        // ACTIVITY CONFLICTS
        // =====================================================

        activityConflicts.add(
                new ActivityConflict(
                        1,
                        1,
                        3,
                        "Both require computer lab"
                )
        );


        // =====================================================
        // STAFF
        // =====================================================

        staff.add(
                new Staff(
                        1,
                        "Alice",
                        "Registration,Workshop"
                )
        );

        staff.add(
                new Staff(
                        2,
                        "Bob",
                        "Security"
                )
        );

        staff.add(
                new Staff(
                        3,
                        "Charlie",
                        "Technical Support,Workshop"
                )
        );

        staff.add(
                new Staff(
                        4,
                        "David",
                        "Registration"
                )
        );


        // =====================================================
        // PARTICIPANTS
        // =====================================================

        participants.add(
                new Participant(
                        1,
                        "Rahul",
                        "rahul@gmail.com",
                        "9876543210",
                        101
                )
        );

        participants.add(
                new Participant(
                        2,
                        "Anjali",
                        "anjali@gmail.com",
                        "9876543211",
                        102
                )
        );

        participants.add(
                new Participant(
                        3,
                        "Kiran",
                        "kiran@gmail.com",
                        "9876543212",
                        103
                )
        );


        // =====================================================
        // REGISTRATIONS
        // =====================================================

        /*
         * No sample registrations are added here.
         *
         * Registrations will be created through:
         * Admin -> Registration Management
         * User  -> Register for Event
         */


        // Update event counts
        updateRegisteredCounts();
    }


    // =========================================================
    // UPDATE REGISTERED COUNTS
    // =========================================================

    private static void updateRegisteredCounts() {

        for (Event event : events) {

            event.setRegisteredCount(0);
        }

        /*
         * Existing participants are counted as registered
         * participants.
         */
        for (Participant participant : participants) {

            Event event =
                    findEventById(participant.getEventId());

            if (event != null) {

                event.setRegisteredCount(
                        event.getRegisteredCount() + 1
                );
            }
        }

        /*
         * Active registrations are also counted.
         *
         * This means newly created registrations will increase
         * the event count.
         */
        for (Registration registration : registrations) {

            if (registration.getStatus()
                    .equalsIgnoreCase("ACTIVE")) {

                Event event =
                        findEventById(
                                registration.getEventId()
                        );

                if (event != null) {

                    event.setRegisteredCount(
                            event.getRegisteredCount() + 1
                    );
                }
            }
        }
    }


    // =========================================================
    // FIND EVENT BY ID
    // =========================================================

    private static Event findEventById(int eventId) {

        for (Event event : events) {

            if (event.getEventId() == eventId) {

                return event;
            }
        }

        return null;
    }
} 