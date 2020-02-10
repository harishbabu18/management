package company

class Company {
    String name
    String description
    Date establishedDate
    Date dateCreated
    Date lastUpdated
    Boolean isDeleted

    static constraints = {
        name unique:true
        description nullable: true, blank: true
        establishedDate nullable: true, blank: true
        isDeleted nullable: true, blank: true
    }
}
