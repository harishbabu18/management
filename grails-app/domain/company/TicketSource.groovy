package company

class TicketSource {
    String name

    static constraints = {
        name unique:true
    }
}
