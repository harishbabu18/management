package Inventory

import company.Address



class Transport {
    Address loading
    Address unloading
    Date schedule
    static hasMany = [inventory: Inventory]
    Date dateCreated
    Date lastUpdated
    Boolean isDeleted
    static constraints = {
        isDeleted nullable: true, blank: true
    }
}
