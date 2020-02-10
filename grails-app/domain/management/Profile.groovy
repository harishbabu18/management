package management

import company.Company
import usermanagement.User

class Profile {

    Company company
    User user
    String firstname
    String lastname
    Date dob
    String mobile
    String termoraryaddress
    String permanentaddress
    Date dateCreated
    Date lastUpdated

    static constraints = {
    }
}
