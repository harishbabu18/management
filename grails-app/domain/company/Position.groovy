package company

class Position {
    String name

    static constraints = {
        name unique:true
    }
}
