package eventflow.model;

public class Event {

    private int eventId;
    private String eventName;
    private String description;
    private String category;
    private String date;
    private String time;
    private int venueId;
    private int capacity;
    private int registeredCount;

    public Event(int eventId,
                 String eventName,
                 String description,
                 String category,
                 String date,
                 String time,
                 int venueId,
                 int capacity) {

        this.eventId = eventId;
        this.eventName = eventName;
        this.description = description;
        this.category = category;
        this.date = date;
        this.time = time;
        this.venueId = venueId;
        this.capacity = capacity;
        this.registeredCount = 0;
    }

    // ================= GETTERS =================

    public int getEventId() {
        return eventId;
    }

    public String getEventName() {
        return eventName;
    }

    public String getDescription() {
        return description;
    }

    public String getCategory() {
        return category;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public int getVenueId() {
        return venueId;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getRegisteredCount() {
        return registeredCount;
    }

    // ================= SETTERS =================

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setVenueId(int venueId) {
        this.venueId = venueId;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void setRegisteredCount(int registeredCount) {
        this.registeredCount = registeredCount;
    }

    // ================= DISPLAY =================

    @Override
    public String toString() {

        return String.format(
                "%-5d %-20s %-15s %-12s %-10d %-10d",
                eventId,
                eventName,
                category,
                date,
                capacity,
                registeredCount
        );
    }
}