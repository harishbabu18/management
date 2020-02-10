package management

import usermanagement.User

class Otp {

    User user
    String otp
    OtpTypes otpTypes
    Date dateCreated
    Date lastUpdated
    boolean verifydone

    static constraints = {
    }
}
