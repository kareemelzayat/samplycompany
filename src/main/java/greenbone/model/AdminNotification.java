package greenbone.model;

public class AdminNotification {

    String level;

    String employeeAbbreviation;

    String message;

    public AdminNotification(String level, String employeeAbbreviation, String message) {
        this.level = level;
        this.employeeAbbreviation = employeeAbbreviation;
        this.message = message;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getEmployeeAbbreviation() {
        return employeeAbbreviation;
    }

    public void setEmployeeAbbreviation(String employeeAbbreviation) {
        this.employeeAbbreviation = employeeAbbreviation;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
