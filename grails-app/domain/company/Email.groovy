package company

class Email {
    String email


    static constraints = {
        email email:true, unique:true

    }
}
