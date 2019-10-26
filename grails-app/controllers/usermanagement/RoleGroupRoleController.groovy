package usermanagement

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.CREATED
import static org.springframework.http.HttpStatus.NOT_FOUND
import static org.springframework.http.HttpStatus.NO_CONTENT
import static org.springframework.http.HttpStatus.OK
import static org.springframework.http.HttpStatus.UNPROCESSABLE_ENTITY

import grails.gorm.transactions.ReadOnly
import grails.gorm.transactions.Transactional

@ReadOnly
class RoleGroupRoleController {

    RoleGroupRoleService roleGroupRoleService

    static responseFormats = ['json', 'xml']
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond roleGroupRoleService.list(params), model:[roleGroupRoleCount: roleGroupRoleService.count()]
    }

    def show(Long id) {
        respond roleGroupRoleService.get(id)
    }

    @Transactional
    def save(RoleGroupRole roleGroupRole) {
        if (roleGroupRole == null) {
            render status: NOT_FOUND
            return
        }
        if (roleGroupRole.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond roleGroupRole.errors
            return
        }

        try {
            roleGroupRoleService.save(roleGroupRole)
        } catch (ValidationException e) {
            respond roleGroupRole.errors
            return
        }

        respond roleGroupRole, [status: CREATED, view:"show"]
    }

    @Transactional
    def update(RoleGroupRole roleGroupRole) {
        if (roleGroupRole == null) {
            render status: NOT_FOUND
            return
        }
        if (roleGroupRole.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond roleGroupRole.errors
            return
        }

        try {
            roleGroupRoleService.save(roleGroupRole)
        } catch (ValidationException e) {
            respond roleGroupRole.errors
            return
        }

        respond roleGroupRole, [status: OK, view:"show"]
    }

    @Transactional
    def delete(Long id) {
        if (id == null) {
            render status: NOT_FOUND
            return
        }

        roleGroupRoleService.delete(id)

        render status: NO_CONTENT
    }
}
