package company

class TicketType {
    String name

    static constraints = {
        name unique:true
    }
}
