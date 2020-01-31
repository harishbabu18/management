package company

class Company {
    String name
    String description
    Date establishedDate
    Date entrydate
    Boolean isDeleted

    static constraints = {
        name unique:true
        description nullable: true, blank: true
        establishedDate nullable: true, blank: true
        entrydate nullable: true, blank: true
        isDeleted nullable: true, blank: true
    }
}
