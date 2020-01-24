package management

import grails.gorm.services.Service

@Service(OtpTypes)
interface OtpTypesService {

    OtpTypes get(Serializable id)

    List<OtpTypes> list(Map args)

    Long count()

    void delete(Serializable id)

    OtpTypes save(OtpTypes otpTypes)

}