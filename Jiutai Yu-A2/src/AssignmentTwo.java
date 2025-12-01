import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;

public class AssignmentTwo {
    public static void main(String[] args) {
        AssignmentTwo app = new AssignmentTwo();
        app.partSeven(); // Run Part7 data analysis test
    }

    // Part3: Waiting Line Test
    public void partThree() {
        System.out.println("=== Part3 Waiting Line Test ===");

        // 1. Create an operator
        Employee op = new Employee("Zhang San", 30, "44010119950101", "EMP001", "Morning Shift");

        // 2. Create a ride
        Ride rollerCoaster = new Ride(op, "Roller Coaster", "Thrilling");

        // 3. Create 5 visitors
        Visitor v1 = new Visitor("Li Si", 25, "44010119980101", "T001", "2025-12-01");
        Visitor v2 = new Visitor("Wang Wu", 32, "44010119910101", "T002", "2025-12-01");
        Visitor v3 = new Visitor("Zhao Liu", 18, "44010120060101", "T003", "2025-12-01");
        Visitor v4 = new Visitor("Sun Qi", 45, "44010119800101", "T004", "2025-12-01");
        Visitor v5 = new Visitor("Zhou Ba", 22, "44010120020101", "T005", "2025-12-01");

        // 4. Add visitors to the waiting line
        rollerCoaster.addVisitorToQueue(v1);
        rollerCoaster.addVisitorToQueue(v2);
        rollerCoaster.addVisitorToQueue(v3);
        rollerCoaster.addVisitorToQueue(v4);
        rollerCoaster.addVisitorToQueue(v5);

        // 5. Print the waiting line
        rollerCoaster.printQueue();

        // 6. Remove one visitor from the line
        rollerCoaster.removeVisitorFromQueue();

        // 7. Print the line again to verify removal
        System.out.println("\nAfter removal:");
        rollerCoaster.printQueue();
    }

    // Part4A: Ride History Test
    public void partFourA() {
        System.out.println("=== Part4A Ride History Test ===");

        // 1. Create an operator
        Employee op = new Employee("Zhang San", 30, "44010119950101", "EMP001", "Morning Shift");

        // 2. Create a ride
        Ride rollerCoaster = new Ride(op, "Roller Coaster", "Thrilling");

        // 3. Create 5 visitors
        Visitor v1 = new Visitor("Li Si", 25, "44010119980101", "T001", "2025-12-01");
        Visitor v2 = new Visitor("Wang Wu", 32, "44010119910101", "T002", "2025-12-01");
        Visitor v3 = new Visitor("Zhao Liu", 18, "44010120060101", "T003", "2025-12-01");
        Visitor v4 = new Visitor("Sun Qi", 45, "44010119800101", "T004", "2025-12-01");
        Visitor v5 = new Visitor("Zhou Ba", 22, "44010120020101", "T005", "2025-12-01");
        Visitor v6 = new Visitor("Wu Jiu", 28, "44010119960101", "T006", "2025-12-01");

        // 4. Add visitors to ride history
        rollerCoaster.addVisitorToHistory(v1);
        rollerCoaster.addVisitorToHistory(v2);
        rollerCoaster.addVisitorToHistory(v3);
        rollerCoaster.addVisitorToHistory(v4);
        rollerCoaster.addVisitorToHistory(v5);

        // 5. Check if visitor exists
        System.out.println("\n--- Check Visitor Existence ---");
        rollerCoaster.checkVisitorFromHistory(v3);
        rollerCoaster.checkVisitorFromHistory(v6);

        // 6. Get total number of visitors
        System.out.println("\n--- Total Visitors in History ---");
        rollerCoaster.numberOfVisitors();

        // 7. Print ride history
        System.out.println("\n--- Ride History Details ---");
        rollerCoaster.printRideHistory();
    }

