package company

class Ticket {
    String description
    boolean urgent
    boolean important
    TicketSource ticketSource
    TicketStatusType ticketStatus
    Employee cratedBy
    Employee assignedTo
    Company company
    Contact contact
    Date dateCreated
    Date lastUpdated

    static constraints = {
    }
}
