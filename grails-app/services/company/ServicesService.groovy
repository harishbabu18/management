package company

import grails.gorm.services.Service

@Service(Services)
interface ServicesService {

    Services get(Serializable id)

    List<Services> list(Map args)

    Long count()

    void delete(Serializable id)

    Services save(Services services)

}