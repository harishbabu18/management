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


    static constraints = {
        addresslinetwo nullable: true, blank: true

    }
}
