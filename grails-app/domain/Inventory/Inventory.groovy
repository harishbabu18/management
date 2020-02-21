package Inventory
import company.Address
import usermanagement.User

class Inventory {
    ProductName name
    String barcode
    QuantityType quantityType
    Integer number
    Double quantity
    Double price
    User createBy
    Lot lot
    Date dateCreated
    Date lastUpdated
    Boolean isDeleted
//    static hasMany = [transport: Transport]
//    static belongsTo = [transport: Transport]


    static constraints = {
        barcode unique:true
        isDeleted nullable: true, blank: true
    }

}

