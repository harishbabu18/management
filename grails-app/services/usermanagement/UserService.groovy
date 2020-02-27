package usermanagement

import grails.gorm.services.Service

@Service(User)
interface UserService {

    User get(Serializable id)

    User findByUsername(String username)

    List<User> list(Map args)

    Long count()

    void delete(Serializable id)

    User save(User user)

}