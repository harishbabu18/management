package usermanagement


import grails.rest.*
import grails.converters.*
import company.Company

class AdmindashboardController {
	static responseFormats = ['json', 'xml']
	
    def index() {
        def compainesRegistered = Company.count()
        def userRegisterd = 30000
        def companyusersOnline = 200
        def usersOnline = 4000
        [harish :compainesRegistered,
        userRegisterd:userRegisterd,
        companyusersOnline:companyusersOnline,
        usersOnline:usersOnline]
     }
}
