package Inventory

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.CREATED
import static org.springframework.http.HttpStatus.NOT_FOUND
import static org.springframework.http.HttpStatus.NO_CONTENT
import static org.springframework.http.HttpStatus.OK
import static org.springframework.http.HttpStatus.UNPROCESSABLE_ENTITY

import grails.gorm.transactions.ReadOnly
import grails.gorm.transactions.Transactional

@ReadOnly
class TransportController {

    TransportService transportService

    static responseFormats = ['json', 'xml']
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond transportService.list(params), model:[transportCount: transportService.count()]
    }

    def show(Long id) {
        respond transportService.get(id)
    }

    @Transactional
    def save(Transport transport) {
        if (transport == null) {
            render status: NOT_FOUND
            return
        }
        if (transport.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond transport.errors
            return
        }

        try {
            transportService.save(transport)
        } catch (ValidationException e) {
            respond transport.errors
            return
        }

        respond transport, [status: CREATED, view:"show"]
    }

    @Transactional
    def update(Transport transport) {
        if (transport == null) {
            render status: NOT_FOUND
            return
        }
        if (transport.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond transport.errors
            return
        }

        try {
            transportService.save(transport)
        } catch (ValidationException e) {
            respond transport.errors
            return
        }

        respond transport, [status: OK, view:"show"]
    }

    @Transactional
    def delete(Long id) {
        if (id == null) {
            render status: NOT_FOUND
            return
        }

        transportService.delete(id)

        render status: NO_CONTENT
    }
}
