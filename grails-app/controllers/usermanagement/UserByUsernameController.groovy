package usermanagement


import grails.rest.*
import grails.converters.*

class UserByUsernameController {

    UserService userService


    static responseFormats = ['json', 'xml']
	
    def index() {
        respond userService.findByUsername(params.username)
    }
    def show() {
        respond userService.findByUsername(params.username)
    }

}
