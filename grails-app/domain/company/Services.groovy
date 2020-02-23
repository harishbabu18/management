package company

class Services {
    String name
    String description
    Double price
    Date deadline
    Date joinindate
    Date relievingdate
    static constraints = {
        name unique:true
        description nullable: true, blank: true
    }
}
