package Inventory

import grails.gorm.services.Service

@Service(QuantityType)
interface QuantityTypeService {

    QuantityType get(Serializable id)

    List<QuantityType> list(Map args)

    Long count()

    void delete(Serializable id)

    QuantityType save(QuantityType quantityType)

}