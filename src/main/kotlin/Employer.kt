class Employer (var name : String, var turnover : Double)
{
    var employees : MutableSet<Employee> = mutableSetOf()

    override fun toString(): String {
        return "$name ($turnover € de CA)"
    }

    fun hireEmployee(employee : Employee) {
        employees.add(employee)
    }

    fun fireEmployee(employee : Employee) {
        employees.remove(employee)
    }

    fun increase(employee: Employee, amount : Double) {
        employee.salary += amount
    }

    fun displayName() {
        println("Liste des employés :")
        for(employee in employees) {
            println("${employee.firstName} ${employee.lastName}")
        }
    }

    fun displayExecutive() {
        println("Liste des cadres :")
        for(executive in employees) {
            if(executive is Executive) {
                println("${executive.firstName} ${executive.lastName}, grade ${executive.grade}")
            }
        }
    }

    fun displaySalary() {
        println("Liste des salaires :")
        for(employee in employees) {
            println("${employee.firstName} ${employee.salary}")
        }
    }

    fun upgrade(executive : Executive) {
        when(executive.grade) {
            Grade.A -> {
                println("Le grade de l'employé est au maximum")
            }
            Grade.B -> {
                executive.grade = Grade.A
                executive.salary += Grade.A.prime
            }
            Grade.C -> {
                executive.grade = Grade.B
                executive.salary += Grade.B.prime
            }
        }
    }
}