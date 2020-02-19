package Inventory

import grails.gorm.services.Service

@Service(ProductName)
interface ProductNameService {

    ProductName get(Serializable id)

    List<ProductName> list(Map args)

    Long count()

    void delete(Serializable id)

    ProductName save(ProductName productName)

}