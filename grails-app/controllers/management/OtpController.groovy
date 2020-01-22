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
class OtpController {

    OtpService otpService

    static responseFormats = ['json', 'xml']
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond otpService.list(params), model:[otpCount: otpService.count()]
    }

    def show(Long id) {
        respond otpService.get(id)
    }

    @Transactional
    def save(Otp otp) {
        if (otp == null) {
            render status: NOT_FOUND
            return
        }
        if (otp.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond otp.errors
            return
        }

        try {
            otpService.save(otp)
        } catch (ValidationException e) {
            respond otp.errors
            return
        }

        respond otp, [status: CREATED, view:"show"]
    }

    @Transactional
    def update(Otp otp) {
        if (otp == null) {
            render status: NOT_FOUND
            return
        }
        if (otp.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond otp.errors
            return
        }

        try {
            otpService.save(otp)
        } catch (ValidationException e) {
            respond otp.errors
            return
        }

        respond otp, [status: OK, view:"show"]
    }

    @Transactional
    def delete(Long id) {
        if (id == null) {
            render status: NOT_FOUND
            return
        }

        otpService.delete(id)

        render status: NO_CONTENT
    }
}
