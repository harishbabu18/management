package company

class Contact {
    Company company
    String firstName
    String lastName
    Date dob
    Position position
    Date dateCreated
    Date lastUpdated
    Boolean isDeleted
    static constraints = {
        isDeleted nullable: true, blank: true
    }
}
