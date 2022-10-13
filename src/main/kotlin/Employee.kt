import java.time.LocalDateTime

open class Employee(firstName : String, lastName : String, birthYear : Int, var employer : Employer) :
    Person(firstName, lastName, birthYear)
{
    override fun toString(): String {
        return super.toString() + ", employé(e) de l'entreprise ${employer.name}, avec un salaire de $salary €"
    }

    var salary = (LocalDateTime.now().year - birthYear) * 100.0
}


