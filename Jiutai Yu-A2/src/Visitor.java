public class Visitor extends Person {
    private String visitorTicketId;
    private String visitDate;

    public Visitor() {}

    public Visitor(String name, int age, String id, String visitorTicketId, String visitDate) {
        super(name, age, id);
        this.visitorTicketId = visitorTicketId;
        this.visitDate = visitDate;
    }

    public String getVisitorTicketId() {
        return visitorTicketId;
    }

    public void setVisitorTicketId(String visitorTicketId) {
        this.visitorTicketId = visitorTicketId;
    }

    public String getVisitDate() {
        return visitDate;
    }

    public void setVisitDate(String visitDate) {
        this.visitDate = visitDate;
    }
}