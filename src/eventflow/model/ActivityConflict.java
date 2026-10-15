package eventflow.model;

public class ActivityConflict {

    private int conflictId;
    private int activity1Id;
    private int activity2Id;
    private String reason;

    public ActivityConflict(int conflictId,
                            int activity1Id,
                            int activity2Id,
                            String reason) {

        this.conflictId = conflictId;
        this.activity1Id = activity1Id;
        this.activity2Id = activity2Id;
        this.reason = reason;
    }

    public int getConflictId() {
        return conflictId;
    }

    public int getActivity1Id() {
        return activity1Id;
    }

    public int getActivity2Id() {
        return activity2Id;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    @Override
    public String toString() {

        return String.format(
                "%-10d %-15d %-15d %-30s",
                conflictId,
                activity1Id,
                activity2Id,
                reason
        );
    }
}