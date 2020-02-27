package company

import usermanagement.User

class Company {
    String name
    String description
    Date establishedDate
    Date dateCreated
    Date lastUpdated
    String email
    String mobile
    String website
    String fax
    OfficeType officeType
    String addresslineone
    String addresslinetwo
    String country
    String state
    String zip
    User user
    
    static constraints = {
        name unique:true
        description nullable: true, blank: true
        establishedDate nullable: true, blank: true
        fax nullable: true, blank: true
        addresslinetwo nullable: true, blank: true
        email unique:true,email: true
        website unique:true,nullable: true, blank: true
    }
}
