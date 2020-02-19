package Inventory

class ProductName {
    String name
    Date dateCreated
    Date lastUpdated
    Boolean isDeleted


    static constraints = {
        name  unique:true
        isDeleted nullable: true, blank: true

    }
}
