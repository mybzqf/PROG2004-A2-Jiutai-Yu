import java.util.LinkedList;
import java.util.Queue;
import java.util.Iterator;
import java.util.Collections;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.io.BufferedReader;
import java.io.FileReader;

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
    private int maxRider; // 按作业要求命名（单周期最大游客数）
    private int completedCycleCount; // Total finished cycles


    // ========== Mandatory 3-parameter constructor (fixes core error) ==========
    public Ride(Employee operator, String rideName, String rideType) {
        this.operator = operator;
        this.rideName = rideName;
        this.rideType = rideType;
        this.waitingLine = new LinkedList<>();
        this.rideHistory = new LinkedList<>();
        this.maxRider = 3; // Default capacity
        this.completedCycleCount = 0;
    }

    // Default constructor (no parameters)
    public Ride() {
        this.waitingLine = new LinkedList<>();
        this.rideHistory = new LinkedList<>();
        this.maxRider = 3;
        this.completedCycleCount = 0;
    }

    // 4-parameter constructor (custom max riders per cycle)
    public Ride(Employee operator, String rideName, String rideType, int maxRider) {
        this.operator = operator;
        this.rideName = rideName;
        this.rideType = rideType;
        this.waitingLine = new LinkedList<>();
        this.rideHistory = new LinkedList<>();
        this.maxRider = maxRider;
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

    public int getMaxRider() {
        return maxRider;
    }

    public void setMaxRider(int maxRider) {
        this.maxRider = maxRider;
    }

    public int getCompletedCycleCount() {
        return completedCycleCount;
    }


    // Part 3: Waiting Line Management Methods
    @Override
    public void addVisitorToQueue(Visitor visitor) {
        try {
            if (visitor == null) {
                throw new IllegalArgumentException("Visitor cannot be null");
            }
            if (rideName == null || rideName.isEmpty()) {
                throw new IllegalStateException("Ride name is not set");
            }
            waitingLine.offer(visitor);
            System.out.println("Successfully added visitor [" + visitor.getName() + "] to waiting line of [" + rideName + "]");
        } catch (IllegalArgumentException e) {
            System.out.println("Failed to add visitor: " + e.getMessage());
        } catch (IllegalStateException e) {
            System.out.println("Failed to add visitor: " + e.getMessage());
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

    // Part 4A: printRideHistory (强制使用Iterator，符合作业要求)
    @Override
    public void printRideHistory() {
        System.out.println("\n=== Ride History - " + rideName + " ===");
        if (rideHistory.isEmpty()) {
            System.out.println("No visitors in ride history");
            return;
        }
        // 必须使用Iterator遍历
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
        while (!waitingLine.isEmpty() && ridersProcessed < maxRider) {
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

    // Part 6: Export ride history to CSV file (匹配Part7导入格式)
    public void exportHistoryToFile(String filePath) {
        System.out.println("\n=== Exporting Ride History to CSV File: " + filePath + " ===");
        try (FileWriter writer = new FileWriter(filePath)) {
            // 写入文件头（便于识别，导入时跳过）
            writer.write("=== Ride History Report - " + rideName + " ===\n");
            writer.write("Export Date: " + LocalDate.now() + "\n");
            writer.write("Name,Age,TicketID,VisitDate\n"); // CSV列标题

            // 按CSV格式写入每条游客数据（逗号分隔）
            for (Visitor visitor : rideHistory) {
                writer.write(visitor.getName() + ","
                        + visitor.getAge() + ","
                        + visitor.getVisitorTicketId() + ","
                        + visitor.getVisitDate() + "\n");
            }
            System.out.println("Success: Ride history exported to " + filePath);
        } catch (IOException e) {
            System.out.println("Error exporting history: " + e.getMessage());
        }
    }

    // Part 7: Import ride history from CSV file (符合作业要求)
    public void importRideHistory(String filePath) {
        System.out.println("\n=== Importing Ride History from File: " + filePath + " ===");
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            // 跳过文件头（Part6导出时的“=== Ride History Report ...”行）
            while ((line = reader.readLine()) != null) {
                if (line.startsWith("===") || line.startsWith("Export Date:") || line.isEmpty()) {
                    continue; // 跳过非数据行
                }
                // 按CSV格式分割（匹配Part6的导出格式）
                String[] data = line.split(",");
                if (data.length != 4) {
                    System.out.println("Skipping invalid line: " + line);
                    continue;
                }
                // 解析数据并创建Visitor对象（匹配Visitor类的构造器）
                String name = data[0];
                int age = Integer.parseInt(data[1]);
                String ticketId = data[2];
                String visitDate = data[3];
                // 假设Visitor构造器为：Visitor(String name, int age, String id, String ticketId, String visitDate)
                Visitor visitor = new Visitor(name, age, "default-id", ticketId, visitDate);
                rideHistory.add(visitor);
            }
            System.out.println("Success: Imported " + rideHistory.size() + " visitors from file");
        } catch (IOException e) {
            System.out.println("Error importing history: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Error parsing age: " + e.getMessage());
        }
    }

    // Part7: Data Analysis Methods
    public double calculateAverageAge() {
        if (rideHistory.isEmpty()) {
            System.out.println("No data to calculate average age: Ride history is empty");
            return 0.0;
        }
        int totalAge = 0;
        for (Visitor v : rideHistory) {
            totalAge += v.getAge();
        }
        double avgAge = (double) totalAge / rideHistory.size();
        System.out.println("Average age of visitors: " + String.format("%.2f", avgAge));
        return avgAge;
    }

    public Visitor findYoungestVisitor() {
        if (rideHistory.isEmpty()) {
            System.out.println("No data to find youngest visitor: Ride history is empty");
            return null;
        }
        Visitor youngest = rideHistory.get(0);
        for (Visitor v : rideHistory) {
            if (v.getAge() < youngest.getAge()) {
                youngest = v;
            }
        }
        System.out.println("Youngest visitor: " + youngest.getName() + " (Age: " + youngest.getAge() + ")");
        return youngest;
    }

    public Visitor findOldestVisitor() {
        if (rideHistory.isEmpty()) {
            System.out.println("No data to find oldest visitor: Ride history is empty");
            return null;
        }
        Visitor oldest = rideHistory.get(0);
        for (Visitor v : rideHistory) {
            if (v.getAge() > oldest.getAge()) {
                oldest = v;
            }
        }
        System.out.println("Oldest visitor: " + oldest.getName() + " (Age: " + oldest.getAge() + ")");
        return oldest;
    }

    public int calculateTotalRiders() {
        int total = rideHistory.size();
        System.out.println("Total riders processed: " + total);
        return total;
    }

    public void printAnalysisReport() {
        System.out.println("\n=== Ride Data Analysis Report - " + rideName + " ===");
        System.out.println("Report Date: " + LocalDate.now());
        System.out.println("----------------------------------------");
        calculateTotalRiders();
        calculateAverageAge();
        findYoungestVisitor();
        findOldestVisitor();
        System.out.println("Total completed cycles: " + completedCycleCount);
        System.out.println("Max riders per cycle: " + maxRider);
        System.out.println("Average riders per cycle: " + String.format("%.2f", (double) rideHistory.size() / (completedCycleCount == 0 ? 1 : completedCycleCount)));
        System.out.println("========================================");
    }
}