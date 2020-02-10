package company

class Email {
    Company company
    Contact contact
    String email
    Boolean isDeleted

    static constraints = {
        email email:true, unique:true
        company nullable: true, blank: true
        contact nullable: true, blank: true
        isDeleted nullable: true, blank: true
    }
}
