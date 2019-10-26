package usermanagement

import grails.gorm.services.Service

@Service(UserRoleGroup)
interface UserRoleGroupService {

    UserRoleGroup get(Serializable id)

    List<UserRoleGroup> list(Map args)

    Long count()

    void delete(Serializable id)

    UserRoleGroup save(UserRoleGroup userRoleGroup)

}