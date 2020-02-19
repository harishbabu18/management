package Inventory

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class QuantityTypeServiceSpec extends Specification {

    QuantityTypeService quantityTypeService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new QuantityType(...).save(flush: true, failOnError: true)
        //new QuantityType(...).save(flush: true, failOnError: true)
        //QuantityType quantityType = new QuantityType(...).save(flush: true, failOnError: true)
        //new QuantityType(...).save(flush: true, failOnError: true)
        //new QuantityType(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //quantityType.id
    }

    void "test get"() {
        setupData()

        expect:
        quantityTypeService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<QuantityType> quantityTypeList = quantityTypeService.list(max: 2, offset: 2)

        then:
        quantityTypeList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        quantityTypeService.count() == 5
    }

    void "test delete"() {
        Long quantityTypeId = setupData()

        expect:
        quantityTypeService.count() == 5

        when:
        quantityTypeService.delete(quantityTypeId)
        sessionFactory.currentSession.flush()

        then:
        quantityTypeService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        QuantityType quantityType = new QuantityType()
        quantityTypeService.save(quantityType)

        then:
        quantityType.id != null
    }
}
