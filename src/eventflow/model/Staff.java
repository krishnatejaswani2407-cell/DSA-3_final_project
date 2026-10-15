package eventflow.model;

public class Staff {

    private int staffId;
    private String staffName;
    private String skills;

    public Staff(int staffId, String staffName, String skills) {
        this.staffId = staffId;
        this.staffName = staffName;
        this.skills = skills;
    }

    public int getStaffId() {
        return staffId;
    }

    public void setStaffId(int staffId) {
        this.staffId = staffId;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    @Override
    public String toString() {

        return String.format(
                "%-8d %-25s %-40s",
                staffId,
                staffName,
                skills
        );
    }
}