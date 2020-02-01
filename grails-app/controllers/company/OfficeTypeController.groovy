package company

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.CREATED
import static org.springframework.http.HttpStatus.NOT_FOUND
import static org.springframework.http.HttpStatus.NO_CONTENT
import static org.springframework.http.HttpStatus.OK
import static org.springframework.http.HttpStatus.UNPROCESSABLE_ENTITY

import grails.gorm.transactions.ReadOnly
import grails.gorm.transactions.Transactional

@ReadOnly
class OfficeTypeController {

    OfficeTypeService officeTypeService

    static responseFormats = ['json', 'xml']
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond officeTypeService.list(params), model:[officeTypeCount: officeTypeService.count()]
    }

    def show(Long id) {
        respond officeTypeService.get(id)
    }

    @Transactional
    def save(OfficeType officeType) {
        if (officeType == null) {
            render status: NOT_FOUND
            return
        }
        if (officeType.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond officeType.errors
            return
        }

        try {
            officeTypeService.save(officeType)
        } catch (ValidationException e) {
            respond officeType.errors
            return
        }

        respond officeType, [status: CREATED, view:"show"]
    }

    @Transactional
    def update(OfficeType officeType) {
        if (officeType == null) {
            render status: NOT_FOUND
            return
        }
        if (officeType.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond officeType.errors
            return
        }

        try {
            officeTypeService.save(officeType)
        } catch (ValidationException e) {
            respond officeType.errors
            return
        }

        respond officeType, [status: OK, view:"show"]
    }

    @Transactional
    def delete(Long id) {
        if (id == null) {
            render status: NOT_FOUND
            return
        }

        officeTypeService.delete(id)

        render status: NO_CONTENT
    }
}
