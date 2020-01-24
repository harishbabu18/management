package management

import grails.gorm.services.Service

@Service(Otp)
interface OtpService {

    Otp get(Serializable id)

    List<Otp> list(Map args)

    Long count()

    void delete(Serializable id)

    Otp save(Otp otp)

}