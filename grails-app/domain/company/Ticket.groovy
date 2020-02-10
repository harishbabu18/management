package company

class Ticket {
    String description
    boolean urgent
    boolean important
    TicketSource ticketSource
    TicketType ticketType
    Employee employee
    Company company
    Contact contact
    Date dateCreated
    Date lastUpdated

    static constraints = {
    }
}
