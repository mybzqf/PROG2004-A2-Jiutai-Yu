import java.util.LinkedList;
import java.util.Queue;
import java.util.Iterator;
import java.util.Collections;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;

public class Ride implements RideInterface {
    // Core attributes (Part 1)
    private Employee operator;
    private String rideName;
    private String rideType;

    // Part 3: Waiting line storage (visitors waiting for the ride)
    private Queue<Visitor> waitingLine;

    // Part 4: Ride history storage (visitors who completed the ride)
    private LinkedList<Visitor> rideHistory;

    // Part 5: Ride cycle configuration
    private int maxRidersPerCycle; // Maximum riders per single cycle
    private int completedCycleCount; // Total finished cycles


    // ========== Mandatory 3-parameter constructor (fixes core error) ==========
    public Ride(Employee operator, String rideName, String rideType) {
        this.operator = operator;
        this.rideName = rideName;
        this.rideType = rideType;
        this.waitingLine = new LinkedList<>();
        this.rideHistory = new LinkedList<>();
        this.maxRidersPerCycle = 3; // Default capacity
        this.completedCycleCount = 0;
    }

    // Default constructor (no parameters)
    public Ride() {
        this.waitingLine = new LinkedList<>();
        this.rideHistory = new LinkedList<>();
        this.maxRidersPerCycle = 3;
        this.completedCycleCount = 0;
    }

    // 4-parameter constructor (custom max riders per cycle)
    public Ride(Employee operator, String rideName, String rideType, int maxRidersPerCycle) {
        this.operator = operator;
        this.rideName = rideName;
        this.rideType = rideType;
        this.waitingLine = new LinkedList<>();
        this.rideHistory = new LinkedList<>();
        this.maxRidersPerCycle = maxRidersPerCycle;
        this.completedCycleCount = 0;
    }


    // Getters and Setters (standard access methods)
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

    public int getMaxRidersPerCycle() {
        return maxRidersPerCycle;
    }

    public void setMaxRidersPerCycle(int maxRidersPerCycle) {
        this.maxRidersPerCycle = maxRidersPerCycle;
    }

    public int getCompletedCycleCount() {
        return completedCycleCount;
    }


    // Part 3: Waiting Line Management Methods
    @Override
    public void addVisitorToQueue(Visitor visitor) {
        if (visitor != null) {
            waitingLine.offer(visitor);
            System.out.println("Visitor [" + visitor.getName() + "] added to waiting line of [" + rideName + "]");
        } else {
            System.out.println("Error: Cannot add null visitor to waiting line");
        }
    }

    @Override
    public void removeVisitorFromQueue() {
        if (waitingLine.isEmpty()) {
            System.out.println("Error: Waiting line of [" + rideName + "] is empty - no visitor to remove");
        } else {
            Visitor removedVisitor = waitingLine.poll();
            System.out.println("Visitor [" + removedVisitor.getName() + "] removed from waiting line");
        }
    }

    @Override
    public void printQueue() {
        System.out.println("\n=== Waiting Line - " + rideName + " ===");
        if (waitingLine.isEmpty()) {
            System.out.println("No visitors in waiting line");
            return;
        }
        int position = 1;
        for (Visitor visitor : waitingLine) {
            System.out.println(position + ". Name: " + visitor.getName()
                    + " | Ticket ID: " + visitor.getVisitorTicketId());
            position++;
        }
    }


    // Part 4: Ride History Management Methods
    @Override
    public void addVisitorToHistory(Visitor visitor) {
        if (visitor != null) {
            rideHistory.add(visitor);
            System.out.println("Visitor [" + visitor.getName() + "] added to ride history");
        } else {
            System.out.println("Error: Cannot add null visitor to ride history");
        }
    }

    @Override
    public boolean checkVisitorFromHistory(Visitor visitor) {
        if (visitor == null) {
            System.out.println("Error: Cannot check null visitor in history");
            return false;
        }
        for (Visitor v : rideHistory) {
            if (v.getVisitorTicketId().equals(visitor.getVisitorTicketId())) {
                System.out.println("Visitor [" + visitor.getName() + "] found in ride history");
                return true;
            }
        }
        System.out.println("Visitor [" + visitor.getName() + "] NOT found in ride history");
        return false;
    }

    @Override
    public int numberOfVisitors() {
        int totalVisitors = rideHistory.size();
        System.out.println("Total visitors in ride history: " + totalVisitors);
        return totalVisitors;
    }

    @Override
    public void printRideHistory() {
        System.out.println("\n=== Ride History - " + rideName + " ===");
        if (rideHistory.isEmpty()) {
            System.out.println("No ride history records");
            return;
        }
        int recordNumber = 1;
        Iterator<Visitor> iterator = rideHistory.iterator();
        while (iterator.hasNext()) {
            Visitor visitor = iterator.next();
            System.out.println(recordNumber + ". Name: " + visitor.getName()
                    + " | Visit Date: " + visitor.getVisitDate());
            recordNumber++;
        }
    }

    // Part 4B: Sort ride history by age then ticket ID
    public void sortRideHistory() {
        Collections.sort(rideHistory, new VisitorComparator());
        System.out.println("Ride history sorted by age (ascending) and ticket ID (ascending)");
    }


    // Part 5: Core Ride Cycle Execution Method
    @Override
    public void runOneCycle() {
        System.out.println("\n=== Starting Ride Cycle - " + rideName + " ===");

        // Validate operator assignment
        if (this.operator == null) {
            System.out.println("Cycle Failed: No operator assigned to " + rideName);
            return;
        }

        // Validate waiting line has visitors
        if (waitingLine.isEmpty()) {
            System.out.println("Cycle Failed: No visitors in waiting line for " + rideName);
            return;
        }

        // Process riders for this cycle
        int ridersProcessed = 0;
        while (!waitingLine.isEmpty() && ridersProcessed < maxRidersPerCycle) {
            Visitor currentRider = waitingLine.poll();
            rideHistory.add(currentRider);
            System.out.println("Rider [" + currentRider.getName() + "] completed the ride");
            ridersProcessed++;
        }

        // Update cycle metrics
        this.completedCycleCount++;

        // Cycle completion summary
        System.out.println("\n=== Cycle Completion Summary ===");
        System.out.println("Total completed cycles: " + this.completedCycleCount);
        System.out.println("Riders processed this cycle: " + ridersProcessed);
        System.out.println("Remaining visitors in waiting line: " + waitingLine.size());
    }

    // Part 6: Export ride history to text file
    public void exportHistoryToFile(String filePath) {
        System.out.println("\n=== Exporting Ride History to File: " + filePath + " ===");
        try (FileWriter writer = new FileWriter(filePath)) {
            // Write file header
            writer.write("=== Ride History Report - " + rideName + " ===\n");
            writer.write("Export Date: " + LocalDate.now() + "\n");
            writer.write("Total Completed Cycles: " + completedCycleCount + "\n");
            writer.write("Max Riders Per Cycle: " + maxRidersPerCycle + "\n\n");

            // Write visitor records
            int recordNum = 1;
            for (Visitor visitor : rideHistory) {
                writer.write("Record " + recordNum + ":\n");
                writer.write("  Name: " + visitor.getName() + "\n");
                writer.write("  Age: " + visitor.getAge() + "\n");
                writer.write("  Ticket ID: " + visitor.getVisitorTicketId() + "\n");
                writer.write("  Visit Date: " + visitor.getVisitDate() + "\n\n");
                recordNum++;
            }
            System.out.println("Success: Ride history exported to " + filePath);
        } catch (IOException e) {
            System.out.println("Error exporting history: " + e.getMessage());
        }
    }
}