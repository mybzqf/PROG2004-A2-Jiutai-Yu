import java.util.LinkedList;
import java.util.Queue;

public class Ride implements RideInterface {
    // Basic attributes (defined in Part1)
    private Employee operator;
    private String rideName;
    private String rideType;

    // Part3: Waiting line (stores visitors waiting for the ride)
    private Queue<Visitor> waitingLine;


    // Constructors
    public Ride() {
        this.waitingLine = new LinkedList<>();
    }

    public Ride(Employee operator, String rideName, String rideType) {
        this.operator = operator;
        this.rideName = rideName;
        this.rideType = rideType;
        this.waitingLine = new LinkedList<>();
    }


    // Getters & Setters for basic attributes
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


    // Part3: Implement waiting line methods
    @Override
    public void addVisitorToQueue(Visitor visitor) {
        if (visitor != null) {
            waitingLine.offer(visitor);
            System.out.println("Successfully added visitor [" + visitor.getName() + "] to the waiting line of [" + rideName + "]");
        } else {
            System.out.println("Failed to add: Visitor information is empty");
        }
    }

    @Override
    public void removeVisitorFromQueue() {
        if (waitingLine.isEmpty()) {
            System.out.println("Failed to remove: The waiting line of [" + rideName + "] is empty");
        } else {
            Visitor removedVisitor = waitingLine.poll();
            System.out.println("Successfully removed visitor [" + removedVisitor.getName() + "] from the waiting line of [" + rideName + "]");
        }
    }

    @Override
    public void printQueue() {
        System.out.println("=== Waiting Line Details of [" + rideName + "] ===");
        if (waitingLine.isEmpty()) {
            System.out.println("No visitors in the waiting line");
            return;
        }
        int index = 1;
        for (Visitor visitor : waitingLine) {
            System.out.println(index + ". Name: " + visitor.getName()
                    + " | Age: " + visitor.getAge()
                    + " | Ticket ID: " + visitor.getVisitorTicketId());
            index++;
        }
        System.out.println("==============================");
    }


    // Empty implementations for other interface methods (to be filled in later parts)
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
}