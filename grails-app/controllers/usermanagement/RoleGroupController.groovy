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
class RoleGroupController {

    RoleGroupService roleGroupService

    static responseFormats = ['json', 'xml']
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond roleGroupService.list(params), model:[roleGroupCount: roleGroupService.count()]
    }

    def show(Long id) {
        respond roleGroupService.get(id)
    }

    @Transactional
    def save(RoleGroup roleGroup) {
        if (roleGroup == null) {
            render status: NOT_FOUND
            return
        }
        if (roleGroup.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond roleGroup.errors
            return
        }

        try {
            roleGroupService.save(roleGroup)
        } catch (ValidationException e) {
            respond roleGroup.errors
            return
        }

        respond roleGroup, [status: CREATED, view:"show"]
    }

    @Transactional
    def update(RoleGroup roleGroup) {
        if (roleGroup == null) {
            render status: NOT_FOUND
            return
        }
        if (roleGroup.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond roleGroup.errors
            return
        }

        try {
            roleGroupService.save(roleGroup)
        } catch (ValidationException e) {
            respond roleGroup.errors
            return
        }

        respond roleGroup, [status: OK, view:"show"]
    }

    @Transactional
    def delete(Long id) {
        if (id == null) {
            render status: NOT_FOUND
            return
        }

        roleGroupService.delete(id)

        render status: NO_CONTENT
    }
}
