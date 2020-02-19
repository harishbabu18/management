package Inventory

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class TransportServiceSpec extends Specification {

    TransportService transportService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Transport(...).save(flush: true, failOnError: true)
        //new Transport(...).save(flush: true, failOnError: true)
        //Transport transport = new Transport(...).save(flush: true, failOnError: true)
        //new Transport(...).save(flush: true, failOnError: true)
        //new Transport(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //transport.id
    }

    void "test get"() {
        setupData()

        expect:
        transportService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Transport> transportList = transportService.list(max: 2, offset: 2)

        then:
        transportList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        transportService.count() == 5
    }

    void "test delete"() {
        Long transportId = setupData()

        expect:
        transportService.count() == 5

        when:
        transportService.delete(transportId)
        sessionFactory.currentSession.flush()

        then:
        transportService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Transport transport = new Transport()
        transportService.save(transport)

        then:
        transport.id != null
    }
}
