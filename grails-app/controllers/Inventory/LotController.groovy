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
class LotController {

    LotService lotService

    static responseFormats = ['json', 'xml']
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond lotService.list(params), model:[lotCount: lotService.count()]
    }

    def show(Long id) {
        respond lotService.get(id)
    }

    @Transactional
    def save(Lot lot) {
        if (lot == null) {
            render status: NOT_FOUND
            return
        }
        if (lot.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond lot.errors
            return
        }

        try {
            lotService.save(lot)
        } catch (ValidationException e) {
            respond lot.errors
            return
        }

        respond lot, [status: CREATED, view:"show"]
    }

    @Transactional
    def update(Lot lot) {
        if (lot == null) {
            render status: NOT_FOUND
            return
        }
        if (lot.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond lot.errors
            return
        }

        try {
            lotService.save(lot)
        } catch (ValidationException e) {
            respond lot.errors
            return
        }

        respond lot, [status: OK, view:"show"]
    }

    @Transactional
    def delete(Long id) {
        if (id == null) {
            render status: NOT_FOUND
            return
        }

        lotService.delete(id)

        render status: NO_CONTENT
    }
}
