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
class TicketSourceController {

    TicketSourceService ticketSourceService

    static responseFormats = ['json', 'xml']
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond ticketSourceService.list(params), model:[ticketSourceCount: ticketSourceService.count()]
    }

    def show(Long id) {
        respond ticketSourceService.get(id)
    }

    @Transactional
    def save(TicketSource ticketSource) {
        if (ticketSource == null) {
            render status: NOT_FOUND
            return
        }
        if (ticketSource.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond ticketSource.errors
            return
        }

        try {
            ticketSourceService.save(ticketSource)
        } catch (ValidationException e) {
            respond ticketSource.errors
            return
        }

        respond ticketSource, [status: CREATED, view:"show"]
    }

    @Transactional
    def update(TicketSource ticketSource) {
        if (ticketSource == null) {
            render status: NOT_FOUND
            return
        }
        if (ticketSource.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond ticketSource.errors
            return
        }

        try {
            ticketSourceService.save(ticketSource)
        } catch (ValidationException e) {
            respond ticketSource.errors
            return
        }

        respond ticketSource, [status: OK, view:"show"]
    }

    @Transactional
    def delete(Long id) {
        if (id == null) {
            render status: NOT_FOUND
            return
        }

        ticketSourceService.delete(id)

        render status: NO_CONTENT
    }
}
