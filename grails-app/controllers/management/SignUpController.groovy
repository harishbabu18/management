package management

import grails.gorm.transactions.Transactional

import grails.rest.*
import grails.converters.*
import grails.validation.ValidationException
import org.apache.commons.lang3.RandomStringUtils
import org.apache.http.impl.client.HttpClientBuilder
import org.springframework.web.client.RestTemplate
import usermanagement.Email
import usermanagement.User
import usermanagement.UserService

import static org.springframework.http.HttpStatus.CREATED
import static org.springframework.http.HttpStatus.NOT_FOUND
import static org.springframework.http.HttpStatus.OK

class SignUpController {
    UserService userService
    OtpService otpService
    RestTemplate restTemplate


    static responseFormats = ['json', 'xml']
    static allowedMethods = [save: "POST", update: "PUT"]






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
//        String charset = (('A'..'Z') + ('0'..'9')).join()
//        Integer length = 5
//        String randomString = RandomStringUtils.random(length, charset.toCharArray())
//
//
//
//        new Otp(user: user,otp: randomString,otpTypes: OtpTypes.findByName("SIGNUP"),verifydone: false).save()
//
//        // POST
//        def post = new URL("http://localhost/mail/send").openConnection()
//        def message = '{"from":"harish.babu@sdc.company","to":"'+user.username+'","message":"'+randomString+'"}'
//        post.setRequestMethod("POST")
//        post.setDoOutput(true)
//        post.setRequestProperty("Content-Type", "application/json")
//        post.getOutputStream().write(message.getBytes("UTF-8"))
//        def postRC = post.getResponseCode()
//        println(postRC)
//        if(postRC.equals(200)) {
//            println(post.getInputStream().getText())
//        }



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