    // Part4B: Ride History Sort Test
    public void partFourB() {
        System.out.println("=== Part4B Ride History Sort Test ===");

        // 1. Create an operator
        Employee op = new Employee("Zhang San", 30, "44010119950101", "EMP001", "Morning Shift");

        // 2. Create a ride
        Ride rollerCoaster = new Ride(op, "Roller Coaster", "Thrilling");

        // 3. Create unsorted visitors (age disorder)
        Visitor v1 = new Visitor("Li Si", 25, "44010119980101", "T005", "2025-12-01");
        Visitor v2 = new Visitor("Wang Wu", 32, "44010119910101", "T002", "2025-12-01");
        Visitor v3 = new Visitor("Zhao Liu", 18, "44010120060101", "T004", "2025-12-01");
        Visitor v4 = new Visitor("Sun Qi", 45, "44010119800101", "T001", "2025-12-01");
        Visitor v5 = new Visitor("Zhou Ba", 22, "44010120020101", "T003", "2025-12-01");

        // 4. Add to history
        rollerCoaster.addVisitorToHistory(v1);
        rollerCoaster.addVisitorToHistory(v2);
        rollerCoaster.addVisitorToHistory(v3);
        rollerCoaster.addVisitorToHistory(v4);
        rollerCoaster.addVisitorToHistory(v5);

        // 5. Print unsorted history
        System.out.println("\n--- Unsorted Ride History ---");
        rollerCoaster.printRideHistory();

        // 6. Sort history
        rollerCoaster.sortRideHistory();

        // 7. Print sorted history
        System.out.println("\n--- Sorted Ride History (Age → Ticket ID) ---");
        rollerCoaster.printRideHistory();
    }

    // Part5: Ride Cycle Test
    public void partFive() {
        System.out.println("=== Part5 Ride Cycle Test ===");

        // 1. Create an operator
        Employee op = new Employee("Zhang San", 30, "44010119950101", "EMP001", "Morning Shift");

        // 2. Create a ride (max 2 riders per cycle)
        Ride rollerCoaster = new Ride(op, "Roller Coaster", "Thrilling", 2);

        // 3. Add 5 visitors to waiting line
        Visitor v1 = new Visitor("Li Si", 25, "44010119980101", "T001", "2025-12-01");
        Visitor v2 = new Visitor("Wang Wu", 32, "44010119910101", "T002", "2025-12-01");
        Visitor v3 = new Visitor("Zhao Liu", 18, "44010120060101", "T003", "2025-12-01");
        Visitor v4 = new Visitor("Sun Qi", 45, "44010119800101", "T004", "2025-12-01");
        Visitor v5 = new Visitor("Zhou Ba", 22, "44010120020101", "T005", "2025-12-01");
        rollerCoaster.addVisitorToQueue(v1);
        rollerCoaster.addVisitorToQueue(v2);
        rollerCoaster.addVisitorToQueue(v3);
        rollerCoaster.addVisitorToQueue(v4);
        rollerCoaster.addVisitorToQueue(v5);

        // 4. Print initial waiting line
        System.out.println("\n--- Initial Waiting Line ---");
        rollerCoaster.printQueue();

        // 5. Run 2 ride cycles
        rollerCoaster.runOneCycle();
        rollerCoaster.runOneCycle();

        // 6. Print final waiting line & ride history
        System.out.println("\n--- Final Waiting Line ---");
        rollerCoaster.printQueue();
        System.out.println("\n--- Ride History After Cycles ---");
        rollerCoaster.printRideHistory();
    }

    // Part6: Export Ride History to File Test
    public void partSix() {
        System.out.println("=== Part6 Export History to File Test ===");

        // 1. Create operator and ride
        Employee op = new Employee("Zhang San", 30, "44010119950101", "EMP001", "Morning Shift");
        Ride rollerCoaster = new Ride(op, "Roller Coaster", "Thrilling", 2);

        // 2. Create and add visitors to queue
        Visitor v1 = new Visitor("Li Si", 25, "44010119980101", "T001", "2025-12-01");
        Visitor v2 = new Visitor("Wang Wu", 32, "44010119910101", "T002", "2025-12-01");
        Visitor v3 = new Visitor("Zhao Liu", 18, "44010120060101", "T003", "2025-12-01");
        Visitor v4 = new Visitor("Sun Qi", 45, "44010119800101", "T004", "2025-12-01");
        rollerCoaster.addVisitorToQueue(v1);
        rollerCoaster.addVisitorToQueue(v2);
        rollerCoaster.addVisitorToQueue(v3);
        rollerCoaster.addVisitorToQueue(v4);

        // 3. Run 2 cycles to generate history
        rollerCoaster.runOneCycle();
        rollerCoaster.runOneCycle();

        // 4. Export history to file (project root directory)
        rollerCoaster.exportHistoryToFile("roller_coaster_history.txt");

        // 5. Verify export by printing history
        System.out.println("\n--- Verify Exported Data ---");
        rollerCoaster.printRideHistory();
    }

