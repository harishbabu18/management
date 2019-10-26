package usermanagement

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class AdmindashboardControllerServiceSpec extends Specification {

    AdmindashboardControllerService admindashboardControllerService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new AdmindashboardController(...).save(flush: true, failOnError: true)
        //new AdmindashboardController(...).save(flush: true, failOnError: true)
        //AdmindashboardController admindashboardController = new AdmindashboardController(...).save(flush: true, failOnError: true)
        //new AdmindashboardController(...).save(flush: true, failOnError: true)
        //new AdmindashboardController(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //admindashboardController.id
    }

    void "test get"() {
        setupData()

        expect:
        admindashboardControllerService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<AdmindashboardController> admindashboardControllerList = admindashboardControllerService.list(max: 2, offset: 2)

        then:
        admindashboardControllerList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        admindashboardControllerService.count() == 5
    }

    void "test delete"() {
        Long admindashboardControllerId = setupData()

        expect:
        admindashboardControllerService.count() == 5

        when:
        admindashboardControllerService.delete(admindashboardControllerId)
        sessionFactory.currentSession.flush()

        then:
        admindashboardControllerService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        AdmindashboardController admindashboardController = new AdmindashboardController()
        admindashboardControllerService.save(admindashboardController)

        then:
        admindashboardController.id != null
    }
}
