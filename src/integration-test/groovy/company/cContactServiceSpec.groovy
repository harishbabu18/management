package company

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class cContactServiceSpec extends Specification {

    cContactService cContactService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new cContact(...).save(flush: true, failOnError: true)
        //new cContact(...).save(flush: true, failOnError: true)
        //cContact cContact = new cContact(...).save(flush: true, failOnError: true)
        //new cContact(...).save(flush: true, failOnError: true)
        //new cContact(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //cContact.id
    }

    void "test get"() {
        setupData()

        expect:
        cContactService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<cContact> cContactList = cContactService.list(max: 2, offset: 2)

        then:
        cContactList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        cContactService.count() == 5
    }

    void "test delete"() {
        Long cContactId = setupData()

        expect:
        cContactService.count() == 5

        when:
        cContactService.delete(cContactId)
        sessionFactory.currentSession.flush()

        then:
        cContactService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        cContact cContact = new cContact()
        cContactService.save(cContact)

        then:
        cContact.id != null
    }
}
