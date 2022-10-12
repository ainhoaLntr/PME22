class Executive(firstName : String, lastName: String, birthYear : Int, employer : Employer, var grade : Grade) :
    Employee(firstName, lastName, birthYear, employer)
{
    override fun toString(): String {
        return super.toString() + " et de grade " +  grade
    }

    init {
        salary += grade.prime
    }
}