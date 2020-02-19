package Inventory

import grails.gorm.services.Service

@Service(Transport)
interface TransportService {

    Transport get(Serializable id)

    List<Transport> list(Map args)

    Long count()

    void delete(Serializable id)

    Transport save(Transport transport)

}