    // Part7: Ride Data Analysis Test
    public void partSeven() {
        System.out.println("=== Part7 Ride Data Analysis Test ===");

        // 1. Create operator and ride
        Employee op = new Employee("Zhang San", 30, "44010119950101", "EMP001", "Morning Shift");
        Ride rollerCoaster = new Ride(op, "Roller Coaster", "Thrilling", 2);

        // 2. Create and add visitors to queue
        Visitor v1 = new Visitor("Li Si", 25, "44010119980101", "T001", "2025-12-01");
        Visitor v2 = new Visitor("Wang Wu", 32, "44010119910101", "T002", "2025-12-01");
        Visitor v3 = new Visitor("Zhao Liu", 18, "44010120060101", "T003", "2025-12-01");
        Visitor v4 = new Visitor("Sun Qi", 45, "44010119800101", "T004", "2025-12-01");
        Visitor v5 = new Visitor("Zhou Ba", 22, "44010120020101", "T005", "2025-12-01");
        Visitor v6 = new Visitor("Wu Jiu", 28, "44010119960101", "T006", "2025-12-01");
        Visitor v7 = new Visitor("Zheng Shi", 35, "44010119900101", "T007", "2025-12-01");
        Visitor v8 = new Visitor("Chen Yi", 29, "44010119950101", "T008", "2025-12-01");
        Visitor v9 = new Visitor("Hu Er", 31, "44010119930101", "T009", "2025-12-01");
        Visitor v10 = new Visitor("He San", 27, "44010119970101", "T010", "2025-12-01");
        rollerCoaster.addVisitorToQueue(v1);
        rollerCoaster.addVisitorToQueue(v2);
        rollerCoaster.addVisitorToQueue(v3);
        rollerCoaster.addVisitorToQueue(v4);
        rollerCoaster.addVisitorToQueue(v5);
        rollerCoaster.addVisitorToQueue(v6);
        rollerCoaster.addVisitorToQueue(v7);
        rollerCoaster.addVisitorToQueue(v8);
        rollerCoaster.addVisitorToQueue(v9);
        rollerCoaster.addVisitorToQueue(v10);

        // 3. Run 2 cycles to generate history
        rollerCoaster.runOneCycle();
        rollerCoaster.runOneCycle();

        // 4. Run full data analysis
        rollerCoaster.printAnalysisReport();

        // 5. Export analysis to file (optional)
        try (FileWriter writer = new FileWriter("roller_coaster_analysis.txt")) {
            writer.write("=== Ride Data Analysis Report - Roller Coaster ===\n");
            writer.write("Report Date: " + LocalDate.now() + "\n");
            writer.write("Total Riders: " + rollerCoaster.calculateTotalRiders() + "\n");
            writer.write("Average Age: " + String.format("%.2f", rollerCoaster.calculateAverageAge()) + "\n");
            Visitor youngest = rollerCoaster.findYoungestVisitor();
            writer.write("Youngest Visitor: " + youngest.getName() + " (Age: " + youngest.getAge() + ")\n");
            Visitor oldest = rollerCoaster.findOldestVisitor();
            writer.write("Oldest Visitor: " + oldest.getName() + " (Age: " + oldest.getAge() + ")\n");
            writer.write("Total Cycles: " + rollerCoaster.getCompletedCycleCount() + "\n");
            System.out.println("\nSuccess: Analysis report exported to roller_coaster_analysis.txt");
        } catch (IOException e) {
            System.out.println("Error exporting analysis: " + e.getMessage());
        }
    }
}