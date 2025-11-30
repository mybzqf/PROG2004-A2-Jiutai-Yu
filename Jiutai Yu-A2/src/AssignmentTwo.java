public class AssignmentTwo {
    public static void main(String[] args) {
        AssignmentTwo app = new AssignmentTwo();
        app.partThree();
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

    // Placeholders for other part methods (to be filled later)
    public void partFourA() {}
    public void partFourB() {}
    public void partSix() {}
    public void partSeven() {}
    public void partFive() {}
}