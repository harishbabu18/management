package company

class TicketStatusType {
    String name

    static constraints = {
        name unique:true
    }
}
