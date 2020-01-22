package management

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.CREATED
import static org.springframework.http.HttpStatus.NOT_FOUND
import static org.springframework.http.HttpStatus.NO_CONTENT
import static org.springframework.http.HttpStatus.OK
import static org.springframework.http.HttpStatus.UNPROCESSABLE_ENTITY

import grails.gorm.transactions.ReadOnly
import grails.gorm.transactions.Transactional

@ReadOnly
class OtpTypesController {

    OtpTypesService otpTypesService

    static responseFormats = ['json', 'xml']
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond otpTypesService.list(params), model:[otpTypesCount: otpTypesService.count()]
    }

    def show(Long id) {
        respond otpTypesService.get(id)
    }

    @Transactional
    def save(OtpTypes otpTypes) {
        if (otpTypes == null) {
            render status: NOT_FOUND
            return
        }
        if (otpTypes.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond otpTypes.errors
            return
        }

        try {
            otpTypesService.save(otpTypes)
        } catch (ValidationException e) {
            respond otpTypes.errors
            return
        }

        respond otpTypes, [status: CREATED, view:"show"]
    }

    @Transactional
    def update(OtpTypes otpTypes) {
        if (otpTypes == null) {
            render status: NOT_FOUND
            return
        }
        if (otpTypes.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond otpTypes.errors
            return
        }

        try {
            otpTypesService.save(otpTypes)
        } catch (ValidationException e) {
            respond otpTypes.errors
            return
        }

        respond otpTypes, [status: OK, view:"show"]
    }

    @Transactional
    def delete(Long id) {
        if (id == null) {
            render status: NOT_FOUND
            return
        }

        otpTypesService.delete(id)

        render status: NO_CONTENT
    }
}
