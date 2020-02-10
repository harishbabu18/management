package company

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class TicketServiceSpec extends Specification {

    TicketService ticketService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Ticket(...).save(flush: true, failOnError: true)
        //new Ticket(...).save(flush: true, failOnError: true)
        //Ticket ticket = new Ticket(...).save(flush: true, failOnError: true)
        //new Ticket(...).save(flush: true, failOnError: true)
        //new Ticket(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //ticket.id
    }

    void "test get"() {
        setupData()

        expect:
        ticketService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Ticket> ticketList = ticketService.list(max: 2, offset: 2)

        then:
        ticketList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        ticketService.count() == 5
    }

    void "test delete"() {
        Long ticketId = setupData()

        expect:
        ticketService.count() == 5

        when:
        ticketService.delete(ticketId)
        sessionFactory.currentSession.flush()

        then:
        ticketService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Ticket ticket = new Ticket()
        ticketService.save(ticket)

        then:
        ticket.id != null
    }
}
