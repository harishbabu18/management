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
class OfferingController {

    OfferingService offeringService

    static responseFormats = ['json', 'xml']
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond offeringService.list(params), model:[offeringCount: offeringService.count()]
    }

    def show(Long id) {
        respond offeringService.get(id)
    }

    @Transactional
    def save(Offering offering) {
        if (offering == null) {
            render status: NOT_FOUND
            return
        }
        if (offering.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond offering.errors
            return
        }

        try {
            offeringService.save(offering)
        } catch (ValidationException e) {
            respond offering.errors
            return
        }

        respond offering, [status: CREATED, view:"show"]
    }

    @Transactional
    def update(Offering offering) {
        if (offering == null) {
            render status: NOT_FOUND
            return
        }
        if (offering.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond offering.errors
            return
        }

        try {
            offeringService.save(offering)
        } catch (ValidationException e) {
            respond offering.errors
            return
        }

        respond offering, [status: OK, view:"show"]
    }

    @Transactional
    def delete(Long id) {
        if (id == null) {
            render status: NOT_FOUND
            return
        }

        offeringService.delete(id)

        render status: NO_CONTENT
    }
}
