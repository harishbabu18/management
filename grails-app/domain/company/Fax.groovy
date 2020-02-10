package company

class Fax {
    Company company
    Contact contact
    String fax
    Boolean isDeleted

    static constraints = {
        fax unique:true
        company nullable: true, blank: true
        contact nullable: true, blank: true
        isDeleted nullable: true, blank: true
    }
}
