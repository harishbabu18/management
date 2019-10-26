package usermanagement

import grails.gorm.services.Service

@Service(RoleGroupRole)
interface RoleGroupRoleService {

    RoleGroupRole get(Serializable id)

    List<RoleGroupRole> list(Map args)

    Long count()

    void delete(Serializable id)

    RoleGroupRole save(RoleGroupRole roleGroupRole)

}