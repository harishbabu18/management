package usermanagement

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class UserRoleGroupServiceSpec extends Specification {

    UserRoleGroupService userRoleGroupService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new UserRoleGroup(...).save(flush: true, failOnError: true)
        //new UserRoleGroup(...).save(flush: true, failOnError: true)
        //UserRoleGroup userRoleGroup = new UserRoleGroup(...).save(flush: true, failOnError: true)
        //new UserRoleGroup(...).save(flush: true, failOnError: true)
        //new UserRoleGroup(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //userRoleGroup.id
    }

    void "test get"() {
        setupData()

        expect:
        userRoleGroupService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<UserRoleGroup> userRoleGroupList = userRoleGroupService.list(max: 2, offset: 2)

        then:
        userRoleGroupList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        userRoleGroupService.count() == 5
    }

    void "test delete"() {
        Long userRoleGroupId = setupData()

        expect:
        userRoleGroupService.count() == 5

        when:
        userRoleGroupService.delete(userRoleGroupId)
        sessionFactory.currentSession.flush()

        then:
        userRoleGroupService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        UserRoleGroup userRoleGroup = new UserRoleGroup()
        userRoleGroupService.save(userRoleGroup)

        then:
        userRoleGroup.id != null
    }
}
