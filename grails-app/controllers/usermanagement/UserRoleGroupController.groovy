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
class UserRoleGroupController {

    UserRoleGroupService userRoleGroupService

    static responseFormats = ['json', 'xml']
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond userRoleGroupService.list(params), model:[userRoleGroupCount: userRoleGroupService.count()]
    }

    def show(Long id) {
        respond userRoleGroupService.get(id)
    }

    @Transactional
    def save(UserRoleGroup userRoleGroup) {
        if (userRoleGroup == null) {
            render status: NOT_FOUND
            return
        }
        if (userRoleGroup.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond userRoleGroup.errors
            return
        }

        try {
            userRoleGroupService.save(userRoleGroup)
        } catch (ValidationException e) {
            respond userRoleGroup.errors
            return
        }

        respond userRoleGroup, [status: CREATED, view:"show"]
    }

    @Transactional
    def update(UserRoleGroup userRoleGroup) {
        if (userRoleGroup == null) {
            render status: NOT_FOUND
            return
        }
        if (userRoleGroup.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond userRoleGroup.errors
            return
        }

        try {
            userRoleGroupService.save(userRoleGroup)
        } catch (ValidationException e) {
            respond userRoleGroup.errors
            return
        }

        respond userRoleGroup, [status: OK, view:"show"]
    }

    @Transactional
    def delete(Long id) {
        if (id == null) {
            render status: NOT_FOUND
            return
        }

        userRoleGroupService.delete(id)

        render status: NO_CONTENT
    }
}
