public class AssignmentTwo {
    public static void main(String[] args) {
        AssignmentTwo app = new AssignmentTwo();
        app.partFourB(); // 测试排序功能
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

    // Placeholders for other part methods
    public void partSix() {}
    public void partSeven() {}
    public void partFive() {}
}