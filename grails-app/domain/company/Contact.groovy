package company

class Contact {
    Company company
    String email
    String mobile
    String website
    String fax
    Date dateCreated
    Date lastUpdated
    Boolean isDeleted


    static constraints = {
        email nullable: true, blank: true
        mobile nullable: true, blank: true
        website nullable: true, blank: true
        fax nullable: true, blank: true
        isDeleted nullable: true, blank: true
    }
}
