package company

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class cAddressServiceSpec extends Specification {

    CAddressService cAddressService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new cAddress(...).save(flush: true, failOnError: true)
        //new cAddress(...).save(flush: true, failOnError: true)
        //cAddress cAddress = new cAddress(...).save(flush: true, failOnError: true)
        //new cAddress(...).save(flush: true, failOnError: true)
        //new cAddress(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //cAddress.id
    }

    void "test get"() {
        setupData()

        expect:
        cAddressService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<cAddress> cAddressList = cAddressService.list(max: 2, offset: 2)

        then:
        cAddressList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        cAddressService.count() == 5
    }

    void "test delete"() {
        Long cAddressId = setupData()

        expect:
        cAddressService.count() == 5

        when:
        cAddressService.delete(cAddressId)
        sessionFactory.currentSession.flush()

        then:
        cAddressService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        cAddress cAddress = new cAddress()
        cAddressService.save(cAddress)

        then:
        cAddress.id != null
    }
}
