import java.util.LinkedList;
import java.util.Queue;
import java.util.Iterator;
import java.util.Collections;

public class Ride implements RideInterface {
    // Basic attributes (defined in Part1)
    private Employee operator;
    private String rideName;
    private String rideType;

    // Part3: Waiting line (stores visitors waiting for the ride)
    private Queue<Visitor> waitingLine;

    // Part4: Ride history (stores visitors who have ridden)
    private LinkedList<Visitor> rideHistory;


    // Constructors
    public Ride() {
        this.waitingLine = new LinkedList<>();
        this.rideHistory = new LinkedList<>();
    }

    public Ride(Employee operator, String rideName, String rideType) {
        this.operator = operator;
        this.rideName = rideName;
        this.rideType = rideType;
        this.waitingLine = new LinkedList<>();
        this.rideHistory = new LinkedList<>();
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


    // Part4: Implement ride history methods
    @Override
    public void addVisitorToHistory(Visitor visitor) {
        if (visitor != null) {
            rideHistory.add(visitor);
            System.out.println("Successfully added visitor [" + visitor.getName() + "] to the ride history of [" + rideName + "]");
        } else {
            System.out.println("Failed to add: Visitor information is empty");
        }
    }

    @Override
    public boolean checkVisitorFromHistory(Visitor visitor) {
        if (visitor == null) {
            System.out.println("Check failed: Visitor information is empty");
            return false;
        }
        for (Visitor v : rideHistory) {
            if (v.getVisitorTicketId().equals(visitor.getVisitorTicketId())) {
                System.out.println("Check result: Visitor [" + visitor.getName() + "] exists in the ride history of [" + rideName + "]");
                return true;
            }
        }
        System.out.println("Check result: Visitor [" + visitor.getName() + "] does NOT exist in the ride history of [" + rideName + "]");
        return false;
    }

    @Override
    public int numberOfVisitors() {
        int count = rideHistory.size();
        System.out.println("Total visitors in ride history of [" + rideName + "]: " + count);
        return count;
    }

    @Override
    public void printRideHistory() {
        System.out.println("=== Ride History Details of [" + rideName + "] ===");
        if (rideHistory.isEmpty()) {
            System.out.println("No visitors in the ride history");
            return;
        }
        Iterator<Visitor> iterator = rideHistory.iterator();
        int index = 1;
        while (iterator.hasNext()) {
            Visitor visitor = iterator.next();
            System.out.println(index + ". Name: " + visitor.getName()
                    + " | Age: " + visitor.getAge()
                    + " | Ticket ID: " + visitor.getVisitorTicketId()
                    + " | Visit Date: " + visitor.getVisitDate());
            index++;
        }
        System.out.println("==============================");
    }

    // Part4B: Sort ride history by age then ticket ID
    public void sortRideHistory() {
        Collections.sort(rideHistory, new VisitorComparator());
        System.out.println("Ride history of [" + rideName + "] has been sorted by age (ascending) then ticket ID (ascending)");
    }


    // Part5: To be implemented later
    @Override
    public void runOneCycle() {
    }
}