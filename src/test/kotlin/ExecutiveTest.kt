import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class ExecutiveTest {

    val company = Employer("macompta", 100000.0)
    val person = Executive("nono", "lntr", 2000, company, Grade.A)

    @Test
    fun testToString() {
        var expected = "nono lntr, né(e) en 2000, employé(e) de l'entreprise macompta, avec un salaire de 2500.0 € et de grade " + Grade.A
        assertEquals(expected, person.toString())
    }

    @Test
    fun getGrade() {
        var expected = Grade.A
        assertEquals(expected, person.grade)
    }

    @Test
    fun setGrade() {
        var expected = Grade.B
        person.grade = Grade.B
        assertEquals(expected, person.grade)
    }
}