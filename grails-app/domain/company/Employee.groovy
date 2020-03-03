package company

import usermanagement.User

class Employee {

    String profilepic
    String firstName
    String lastName
    String email
    Date dob
    User user
    Date joinindate
    Date relievingdate
    Date dateCreated
    Date lastUpdated

    static constraints = {
        profilepic nullable:true, blank:true
    }
}
