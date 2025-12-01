public interface RideInterface {
    // Part3: Waiting line methods
    void addVisitorToQueue(Visitor visitor);
    void removeVisitorFromQueue();
    void printQueue();

    // Part4: Ride history methods
    void addVisitorToHistory(Visitor visitor);
    boolean checkVisitorFromHistory(Visitor visitor);
    int numberOfVisitors();
    void printRideHistory();

    // Part5: Ride cycle method
    void runOneCycle();
}