import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class EmployeeTest {

    val company = Employer("macompta", 100000.0)
    val person = Employee("nono", "lntr", 2000, company)

    @Test
    fun testToString() {
        var expected = "nono lntr, né(e) en 2000, employé(e) de l'entreprise macompta, avec un salaire de 2200.0 €"
        assertEquals(expected, person.toString())
    }

    @Test
    fun getSalary() {
        var expected = 2200.0
        assertEquals(expected, person.salary)
    }

    @Test
    fun setSalary() {
        var expected = 2300.0
        person.salary = 2300.0
        assertEquals(expected, person.salary)
    }

    @Test
    fun getEmployer() {
        var expected = company
        assertEquals(expected, person.employer)
    }

    @Test
    fun setEmployer() {
        var expected = Employer("AGI", 200000.0)
        person.employer = Employer("AGI", 200000.0)
        assertEquals(expected.name, person.employer.name)
        assertEquals(expected.turnover, person.employer.turnover)
    }
}