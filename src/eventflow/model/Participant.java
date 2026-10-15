package eventflow.model;

public class Participant {

    private int participantId;
    private String participantName;
    private String email;
    private String phone;
    private int eventId;

    // Constructor
    public Participant(int participantId,
                       String participantName,
                       String email,
                       String phone,
                       int eventId) {

        this.participantId = participantId;
        this.participantName = participantName;
        this.email = email;
        this.phone = phone;
        this.eventId = eventId;
    }

    // Get Participant ID
    public int getParticipantId() {
        return participantId;
    }

    // Set Participant ID
    public void setParticipantId(int participantId) {
        this.participantId = participantId;
    }

    // Get Participant Name
    public String getParticipantName() {
        return participantName;
    }

    // Set Participant Name
    public void setParticipantName(String participantName) {
        this.participantName = participantName;
    }

    // Get Email
    public String getEmail() {
        return email;
    }

    // Set Email
    public void setEmail(String email) {
        this.email = email;
    }

    // Get Phone
    public String getPhone() {
        return phone;
    }

    // Set Phone
    public void setPhone(String phone) {
        this.phone = phone;
    }

    // Get Event ID
    public int getEventId() {
        return eventId;
    }

    // Set Event ID
    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    // Display participant information
    @Override
    public String toString() {
        return String.format(
                "%-8d %-22s %-30s %-15s %-10d",
                participantId,
                participantName,
                email,
                phone,
                eventId
        );
    }
} 