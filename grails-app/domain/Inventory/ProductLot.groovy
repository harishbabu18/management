package Inventory

class ProductLot {
    String name
    Date expiryDate
    Date dateCreated
    Date lastUpdated
    Boolean isDeleted
    static constraints = {
        isDeleted nullable: true, blank: true

    }
}
