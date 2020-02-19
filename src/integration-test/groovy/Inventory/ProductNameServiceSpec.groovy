package Inventory

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class ProductNameServiceSpec extends Specification {

    ProductNameService productNameService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new ProductName(...).save(flush: true, failOnError: true)
        //new ProductName(...).save(flush: true, failOnError: true)
        //ProductName productName = new ProductName(...).save(flush: true, failOnError: true)
        //new ProductName(...).save(flush: true, failOnError: true)
        //new ProductName(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //productName.id
    }

    void "test get"() {
        setupData()

        expect:
        productNameService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<ProductName> productNameList = productNameService.list(max: 2, offset: 2)

        then:
        productNameList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        productNameService.count() == 5
    }

    void "test delete"() {
        Long productNameId = setupData()

        expect:
        productNameService.count() == 5

        when:
        productNameService.delete(productNameId)
        sessionFactory.currentSession.flush()

        then:
        productNameService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        ProductName productName = new ProductName()
        productNameService.save(productName)

        then:
        productName.id != null
    }
}
