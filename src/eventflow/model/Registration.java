package eventflow.model;

public class Registration {

    private int registrationId;
    private int userId;
    private int eventId;
    private String registrationCode;
    private String registrationDate;
    private String status;

    // Constructor
    public Registration(int registrationId,
                        int userId,
                        int eventId,
                        String registrationCode,
                        String registrationDate,
                        String status) {

        this.registrationId = registrationId;
        this.userId = userId;
        this.eventId = eventId;
        this.registrationCode = registrationCode;
        this.registrationDate = registrationDate;
        this.status = status;
    }

    // Registration ID
    public int getRegistrationId() {
        return registrationId;
    }

    public void setRegistrationId(int registrationId) {
        this.registrationId = registrationId;
    }

    // User ID
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    // Event ID
    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    // Registration Code
    public String getRegistrationCode() {
        return registrationCode;
    }

    public void setRegistrationCode(String registrationCode) {
        this.registrationCode = registrationCode;
    }

    // Registration Date
    public String getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(String registrationDate) {
        this.registrationDate = registrationDate;
    }

    // Status
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    // Display registration
    @Override
    public String toString() {

        return String.format(
                "%-8d %-10d %-10d %-20s %-15s %-12s",
                registrationId,
                userId,
                eventId,
                registrationCode,
                registrationDate,
                status
        );
    }
} 