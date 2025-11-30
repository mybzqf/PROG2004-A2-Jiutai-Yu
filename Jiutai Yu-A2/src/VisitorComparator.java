import java.util.Comparator;

public class VisitorComparator implements Comparator<Visitor> {
    @Override
    public int compare(Visitor v1, Visitor v2) {
        // First sort by age (ascending), then by ticket ID (ascending)
        int ageCompare = v1.getAge() - v2.getAge();
        if (ageCompare != 0) {
            return ageCompare;
        }
        return v1.getVisitorTicketId().compareTo(v2.getVisitorTicketId());
    }
}