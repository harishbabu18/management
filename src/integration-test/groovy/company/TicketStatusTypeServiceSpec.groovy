package company

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class TicketStatusTypeServiceSpec extends Specification {

    TicketStatusTypeService ticketStatusTypeService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new TicketStatusType(...).save(flush: true, failOnError: true)
        //new TicketStatusType(...).save(flush: true, failOnError: true)
        //TicketStatusType ticketStatusType = new TicketStatusType(...).save(flush: true, failOnError: true)
        //new TicketStatusType(...).save(flush: true, failOnError: true)
        //new TicketStatusType(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //ticketStatusType.id
    }

    void "test get"() {
        setupData()

        expect:
        ticketStatusTypeService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<TicketStatusType> ticketStatusTypeList = ticketStatusTypeService.list(max: 2, offset: 2)

        then:
        ticketStatusTypeList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        ticketStatusTypeService.count() == 5
    }

    void "test delete"() {
        Long ticketStatusTypeId = setupData()

        expect:
        ticketStatusTypeService.count() == 5

        when:
        ticketStatusTypeService.delete(ticketStatusTypeId)
        sessionFactory.currentSession.flush()

        then:
        ticketStatusTypeService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        TicketStatusType ticketStatusType = new TicketStatusType()
        ticketStatusTypeService.save(ticketStatusType)

        then:
        ticketStatusType.id != null
    }
}
