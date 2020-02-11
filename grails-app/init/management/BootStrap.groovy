package management

import company.Position
import company.TicketSource
import company.TicketStatusType
import usermanagement.Role
import usermanagement.User
import usermanagement.UserRole


class BootStrap {

    def init = { servletContext ->
        User admin = new User(username: "babuamuda@gmail.com",password:"B@vana20").save()
        User qualificaadmin = new User(username: "audit@qualificagroup.it",password:"test@123").save()

        User customer = new User(username: "liricsdash2014@gmail.com",password:"lirics@123").save()
        User account = new User(username: "akshitharajappa10@gmail.com",password:"akshitha@123").save()
        Role adminrole = new Role(authority: "ROLE_ADMIN").save()
        Role customerrole = new Role(authority: "ROLE_CUSTOMER").save()
        Role accountrole = new Role(authority: "ROLE_ACCOUNT").save()

        UserRole.create(admin,adminrole)
        UserRole.create(qualificaadmin,adminrole)

        UserRole.create(customer,customerrole)
        UserRole.create(account,accountrole)


        new Position(name: "Employee").save()
        new Position(name: "Freelancer").save()

        new TicketStatusType(name: "New").save()
        new TicketStatusType(name: "Open").save()
        new TicketStatusType(name: "Pending customer").save()
        new TicketStatusType(name: "Awaiting Third").save()
        new TicketStatusType(name: "Closed").save()
        new TicketStatusType(name: "0 ‐ Potential").save()
        new TicketStatusType(name: "01 ‐ Contact Established").save()
        new TicketStatusType(name: "01 ‐ Int. But Wait EXP").save()
        new TicketStatusType(name: "1 ‐ Hold Ns Activities").save()
        new TicketStatusType(name: "1 ‐ certifies Third Activity").save()
        new TicketStatusType(name: "1 ‐ Customer Waiting").save()
        new TicketStatusType(name: "1 * ‐ Negotiation Hot").save()
        new TicketStatusType(name: "Potential").save()
        new TicketStatusType(name: "Interested").save()
        new TicketStatusType(name: "won").save()
        new TicketStatusType(name: "Persa").save()
        new TicketStatusType(name: "Abandoned").save()

        new TicketSource(name: "Phone Call").save()
        new TicketSource(name: "App").save()
        new TicketSource(name: "Mail").save()



    }
    def destroy = {
    }
}
