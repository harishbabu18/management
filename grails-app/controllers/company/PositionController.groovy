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
class PositionController {

    PositionService positionService

    static responseFormats = ['json', 'xml']
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond positionService.list(params), model:[positionCount: positionService.count()]
    }

    def show(Long id) {
        respond positionService.get(id)
    }

    @Transactional
    def save(Position position) {
        if (position == null) {
            render status: NOT_FOUND
            return
        }
        if (position.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond position.errors
            return
        }

        try {
            positionService.save(position)
        } catch (ValidationException e) {
            respond position.errors
            return
        }

        respond position, [status: CREATED, view:"show"]
    }

    @Transactional
    def update(Position position) {
        if (position == null) {
            render status: NOT_FOUND
            return
        }
        if (position.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond position.errors
            return
        }

        try {
            positionService.save(position)
        } catch (ValidationException e) {
            respond position.errors
            return
        }

        respond position, [status: OK, view:"show"]
    }

    @Transactional
    def delete(Long id) {
        if (id == null) {
            render status: NOT_FOUND
            return
        }

        positionService.delete(id)

        render status: NO_CONTENT
    }
}
