import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

internal class PersonTest {

    val company = Employer("macompta", 100000.0)
    val person = Employee("nono", "lntr", 2000, company)

    @Test
    fun getFirstName() {
        var expected = "nono"
        assertEquals(expected, person.firstName)
    }

    @Test
    fun setFirstName() {
        var expected = "guigui"
        person.firstName = "guigui"
        assertEquals(expected, person.firstName)
    }

    @Test
    fun getLastName() {
        var expected = "lntr"
        assertEquals(expected, person.lastName)
    }

    @Test
    fun setLastName() {
        var expected = "peyre"
        person.lastName = "peyre"
        assertEquals(expected, person.lastName)
    }

    @Test
    fun getBirthYear() {
        var expected = 2000
        assertEquals(expected, person.birthYear)
    }
}