package Inventory

class Lot {
    String lotname
    Date expiryDate
    String note
    Date dateCreated
    Date lastUpdated
    Boolean isDeleted
    static constraints = {
        isDeleted nullable: true, blank: true
    }
}
