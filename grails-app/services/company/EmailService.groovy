package company

import grails.gorm.services.Service

@Service(Email)
interface EmailService {

    Email get(Serializable id)

    List<Email> list(Map args)

    Long count()

    void delete(Serializable id)

    Email save(Email email)

}