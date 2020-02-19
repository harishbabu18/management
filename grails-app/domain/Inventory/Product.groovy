package Inventory

import usermanagement.User


class Product {

    ProductName name
    String barcode
    QuantityType quantityType
    Double quantity
    Double price
    Date dateCreated
    Date lastUpdated
    Boolean isDeleted
    User createBy

    static constraints = {
        barcode unique:true
        isDeleted nullable: true, blank: true
    }
}
