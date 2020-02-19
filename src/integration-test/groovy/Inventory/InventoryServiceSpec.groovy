package Inventory

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class InventoryServiceSpec extends Specification {

    InventoryService inventoryService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Inventory(...).save(flush: true, failOnError: true)
        //new Inventory(...).save(flush: true, failOnError: true)
        //Inventory inventory = new Inventory(...).save(flush: true, failOnError: true)
        //new Inventory(...).save(flush: true, failOnError: true)
        //new Inventory(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //inventory.id
    }

    void "test get"() {
        setupData()

        expect:
        inventoryService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Inventory> inventoryList = inventoryService.list(max: 2, offset: 2)

        then:
        inventoryList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        inventoryService.count() == 5
    }

    void "test delete"() {
        Long inventoryId = setupData()

        expect:
        inventoryService.count() == 5

        when:
        inventoryService.delete(inventoryId)
        sessionFactory.currentSession.flush()

        then:
        inventoryService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Inventory inventory = new Inventory()
        inventoryService.save(inventory)

        then:
        inventory.id != null
    }
}
