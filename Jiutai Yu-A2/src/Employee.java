public class Employee extends Person {
    private String employeeId;
    private String shift;

    public Employee() {}

    public Employee(String name, int age, String id, String employeeId, String shift) {
        super(name, age, id);
        this.employeeId = employeeId;
        this.shift = shift;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getShift() {
        return shift;
    }

    public void setShift(String shift) {
        this.shift = shift;
    }
}