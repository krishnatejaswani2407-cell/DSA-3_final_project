package eventflow.model;

public class Venue {

    private int venueId;
    private String venueName;
    private int capacity;
    private String facilities;

    public Venue(int venueId, String venueName,
                 int capacity, String facilities) {

        this.venueId = venueId;
        this.venueName = venueName;
        this.capacity = capacity;
        this.facilities = facilities;
    }

    // ================= GETTERS =================

    public int getVenueId() {
        return venueId;
    }

    public String getVenueName() {
        return venueName;
    }

    public int getCapacity() {
        return capacity;
    }

    public String getFacilities() {
        return facilities;
    }

    // ================= SETTERS =================

    public void setVenueName(String venueName) {
        this.venueName = venueName;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void setFacilities(String facilities) {
        this.facilities = facilities;
    }

    // ================= DISPLAY =================

    @Override
    public String toString() {

        return String.format(
                "%-5d %-22s %-10d %-35s",
                venueId,
                venueName,
                capacity,
                facilities
        );
    }
}