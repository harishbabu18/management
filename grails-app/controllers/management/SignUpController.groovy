package management

import grails.gorm.transactions.Transactional

import grails.rest.*
import grails.converters.*
import grails.validation.ValidationException
import usermanagement.User
import usermanagement.UserService

import static org.springframework.http.HttpStatus.CREATED
import static org.springframework.http.HttpStatus.NOT_FOUND

class SignUpController {
    UserService userService


    static responseFormats = ['json', 'xml']
    static allowedMethods = [save: "POST"]






    @Transactional
    def save(User user) {
        user.enabled = true

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

        respond user, [status: CREATED, view:"show"]

    }


}
