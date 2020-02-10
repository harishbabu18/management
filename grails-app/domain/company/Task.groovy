package company

class Task {
    Ticket ticket
    Employee assignedTo
    Employee assignedBy
    String personalNote
    String publicMessage
    Date dateCreated
    Date lastUpdated

    static constraints = {
    }
}
