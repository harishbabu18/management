package company

class Address {
    Company company
    String addresslineone
    String addresslinetwo
    String country
    String state
    String zip
    OfficeType officeType

    Date dateCreated
    Date lastUpdated

    Boolean isDeleted

    static constraints = {
        addresslinetwo nullable: true, blank: true
        isDeleted nullable: true, blank: true
    }
}
