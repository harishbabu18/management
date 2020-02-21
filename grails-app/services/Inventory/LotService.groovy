package Inventory

import grails.gorm.services.Service

@Service(Lot)
interface LotService {

    Lot get(Serializable id)

    List<Lot> list(Map args)

    Long count()

    void delete(Serializable id)

    Lot save(Lot lot)

}