package company

import grails.gorm.services.Service

@Service(OfficeType)
interface OfficeTypeService {

    OfficeType get(Serializable id)

    List<OfficeType> list(Map args)

    Long count()

    void delete(Serializable id)

    OfficeType save(OfficeType officeType)

}