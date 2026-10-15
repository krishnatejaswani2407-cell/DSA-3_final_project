package eventflow.model;

public class Activity {

    private int activityId;
    private String activityName;
    private int duration;
    private int capacity;

    public Activity(int activityId, String activityName,
                    int duration, int capacity) {

        this.activityId = activityId;
        this.activityName = activityName;
        this.duration = duration;
        this.capacity = capacity;
    }

    public int getActivityId() {
        return activityId;
    }

    public void setActivityId(int activityId) {
        this.activityId = activityId;
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public String toString() {

        return String.format(
                "%-8d %-25s %-12d %-10d",
                activityId,
                activityName,
                duration,
                capacity
        );
    }
}