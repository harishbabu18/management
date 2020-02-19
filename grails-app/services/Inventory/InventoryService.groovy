package Inventory

import grails.gorm.services.Service

@Service(Inventory)
interface InventoryService {

    Inventory get(Serializable id)

    List<Inventory> list(Map args)

    Long count()

    void delete(Serializable id)

    Inventory save(Inventory inventory)

}