package company

class Services {
    String name
    String description
    Double price
    Date deadline
    Date dateCreated
    Date lastUpdated
    static constraints = {
        name unique:true
        description nullable: true, blank: true
    }
}
