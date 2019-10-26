package usermanagement

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class RoleGroupRoleServiceSpec extends Specification {

    RoleGroupRoleService roleGroupRoleService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new RoleGroupRole(...).save(flush: true, failOnError: true)
        //new RoleGroupRole(...).save(flush: true, failOnError: true)
        //RoleGroupRole roleGroupRole = new RoleGroupRole(...).save(flush: true, failOnError: true)
        //new RoleGroupRole(...).save(flush: true, failOnError: true)
        //new RoleGroupRole(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //roleGroupRole.id
    }

    void "test get"() {
        setupData()

        expect:
        roleGroupRoleService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<RoleGroupRole> roleGroupRoleList = roleGroupRoleService.list(max: 2, offset: 2)

        then:
        roleGroupRoleList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        roleGroupRoleService.count() == 5
    }

    void "test delete"() {
        Long roleGroupRoleId = setupData()

        expect:
        roleGroupRoleService.count() == 5

        when:
        roleGroupRoleService.delete(roleGroupRoleId)
        sessionFactory.currentSession.flush()

        then:
        roleGroupRoleService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        RoleGroupRole roleGroupRole = new RoleGroupRole()
        roleGroupRoleService.save(roleGroupRole)

        then:
        roleGroupRole.id != null
    }
}
