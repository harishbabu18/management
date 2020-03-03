package company

import usermanagement.User

class Offering {
    Company company
    Contact contact
    String proptocol
    Date startDate
    Date endDate
    User user
    Date dateCreated
    Date lastUpdated

    static constraints = {
    }
}
