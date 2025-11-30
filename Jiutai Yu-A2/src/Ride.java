public class Ride implements RideInterface{
    @Override
    public void addVisitorToQueue(Visitor visitor) {

    }

    @Override
    public void removeVisitorFromQueue() {

    }

    @Override
    public void printQueue() {

    }

    @Override
    public void addVisitorToHistory(Visitor visitor) {

    }

    @Override
    public boolean checkVisitorFromHistory(Visitor visitor) {
        return false;
    }

    @Override
    public int numberOfVisitors() {
        return 0;
    }

    @Override
    public void printRideHistory() {

    }

    @Override
    public void runOneCycle() {

    }

    private Employee operator;
    private String rideName;
    private String rideType;

    public Ride() {}

    public Ride(Employee operator, String rideName, String rideType) {
        this.operator = operator;
        this.rideName = rideName;
        this.rideType = rideType;
    }

    public Employee getOperator() {
        return operator;
    }

    public void setOperator(Employee operator) {
        this.operator = operator;
    }

    public String getRideName() {
        return rideName;
    }

    public void setRideName(String rideName) {
        this.rideName = rideName;
    }

    public String getRideType() {
        return rideType;
    }

    public void setRideType(String rideType) {
        this.rideType = rideType;
    }
}