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
class ServicesController {

    ServicesService servicesService

    static responseFormats = ['json', 'xml']
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond servicesService.list(params), model:[servicesCount: servicesService.count()]
    }

    def show(Long id) {
        respond servicesService.get(id)
    }

    @Transactional
    def save(Services services) {
        if (services == null) {
            render status: NOT_FOUND
            return
        }
        if (services.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond services.errors
            return
        }

        try {
            servicesService.save(services)
        } catch (ValidationException e) {
            respond services.errors
            return
        }

        respond services, [status: CREATED, view:"show"]
    }

    @Transactional
    def update(Services services) {
        if (services == null) {
            render status: NOT_FOUND
            return
        }
        if (services.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond services.errors
            return
        }

        try {
            servicesService.save(services)
        } catch (ValidationException e) {
            respond services.errors
            return
        }

        respond services, [status: OK, view:"show"]
    }

    @Transactional
    def delete(Long id) {
        if (id == null) {
            render status: NOT_FOUND
            return
        }

        servicesService.delete(id)

        render status: NO_CONTENT
    }
}
