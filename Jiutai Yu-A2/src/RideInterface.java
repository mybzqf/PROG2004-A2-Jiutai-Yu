// RideInterface.java（接口）
public interface RideInterface {
    // Part3：队列方法
    void addVisitorToQueue(Visitor visitor);
    void removeVisitorFromQueue();
    void printQueue();

    // Part4：历史方法
    void addVisitorToHistory(Visitor visitor);
    boolean checkVisitorFromHistory(Visitor visitor);
    int numberOfVisitors();
    void printRideHistory();

    // Part5：运行方法
    void runOneCycle();
}