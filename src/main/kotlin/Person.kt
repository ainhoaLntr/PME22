abstract class Person (var firstName: String, var lastName: String, val birthYear: Int)
{
    override fun toString(): String {
        return "$firstName $lastName, né(e) en $birthYear"
    }
}

