package company

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class TicketSourceServiceSpec extends Specification {

    TicketSourceService ticketSourceService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new TicketSource(...).save(flush: true, failOnError: true)
        //new TicketSource(...).save(flush: true, failOnError: true)
        //TicketSource ticketSource = new TicketSource(...).save(flush: true, failOnError: true)
        //new TicketSource(...).save(flush: true, failOnError: true)
        //new TicketSource(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //ticketSource.id
    }

    void "test get"() {
        setupData()

        expect:
        ticketSourceService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<TicketSource> ticketSourceList = ticketSourceService.list(max: 2, offset: 2)

        then:
        ticketSourceList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        ticketSourceService.count() == 5
    }

    void "test delete"() {
        Long ticketSourceId = setupData()

        expect:
        ticketSourceService.count() == 5

        when:
        ticketSourceService.delete(ticketSourceId)
        sessionFactory.currentSession.flush()

        then:
        ticketSourceService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        TicketSource ticketSource = new TicketSource()
        ticketSourceService.save(ticketSource)

        then:
        ticketSource.id != null
    }
}
