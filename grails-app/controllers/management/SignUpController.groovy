package management

import grails.gorm.transactions.Transactional

import grails.rest.*
import grails.converters.*
import grails.validation.ValidationException
import org.apache.commons.lang3.RandomStringUtils
import usermanagement.User
import usermanagement.UserService

import static org.springframework.http.HttpStatus.CREATED
import static org.springframework.http.HttpStatus.NOT_FOUND
import static org.springframework.http.HttpStatus.OK

class SignUpController {
    UserService userService
    OtpService otpService


    static responseFormats = ['json', 'xml']
    static allowedMethods = [save: "POST", update: "PUT"]






    @Transactional
    def save(User user) {
        user.enabled = false

        if (user == null) {
            render status: NOT_FOUND
            return
        }
        if (user.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond user.errors
            return
        }

        try {
            userService.save(user)
        } catch (ValidationException e) {
            respond user.errors
            return
        }
        String charset = (('A'..'Z') + ('0'..'9')).join()
        Integer length = 9
        String randomString = RandomStringUtils.random(length, charset.toCharArray())

        new Otp(user: user,otp: randomString,otpTypes: OtpTypes.findByName("SIGNUP"),verifydone: false).save()

        respond user, [status: CREATED, view:"show"]

    }


    @Transactional
    def update(User user) {

        def verifyotp = Otp.findByUserAndOtpTypes(User.get(params.id),OtpTypes.findByName("SIGNUP"))

        if(verifyotp.otp==params.otp){
            user.enabled=true
        }

        if (user == null) {
            render status: NOT_FOUND
            return
        }

        if (user.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond user.errors
            return
        }

        try {
            userService.save(user)
        } catch (ValidationException e) {
            respond user.errors
            return
        }

        verifyotp.verifydone = true

        otpService.save(verifyotp)

        respond user, [status: OK, view:"show"]

    }


}
