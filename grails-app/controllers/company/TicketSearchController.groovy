package company


import grails.rest.*
import grails.converters.*

class TicketSearchController {
	static responseFormats = ['json', 'xml']
	
    def index() {
        def c = Ticket.createCriteria()
        def results = c.list{
            like("description", params.description)
        }
         respond results
    }
}
