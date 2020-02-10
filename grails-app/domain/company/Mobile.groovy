package company

class Mobile {
    Company company
    Contact contact
    String mobile
    Boolean isDeleted

    static constraints = {
        mobile unique:true
        company nullable: true, blank: true
        contact nullable: true, blank: true
        isDeleted nullable: true, blank: true
    }
}
