package company

import grails.gorm.services.Service

@Service(Offering)
interface OfferingService {

    Offering get(Serializable id)

    List<Offering> list(Map args)

    Long count()

    void delete(Serializable id)

    Offering save(Offering offering)

}